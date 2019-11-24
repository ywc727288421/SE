package com.se.controller;

import com.se.pojo.User;
import com.se.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DeepBlue
 * @date 2019/11/2  17:34
 */
@Controller
public class LoginController {

    @Autowired
    private LoginServer loginServer = null;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showPage(ModelAndView mv) {
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameterValues("username")[0];
        String identity = request.getParameterValues("identity")[0];
        String password = request.getParameterValues("password")[0];
        User user = new User( identity,username, password);
        boolean flag = loginServer.checkData(user);
        if (flag) {
            boolean flag2 = loginServer.checkLogin(user);
            if (flag2) {
                switch (user.getIdentity()) {
                    case "管理员":
                        request.getSession().setAttribute("session", user);
                        response.sendRedirect("./managers/index");
                        break;
                    case "老师":
                        request.getSession().setAttribute("session", user);
                        response.sendRedirect("./teacher/index");
                        break;
                    case "班长":
                        request.getSession().setAttribute("session", user);
                        response.sendRedirect("./class/index");
                }
            } else {
                request.setAttribute("error", "用户名密码校验错误,请重新输入！");
                return "login";
            }
        } else {
            request.setAttribute("error", "信息校验错误,请检查是否注册以及字段值是否填写！");
        }
        return "login";
    }
}
