package com.capgemini.coursesmanagementremastered.entity.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CourseDTO {

    private Integer courseId;
    @NotNull(message = "Course title should not be null!")
    private String title;
    private Integer numberOfCredits;

    

}
