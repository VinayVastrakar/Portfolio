package com.vinay.portfolio_backend.Dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectDTO {
    private Long projectId;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String projectUrl;
    private String repositoryUrl;
    private List<SkillDTO> skills;

    // Getters and setters
}
