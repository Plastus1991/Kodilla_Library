package com.crud.kodillalibrary.service;


import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TitleService {

    private final TitleRepository titleRepository;


    public void saveTitle(final Title title) {
        titleRepository.save(title);
    }
}
