package com.StudentManagement.management.mysqldao;

import com.StudentManagement.management.entities.MySQLstudentsRelated.Students;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO extends CrudRepository<Students,Integer> {


    @Query("select s from Students s")
    public List<Students> findAllStudents();

    @Query("Select s from Students s where s.rollNumber=?1")
    public Students findByRollNumber(int rollNumber);

    @Query("select s from Students s where s.classRoom.classRoomId=?1")
    public List<Students> getStudentsForClassRoomById(int classRoomId);
}
