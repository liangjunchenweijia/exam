package com.exam.exam_system.pojo;

/**
 * @Author :
 * @ClassName : ExamPojo
 * @Description :
 * @Date : 2020/4/2 9:27
 */
public class ExamPojo {

    private Long id;

    private String examName;

    private String subjectName;

    private Long examTestPaperId;

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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getExamTestPaperId() {
        return examTestPaperId;
    }

    public void setExamTestPaperId(Long examTestPaperId) {
        this.examTestPaperId = examTestPaperId;
    }
}
