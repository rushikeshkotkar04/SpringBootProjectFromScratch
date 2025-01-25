package com.StudentManagement.management.mysqldao;

import com.StudentManagement.management.entities.MySQLstudentsRelated.StudentDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDeatilsDAO extends CrudRepository<StudentDetails,Integer> {

    @Query("select sd from StudentDetails sd where sd.student.rollNumber=?1")
    List<StudentDetails> findDetailsByRollNumber(int rollnumber);
}
