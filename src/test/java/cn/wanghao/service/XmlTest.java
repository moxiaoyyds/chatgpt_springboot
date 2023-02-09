package cn.wanghao.service;

import cn.wanghao.utils.MessageUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author WangHao
 * @Description
 * @createTime 2023-02-09 00:00
 **/

@SpringBootTest
public class XmlTest {

    @Test
    public void xmlDemoTest() {
        // 创建对象
        Document document = DocumentHelper.createDocument();
        // 添加根节点
        Element element = document.addElement("element");
        Element toUserName = element.addElement("ToUserName");
        toUserName.setText("接收方帐号");
        Element fromUserName = element.addElement("FromUserName");
        fromUserName.setText("开发者微信号");
    }
}
