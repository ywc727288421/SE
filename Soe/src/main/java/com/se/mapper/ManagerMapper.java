package com.se.mapper;

import com.se.pojo.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {
    //管理用到的数据库方法
    List<Teacher> selectAllTeacher();

    //找到密码
    String findPassword(String username, String kind);

    //删除用户和订单
    void delete(String id, String kind);

    //修改密码
    void changeNewPassword(String username, String newPassword, String kind);

    //查询所有老师
    List<ClassLeader> selectAllClassLeader();

    //查询所有的订单
    List<Order> selectAllOrder();

    //更改订单状态
    void approval(int id, int state);

    //获取即将发放的所有书本
    List<GrantBooks> getBooks();

    //所有图书
    List<Book> books();

    //扣减余量
    void deduction(int id, int num);

    //改变图书余量
    void changeBookNum(int id, int num);

    //增加新图书
    void addNewBook(String name, int num, String press, double price);

    //sendBook
    void sendBook(int id, String time, String place);

    List<Order> selectAllPassOrder();

    void updateClassLeaderInfo(String username, String classid, String department, String email);

    void updateTeacherInfo(String username, String department, String email);

    void updateClasses(int username, String classId);

    int selectTeacherId(String username);

    void deleteClass(int id);
}
