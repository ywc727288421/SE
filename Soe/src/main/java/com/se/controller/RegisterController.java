package com.se.controller;

import com.se.pojo.User;
import com.se.server.RegisterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author DeepBlue
 * @date 2019/10/31  13:43
 */

@Controller
public class RegisterController {
    @Autowired
    private RegisterServer registerServer = null;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegisterPage(ModelAndView mv) {
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request) throws UnsupportedEncodingException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取前端数据
        String identity = request.getParameterValues("identity")[0];
        String username = request.getParameterValues("username")[0];
        String email = request.getParameterValues("email")[0];
        String password = request.getParameterValues("password")[0];
        String password2 = request.getParameterValues("password2")[0];
        boolean flag;
        User user = null;
        user = new User(identity, username, password, password2, email);
        flag = registerServer.checkRegister(user);
        if (flag) {
            try {
                registerServer.uploadTodb(user);
                request.setAttribute("error", "注册成功!");
                return "register";
            } catch (Exception e) {
                request.setAttribute("error", "输入的用户名重复请使用其他用户名！");
                return "register";
            }
        } else {
            request.setAttribute("error", "校验出错,请检查输入是否正确！");
            return "register";
        }
    }

}
