package com.se.mapper;

import com.se.pojo.ClassLeader;
import com.se.pojo.Manager;
import com.se.pojo.Teacher;
import com.se.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author DeepBlue
 * @date 2019/10/31  21:04
 */

@Repository
public interface UserMapper {
    boolean uploadTeacher(User user);
    boolean uploadClassLeader(User user);
    boolean uploadManager(User user);
    String selectTeacherPassword(User user);
    String selectManagerPassword(User user);
    String selectClassLeaderPassword(User user);
}
