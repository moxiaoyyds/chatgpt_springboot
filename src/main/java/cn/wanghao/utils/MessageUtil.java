package cn.wanghao.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangHao
 * @Description 解析微信发送的Xml
 * @createTime 2023-02-08 22:05
 **/
public class MessageUtil {

    /**
     * 解析微信发送来的Xml
     * @param request 微信发送来的Xml
     * @return 装有xml节点的map
     * @throws Exception
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        ServletInputStream inputStream = request.getInputStream();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        List<Element> elements = document.getRootElement().elements();

        HashMap<String, String> map = new HashMap<>();
        for (Element element : elements) {
            map.put(element.getName(), element.getText());
        }
        inputStream.close();
        return map;
    }
}
