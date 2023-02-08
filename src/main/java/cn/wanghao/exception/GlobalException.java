package cn.wanghao.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;

/**
 * @author WangHao
 * @Description 全局异常处理
 * @createTime 2023-02-08 18:25
 **/
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SocketTimeoutException.class)
    public String TimeoutException() {
        return "ChatGpt访问超时，请稍后重试！";
    }
}
