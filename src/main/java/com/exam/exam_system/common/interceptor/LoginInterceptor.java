package com.exam.exam_system.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.common.constant.LoginUserConstant;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author :
 * @ClassName : LoginInterceptor
 * @Description : 登录拦截器
 * @Date : 2020/3/22 10:34
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginName = request.getSession().getAttribute(LoginUserConstant.LoginUser);
        if (null == loginName || (loginName instanceof String)) {
//            Result<String> result = new Result<>(ErrorMsgEnum.NOT_LOGIN.getCode(), ErrorMsgEnum.NOT_LOGIN.getMsg());
            response.sendRedirect("/templates/login.html");
//            returnJson(response, result);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 返回Json字符串
     *
     * @param response 相应对象
     * @param object   要转换的对象
     */
    private void returnJson(HttpServletResponse response, Object object) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            String json = JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
            writer.print(json);
        } catch (IOException e) {
            logger.error("response error", e);
        }
    }
}
