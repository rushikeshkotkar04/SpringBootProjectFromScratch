package com.StudentManagement.management.mysqldao;

import com.StudentManagement.management.entities.MySQLstudentsRelated.ClassRooms;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClassRoomDAO extends CrudRepository<ClassRooms,Integer> {

    @Query("select c from ClassRooms c where c.classRoomId=?1")
    public ClassRooms findClassRoomById(int classRoomId);

}
