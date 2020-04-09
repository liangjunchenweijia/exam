package com.exam.exam_system.mapper.usermapper;

import com.exam.exam_system.pojo.AchievementPojo;
import com.exam.exam_system.pojo.LoginUserPojo;
import com.exam.exam_system.pojo.request.AchievementRequest;
import com.exam.exam_system.pojo.request.UserRequest;
import com.exam.exam_system.pojo.response.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :
 * @ClassName : UserMapper
 * @Description : 用户相关数据层
 * @Date : 2020/3/22 1:47
 */
public interface UserMapper {
    /**
     * @param userRequest
     * @Author :
     * @Description : 注册用户
     * @Date : 2020/3/22 1:58
     * @Return :  返回 影响行数
     **/
    int insertUser(@Param("userRequest") UserRequest userRequest);

    /**
     * @param userName
     * @Author :
     * @Description : 校验用户是否已存在
     * @Date : 2020/3/22 2:20
     * @Return : 返回总数
     **/
    UserVO checkUser(@Param("userName") String userName);

    /**
     * @param userRequest
     * @Author :
     * @Description : 用户登录
     * @Date : 2020/3/22 2:52
     * @Return : 返回用户信息
     **/
    LoginUserPojo selectUserInfo(@Param("userRequest") UserRequest userRequest);

    /**
     * @param userRequest
     * @Author :
     * @Description : 通过用户名称和用户密码查询用户信息
     * @Date : 2020/3/22 10:09
     * @Return : 返回用户信息
     **/
    UserVO selectUserByNameAndEncrypted(@Param("userRequest") UserRequest userRequest);

    /**
     * @param id 用户唯一编号
     * @Author :
     * @Description : 根据唯一编号查询用户信息
     * @Date : 2020/3/22 11:23
     * @Return : 返回用户信息
     **/
    UserVO selectUserById(@Param("id") Long id);

    /**
     * @param userRequest
     * @Author :
     * @Description : 根据唯一编号修改用户信息
     * @Date : 2020/3/22 11:36
     * @Return : 返回影响行数
     **/
    int updateUserById(@Param("userRequest") UserRequest userRequest);

    /**
     * @param
     * @Author :
     * @Description : 分页查询所有学生信息
     * @Date : 2020/3/22 16:06
     * @Return : 返回所有学生信息
     **/
    List<UserVO> selectUserAll(@Param("userRequest") UserRequest userRequest, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * @param userRequest
     * @Author :
     * @Description : 查询所有学生总数
     * @Date : 2020/3/22 16:18
     * @Return : 返回所有学生总数
     **/
    Integer selectUserAllCount(@Param("userRequest") UserRequest userRequest);

    /**
     * @param userIds
     * @Author :
     * @Description : 批量删除学生
     * @Date : 2020/3/22 16:53
     * @Return :
     **/
    int batchDelStuByIds(@Param("userIds") List<Long> userIds);

    /**
     * @param userSno
     * @Author :
     * @Description : 验证学号
     * @Date : 2020/3/28 10:33
     * @Return :
     **/
    UserVO checkUserSno(@Param("userSno") String userSno);

    /**
     * @param request
     * @param offset
     * @param limit
     * @Author :
     * @Description : 查询考试成绩
     * @Date : 2020/4/9 13:41
     * @Return :
     **/
    List<AchievementPojo> selectAchievement(@Param("request") AchievementRequest request, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * @param request
     * @Author :
     * @Description : 查询考试成绩总数
     * @Date : 2020/4/9 13:45
     * @Return :
     **/
    int selectAchievementCount(@Param("request") AchievementRequest request);

}
