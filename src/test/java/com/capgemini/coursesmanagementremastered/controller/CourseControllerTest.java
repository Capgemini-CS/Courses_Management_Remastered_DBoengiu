package com.capgemini.coursesmanagementremastered.controller;

import com.capgemini.coursesmanagementremastered.entity.Course;
import com.capgemini.coursesmanagementremastered.repository.CourseRepository;
import com.capgemini.coursesmanagementremastered.repository.StudentRepository;
import com.capgemini.coursesmanagementremastered.service.CourseService;
import com.capgemini.coursesmanagementremastered.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

    @MockBean
    private CourseRepository courseRepository;

    @MockBean
    private CourseService courseService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldUpdateTutorial() throws Exception {
        int id = 1;

        Course course = new Course(id, "Spring Boot @WebMvcTest", 5);
        Course updatedCourse = new Course(id, "Updated", 9);

        when(courseRepository.findById(id)).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Course.class))).thenReturn(updatedCourse);

        mockMvc.perform(put("/courses/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCourse)))
                .andExpect(status().isIAmATeapot())
                .andDo(print());
    }

}