package com.exam.exam_system.pojo.response;


import java.util.Date;
import java.util.List;

/**
 * @Author :
 * @ClassName : ExamTestPaperVO
 * @Description :
 * @Date : 2020/4/1 13:28
 */
public class ExamTestPaperVO {
    private Long id;

    private String testPaperName;

    private Long subjectId;

    private Date startTime;

    private Date endTime;
    private String minute;

    private List<ExamTestPaperContentVO> examTestPaperContentVOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestPaperName() {
        return testPaperName;
    }

    public void setTestPaperName(String testPaperName) {
        this.testPaperName = testPaperName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public List<ExamTestPaperContentVO> getExamTestPaperContentVOS() {
        return examTestPaperContentVOS;
    }

    public void setExamTestPaperContentVOS(List<ExamTestPaperContentVO> examTestPaperContentVOS) {
        this.examTestPaperContentVOS = examTestPaperContentVOS;
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

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
