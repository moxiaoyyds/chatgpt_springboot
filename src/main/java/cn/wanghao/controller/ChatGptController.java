package cn.wanghao.controller;

import cn.wanghao.service.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangHao
 * @Description
 * @createTime 2023-02-08 17:13
 **/
@RestController
public class ChatGptController {

    @Autowired
    private ChatGptService chatGptService;

    @PostMapping("/request")
    public String getRequest(@RequestBody String question) {
        return chatGptService.getResponse(question);
    }
}
