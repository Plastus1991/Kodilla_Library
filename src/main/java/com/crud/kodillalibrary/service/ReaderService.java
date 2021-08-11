package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;


    public Reader saveReader(final Reader reader) {
       return readerRepository.save(reader);
    }

    public Optional<Reader> getReaderById(Long id) {
        return readerRepository.findById(id);
    }











}
