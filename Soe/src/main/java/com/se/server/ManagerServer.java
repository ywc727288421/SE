package com.se.server;

import com.se.mapper.ManagerMapper;
import com.se.pojo.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServer {
    @Autowired
    private ManagerMapper managerMapper = null;

    public List<Teacher> getAllTeacher() {
        return managerMapper.selectAllTeacher();
    }

    public boolean checkDataAndUpdate(String username, String oldPass, String newPass, String newPass2, String kind) {
        if (username.isEmpty() || oldPass.isEmpty() || newPass.isEmpty() || newPass2.isEmpty()) {
            return false;
        }
        if (newPass.equals(newPass2)) {
            if (oldPass.equals(managerMapper.findPassword(username, kind))) {
                managerMapper.changeNewPassword(username, newPass, kind);
                return true;
            }
        }
        return false;
    }

    public void delete(String id, String kind) {
        managerMapper.delete(id, kind);
    }

    public List<ClassLeader> getAllClassLeader() {
        return managerMapper.selectAllClassLeader();
    }

    public List<Order> selectAllOrder() {
        return managerMapper.selectAllOrder();
    }

    //改变审批状态
    public void approval(int id, int state) {
        managerMapper.approval(id, state);
    }

    //获取待发放图书列表
    public List<GrantBooks> getBooks() {
        return managerMapper.getBooks();
    }

    //获取图书
    public List<Book> books() {
        return managerMapper.books();
    }

    //扣减余量
    public void deduction(int id, int num) {
        managerMapper.deduction(id, num);
    }

    //改变图书库存数量
    public void changeBookNum(int id, int num) {
        managerMapper.changeBookNum(id, num);
    }

    //增加新图书
    public void addNewBook(String name, int num, String press, double price) {
        managerMapper.addNewBook(name, num, press, price);
    }

    //添加订单到已发放
    public void sendBook(int id, String time, String place) {
        managerMapper.sendBook(id, time, place);
        managerMapper.approval(id, 3);
    }

    public List<Order> selectAllPassOrder() {
        return managerMapper.selectAllPassOrder();
    }

    public void updateClassLeaderInfo(String username, String classid, String department, String email) {
        managerMapper.updateClassLeaderInfo(username, classid, department, email);
    }

    public void updateTeacherInfo(String username, String department, String email) {
        managerMapper.updateTeacherInfo(username, department, email);
    }

    public void updateClasses(int username, String classId) {
        managerMapper.updateClasses(username, classId);
    }

    public int selectTeacherId(String username) {
        return managerMapper.selectTeacherId(username);
    }

    public void deleteClass(int id) {
        managerMapper.deleteClass(id);
    }
}
