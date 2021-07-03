package com.crud.kodillalibrary.controller;


import com.crud.kodillalibrary.domain.CheckOut;
import com.crud.kodillalibrary.dto.CheckOutDto;
import com.crud.kodillalibrary.mapper.CheckOutMapper;
import com.crud.kodillalibrary.repository.CheckOutRepository;
import com.crud.kodillalibrary.service.CheckOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckOutController {

    private final CheckOutMapper checkOutMapper;
    private final CheckOutService checkOutService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCheckOut(@RequestBody CheckOutDto checkOutDto) {
        CheckOut checkOut = checkOutMapper.mapToCheckOut(checkOutDto);
        checkOutService.saveCheckOut(checkOut);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCheckOut(@PathVariable Long id ) {
         checkOutService.createCheck(id);
    }

}
