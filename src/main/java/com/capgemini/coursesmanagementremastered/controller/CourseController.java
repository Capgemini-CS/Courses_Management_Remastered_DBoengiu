package com.capgemini.coursesmanagementremastered.controller;

import com.capgemini.coursesmanagementremastered.entity.dto.CourseDTO;
import com.capgemini.coursesmanagementremastered.service.CourseService;
import org.springframework.beans.FatalBeanException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/")
    public ResponseEntity<CourseDTO> add(@RequestBody @Valid CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.addCourse(courseDTO), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<CourseDTO> update(@RequestBody CourseDTO payload) {
        return new ResponseEntity<>(courseService.updateCourse(payload), HttpStatus.I_AM_A_TEAPOT);
    }




}
