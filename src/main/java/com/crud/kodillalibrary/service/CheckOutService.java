package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.CheckOut;
import com.crud.kodillalibrary.domain.Piece;
import com.crud.kodillalibrary.repository.CheckOutRepository;
import com.crud.kodillalibrary.repository.PieceRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CheckOutService {

    private final CheckOutRepository checkOutRepository;
    private final PieceRepository pieceRepository;


    public void saveCheckOut(final CheckOut checkOut) {
        checkOutRepository.save(checkOut);

    }

    public CheckOut createCheck(final Long pieceId) {

        CheckOut checkOut = new CheckOut();

        checkOut.setPiece(pieceRepository.getById(pieceId));
        return checkOutRepository.save(checkOut);

    }


}
