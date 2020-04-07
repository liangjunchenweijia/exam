package com.exam.exam_system.pojo;

import java.util.Date;

/**
 * @Author :
 * @ClassName : StuExamPojo
 * @Description : 学生考试列表作业
 * @Date : 2020/4/7 10:10
 */
public class StuExamPojo {

    private Long id;

    private Long subjectId;

    private String subjectName;

    private Long examTypeId;

    private String examName;

    private Date startTime;

    private Date endTime;

    public Long getSubjectId() {
        return subjectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(Long examTypeId) {
        this.examTypeId = examTypeId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
