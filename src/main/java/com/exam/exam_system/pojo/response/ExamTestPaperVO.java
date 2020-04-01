package com.exam.exam_system.pojo.response;

import java.util.List;

/**
 * @Author :
 * @ClassName : ExamTestPaperVO
 * @Description :
 * @Date : 2020/4/1 13:28
 */
public class ExamTestPaperVO {

    private String testPaperName;

    private List<ExamTestPaperContentVO> examTestPaperContentVOS;

    public String getTestPaperName() {
        return testPaperName;
    }

    public void setTestPaperName(String testPaperName) {
        this.testPaperName = testPaperName;
    }

    public List<ExamTestPaperContentVO> getExamTestPaperContentVOS() {
        return examTestPaperContentVOS;
    }

    public void setExamTestPaperContentVOS(List<ExamTestPaperContentVO> examTestPaperContentVOS) {
        this.examTestPaperContentVOS = examTestPaperContentVOS;
    }
}
