package com.StudentManagement.management.services;

import com.StudentManagement.management.mysqldao.ClassRoomDAO;
import com.StudentManagement.management.mysqldao.StudentDAO;
import com.StudentManagement.management.mysqldao.StudentDeatilsDAO;
import com.StudentManagement.management.entities.MySQLstudentsRelated.ClassRooms;
import com.StudentManagement.management.entities.MySQLstudentsRelated.StudentDetails;
import com.StudentManagement.management.entities.MySQLstudentsRelated.Students;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentManagmentService {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private ClassRoomDAO classRoomDAO;

    @Autowired
    private StudentDeatilsDAO studentDeatilsDAO;

    private Logger logger= LoggerFactory.getLogger(StudentManagmentService.class);


    public List<Students> getAllStudents(){
//        Pageable pageable= PageRequest.of(6,3);
        return studentDAO.findAllStudents();
    }

    public Students getStudentByRollNumber(int rollNumber){
        return studentDAO.findByRollNumber(rollNumber);
    }

    public void addStudents(Students student){
        studentDAO.save(student);
    }

    public String assignClassRoomToStudent(int studentRollNumber,int classRoomId){
        Students student=studentDAO.findByRollNumber(studentRollNumber);
        ClassRooms classroom=classRoomDAO.findClassRoomById(classRoomId);
        if (student==null){
            return "No student with roll number "+studentRollNumber+" Present";
        }
        else if(classroom == null){
            return "No classRoom with Id "+classRoomId+" Present";
        }
        if (classroom.getStudents()==null){
            classroom.setStudents(new ArrayList<>());
        }
        classroom.getStudents().add(student);
        student.setClassRoom(classroom);
        studentDAO.save(student);
        classRoomDAO.save(classroom);
        return "Successfully added student to classroom";
    }

    public List<Students> getStudentsForClassRoom(int classRoomId){
        List<Students> students=studentDAO.getStudentsForClassRoomById(classRoomId);
        return students;
    }

    public String addStudentDetails(int studentId, StudentDetails studentDetail){
        Students student=studentDAO.findByRollNumber(studentId);
        if(student==null){
            return "Student not found";
        }
        System.out.println("Here");
        studentDetail.setStudent(student);

        studentDeatilsDAO.save(studentDetail);
        return "Successfully added";
    }

    public List<StudentDetails> getStudentsDetailsByRollNumber(int rollNumber){
        return studentDeatilsDAO.findDetailsByRollNumber(rollNumber);
    }


}
