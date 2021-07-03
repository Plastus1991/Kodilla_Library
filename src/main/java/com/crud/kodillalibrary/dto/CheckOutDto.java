package com.crud.kodillalibrary.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CheckOutDto {

    private final Long id;
    private final Long copyId;
    private final int day;
    private final int month;
    private final int year;

}
