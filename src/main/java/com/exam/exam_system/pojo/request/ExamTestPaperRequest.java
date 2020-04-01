package com.exam.exam_system.pojo.request;

import java.util.List;

/**
 * @Author :
 * @ClassName : ExamTestPaperRequest
 * @Description :
 * @Date : 2020/4/1 12:04
 */
public class ExamTestPaperRequest {

    private List<Long> ids;

    private List<ExamTestPaperContentRequest> examTestPaperContentRequests;

    public List<ExamTestPaperContentRequest> getExamTestPaperContentRequests() {
        return examTestPaperContentRequests;
    }

    public void setExamTestPaperContentRequests(List<ExamTestPaperContentRequest> examTestPaperContentRequests) {
        this.examTestPaperContentRequests = examTestPaperContentRequests;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
