package com.exam.exam_system.exception;

import com.exam.exam_system.common.Result;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author :
 * @ClassName : GlobalExceptionHandler
 * @Description :  全局异常处理
 * @Date : 2020/3/22 13:51
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    Result<String> handleException(Exception e) {
        logger.error(e.toString(), e);
        return new Result<String>(ErrorMsgEnum.SERVICE_UNAVAILABILITY.getCode(), ErrorMsgEnum.SERVICE_UNAVAILABILITY.getMsg());
    }

    @ExceptionHandler(UserException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Result<String> handleException(UserException e) {
        logger.error(e.toString(), e);
        return new Result<String>(e.getErrorMsgEnum().getCode(), e.getMessage());
    }

    @ExceptionHandler(SubjectException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Result<String> handleException(SubjectException e) {
        logger.error(e.toString(), e);
        return new Result<String>(e.getErrorMsgEnum().getCode(), e.getMessage());
    }

    @ExceptionHandler(ExamTypeException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Result<String> handleException(ExamTypeException e) {
        logger.error(e.toString(), e);
        return new Result<String>(e.getErrorMsgEnum().getCode(), e.getMessage());
    }

}
