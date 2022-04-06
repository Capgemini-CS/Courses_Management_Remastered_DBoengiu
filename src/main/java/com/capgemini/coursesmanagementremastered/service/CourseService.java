package com.capgemini.coursesmanagementremastered.service;

import com.capgemini.coursesmanagementremastered.entity.Course;
import com.capgemini.coursesmanagementremastered.entity.dto.CourseDTO;
import com.capgemini.coursesmanagementremastered.mapper.NewCourseMapper;
import com.capgemini.coursesmanagementremastered.repository.CourseRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    private NewCourseMapper courseMapper = Mappers.getMapper(NewCourseMapper.class);



    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course newCourse = courseRepository.save(courseMapper.getEntityFromDTO(courseDTO));
        return courseMapper.getDTOFromEntity(newCourse);

    }

    public CourseDTO updateCourse(CourseDTO payload) {

        Course existingCourse = courseRepository.getById(payload.getCourseId());

        copyNonNullProperties(payload, existingCourse);
        courseRepository.save(existingCourse);

        return courseMapper.getDTOFromEntity(existingCourse);

    }


    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}
