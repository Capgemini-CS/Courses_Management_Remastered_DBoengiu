package com.capgemini.coursesmanagementremastered.mapper;

import com.capgemini.coursesmanagementremastered.entity.Course;
import com.capgemini.coursesmanagementremastered.entity.dto.CourseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface NewCourseMapper {

    CourseDTO getDTOFromEntity(Course course);
    Course getEntityFromDTO(CourseDTO courseDTO);
}
