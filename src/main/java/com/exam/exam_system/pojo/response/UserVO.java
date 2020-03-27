package com.exam.exam_system.pojo.response;

import java.util.Date;

/**
 * @Author :
 * @ClassName : UserVO
 * @Description :
 * @Date : 2020/3/22 1:46
 */
public class UserVO {

    private Long id;

    private String userName;

    private String userPwd;

    private Integer userAge;

    private Integer userSex;

    private Integer userType;

    private String userSecretProtection;

    private Date createTime;

    private Date modifyTime;

    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserSecretProtection() {
        return userSecretProtection;
    }

    public void setUserSecretProtection(String userSecretProtection) {
        this.userSecretProtection = userSecretProtection;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
