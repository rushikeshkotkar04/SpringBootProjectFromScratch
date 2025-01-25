package com.StudentManagement.management.entities.MySQLstudentsRelated;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClassRooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classRoomId;

    private String classRoomName;

    @OneToMany(mappedBy = "classRoom",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Students> students;


    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
