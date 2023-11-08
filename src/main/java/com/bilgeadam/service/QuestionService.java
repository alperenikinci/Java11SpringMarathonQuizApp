package com.bilgeadam.service;

import com.bilgeadam.dto.request.OptionSaveRequestDto;
import com.bilgeadam.dto.request.QuestionSaveRequestDto;
import com.bilgeadam.dto.response.OptionResponseDto;
import com.bilgeadam.dto.response.QuestionResponseDto;
import com.bilgeadam.mapper.QuestionMapper;
import com.bilgeadam.repository.QuestionRepository;
import com.bilgeadam.repository.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final OptionService optionService;


    //TODO response Dto yazılacak.
    public Question saveQuestion(QuestionSaveRequestDto dto){
        Question question = null;
        List<OptionSaveRequestDto> optionList = dto.getOptionSaveRequestDtoList();
        if(optionList.size()>=2){
            question = questionRepository.save(QuestionMapper.INSTANCE.fromSaveRequestToQuestion(dto));
            question = optionService.saveAllOptions(dto.getOptionSaveRequestDtoList(),question);
            return questionRepository.save(question);
        } else {
            //TODO custom exception fırlatılacak.
            throw  new RuntimeException("aasdf");
        }

    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public QuestionResponseDto findByIdWithOptionData(Long id) {
        Optional<Question> questionOptional = questionRepository.findById(id);

        if(questionOptional.isPresent()){
            List<OptionResponseDto> optionResponseDtoList = optionService.findAllByQuestionId(questionOptional.get().getId());
            QuestionResponseDto questionResponseDto = QuestionResponseDto.builder()
                    .content(questionOptional.get().getQuestionContent())
                    .optionList(optionResponseDtoList)
                    .build();
            return questionResponseDto;
        }else {
            //TODO custom exception eklenecek.
            throw new RuntimeException("");
        }
    }

    public List<QuestionResponseDto> findAllWithOptionData(){
        List<Question> questionList = questionRepository.findAll();
        List<QuestionResponseDto> questionResponseDtoList = new ArrayList<>();
        if(questionList.size()>0){
            for(Question question: questionList){
                List<OptionResponseDto> optionResponseDtoList = optionService.findAllByQuestionId(question.getId());
                QuestionResponseDto questionResponseDto = QuestionResponseDto.builder()
                        .content(question.getQuestionContent())
                        .optionList(optionResponseDtoList)
                        .build();
                questionResponseDtoList.add(questionResponseDto);
            }
            return questionResponseDtoList;
        }else {
            throw new RuntimeException("hicbir soru bulunamadı...");
        }
    }
}
