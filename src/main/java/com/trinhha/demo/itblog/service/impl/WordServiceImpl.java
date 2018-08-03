package com.trinhha.demo.itblog.service.impl;

import com.trinhha.demo.itblog.dto.Word;
import com.trinhha.demo.itblog.repository.WordRepository;
import com.trinhha.demo.itblog.service.WordService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Inject
    WordRepository wordRepository;

    @Override
    public Word saveNewWord(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }
}
