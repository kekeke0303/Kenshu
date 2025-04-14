package com.example.kenshu2app.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data // ← これでgetter/setterを全部自動生成
@Entity
@Table(name = "primary_skill")
public class PrimarySkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "primarySkill")
    private List<SecondarySkill> secondarySkills;

    // getter/setter略
}
