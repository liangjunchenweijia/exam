package com.exam.exam_system.pojo;

import com.exam.exam_system.pojo.request.StuExamRequest;

import java.util.List;

/**
 * @Author :
 * @ClassName : ApplyExamPojo
 * @Description :
 * @Date : 2020/4/9 8:54
 */
public class ApplyExamPojo {
    private List<StuExamRequest> stuExamRequests;

    public List<StuExamRequest> getStuExamRequests() {
        return stuExamRequests;
    }

    public void setStuExamRequests(List<StuExamRequest> stuExamRequests) {
        this.stuExamRequests = stuExamRequests;
    }
}
