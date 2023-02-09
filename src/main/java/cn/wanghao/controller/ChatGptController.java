package cn.wanghao.controller;

import cn.wanghao.service.ChatGptService;
import cn.wanghao.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WangHao
 * @Description
 * @createTime 2023-02-08 17:13
 **/
@RestController
public class ChatGptController {

    @Autowired
    private ChatGptService chatGptService;
    @Autowired
    private WeChatService weChatService;

    /**
     * 与微信接口配置信息
     * signature	微信加密签名，signature结合了开发者填写的 token 参数和请求中的 timestamp 参数、nonce参数。
     * timestamp	时间戳
     * nonce	随机数
     * echostr	随机字符串
     *
     * @param request
     * @return 原样返回 echostr 表示对接成功
     */
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        if (weChatService.decryptMsg(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }

    @PostMapping("/hello")
    public String getRequest(HttpServletRequest request) {
        String message = weChatService.processMessages(request);
        return message;
    }

    /**
     * ChatGpt测试接口
     *
     * @param question
     * @return
     */
    @PostMapping("/test")
    public String test(@RequestBody String question) {
        return chatGptService.getResponse(question);
    }
}
