package com.crud.kodillalibrary.mapper;


import com.crud.kodillalibrary.domain.Piece;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.dto.PieceDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PieceMapper {

    public Piece mapToPiece(final PieceDto pieceDto) {
        Title title = new Title();
        title.setId(pieceDto.getTitleId());
        return new Piece(
                pieceDto.getId(),
                pieceDto.getStatus(),
                title
        );
    }

    public PieceDto mapToPieceDto(final Piece piece) {
        return new PieceDto(
                piece.getId(),
                piece.getStatus(),
                piece.getTitle().getId()
        );
    }

    public List<PieceDto> mapPieceDtoToList(final List<Piece> pieceList) {
        return pieceList.stream()
                .map(this::mapToPieceDto)
                .collect(Collectors.toList());
    }
}
