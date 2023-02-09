package cn.wanghao.service.impl;

import cn.wanghao.service.ChatGptService;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangHao
 * @Description
 * @createTime 2023-02-08 17:11
 **/
@Service
public class ChatGptServiceImpl implements ChatGptService {

    // 自己的OpenAI api
    @Value("${key}")
    private String key;

    /**
     * ChatGpt问答
     * @param question 问题
     * @return ChatGpt返回的答案
     */
    @Override
    public String getResponse(String question) {
        OpenAiService openAiService = new OpenAiService(key);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(question)
                .model("text-davinci-003")
                .maxTokens(2048)
                .echo(true)
                .build();
        List<CompletionChoice> choiceList = openAiService.createCompletion(completionRequest).getChoices();
        return choiceList.get(0).getText().substring(question.length()).trim();
    }
}
