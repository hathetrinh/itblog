package com.trinhha.demo.itblog.service;

import com.trinhha.demo.itblog.dto.Word;

import java.util.List;
import java.util.Set;

public interface WordService {

    Word saveNewWord(Word word);

    List<Word> getAllWords();
}
