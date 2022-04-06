package com.capgemini.coursesmanagementremastered.mapper;

import com.capgemini.coursesmanagementremastered.entity.Student;
import com.capgemini.coursesmanagementremastered.entity.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NewStudentMapper {

    @Mapping(ignore = true, target = "cnp")
    StudentDTO getDTOFromEntity(Student student);


    Student getEntityFromDTO(StudentDTO studentDTO);
}
