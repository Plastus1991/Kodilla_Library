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
    private LocalDate returnBook;

    @OneToOne
    @JoinColumn(name = "piece_Id", referencedColumnName = "id")
    private Piece piece;

    public CheckOut(Long id, int day, int month, int year, Piece piece) {
        this.id = id;
        this.returnBook = LocalDate.of(year, month, day );
        this.borrowDate = new Date();
        this.piece = piece;
    }
}
