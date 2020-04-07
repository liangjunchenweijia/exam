package com.exam.exam_system.exception;

import com.exam.exam_system.common.enums.ErrorMsgEnum;

/**
 * @Author :
 * @ClassName : TestPaperException
 * @Description :
 * @Date : 2020/4/3 9:25
 */
public class TestPaperException extends CustomException{
    private static final long serialVersionUID = -6917773654901826457L;

    public TestPaperException(ErrorMsgEnum code) {
        super(code);
    }

    public TestPaperException(ErrorMsgEnum code, Object... args) {
        super(code, args);
    }

    public TestPaperException(ErrorMsgEnum code, Throwable t) {
        super(code, t);
    }
}
