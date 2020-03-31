package com.exam.exam_system.exception;


import com.exam.exam_system.common.enums.ErrorMsgEnum;

/**
 * @author :
 * @ClassName : UserException
 * @Description :
 * @Date : 2020/3/22 13:20
 */
public class SubjectException extends CustomException {


    private static final long serialVersionUID = -5969632991226232856L;

    public SubjectException(ErrorMsgEnum code) {
        super(code);
    }

    public SubjectException(ErrorMsgEnum code, Object... args) {
        super(code, args);
    }

    public SubjectException(ErrorMsgEnum code, Throwable t) {
        super(code, t);
    }
}
