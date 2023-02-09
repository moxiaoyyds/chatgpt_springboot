package cn.wanghao.service.impl;

import cn.wanghao.pojo.BaseMessage;
import cn.wanghao.pojo.TextMessage;
import cn.wanghao.service.ChatGptService;
import cn.wanghao.service.WeChatService;
import cn.wanghao.utils.CheckUtil;
import cn.wanghao.utils.MessageUtil;
import com.thoughtworks.xstream.XStream;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author WangHao
 * @Description
 * @createTime 2023-02-08 23:00
 **/

@Service
public class WeChatServiceImpl implements WeChatService {

    @Value("${token}")
    private String token;
    @Autowired
    private ChatGptService chatGptService;
    /**
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，文本为text
     * Content	文本消息内容
     * MsgId	消息id，64位整型
     * MsgDataId	消息的数据ID（消息如果来自文章时才有）
     * Idx	多图文时第几篇文章，从1开始（消息如果来自文章时才有）
     *
     * @param request 微信传来的xml
     * @return
     */
    @Override
    public String processMessages(HttpServletRequest request) {
        try {
            Map<String, String> map = MessageUtil.parseXml(request);
            String content = map.get("Content");
            // 获取chatgpt的回答
            String response = chatGptService.getResponse(content);
            // 封装消息成xml返回微信
            TextMessage textMessage = new TextMessage(map, response);
            XStream stream = new XStream();
            stream.processAnnotations(TextMessage.class);
            String xml = stream.toXML(textMessage);
            System.out.println(xml);
            return xml;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 解密微信发送的加密签名
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public boolean decryptMsg(String signature, String timestamp, String nonce) {
        boolean result;
        try {
            result = CheckUtil.checkSignature(signature, timestamp, nonce, token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
