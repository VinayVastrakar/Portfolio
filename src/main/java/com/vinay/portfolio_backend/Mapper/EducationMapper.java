package com.vinay.portfolio_backend.Mapper;

import com.vinay.portfolio_backend.Dto.EducationDTO;
import com.vinay.portfolio_backend.Models.Education;

public class EducationMapper {

    public static EducationDTO toDTO(Education education) {
        EducationDTO dto = new EducationDTO();
        dto.setEducationId(education.getEducationId());
        dto.setInstitutionName(education.getInstitutionName());
        dto.setDegree(education.getDegree());
        dto.setFieldOfStudy(education.getFieldOfStudy());
        dto.setStartDate(education.getStartDate());
        dto.setEndDate(education.getEndDate());
        return dto;
    }

    public static Education toEntity(EducationDTO dto) {
        Education education = new Education();
        education.setEducationId(dto.getEducationId());
        education.setInstitutionName(dto.getInstitutionName());
        education.setDegree(dto.getDegree());
        education.setFieldOfStudy(dto.getFieldOfStudy());
        education.setStartDate(dto.getStartDate());
        education.setEndDate(dto.getEndDate());
        return education;
    }
}
