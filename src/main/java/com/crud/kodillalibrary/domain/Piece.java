package com.crud.kodillalibrary.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COPY_OF_BOOK")
public class Piece {

    @NotNull
    @GeneratedValue
    @Id
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "STATUS_OF_COPY")
    private String status;

    @ManyToOne
    @JoinColumn(name = "FK_TITLE")
    private Title title;

    @OneToOne(mappedBy = "piece" )
    private CheckOut checkOut;

    public Piece(Long id, String status, Title title) {
        this.id = id;
        this.status = status;
        this.title = title;
    }


}
