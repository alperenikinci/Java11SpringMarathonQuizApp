package com.bilgeadam.repository;

import com.bilgeadam.dto.response.OptionResponseDto;
import com.bilgeadam.repository.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option,Long> {
    List<Option> findAllByQuestionId(Long id);
}
