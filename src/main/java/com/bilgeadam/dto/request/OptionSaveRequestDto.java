package com.bilgeadam.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionSaveRequestDto {

    @Column(length = 2048,nullable = false)
    private String optionContent;

    @Builder.Default
    private Boolean isCorrectAnswer = false;

}
