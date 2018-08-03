package com.trinhha.demo.itblog.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@AllArgsConstructor
@Table(name = "word")
@ToString
@EqualsAndHashCode
public class Word {

    @Id
    @Column(name = "word_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int wordId;

    @NotEmpty(message = "Please insert word field")
    @Column(name = "english", unique = true)
    String english;

    @Column(name = "spelling")
    String spelling;

    @Column(name = "type_of_word")
    String typeOfWord;

    @Column(name = "meaning")
    String mean;

    @Column(name = "extra_information")
    String extraInformation;

    @Column(name = "example")
    String example;

    public Word() {
        this.english = "";
        this.spelling = "";
        this.typeOfWord = "";
        this.extraInformation = "";
        this.example = "";
        this.mean = "";
    }
}
