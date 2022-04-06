package com.capgemini.coursesmanagementremastered.controller;

import com.capgemini.coursesmanagementremastered.entity.Student;
import com.capgemini.coursesmanagementremastered.entity.StudentPage;
import com.capgemini.coursesmanagementremastered.entity.StudentSearchCriteria;
import com.capgemini.coursesmanagementremastered.entity.dto.StudentDTO;
import com.capgemini.coursesmanagementremastered.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public ResponseEntity<StudentDTO> add(@RequestBody @Valid StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.addStudent(studentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("{student_id}/course/{course_id}")
    public void enrollStudent(@PathVariable("student_id") Integer studentId, @PathVariable("course_id") Integer courseId) {
        studentService.enrollStudent(studentId, courseId);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<Student>> getStudents(StudentPage studentPage, StudentSearchCriteria studentSearchCriteria) {
        return new ResponseEntity<>(studentService.getStudents(studentPage, studentSearchCriteria), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

}
