package com.exam.exam_system.pojo.request;

import java.util.Date;

/**
 * @Author :
 * @ClassName : examTestpaperContent
 * @Description :
 * @Date : 2020/4/1 10:28
 */
public class ExamTestPaperContentRequest {

    private Long id;

    private Long testPaperNameId;

    private String title;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String answer;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestPaperNameId() {
        return testPaperNameId;
    }

    public void setTestPaperNameId(Long testPaperNameId) {
        this.testPaperNameId = testPaperNameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
