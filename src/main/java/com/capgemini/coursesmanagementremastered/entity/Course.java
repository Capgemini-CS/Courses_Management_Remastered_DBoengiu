package com.capgemini.coursesmanagementremastered.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@DynamicUpdate
@Entity(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "course_title")
    private String title;
    @Column(name = "credits")
    private Integer numberOfCredits;
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public Course(Integer courseId, String title, Integer numberOfCredits) {
        this.courseId = courseId;
        this.title = title;
        this.numberOfCredits = numberOfCredits;
    }
}
