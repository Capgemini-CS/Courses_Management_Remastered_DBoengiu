package com.capgemini.coursesmanagementremastered.repository;

import com.capgemini.coursesmanagementremastered.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
