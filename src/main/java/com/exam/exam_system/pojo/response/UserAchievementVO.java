package com.exam.exam_system.pojo.response;

import java.util.List;

/**
 * @Author :
 * @ClassName : UserAchievementVO
 * @Description : 学生成绩作业
 * @Date : 2020/3/30 10:55
 */
public class UserAchievementVO {

    private String name;
    
    private List<ExamTypeVO> examTypeVOS;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExamTypeVO> getExamTypeVOS() {
        return examTypeVOS;
    }

    public void setExamTypeVOS(List<ExamTypeVO> examTypeVOS) {
        this.examTypeVOS = examTypeVOS;
    }
}
