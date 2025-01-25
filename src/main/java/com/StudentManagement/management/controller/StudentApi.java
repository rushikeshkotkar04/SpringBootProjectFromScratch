package com.StudentManagement.management.controller;

import com.StudentManagement.management.customExceptions.CustomStudentNotFound;
import com.StudentManagement.management.entities.MySQLstudentsRelated.StudentDetails;
import com.StudentManagement.management.entities.MySQLstudentsRelated.Students;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import com.StudentManagement.management.services.StudentManagmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;





@RestController
@RequestMapping("students/")
@Slf4j
public class StudentApi {

    @Autowired
    private StudentManagmentService studentManagmentService;

    private Logger log= LoggerFactory.getLogger(StudentApi.class);

//    @Value("${spring.datasource.username}")
//    private String user;
//
    @Autowired
    private RestTemplate restTemplate;
//    private RestTemplate restTemplate = new RestTemplate();



//    ------------- Get Methods -------------------

    @GetMapping("/")
    public List<Students> getAllStudents() {
        System.out.println("Students");
//        log.info("Info About get Students");
        List<Students> students=studentManagmentService.getAllStudents();


        if (students==null){
            System.out.println("Here");
            throw new CustomStudentNotFound("Student Not Found",HttpStatus.NOT_FOUND);
        }
        return students;
    }

    @GetMapping("/{rollNumber}")
    public Students getStudentByRollNumber(@PathVariable int rollNumber){
        return studentManagmentService.getStudentByRollNumber(rollNumber);
    }

    //    ------------- Post Methods -------------------

    @PostMapping("/")
    public ResponseEntity<String> addStudents(@RequestBody List<Students> students){
        for(Students student:students){
            studentManagmentService.addStudents(student);
        }
        return ResponseEntity.ok().body("Added List of students");
    }


    @PostMapping("/{studentRollNumber}/{classRoomId}")
    public ResponseEntity<String> assignClassRoomToStudent(@PathVariable int studentRollNumber,@PathVariable int classRoomId){
        String assigningStudentToClassRoom=studentManagmentService.assignClassRoomToStudent(studentRollNumber,classRoomId);
        return ResponseEntity.ok(assigningStudentToClassRoom);
    }

    @PostMapping("/details/{studentId}")
    public ResponseEntity<String> addStudentsDetails(@PathVariable int studentId,@RequestBody StudentDetails studentDetails){
        System.out.println("Here 1");
        String res=studentManagmentService.addStudentDetails(studentId,studentDetails);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/externalApi")
    public ResponseEntity<Object> getDataFromExternalAPI(){
        String url="https://jsonplaceholder.typicode.com/users";
//        return restTemplate.exchange(url, HttpMethod.GET,null, Object.class);
        return restTemplate.exchange(url,HttpMethod.GET,null,Object.class);
    }

    @GetMapping("/details/{rollNumber}")
    public List<StudentDetails> getStudentsDetailsByRollNumber(@PathVariable int rollNumber){
        return studentManagmentService.getStudentsDetailsByRollNumber(rollNumber);
    }


}
