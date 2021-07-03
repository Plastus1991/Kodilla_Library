package com.crud.kodillalibrary.mapper;


import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.dto.TitleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleMapper {

    public Title mapToTitle(TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getYear()
        );
    }

    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear()
        );
    }

    public List<TitleDto> mapToListTitleDto(final List<Title> titleList) {
        return titleList.stream()
                .map(this::mapToTitleDto)
                .collect(Collectors.toList());
    }
}
