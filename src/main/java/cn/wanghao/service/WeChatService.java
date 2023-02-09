package cn.wanghao.service;

import cn.wanghao.pojo.BaseMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.prefs.BackingStoreException;

/**
 * @author WangHao
 * @Description 微信接口
 * @createTime 2023-02-08 23:00
 **/
public interface WeChatService {

    /**
     *
     * @param request request 微信传来的xml
     * @return
     */
    String processMessages(HttpServletRequest request);

    /**
     * 解密微信发送的加密签名
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    boolean decryptMsg(String signature, String timestamp, String nonce);
}
