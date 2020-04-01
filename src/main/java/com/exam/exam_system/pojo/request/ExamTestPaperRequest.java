package com.exam.exam_system.pojo.request;

import java.util.List;

/**
 * @Author :
 * @ClassName : ExamTestPaperRequest
 * @Description :
 * @Date : 2020/4/1 12:04
 */
public class ExamTestPaperRequest {

    private List<ExamTestPaperContentRequest> examTestPaperContentRequests;

    public List<ExamTestPaperContentRequest> getExamTestPaperContentRequests() {
        return examTestPaperContentRequests;
    }

    public void setExamTestPaperContentRequests(List<ExamTestPaperContentRequest> examTestPaperContentRequests) {
        this.examTestPaperContentRequests = examTestPaperContentRequests;
    }
}
