package com.exam.exam_system.pojo.response;

import java.util.Date;
import java.util.List;

/**
 * @Author :
 * @ClassName : ExamTypeVO
 * @Description :
 * @Date : 2020/3/24 15:24
 */
public class ExamTypeVO {

    private Long id;


    private String examName;


    private String examMold;


    private Date examTime;


    private String subjectId;

    private List<String> subjectName;

    private String remark;

    private Integer status;

    private Date modifyTime;

    private Date createTime;

    private List<SubjectVO> subjectNames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamMold() {
        return examMold;
    }

    public void setExamMold(String examMold) {
        this.examMold = examMold;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<String> getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(List<String> subjectName) {
        this.subjectName = subjectName;
    }

    public List<SubjectVO> getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(List<SubjectVO> subjectNames) {
        this.subjectNames = subjectNames;
    }
}
