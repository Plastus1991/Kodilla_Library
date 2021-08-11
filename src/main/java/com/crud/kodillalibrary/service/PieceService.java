package com.crud.kodillalibrary.service;


import com.crud.kodillalibrary.domain.Piece;
import com.crud.kodillalibrary.repository.PieceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PieceService {

    private final PieceRepository pieceRepository;

    public void savePiece(final Piece piece) {
        pieceRepository.save(piece);
    }

    public List<Piece> getAllPieces() {
        return pieceRepository.findAll();
    }
}
