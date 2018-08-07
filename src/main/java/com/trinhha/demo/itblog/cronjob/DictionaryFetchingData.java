package com.trinhha.demo.itblog.cronjob;

import com.trinhha.demo.itblog.Exception.InvalidWordException;
import com.trinhha.demo.itblog.dto.Word;
import com.trinhha.demo.itblog.service.WordService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

@Log
@Component
@NoArgsConstructor
public class DictionaryFetchingData {

    enum DictionaryFetching {
        l_new_word("^-(.)*@(.)*\\/(.)*\\/$"),
        l_word_type("^\\*(.)*$"),
        l_mean_of_word("^\\-(.)*$"),
        l_example("^\\=(.)*\\+(.)*$"),
        none("");

        private String value;
        private Pattern pattern;

        DictionaryFetching(String value) {
            this.value = value;
            this.pattern = Pattern.compile(this.value);
        }

        public Pattern getPattern() {
            return pattern;
        }
    }

    @Value("${dict.location.file}")
    private String fileLocation;

    @Inject
    private WordService wordService;

    @Getter
    @Setter
    private Word word;

    public static final String jobName = "Dictionary_fetching_data";

//    @Scheduled(fixedDelay = 20000000)
    public void readFile() throws Exception {
        FileReader fileReader = new FileReader(this.fileLocation);
        BufferedReader bufferedReader =
                new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            this.fetchData(line);
        }
        bufferedReader.close();
    }

    private DictionaryFetching getLineType(String line) {
        for (DictionaryFetching dictionaryFetching : DictionaryFetching.values()) {
            if (dictionaryFetching.getPattern().matcher(line).matches()) {
                return dictionaryFetching;
            }
        }
        return DictionaryFetching.none;
    }

    private void fetchData(String line) {
        switch (this.getLineType(line)) {
            case l_new_word:
                if (this.word != null) {
                    try {
                        this.wordService.saveNewWord(word);
                    } catch (InvalidWordException e) {
                        log.warning("Invalid word " + e.getMessage());
                    } catch (Exception e) {
                        log.warning("Exception " + e.getMessage());
                    }
                }
                this.word = new Word();
                this.getEnglishWord(line);
                break;
            case l_word_type:
                this.getTypeOfWord(line);
                break;
            case l_mean_of_word:
                this.getMeanOfWord(line);
                break;
            case l_example:
                this.getExample(line);
                break;
            case none:
                log.warning("Could not classification");
                break;
        }
    }

    private void getExample(String line) {
        if (this.word != null) {
            this.word.setExample(this.word.getExample() + "\n" + line);
        }
    }

    private void getMeanOfWord(String line) {
        if (this.word != null) {
            this.word.setMean(this.word.getMean() + "\n" + line);
        }
    }

    private void getTypeOfWord(String line) {
        if (this.word != null) {
            this.word.setTypeOfWord(line);
        }
    }

    private void getEnglishWord(String newWordLine) {
        try {
            newWordLine = newWordLine.substring(newWordLine.indexOf('@') + 1, newWordLine.length());
            String englishWord = newWordLine.substring(0, newWordLine.indexOf('/'));
            String spelling = newWordLine.substring(englishWord.length(), newWordLine.length());
            this.word.setEnglish(englishWord);
            this.word.setSpelling(spelling);
        } catch (Exception e) {
            log.info(e.toString() + "  " + newWordLine);
        }
    }
}
