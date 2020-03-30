package com.exam.exam_system.pojo.request;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author :
 * @ClassName : AchievementRequest
 * @Description : 考试成绩作业
 * @Date : 2020/3/28 16:42
 */
public class AchievementRequest {

    private Long id;

    private Long subjectId;

    private Long examId;

    private Long userId;

    private Double achievement;

    private Date createTime;

    private Date modifyTime;

    private String examType;

    private String examName;

    private String subjectName;

    private String userName;

    private Double minAchievement;

    private Double maxAchievement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAchievement() {
        return achievement;
    }

    public void setAchievement(Double achievement) {
        this.achievement = achievement;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getMinAchievement() {
        return minAchievement;
    }

    public void setMinAchievement(Double minAchievement) {
        this.minAchievement = minAchievement;
    }

    public Double getMaxAchievement() {
        return maxAchievement;
    }

    public void setMaxAchievement(Double maxAchievement) {
        this.maxAchievement = maxAchievement;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
