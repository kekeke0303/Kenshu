package com.example.kenshu2app.repository;

import com.example.kenshu2app.entity.PrimarySkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimarySkillRepository extends JpaRepository<PrimarySkill, Long> {
}
