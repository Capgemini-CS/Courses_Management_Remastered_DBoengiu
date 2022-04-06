package com.capgemini.coursesmanagementremastered.service;

import com.capgemini.coursesmanagementremastered.entity.Course;
import com.capgemini.coursesmanagementremastered.entity.Student;
import com.capgemini.coursesmanagementremastered.entity.StudentPage;
import com.capgemini.coursesmanagementremastered.entity.StudentSearchCriteria;
import com.capgemini.coursesmanagementremastered.entity.dto.StudentDTO;
import com.capgemini.coursesmanagementremastered.mapper.NewStudentMapper;
import com.capgemini.coursesmanagementremastered.repository.CourseRepository;
import com.capgemini.coursesmanagementremastered.repository.StudentCriteriaRepository;
import com.capgemini.coursesmanagementremastered.repository.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentCriteriaRepository studentCriteriaRepository;

    private NewStudentMapper studentMapper = Mappers.getMapper(NewStudentMapper.class);


    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, StudentCriteriaRepository studentCriteriaRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;

        this.studentCriteriaRepository = studentCriteriaRepository;
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student newStudent = studentRepository.save(studentMapper.getEntityFromDTO(studentDTO));
        return studentMapper.getDTOFromEntity(newStudent);

    }

    public StudentDTO getStudentById(Integer studentId) {
        Student foundStudent = studentRepository.getById(studentId);
        return studentMapper.getDTOFromEntity(foundStudent);

    }

    public void enrollStudent(Integer studentId, Integer courseId) {
        Course course = courseRepository.getById(courseId);
        Student student = studentRepository.getById(studentId);

        student.enrollInCourse(course);

        studentRepository.save(student);

    }

    public Page<Student> getStudents(StudentPage studentPage, StudentSearchCriteria studentSearchCriteria){
        return studentCriteriaRepository.findAllWithFilters(studentPage, studentSearchCriteria);
    }
}
