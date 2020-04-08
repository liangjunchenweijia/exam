package com.exam.exam_system.pojo.response;

import java.util.Date;

/**
 * @Author :
 * @ClassName : ApplyExamResponse
 * @Description :
 * @Date : 2020/4/8 14:31
 */
public class ApplyExamResponse {

    private String examRule;

    private String minute;

    private Date startTime;

    private Date endTime;

    private Long examTestPaperId;

    public String getExamRule() {
        return examRule;
    }

    public void setExamRule(String examRule) {
        this.examRule = examRule;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
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

    public Long getExamTestPaperId() {
        return examTestPaperId;
    }

    public void setExamTestPaperId(Long examTestPaperId) {
        this.examTestPaperId = examTestPaperId;
    }
}
