package com.StudentManagement.management.entities.MySQLstudentsRelated;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rollNumber;


//    @NotNull(message = "First Name Cannot be null")
    private String firstName;

    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private ClassRooms classRoom;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private StudentDetails studentDetails;

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ClassRooms getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRooms classRoom) {
        this.classRoom = classRoom;
    }
}
