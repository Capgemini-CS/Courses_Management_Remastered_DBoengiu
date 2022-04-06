package com.capgemini.coursesmanagementremastered.controller;

import com.capgemini.coursesmanagementremastered.entity.Student;
import com.capgemini.coursesmanagementremastered.repository.StudentRepository;
import com.capgemini.coursesmanagementremastered.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateStudent() throws Exception {
        Student tutorial = new Student(1, "John", "Doe", 1, "1234567890123");

        mockMvc.perform(post("/students/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tutorial)))
                .andExpect(status().isCreated())
                .andDo(print());
    }


    @Test
    void shouldReturnStudentById() throws Exception {
        int id = 1;
        Student student = new Student(1, "John", "Doe", 1, "1234567890123");

        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        mockMvc.perform(get("/students/{id}", id)).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldReturnListOfStudents() throws Exception {
        List<Student> students = new ArrayList<>(
                Arrays.asList(new Student(1, "John", "Doe", 1, "1234567890123"),
                        new Student(2, "Jane", "Smith", 2, "1234567890123"),
                        new Student(3, "Jim", "Hook", 3, "1234567890123")));

        when(studentRepository.findAll()).thenReturn(students);
        mockMvc.perform(get("/students/"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}