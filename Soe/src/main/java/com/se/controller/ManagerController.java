package com.se.controller;

import com.se.pojo.*;
import com.se.server.ManagerServer;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.Class;
import java.util.List;

/**
 * @author DeepBlue
 * @date 2019/11/3  21:17
 */

@Controller
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerServer managerServer = null;

    //管理员主页
    @RequestMapping("/index")
    public String showPage(HttpServletRequest request) {
        return "managers/managerIndex";
    }

    //订单首页
    @RequestMapping("/order-list")
    public String show1(HttpServletRequest request) {
        List<Order> orders = managerServer.selectAllOrder();
        request.setAttribute("orders", orders);
        return "managers/order-list";
    }

    //教师列表
    @RequestMapping("/teacherlist")
    public String show2(HttpServletRequest request) {
        List<Teacher> teachers = managerServer.getAllTeacher();
        request.setAttribute("teachers", teachers);
        return "managers/teacherlist";
    }

    //班长列表
    @RequestMapping("/class-list")
    public String classLeaderList(HttpServletRequest request) {
        List<ClassLeader> classLeaders = managerServer.getAllClassLeader();
        request.setAttribute("classLeader", classLeaders);
        return "managers/classlist";
    }

    //改密码
    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String oldpassword = request.getParameterValues("oldpass")[0];
        String newPass = request.getParameterValues("newpass")[0];
        String newPass1 = request.getParameterValues("repass")[0];
        String username = request.getParameterValues("username")[0];
        String kind = request.getParameterValues("kind")[0];
        boolean flag = managerServer.checkDataAndUpdate(username, oldpassword, newPass, newPass1, kind);
        if (flag)
            request.setAttribute("message", "修改成功");
        else
            request.setAttribute("message", "修改失败,请检查");
        return "managers/member-password";
    }

    //修改资料
    @RequestMapping("member-edit")
    public String editPage(HttpServletRequest request) {
        return "managers/member-edit";
    }


    //修改老师密码
    @RequestMapping("member-password")
    public String editPasswordPage(HttpServletRequest request, @RequestParam String username) {
        request.setAttribute("username", username);
        return "managers/member-password";
    }

    //删除用户
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(HttpServletRequest request, @RequestParam String id, @RequestParam String kind) {
        if (id != null) {
            managerServer.delete(id, kind);
        }
    }

    //修改班长密码
    @RequestMapping(value = "member-password2")
    public String editPasswordPage2(HttpServletRequest request, @RequestParam String username) {
        request.setAttribute("username", username);
        return "managers/member-password2";
    }

    @RequestMapping("/welcome")
    public String show3(HttpServletRequest request) {
        return "managers/welcome";
    }

    //审批订单
    @RequestMapping("/approval")
    public void approval(HttpServletRequest request, @RequestParam int id, @RequestParam int state, @RequestParam int num) {
        managerServer.approval(id, state);
        if (state == 1) {
            managerServer.deduction(id, num);
        }
    }

    //待发放列表
    @RequestMapping("/wait-list")
    public String waitPage(HttpServletRequest request) {
        List<GrantBooks> grantBooks = managerServer.getBooks();
        request.setAttribute("grant", grantBooks);
        return "managers/wait-list";
    }

    //获取图书列表
    @RequestMapping("/books")
    public String books(HttpServletRequest request) {
        List<Book> books = managerServer.books();
        request.setAttribute("books", books);
        return "managers/books";
    }

    //增加图书库存
    @RequestMapping(value = "/addbook")
    public String addBook(HttpServletRequest request, String place, String time) {
        if (place != null && time != null) {
        }
        return "managers/addbook";
    }

    //改变图书数量的POST提交
    @RequestMapping("/changebooknum")
    public String changeBookNum(HttpServletRequest request,
                                @RequestParam int id, @RequestParam int num) {
        managerServer.changeBookNum(id, num);
        return "managers/changebooknum";
    }

    //获取修改图书页面
    @RequestMapping("/getchangenumPage")
    public String getChangePage(HttpServletRequest request, int id) {
        request.setAttribute("id", id);
        return "managers/changebooknum";
    }

    //增加新图书
    @RequestMapping("/addnewbook")
    public String addNewBook(@RequestParam(value = "bookname", required = false) String bookName,
                             @RequestParam(value = "booknum", required = false) Integer bookNum,
                             @RequestParam(value = "press", required = false) String press,
                             @RequestParam(value = "price", required = false) Double price) {
        if (bookName != null) {
            managerServer.addNewBook(bookName, bookNum, press, price);
        }
        return "managers/addnewbook";
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
        return "managers/classleaderinfo";
    }

    //发放图书
    @RequestMapping("/sendbook")
    public String sendBook(HttpServletRequest request, @RequestParam Integer id, @RequestParam(required = false) String time, @RequestParam(required = false) String place) {
        if (id != null) {
            request.setAttribute("id", id);
        }
        if (time != null) {
            managerServer.sendBook(id, time, place);
            request.setAttribute("message", "ok");
        }
        return "managers/sendbook";
    }

    //已经发放列表
    @RequestMapping("/grantlist")
    public String grantList(HttpServletRequest request) {
        List<Order> orders = managerServer.selectAllPassOrder();
        request.setAttribute("books", orders);
        return "managers/grantlist";
    }

    //教师信息修改
    @RequestMapping("/teacherinfo")
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
            int userId=managerServer.selectTeacherId(username);
            managerServer.deleteClass(userId);
            for (int i = 0; i < cs.length; i++) {
                managerServer.updateClasses(userId,cs[i]);
            }
            request.setAttribute("message", "更新完成！");
        }
        return "managers/teacherinfo";
    }
}
