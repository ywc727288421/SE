package com.se.controller;

import com.se.pojo.*;
import com.se.server.ManagerServer;
import com.se.server.TeacherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServer teacherServer = null;

    @Autowired
    private ManagerController managerController = null;
    @Autowired
    private ManagerServer managerServer = null;

    @RequestMapping("/index")
    public String showPage() {
        return "teacher/teacherIndex";
    }


    //班长列表
    @RequestMapping("/class-list")
    public String classLeaderList(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session");
        List<ClassLeader> classLeaders = teacherServer.getAllClassLeader(managerServer.selectTeacherId(user.getUsername()));
        request.setAttribute("classLeader", classLeaders);
        return "teacher/classlist";
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request) throws UnsupportedEncodingException {
        return managerController.changePassword(request);
    }

    //修改资料
    @RequestMapping("member-edit")
    public String editPage(HttpServletRequest request) {
        return managerController.editPage(request);
    }

    //删除用户
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteTeacher(HttpServletRequest request, @RequestParam String id, @RequestParam String kind) {
        if (id != null) {
            managerServer.delete(id, kind);
        }
    }

    //修改班长密码
    @RequestMapping(value = "member-password2")
    public String editPasswordPage2(HttpServletRequest request, @RequestParam String username) {
        request.setAttribute("username", username);
        return "teacher/member-password2";
    }


    //班长信息修改
    @RequestMapping("/classleaderinfo")
    public String changeClassLeaderInfo(HttpServletRequest request, @RequestParam(required = false) String username
            , @RequestParam(required = false) String classid, @RequestParam(required = false) String department,
                                        @RequestParam(required = false) String email,
                                        @RequestParam(required = false) Integer po) {
        if (classid != null) {
            request.setAttribute("username", username);
            request.setAttribute("classid", classid);
            request.setAttribute("department", department);
            request.setAttribute("email", email);
        }
        if (po != null && po == 1) {
            managerServer.updateClassLeaderInfo(username, classid, department, email);
            request.setAttribute("message", "更新完成！");
        }
        return "teacher/classleaderinfo";
    }

    //教师信息修改
    @RequestMapping("/changeinfo")
    public String changeTeacherInfo(HttpServletRequest request, @RequestParam(required = false) String username
            , @RequestParam(required = false) String classid, @RequestParam(required = false) String department, @RequestParam(required = false) Integer po,
                                    @RequestParam(required = false) String email) {
        if (classid != null) {
            request.setAttribute("username", username);
            request.setAttribute("classid", classid);
            request.setAttribute("department", department);
            request.setAttribute("email", email);
        }
        if (po != null && po == 1) {
            managerServer.updateTeacherInfo(username, department, email);
            String[] cs = classid.split("\\,");
            System.out.println(cs);
            int userId = managerServer.selectTeacherId(username);
            managerServer.deleteClass(userId);
            for (int i = 0; i < cs.length; i++) {
                managerServer.updateClasses(userId, cs[i]);
            }
            request.setAttribute("message", "更新完成！");
        }
        return "teacher/changeinfo";
    }

    //订单页面,只有教师自己的
    @RequestMapping("/order-list")
    public String show1(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session");
        List<Order> orders = teacherServer.selectAllOrder(user.getUsername());
        request.setAttribute("orders", orders);
        return "teacher/order-list";
    }

    //获取图书列表
    @RequestMapping("/books")
    public String books(HttpServletRequest request) {
        List<Book> books = teacherServer.books();
        request.setAttribute("books", books);
        return "teacher/books";
    }

    //已经发放列表
    @RequestMapping("/grantlist")
    public String grantList(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session");
        List<Order> orders = teacherServer.selectAllPassOrder(user.getUsername());
        request.setAttribute("books", orders);
        return "teacher/grantlist";
    }

    @RequestMapping("/addneworder")
    public String getAddPage(HttpServletRequest request) {
        List<Book> books = teacherServer.books();
        request.setAttribute("books", books);
        return "teacher/addneworder";
    }

    @RequestMapping("/addneworders")
    public String insertToDB(HttpServletRequest request, int bookid, int booknum, int classid) {
        User user = (User) request.getSession().getAttribute("session");
        int teacherId = managerServer.selectTeacherId(user.getUsername());
        teacherServer.insertOrder(teacherId, bookid, booknum, classid);
        return "teacher/addneworder";
    }

    @RequestMapping("/welcome")
    public String show3(HttpServletRequest request) {
        return "managers/welcome";
    }
}
