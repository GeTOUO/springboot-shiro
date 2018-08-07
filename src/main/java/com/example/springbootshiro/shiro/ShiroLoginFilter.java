package com.example.springbootshiro.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author carzy
 * @date 2018/08/03
 */
@Component
public class ShiroLoginFilter extends FormAuthenticationFilter {

    /**
     * 在访问controller前判断是否登录，返回json，不进行重定向。
     *
     * @param request
     * @param response
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest request1 = WebUtils.toHttp(request);
        HttpServletResponse response1 = WebUtils.toHttp(response);
        if (request1.getMethod().equals(RequestMethod.OPTIONS.name())) {
            response1.setStatus(HttpStatus.OK.value());
            return true;
        }
        response1.setHeader("Access-Control-Allow-Origin", request1.getHeader("Origin"));
        response1.setHeader("Access-Control-Allow-Credentials", "true");
        response1.setContentType("application/json; charset=utf-8");
        response1.setStatus(HttpStatus.UNAUTHORIZED.value());
        response1.setCharacterEncoding("UTF-8");
        PrintWriter out = response1.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        Message message = new Message();
        message.code = HttpStatus.UNAUTHORIZED.value() + "";
        message.message = "登录认证失效，请重新登录!";
        out.println(mapper.writeValueAsString(message));
        out.flush();
        out.close();
        return false;
    }

    private class Message {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
