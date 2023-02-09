package cn.wanghao.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * @author WangHao
 * @Description 文本消息
 * @createTime 2023-02-08 23:25
 **/
@Data
@ToString
@XStreamAlias("xml")
public class TextMessage extends BaseMessage{

    /**
     * 文本消息内容
     */
    @XStreamAlias("Content")
    private String content;

    public TextMessage(Map<String, String> map, String content) {
        super(map);
        this.setMsgType("text");
        this.content = content;
    }

}
