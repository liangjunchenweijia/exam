package com.exam.exam_system.controller.usercontroller;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.common.config.annotation.LoginUser;
import com.exam.exam_system.common.constant.LoginUserConstant;
import com.exam.exam_system.common.constant.UserConstant;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.exception.UserException;
import com.exam.exam_system.pojo.LoginUserPojo;
import com.exam.exam_system.pojo.request.UserIdsRequest;
import com.exam.exam_system.pojo.request.UserRequest;
import com.exam.exam_system.pojo.response.UserVO;
import com.exam.exam_system.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author :
 * @ClassName : UserController
 * @Description : 用户相关控制器
 * @Date : 2020/3/22 1:50
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    //用户服务
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param userRequest
     * @Author :
     * @Description :用户注册
     * @Date : 2020/3/22 1:54
     * @Return :
     **/
    @PostMapping("/registerUser")
    public Result<Object> registerUser(@RequestBody UserRequest userRequest) {
        logger.info("注册用户：{}", JSON.toJSONString(userRequest));
        if (null == userRequest) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        try {
            userService.saveUser(userRequest);
        } catch (UserException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        return new Result<Object>();
    }

    /**
     * @param userRequest
     * @Author :
     * @Description :  用户登录
     * @Date : 2020/3/22 2:48
     * @Return :
     **/
    @PostMapping("/loginUser")
    public Result<LoginUserPojo> loginUser(@RequestBody UserRequest userRequest, HttpSession session) {
        logger.info("用户登录:{}", JSON.toJSONString(userRequest));
        LoginUserPojo userInfo = null;
        if (null == userRequest) {
            return new Result<LoginUserPojo>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        try {
            userInfo = userService.findUserInfo(userRequest);
        } catch (UserException e) {
            return new Result<LoginUserPojo>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        if (null != userInfo) {
            session.setAttribute(LoginUserConstant.LoginUser, userInfo);
            return new Result<LoginUserPojo>(userInfo);
        }
        return new Result<LoginUserPojo>(ErrorMsgEnum.USER_PWD_OR_USER_NAME_ERROR.getCode(), ErrorMsgEnum.USER_PWD_OR_USER_NAME_ERROR.getMsg());
    }

    /**
     * @param
     * @Author :
     * @Description : 用户密码找回
     * @Date : 2020/3/22 9:59
     * @Return : 返回找回的密码
     **/
    @PostMapping("/userPwdRetrieve")
    public Result<String> userPwdRetrieve(@RequestBody UserRequest userRequest) {
        logger.info("用户密码找回：{}", JSON.toJSONString(userRequest));
        String pwd = null;
        try {
            pwd = userService.findPwd(userRequest);
        } catch (UserException e) {
            return new Result<String>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        logger.info("用户密码找回：{}", pwd);
        return new Result<String>(UserConstant.USERPWD + pwd);
    }

    /**
     * @param userLogin
     * @Author :
     * @Description : 查询当前用户详情
     * @Date : 2020/3/22 11:20
     * @Return : 返回用户详细信息
     **/
    @GetMapping("/queryUserById")
    public Result<UserVO> queryUserById(@LoginUser LoginUserPojo userLogin, Long id) {
        logger.info("查询当前用户详情:{}", JSON.toJSONString(userLogin));
        UserVO user = new UserVO();
        if (null != userLogin) {
            user = userService.findUserById(userLogin.getId());
        } else {
            user = userService.findUserById(id);
        }
        logger.info("查询当前用户详情返回：{}", JSON.toJSONString(user));
        return new Result<UserVO>(user);
    }

    /**
     * @param userLogin
     * @param userRequest
     * @Author :
     * @Description : 修改当前用户信息
     * @Date : 2020/3/22 11:33
     * @Return :
     **/
    @PostMapping("/modifyUserById")
    public Result<Object> modifyUserById(@RequestBody UserRequest userRequest, @LoginUser LoginUserPojo userLogin, HttpServletRequest request) {
        logger.info("修改当前用户信息：{}", JSON.toJSONString(userLogin));
        if (null == userRequest || null == userLogin) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        userRequest.setId(userLogin.getId());
        //修改前查出未修改前的用户名称和密码
        UserVO user = userService.findUserById(userRequest.getId());
        int line = 0;
        try {
            line = userService.alterUserById(userRequest);
        } catch (UserException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        if (line == 1) {
            //如果修改的用户名或者用户密码与之前不一致,强制退出,重新登陆
            if (!userRequest.getUserName().equals(user.getUserName())
                    || !userRequest.getUserPwd().equals(user.getUserPwd())) {
                request.getSession().invalidate();
                return new Result<Object>(ErrorMsgEnum.LOGIN_AGAIN.getCode(), ErrorMsgEnum.LOGIN_AGAIN.getMsg());
            }
            return new Result<Object>();
        }
        return new Result<Object>(ErrorMsgEnum.UPDATE_USER_ERROR.getCode(), ErrorMsgEnum.UPDATE_USER_ERROR.getMsg());
    }

    /**
     * @param userRequest
     * @Author :
     * @Description : 管理员修改用户信息
     * @Date : 2020/3/31 12:24
     * @Return :
     **/
    @PostMapping("/adminModifyUserById")
    public Result<Object> adminModifyUserById(@RequestBody UserRequest userRequest) {
        logger.info("管理员修改用户信息:{}", JSON.toJSONString(userRequest));
        if (null == userRequest) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        try {
            userService.alterUserById(userRequest);
        } catch (UserException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        return new Result<Object>();
    }

    /**
     * @param
     * @Author :
     * @Description :  查询所有类型为学生的信息(分页筛选)
     * @Date : 2020/3/22 14:08
     * @Return : 返回所有用户信息
     **/
    @RequestMapping("/queryUserAll")
    public PageResult<List<UserVO>> queryUserAll(@RequestBody PageRequest<UserRequest> userRequest) {
        logger.info("查询所有类型为学生的信息：{}", JSON.toJSONString(userRequest));
        PageResult<List<UserVO>> userAll = userService.findUserAll(userRequest);
        logger.info("查询所有类型为学生的信息返回:{}", JSON.toJSONString(userAll));
        return new PageResult<List<UserVO>>(userAll.getPageNo(), userAll.getPageSize(), userAll.getTotal(), userAll.getObj());
    }

    /**
     * @param userIds 学生id
     * @Author :
     * @Description :  批量删除用户为学生(类型)逻辑删除
     * @Date : 2020/3/22 16:49
     * @Return :
     **/
    @PostMapping("/batchRemoveStu")
    public Result<Object> batchRemoveStu(@RequestBody UserIdsRequest userIds) {
        if (null == userIds) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        logger.info("批量删除用户为学生:{}", JSON.toJSONString(userIds));
        userService.batchDelStuByIds(userIds.getUserIds());
        return new Result<Object>();
    }


}
