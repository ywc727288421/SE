package com.se.server;


import com.se.mapper.ClassLeaderMapper;
import com.se.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassLeaderServer {
    @Autowired
    private ClassLeaderMapper classLeaderMapper = null;

    public List<Order> selectAllPassOrder(String username) {
        return classLeaderMapper.selectAllPassOrder(username);
    }
}
