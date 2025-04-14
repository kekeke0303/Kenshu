package com.example.kenshu2app.repository;

import com.example.kenshu2app.entity.SecondarySkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondarySkillRepository extends JpaRepository<SecondarySkill, Long> {
    List<SecondarySkill> findByPrimarySkillId(Long primaryId); // プライマリIDに紐づくセカンダリ取得用
}
