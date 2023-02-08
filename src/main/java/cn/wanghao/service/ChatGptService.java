package cn.wanghao.service;

/**
 * @author WangHao
 * @Description ChatGpt调用接口
 * @createTime 2023-02-08 17:10
 **/
public interface ChatGptService {
    /**
     * ChatGpt问答
     * @param question 问题
     * @return ChatGpt返回的答案
     */
    String getResponse(String question);
}
