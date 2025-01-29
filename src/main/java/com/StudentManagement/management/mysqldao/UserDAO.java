package com.StudentManagement.management.mysqldao;

import com.StudentManagement.management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
}
