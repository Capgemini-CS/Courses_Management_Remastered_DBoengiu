package com.capgemini.coursesmanagementremastered.repository;

import com.capgemini.coursesmanagementremastered.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
