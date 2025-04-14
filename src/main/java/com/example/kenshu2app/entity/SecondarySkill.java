package com.example.kenshu2app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data // ← これでgetter/setterを全部自動生成 
@Entity
@Table(name = "secondary_skill")
public class SecondarySkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "primary_id")
    private PrimarySkill primarySkill;

    // getter/setter略
}

