package com.vinay.portfolio_backend.Mapper;

import com.vinay.portfolio_backend.Dto.SkillDTO;
import com.vinay.portfolio_backend.Models.Skill;

public class SkillMapper {

    public static SkillDTO toDTO(Skill skill) {
        SkillDTO dto = new SkillDTO();
        dto.setSkillId(skill.getSkillId());
        dto.setName(skill.getName());
        dto.setCategory(skill.getCategory());
        return dto;
    }

    public static Skill toEntity(SkillDTO dto) {
        Skill skill = new Skill();
        skill.setSkillId(dto.getSkillId());
        skill.setName(dto.getName());
        skill.setCategory(dto.getCategory());
        return skill;
    }
}
