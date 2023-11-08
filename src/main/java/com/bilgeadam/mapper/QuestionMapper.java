package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.QuestionSaveRequestDto;
import com.bilgeadam.repository.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question fromSaveRequestToQuestion(QuestionSaveRequestDto dto);
}
