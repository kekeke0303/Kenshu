
package com.example.kenshu2app.dto;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SkillDTO {
	
    @NotNull(message = "プライマリスキルは必須です")
    private Long primarySkillId;

    @NotNull(message = "セカンダリスキルは必須です")
    private Long secondarySkillId;

    @NotNull(message = "スキルレベルは必須です")
    @Min(1)
    @Max(5)
    private Short level;

    @NotNull(message = "案件利用有無を選択してください")
    private Short umu;

    @Min(value = 0, message = "経験年数は0以上で入力してください")
    private Integer expYear;
}
