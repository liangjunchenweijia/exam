package com.exam.exam_system.common.config;

import com.exam.exam_system.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Author : liang_Jun
 * @ClassName : WebConfigurer
 * @Description :
 * @Date : 2020/3/20 9:51
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {
    private final LoginInterceptor loginInterceptor;

    public WebConfigurer(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currUserMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    /**
     * 实例化自己的注解解析器
     *
     * @return
     */
    @Bean
    public CurrUserMethodArgumentResolver currUserMethodArgumentResolver() {
        return new CurrUserMethodArgumentResolver();
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/loginUser")
                .excludePathPatterns("/user/registerUser")
                .excludePathPatterns("/user/loginUser")
                .excludePathPatterns("/exam/login")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/templates/login.html");
        super.addInterceptors(registry);
    }

    /**
     * @param registry
     * @Author :
     * @Description : 配置静态资源
     * @Date : 2020/3/27 20:12
     * @Return :
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }
}
