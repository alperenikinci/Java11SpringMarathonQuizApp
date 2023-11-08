package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.OptionSaveRequestDto;
import com.bilgeadam.dto.response.OptionResponseDto;
import com.bilgeadam.repository.entity.Option;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OptionMapper {

    OptionMapper INSTANCE = Mappers.getMapper(OptionMapper.class);

    Option fromSaveRequestToOption(OptionSaveRequestDto dto);
    OptionResponseDto fromOptionToResponse(Option option);

    List<Option> fromSaveRequestsToOptions(List<OptionSaveRequestDto> dtoList);
    List<OptionResponseDto> fromOptionsToResponses(List<Option> optionList);




}
