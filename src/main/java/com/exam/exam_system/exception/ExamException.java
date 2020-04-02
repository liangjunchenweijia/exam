package com.exam.exam_system.exception;

import com.exam.exam_system.common.enums.ErrorMsgEnum;

/**
 * @Author :
 * @ClassName : ExamException
 * @Description :
 * @Date : 2020/4/2 14:57
 */
public class ExamException extends CustomException {
    private static final long serialVersionUID = 5698609357248166153L;

    public ExamException(ErrorMsgEnum code) {
        super(code);
    }

    public ExamException(ErrorMsgEnum code, Object... args) {
        super(code, args);
    }

    public ExamException(ErrorMsgEnum code, Throwable t) {
        super(code, t);
    }
}
