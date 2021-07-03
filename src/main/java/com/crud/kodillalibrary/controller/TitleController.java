package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.dto.TitleDto;
import com.crud.kodillalibrary.mapper.TitleMapper;
import com.crud.kodillalibrary.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/title")
@RequiredArgsConstructor
public class TitleController {

    private final TitleMapper titleMapper;
    private final TitleService titleService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto titleDto) {

        Title title = titleMapper.mapToTitle(titleDto);
        titleService.saveTitle(title);
    }
}
