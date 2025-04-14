package com.example.kenshu2app.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsersDTO {

    @NotBlank(message = "ログインIDは必須です")
    private String loginId;

    @NotBlank(message = "パスワードは必須です")
    private String password;

    @NotBlank(message = "氏名は必須です")
    private String name;

    @NotNull(message = "年齢は必須です")
    @Min(value = 0, message = "年齢は0以上で入力してください")
    @Max(value = 120, message = "年齢は120以下で入力してください")
    private Integer age;

    @NotNull(message = "グループは必須です")
    private GroupsDTO group;

    @NotNull(message = "権限は必須です")
    private Short authority;

    @Valid
    private List<SkillDTO> skills = new ArrayList<>();
}
