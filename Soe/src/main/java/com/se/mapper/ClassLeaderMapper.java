package com.se.mapper;


import com.se.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassLeaderMapper {
    List<Order> selectAllPassOrder(String username);
}
