package com.trinhha.demo.itblog.service;

import com.trinhha.demo.itblog.Exception.InvalidWordException;
import com.trinhha.demo.itblog.dto.Word;

import java.util.List;

public interface WordService {

    Word saveNewWord(Word word) throws InvalidWordException;

    List<Word> getAllWords();
}
