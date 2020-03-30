package com.exam.exam_system.pojo.request;

import java.util.Date;

/**
 * @Author :
 * @ClassName : UserRequest
 * @Description :
 * @Date : 2020/3/22 1:53
 */
public class UserRequest {
    private Long id;

    private String name;

    private String userName;

    private String userPwd;

    private Integer userAge;

    private Integer userMaxAge;

    private Integer userMinAge;

    private Integer userSex;

    private Integer userType;

    private String userSno;

    private Date createTime;

    private Date createMaxTime;

    private Date createMinTime;

    private Date modifyTime;

    private Integer isDeleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getUserSno() {
        return userSno;
    }

    public void setUserSno(String userSno) {
        this.userSno = userSno;
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

    public Integer getUserMaxAge() {
        return userMaxAge;
    }

    public void setUserMaxAge(Integer userMaxAge) {
        this.userMaxAge = userMaxAge;
    }

    public Integer getUserMinAge() {
        return userMinAge;
    }

    public void setUserMinAge(Integer userMinAge) {
        this.userMinAge = userMinAge;
    }

    public Date getCreateMaxTime() {
        return createMaxTime;
    }

    public void setCreateMaxTime(Date createMaxTime) {
        this.createMaxTime = createMaxTime;
    }

    public Date getCreateMinTime() {
        return createMinTime;
    }

    public void setCreateMinTime(Date createMinTime) {
        this.createMinTime = createMinTime;
    }
}
