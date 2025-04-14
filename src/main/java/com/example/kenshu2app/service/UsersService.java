package com.example.kenshu2app.service;

import com.example.kenshu2app.dto.UsersDTO;
import com.example.kenshu2app.entity.*;
import com.example.kenshu2app.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private GroupsRepository groupRepository;
    @Autowired
    private PrimarySkillRepository primarySkillRepository;
    @Autowired
    private SecondarySkillRepository secondarySkillRepository;
    
    public void registerUser(UsersDTO dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(dto.getPassword());

        // ユーザー登録
        Users user = new Users();
        user.setLoginId(dto.getLoginId());
        user.setPassword(encodedPassword);
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setAuthority(dto.getAuthority());
        
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        
        user.setCreateBy(currentUser);
        user.setCreatedDate(LocalDateTime.now());
        user.setLastModifiedBy(currentUser);
        user.setLastModifiedDate(LocalDateTime.now());
        user.setGroup(groupRepository.findById(dto.getGroup().getId()).orElse(null));
        Users savedUser = usersRepository.save(user);

        // スキルリストをループして登録
        dto.getSkills().forEach(skillDTO -> {
            Skill skill = new Skill();
            skill.setUser(savedUser);
            skill.setPrimarySkill(primarySkillRepository.findById(skillDTO.getPrimarySkillId()).orElse(null));
            skill.setSecondarySkill(secondarySkillRepository.findById(skillDTO.getSecondarySkillId()).orElse(null));
            skill.setLevel(skillDTO.getLevel());
            skill.setUmu(skillDTO.getUmu());
            skill.setExpYear(skillDTO.getExpYear());
            skillRepository.save(skill);
        });
    }
}
