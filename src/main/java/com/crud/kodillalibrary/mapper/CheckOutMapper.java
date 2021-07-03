package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.CheckOut;
import com.crud.kodillalibrary.domain.Piece;
import com.crud.kodillalibrary.dto.CheckOutDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckOutMapper {

    public CheckOut mapToCheckOut(CheckOutDto checkOutDto) {
        Piece piece = new Piece();
        piece.setId(checkOutDto.getCopyId());

        return new CheckOut(
                checkOutDto.getId(),
                checkOutDto.getDay(),
                checkOutDto.getMonth(),
                checkOutDto.getYear(),
                piece
        );
    }

    public CheckOutDto mapToCheckOutDto(CheckOut checkOut) {
        return new CheckOutDto(
                checkOut.getId(),
                checkOut.getPiece().getId(),
                checkOut.getReturnBook().getDayOfMonth(),
                checkOut.getReturnBook().getMonthValue(),
                checkOut.getReturnBook().getYear()

        );
    }

    public List<CheckOutDto> mapCheckOutDtoToList(final List<CheckOut> checkOutList) {
        return checkOutList.stream()
                .map(this::mapToCheckOutDto)
                .collect(Collectors.toList());
    }
}
