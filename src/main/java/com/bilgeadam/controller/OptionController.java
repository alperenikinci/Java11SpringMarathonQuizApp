package com.bilgeadam.controller;

import com.bilgeadam.dto.request.OptionSaveRequestDto;
import com.bilgeadam.dto.response.OptionResponseDto;
import com.bilgeadam.repository.QuestionRepository;
import com.bilgeadam.repository.entity.Option;
import com.bilgeadam.repository.entity.Question;
import com.bilgeadam.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bilgeadam.constants.RestApi.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(OPTION)
public class OptionController {

    private final OptionService optionService;


//    @PostMapping(SAVE)
//    public ResponseEntity<OptionResponseDto> saveOption(@RequestBody OptionSaveRequestDto dto){
//        return ResponseEntity.ok(optionService.saveOption(dto));
//    }


//    @PostMapping(SAVEALL)
//    public ResponseEntity<List<OptionResponseDto>> saveAllOptions(@RequestBody List<OptionSaveRequestDto> dtoList){
//        Question question = new Question();
//        question = questionRepository.save(question);
//        return ResponseEntity.ok(optionService.saveAllOptions(dtoList,question));
//    }
}
