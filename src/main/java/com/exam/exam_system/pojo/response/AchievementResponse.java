package com.exam.exam_system.pojo.response;

/**
 * @Author :
 * @ClassName : AchievementResponse
 * @Description :
 * @Date : 2020/4/9 9:19
 */
public class AchievementResponse {
    private String answer;
    private String rightAnswers;
    private Integer achievement;
    private Integer grade;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(String rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
