package com.example.kenshu2app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data // ← これでgetter/setterを全部自動生成 
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "primary_id", nullable = false)
    private PrimarySkill primarySkill;

    @ManyToOne
    @JoinColumn(name = "secondary_id", nullable = false)
    private SecondarySkill secondarySkill;

    private Short level;       // スキルレベル
    private Integer expYear;   // 経験年月数
    private Short umu;         // 有無（0: 無, 1: 有）

    // getter/setter略
}

