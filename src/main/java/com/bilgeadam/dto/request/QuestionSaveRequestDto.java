package com.bilgeadam.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionSaveRequestDto {
    @Column(length = 2048)
    private String questionContent;
    private List<OptionSaveRequestDto> optionSaveRequestDtoList;
}
