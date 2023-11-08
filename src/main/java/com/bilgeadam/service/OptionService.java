package com.bilgeadam.service;

import com.bilgeadam.dto.request.OptionSaveRequestDto;
import com.bilgeadam.dto.response.OptionResponseDto;
import com.bilgeadam.mapper.OptionMapper;
import com.bilgeadam.repository.OptionRepository;
import com.bilgeadam.repository.entity.Option;
import com.bilgeadam.repository.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionService {
    private final OptionRepository optionRepository;

    public OptionResponseDto saveOption(OptionSaveRequestDto dto){
        Option option = OptionMapper.INSTANCE.fromSaveRequestToOption(dto);
        option = optionRepository.save(option);
        return OptionMapper.INSTANCE.fromOptionToResponse(option);
    }

    public List<OptionResponseDto> saveAllOptions(List<OptionSaveRequestDto> dtoList, Question question){
        List<Option> optionList = new ArrayList<>();
        List<Option> updatedOptionList = new ArrayList<>();

        optionList = OptionMapper.INSTANCE.fromSaveRequestsToOptions(dtoList);

        for(int i = 0; i<optionList.size();i++){
           Option option =  optionList.get(i);
           option.setQuestionId(question.getId());
           option.setOptionNo(i+1);
           updatedOptionList.add(option);
        }
        optionRepository.saveAll(updatedOptionList);
        /*


         */
        return OptionMapper.INSTANCE.fromOptionsToResponses(updatedOptionList);
    }
}
