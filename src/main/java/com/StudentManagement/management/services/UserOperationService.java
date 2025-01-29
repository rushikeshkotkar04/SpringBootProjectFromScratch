package com.StudentManagement.management.services;

import com.StudentManagement.management.entities.User;
import com.StudentManagement.management.mysqldao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserOperationService {

    @Autowired
    private UserDAO userDAO;

    public String save(User user){
        userDAO.save(user);
        return "User Saved successFully";
    }
}
