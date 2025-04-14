package com.example.kenshu2app.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data // ← これでgetter/setterを全部自動生成 
@Entity
@Table(name = "users") 
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String createBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    @Column(name = "login_id", nullable = false, length = 20)
    private String loginId;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private short authority;

    private Integer age;

    @Column(length = 50)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups group;
 
}
