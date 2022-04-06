package com.capgemini.coursesmanagementremastered.mapper;

import com.capgemini.coursesmanagementremastered.entity.Student;
import com.capgemini.coursesmanagementremastered.entity.dto.StudentDTO;

@Deprecated
public class StudentMapper {
    public static StudentDTO toDTO (Student student){
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setYearOfStudy(student.getYearOfStudy());


        return studentDTO;
    }


    public static Student toEntity(StudentDTO studentDTO){
        Student student = new Student();

        student.setStudentId(studentDTO.getStudentId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setYearOfStudy(studentDTO.getYearOfStudy());
        student.setCnp(studentDTO.getCnp());


        return student;
    }
}
