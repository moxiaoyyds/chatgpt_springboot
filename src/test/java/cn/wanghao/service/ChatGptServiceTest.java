package cn.wanghao.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author WangHao
 * @Description
 * @createTime 2023-02-08 17:31
 **/

@SpringBootTest
public class ChatGptServiceTest {

    @Autowired
    private ChatGptService chatGptService;

    @Test
    public void getResponseTest() {
        String question = "你好！";
        String response = chatGptService.getResponse(question);
        System.out.println("回答 = " + response);
    }
}
