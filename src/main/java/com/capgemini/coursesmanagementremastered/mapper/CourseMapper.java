package com.capgemini.coursesmanagementremastered.mapper;

import com.capgemini.coursesmanagementremastered.entity.Course;
import com.capgemini.coursesmanagementremastered.entity.dto.CourseDTO;

@Deprecated
public class CourseMapper {

    public static CourseDTO toDTO (Course course){
        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setNumberOfCredits(course.getNumberOfCredits());

        return courseDTO;
    }


    public static Course toEntity(CourseDTO courseDTO){
        Course course = new Course();

        course.setCourseId(courseDTO.getCourseId());
        course.setTitle(courseDTO.getTitle());
        course.setNumberOfCredits(courseDTO.getNumberOfCredits());


        return course;
    }
}
