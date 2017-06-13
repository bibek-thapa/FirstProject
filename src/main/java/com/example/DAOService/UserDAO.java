package com.example.DAOService;

import com.example.data.UserDetail;

public interface UserDAO {
    public UserDetail findUserByEmail(String email);
    public void saveUser(UserDetail user);
}
