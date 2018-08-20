package com.trinhha.demo.itblog.repository;

import com.trinhha.demo.itblog.dto.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
    Word findByEnglish(String english);
}
