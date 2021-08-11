package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.Piece;
import com.crud.kodillalibrary.dto.PieceDto;
import com.crud.kodillalibrary.mapper.PieceMapper;
import com.crud.kodillalibrary.service.PieceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/piece")
@RequiredArgsConstructor
public class PieceController {

    private final PieceMapper pieceMapper;
    private final PieceService pieceService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPiece(@RequestBody PieceDto pieceDto) {

        Piece piece = pieceMapper.mapToPiece(pieceDto);
        pieceService.savePiece(piece);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/allOnStock")
    public List<PieceDto> getPiecesOnStock() {
        List<Piece> pieces = pieceService.getAllPieces();

        List<Piece> onStack = pieces.stream()
                .filter(p -> p.getStatus().contains("stock"))
                .collect(Collectors.toList());

        return pieceMapper.mapPieceDtoToList(onStack);

    }
}
