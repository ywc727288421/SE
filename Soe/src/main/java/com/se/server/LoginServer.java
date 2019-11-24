package com.se.server;

import com.se.mapper.UserMapper;
import com.se.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DeepBlue
 * @date 2019/11/2  17:35
 */
@Service
public class LoginServer {
    @Autowired
    private UserMapper userMapper = null;

    public boolean checkData(User user) {
        return !(user == null || user.getUsername().isEmpty() || user.getPassword().isEmpty());
    }

    public boolean checkLogin(User user) {
        switch (user.getIdentity()) {
            case "管理员":
                String password = userMapper.selectManagerPassword(user);
                return (user.getPassword().equals(password));
            case "老师":
                String password2 = userMapper.selectTeacherPassword(user);
                return (user.getPassword().equals(password2));
            case "班长":
                String password3=userMapper.selectClassLeaderPassword(user);
                return (user.getPassword().equals(password3));
            default:
                return false;
        }
    }

}
