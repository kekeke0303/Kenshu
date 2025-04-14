package com.example.kenshu2app.repository;


import com.example.kenshu2app.entity.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Long> {
    // loginIdなどで検索したいときはここに追加
	Optional<Users> findByLoginId(String loginId);
}