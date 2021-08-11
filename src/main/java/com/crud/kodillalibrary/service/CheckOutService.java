package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.CheckOut;
import com.crud.kodillalibrary.domain.Piece;
import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.repository.CheckOutRepository;
import com.crud.kodillalibrary.repository.PieceRepository;
import com.crud.kodillalibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class CheckOutService {

    private final CheckOutRepository checkOutRepository;
    private final PieceRepository pieceRepository;
    private final ReaderRepository readerRepository;

    public CheckOut createCheck(final Long pieceId, final Long userId) {

        Piece piece = pieceRepository.getById(pieceId);
        Reader reader = readerRepository.getById(userId);
        piece.setStatus("Borrow");
        CheckOut checkOut = new CheckOut();
        checkOut.setBorrowDate(new Date());
        checkOut.setPiece(piece);
        checkOut.setReader(reader);
        return checkOutRepository.save(checkOut);
    }

    public CheckOut returnBook( final Long checkoutId) {

        CheckOut checkOut = checkOutRepository.getById(checkoutId);
        checkOut.setReturnBook(new Date());
        Piece piece = checkOut.getPiece();
        piece.setStatus("Return");

        return checkOutRepository.save(checkOut);
    }
}
