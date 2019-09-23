package com.example.microcomsumer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 *  * 通用异常处理
 * @author jiahaikun
 * @date 2018-07-26
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;

    /**
     * 拦截处理所有未知异常
     *
     * @param req 可获取url
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultMessageInfo errorHandler(HttpServletRequest req, Exception e) throws Exception {
        ResultMessageInfo r = new ResultMessageInfo();
        r.setCode(ResultMessageInfo.State.ERROR.getCode());
        r.setUrl(req.getRequestURL().toString());
        r.setMsg(e.getMessage());
        logger.error("ExceptionStack:::"+getStackMsg(e));
        return r;
    }

    /**
     * 异常堆栈信息转化为String
     * @param e
     * @return
     */
    private String getStackMsg(Exception e) {

        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackArray = e.getStackTrace();
        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }
        return sb.toString();
    }



}

