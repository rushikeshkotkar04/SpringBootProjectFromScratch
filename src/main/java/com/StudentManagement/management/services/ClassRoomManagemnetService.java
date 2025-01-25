package com.StudentManagement.management.services;


import com.StudentManagement.management.mysqldao.ClassRoomDAO;
import com.StudentManagement.management.entities.MySQLstudentsRelated.ClassRooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomManagemnetService {

    @Autowired
    private ClassRoomDAO classRoomDAO;


    public String saveClassRoom(ClassRooms classRoom){
        classRoomDAO.save(classRoom);
        return "Saved classroom successfully";
    }
}
