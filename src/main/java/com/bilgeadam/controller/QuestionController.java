package com.bilgeadam.controller;

import com.bilgeadam.dto.request.QuestionSaveRequestDto;
import com.bilgeadam.dto.response.QuestionResponseDto;
import com.bilgeadam.repository.entity.Question;
import com.bilgeadam.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadam.constants.RestApi.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(QUESTION)
public class QuestionController {

    private final QuestionService questionService;


    @PostMapping(SAVE)
    public ResponseEntity<Question> saveQuestion(@RequestBody @Valid QuestionSaveRequestDto dto){
        return ResponseEntity.ok(questionService.saveQuestion(dto));
    }

    @GetMapping(FINDBYIDWITHOPTIONDATA)
    public ResponseEntity<QuestionResponseDto> findByIdWithOptionData(Long id){
        return ResponseEntity.ok(questionService.findByIdWithOptionData(id));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Question>> findAll(){
        return ResponseEntity.ok(questionService.findAll());
    }

    @GetMapping(FINDALLWITHOPTIONDATA)
    public ResponseEntity<List<QuestionResponseDto>> findAllWithOptionData(){
        return ResponseEntity.ok(questionService.findAllWithOptionData());
    }
}
