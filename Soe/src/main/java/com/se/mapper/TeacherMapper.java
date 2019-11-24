package com.se.mapper;

import com.se.pojo.Book;
import com.se.pojo.ClassLeader;
import com.se.pojo.GrantBooks;
import com.se.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    //所有图书
    List<Book> books();

    //查询所有的订单
    List<Order> selectAllOrder(String username);

    //获取即将发放的所有书本
    List<GrantBooks> getBooks();

    //获取发放的书本
    List<Order> selectAllPassOrder(String username);

    void insertOrder(int userId, int bookid, int booknum, int classid);

    List<ClassLeader> selectAllClassLeader(int id);
}
