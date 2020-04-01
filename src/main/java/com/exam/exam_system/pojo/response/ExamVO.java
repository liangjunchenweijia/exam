package com.exam.exam_system.pojo.response;

import java.util.Date;

/**
 * @Author :
 * @ClassName : ExamVO
 * @Description :
 * @Date : 2020/3/26 15:17
 */
public class ExamVO {

    private Long id;


    private Long subjectId;


    private Long examTestPaperId;


    private Long examTypeId;


    private Integer status;


    private Date startTime;


    private Date endTime;


    private Date createTime;


    private Date modifyTime;

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

    public Long getExamTestPaperId() {
        return examTestPaperId;
    }

    public void setExamTestPaperId(Long examTestPaperId) {
        this.examTestPaperId = examTestPaperId;
    }

    public Long getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(Long examTypeId) {
        this.examTypeId = examTypeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
