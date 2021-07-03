package com.crud.kodillalibrary.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TitleDto {

    private final Long id;
    private final String title;
    private final String author;
    private final int year;

}
