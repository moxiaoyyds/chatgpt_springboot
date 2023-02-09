package cn.wanghao.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @author WangHao
 * @Description 公共实体类
 * @createTime 2023-02-08 23:17
 **/

@Data
@NoArgsConstructor
@XStreamAlias("xml")
public class BaseMessage {
    /**
     * 开发者微信号
     */
    @XStreamAlias("ToUserName")
    private String toUserName;
    /**
     * 发送方帐号
     */
    @XStreamAlias("FromUserName")
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    @XStreamAlias("CreateTime")
    private String createTime;
    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    private String msgType;
    /**
     * 消息id，64位整型
     */
    @XStreamAlias("MsgId")
    private String msgId;
    public BaseMessage(Map<String, String> map) {
        this.toUserName = map.get("FromUserName");
        this.fromUserName = map.get("ToUserName");
        this.createTime = System.currentTimeMillis() / 1000 + "";
        this.msgType = map.get("MsgType");
        this.msgId = map.get("MsgId");
    }
}
