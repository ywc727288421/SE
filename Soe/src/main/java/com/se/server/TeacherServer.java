package com.se.server;

import com.se.mapper.TeacherMapper;
import com.se.pojo.Book;
import com.se.pojo.ClassLeader;
import com.se.pojo.GrantBooks;
import com.se.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServer {
    @Autowired
    private TeacherMapper teacherMapper = null;

    public List<Order> selectAllOrder(String username) {
        return teacherMapper.selectAllOrder(username);
    }

    public List<GrantBooks> getBooks() {
        return teacherMapper.getBooks();
    }

    //获取图书
    public List<Book> books() {
        return teacherMapper.books();
    }

    public List<Order> selectAllPassOrder(String username) {
        return teacherMapper.selectAllPassOrder(username);
    }

    public void insertOrder(int userId, int bookid, int booknum, int classid) {
        teacherMapper.insertOrder(userId, bookid, booknum, classid);
    }

    public List<ClassLeader> getAllClassLeader(int id) {
        return teacherMapper.selectAllClassLeader(id);
    }
}
