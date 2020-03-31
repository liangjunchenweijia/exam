package com.exam.exam_system.pojo.response;

import java.util.Date;
import java.util.List;

/**
 * @Author :
 * @ClassName : ExamVO
 * @Description :
 * @Date : 2020/3/26 15:17
 */
public class ExamVO {

    private Long id;


    private Long userId;

    private String name;


    private String subjectId;


    private Long examTypeId;


    private Integer status;


    private Date createTime;


    private Date modifyTime;

    private String examName;

    private List<String> subjectName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
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

    public List<String> getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(List<String> subjectName) {
        this.subjectName = subjectName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
