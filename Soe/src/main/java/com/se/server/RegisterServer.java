package com.se.server;

import com.se.mapper.UserMapper;
import com.se.pojo.ClassLeader;
import com.se.pojo.Manager;
import com.se.pojo.Teacher;
import com.se.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DeepBlue
 * @date 2019/10/31  15:10
 */


@Service
public class RegisterServer {

    @Autowired
    private UserMapper userMapper = null;

    //检查密码是否相符
    public boolean checkRegister(User user) {
        if (user == null || user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getIdentity().isEmpty()) {
            return false;
        } else {
            return user.getPassword().equals(user.getPassword2());
        }
    }

    public boolean uploadTodb(User user) throws Exception {
        switch (user.getIdentity()) {
            case "管理员":
                return uploadManager(user);
            case "老师":
                return uploadTeacher(user);
            case "班长":
                return uploadClassLeader(user);
            default:
                return false;
        }
    }

    public boolean uploadTeacher(User teacher) {
        return userMapper.uploadTeacher(teacher);
    }

    public boolean uploadManager(User manager) {
        return userMapper.uploadManager(manager);
    }

    public boolean uploadClassLeader(User classLeader) {
        return userMapper.uploadClassLeader(classLeader);
    }
}
