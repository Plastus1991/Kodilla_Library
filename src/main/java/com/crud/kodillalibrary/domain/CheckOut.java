package com.crud.kodillalibrary.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BORROW_BOOK")
public class CheckOut {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;


    @Column(name = "BORROW_DATE")
    private Date borrowDate;


    @Column(name = "RETURN_DATE")
    private Date returnBook;

    @ManyToOne
    @JoinColumn(name = "piece_Id")
    private Piece piece;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public CheckOut(Long id, Piece piece) {
        this.id = id;
        this.borrowDate = new Date();
        this.piece = piece;
    }
}
