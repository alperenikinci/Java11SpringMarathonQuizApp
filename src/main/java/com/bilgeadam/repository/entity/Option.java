package com.bilgeadam.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_option")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer optionNo;
    @Column(length = 2048)
    private String optionContent;
    @Builder.Default
    private Boolean isCorrectAnswer = false;
    private Long questionId;



}
