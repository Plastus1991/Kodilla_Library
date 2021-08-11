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
                piece
        );
    }

    public CheckOutDto mapToCheckOutDto(CheckOut checkOut) {

        return new CheckOutDto(
                checkOut.getId(),
                checkOut.getPiece().getId()
        );
    }

    public List<CheckOutDto> mapCheckOutDtoToList(final List<CheckOut> checkOutList) {
        return checkOutList.stream()
                .map(this::mapToCheckOutDto)
                .collect(Collectors.toList());
    }
}
