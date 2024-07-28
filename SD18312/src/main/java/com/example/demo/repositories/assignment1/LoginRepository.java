package com.example.demo.repositories.assignment1;

import com.example.demo.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class LoginRepository {
    private List<User> users;

    public LoginRepository(){
        this.users = new ArrayList<>();
        this.users.add(new User("hung", "1234"));
        this.users.add(new User("gia", "1234"));
    }

    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Xác thực thành công nếu tìm thấy người dùng có tên đăng nhập và mật khẩu khớp
            }
        }
        return false; // Xác thực không thành công nếu không tìm thấy người dùng khớp
    }
}
