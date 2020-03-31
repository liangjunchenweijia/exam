package com.exam.exam_system.service.userservice;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.constant.UserConstant;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.exception.UserException;
import com.exam.exam_system.mapper.timemapper.TimeMapper;
import com.exam.exam_system.mapper.usermapper.UserMapper;
import com.exam.exam_system.pojo.LoginUserPojo;
import com.exam.exam_system.pojo.request.UserRequest;
import com.exam.exam_system.pojo.response.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author :
 * @ClassName : UserService
 * @Description : 用户相关服务层
 * @Date : 2020/3/22 1:49
 */
@Transactional
@Service
public class UserService {
    //用户数据
    private final UserMapper userMapper;

    //时间服务
    private final TimeMapper timeMapper;

    @Autowired
    public UserService(UserMapper userMapper, TimeMapper timeMapper) {
        this.userMapper = userMapper;
        this.timeMapper = timeMapper;
    }

    /**
     * @param userRequest
     * @Author :
     * @Description : 注册用户
     * @Date : 2020/3/22 1:56
     * @Return :返回 影响行数
     **/
    public int saveUser(UserRequest userRequest) {
        userRequest.setIsDeleted(UserConstant.NOT_DELETED);
        //校验用户是否已存在
        UserVO userVO = userMapper.checkUser(userRequest.getUserName());
        if (null != userVO) {
            throw new UserException(ErrorMsgEnum.USER_ALREADY_EXISTED);
        }
        UserVO userInfo = userMapper.checkUserSno(userRequest.getUserSno());
        if (null != userInfo) {
            throw new UserException(ErrorMsgEnum.USER_SNO_ALREADY_EXISTED);
        }
        return userMapper.insertUser(userRequest);
    }

    /**
     * @param userRequest
     * @Author :
     * @Description : 用户登录
     * @Date : 2020/3/22 2:51
     * @Return : 返回 用户信息
     **/
    public LoginUserPojo findUserInfo(UserRequest userRequest) {
        LoginUserPojo loginUserPojo = userMapper.selectUserInfo(userRequest);
        if (null != loginUserPojo) {
            if (loginUserPojo.getIsDeleted() == 2) {
                throw new UserException(ErrorMsgEnum.PWD_MODIFY);
            }
        }
        return loginUserPojo;
    }

    /**
     * @param userRequest
     * @Author :
     * @Description :  密码找回
     * @Date : 2020/3/22 10:03
     * @Return :
     **/
    public String findPwd(UserRequest userRequest) {
        UserVO userInfo = userMapper.checkUser(userRequest.getUserName());
        if (null != userInfo) {
            throw new UserException(ErrorMsgEnum.USER_INEXISTENCE);
        }
        //模拟密码找回(通过输入注册时的用户名以及密保找回)
        UserVO userVO = userMapper.selectUserByNameAndEncrypted(userRequest);
        if (null == userVO) {
            throw new UserException(ErrorMsgEnum.USER_SNO_ERROR);
        }
        if (2 == userVO.getIsDeleted()) {
            throw new UserException(ErrorMsgEnum.PWD_MODIFY);
        }
        return userVO.getUserPwd();
    }

    /**
     * @param id 用户唯一编号
     * @Author :
     * @Description : 查询当前用户
     * @Date : 2020/3/22 11:22
     * @Return : 返回 用户详情
     **/
    public UserVO findUserById(Long id) {
        return userMapper.selectUserById(id);
    }

    /**
     * @param userRequest 用户唯一编号
     * @Author :
     * @Description : 当前用户信息修改
     * @Date : 2020/3/22 11:35
     * @Return : 返回影响行数
     **/
    public int alterUserById(UserRequest userRequest) {
        UserVO userVO = userMapper.checkUser(userRequest.getUserName());
        if (userVO != null && !userVO.getId().equals(userRequest.getId())) {
            throw new UserException(ErrorMsgEnum.USER_NAME_ALREADY_EXISTED);
        }
        UserVO userInfo = userMapper.checkUserSno(userRequest.getUserSno());
        if (null != userInfo && !userInfo.getId().equals(userRequest.getId())) {
            throw new UserException(ErrorMsgEnum.USER_SNO_ALREADY_EXISTED);
        }
        userRequest.setModifyTime(timeMapper.getTime());
        return userMapper.updateUserById(userRequest);
    }

    /**
     * @param
     * @Author :
     * @Description : 查询所有学生信息
     * @Date : 2020/3/22 16:05
     * @Return : 返回所有学生信息
     **/
    public PageResult<List<UserVO>> findUserAll(PageRequest<UserRequest> userRequest) {
        List<UserVO> userVOS = userMapper
                .selectUserAll(userRequest.getObj(), userRequest.getOffset(), userRequest.getLimit());
        int userCount = userMapper.selectUserAllCount(userRequest.getObj());
        return new PageResult<List<UserVO>>(userRequest.getPageNo(), userRequest.getPageSize(), userCount, userVOS);
    }

    /**
     * @param userIds
     * @Author :
     * @Description : 批量删除学生
     * @Date : 2020/3/22 16:52
     * @Return :
     **/
    public int batchDelStuByIds(List<Long> userIds) {
        return userMapper.batchDelStuByIds(userIds);
    }


}
