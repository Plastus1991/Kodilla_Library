package com.crud.kodillalibrary.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    @OneToMany(
            targetEntity = CheckOut.class,
            mappedBy = "piece",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<CheckOut> checkOutList;

    public Piece(Long id, String status, Title title) {
        this.id = id;
        this.status = status;
        this.title = title;
    }


}
