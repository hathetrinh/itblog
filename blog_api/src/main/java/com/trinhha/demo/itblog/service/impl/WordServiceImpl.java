package com.trinhha.demo.itblog.service.impl;

import com.trinhha.demo.itblog.Exception.InvalidWordException;
import com.trinhha.demo.itblog.dto.Word;
import com.trinhha.demo.itblog.repository.WordRepository;
import com.trinhha.demo.itblog.service.WordService;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class WordServiceImpl implements WordService {

    @Inject
    private WordRepository wordRepository;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = {InvalidWordException.class, JpaSystemException.class})
    public Word saveNewWord(Word word) throws InvalidWordException {
        if (null != wordRepository.findByEnglish(word.getEnglish())) {
            throw new InvalidWordException("We already have " + word.getEnglish());
        }

        return wordRepository.save(word);
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }
}
