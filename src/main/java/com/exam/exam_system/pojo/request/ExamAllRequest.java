package com.exam.exam_system.pojo.request;

/**
 * @Author :
 * @ClassName : ExamAllRequet
 * @Description :  考试列表请求
 * @Date : 2020/4/2 9:35
 */
public class ExamAllRequest {

    private String examName;

    private String subjectName;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
