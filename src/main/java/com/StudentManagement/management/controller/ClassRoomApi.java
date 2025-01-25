package com.StudentManagement.management.controller;


import com.StudentManagement.management.entities.MySQLstudentsRelated.ClassRooms;
import com.StudentManagement.management.entities.MySQLstudentsRelated.Students;
import com.StudentManagement.management.services.ClassRoomManagemnetService;
import com.StudentManagement.management.services.StudentManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassRoomApi {

    @Autowired
    private ClassRoomManagemnetService classRoomManagemnetService;

    @Autowired
    private StudentManagmentService studentManagmentService;

    @GetMapping("/{classRoomId}")
    public ResponseEntity<List<Students>> getStudentsOfClassRoom(@PathVariable int classRoomId){
        List<Students> students=studentManagmentService.getStudentsForClassRoom(classRoomId);
        return ResponseEntity.ok(students);
    }
    @PostMapping("/")
    public ResponseEntity<String> addingClassRoom(@RequestBody ClassRooms classRoom){
        String saveClassroom=classRoomManagemnetService.saveClassRoom(classRoom);
        return ResponseEntity.ok(saveClassroom);
    }


}
