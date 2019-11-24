package com.se.controller;

import com.se.pojo.Order;
import com.se.pojo.User;
import com.se.server.ClassLeaderServer;
import com.se.server.ManagerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author DeepBlue
 * @date 2019/11/5  16:15
 */
@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassLeaderServer classLeaderServer = null;

    @Autowired
    private ManagerServer managerServer=null;
    @RequestMapping("/index")
    public String showPage() {
        return "class/classIndex";
    }

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        return "managers/welcome";
    }

    @RequestMapping("/changeinfo")
    public String changeinfo() {
        return "class/changeinfo";
    }


    //已经发放列表
    @RequestMapping("/grantlist")
    public String grantList(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session");
        List<Order> orders = classLeaderServer.selectAllPassOrder(user.getUsername());
        request.setAttribute("books", orders);
        return "teacher/grantlist";
    }

    //班长信息修改
    @RequestMapping("/classleaderinfo")
    public String changeClassLeaderInfo(HttpServletRequest request, @RequestParam(required = false) String username
            , @RequestParam(required = false) String classid, @RequestParam(required = false) String department,
                                        @RequestParam(required = false) String email,
                                        @RequestParam(required = false) Integer po) {
        User user = (User) request.getSession().getAttribute("session");
        request.setAttribute("username", user.getUsername());
        if (po != null && po == 1) {
            managerServer.updateClassLeaderInfo(user.getUsername(), classid, department, email);
            request.setAttribute("message", "更新完成！");
        }
        return "class/changeinfo";
    }
}
