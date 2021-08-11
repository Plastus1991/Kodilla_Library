package com.crud.kodillalibrary.controller;


import com.crud.kodillalibrary.domain.CheckOut;
import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.dto.ReaderDto;
import com.crud.kodillalibrary.mapper.ReaderMapper;
import com.crud.kodillalibrary.repository.CheckOutRepository;
import com.crud.kodillalibrary.repository.ReaderRepository;
import com.crud.kodillalibrary.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/reader")
@RequiredArgsConstructor

public class ReaderController {

    private final ReaderService readerService;
    private final ReaderMapper readerMapper;
    private final ReaderRepository readerRepository;
    private final CheckOutRepository checkOutRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        readerService.saveReader(reader);
    }


}
