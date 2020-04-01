package com.exam.exam_system.exception;


import com.exam.exam_system.common.enums.ErrorMsgEnum;

/**
 * @author :
 * @ClassName : ExamTypeException
 * @Description :
 * @Date : 2020/3/22 13:20
 */
public class ExamTypeException extends CustomException {


    private static final long serialVersionUID = 8236648180129608888L;

    public ExamTypeException(ErrorMsgEnum code) {
        super(code);
    }

    public ExamTypeException(ErrorMsgEnum code, Object... args) {
        super(code, args);
    }

    public ExamTypeException(ErrorMsgEnum code, Throwable t) {
        super(code, t);
    }
}
