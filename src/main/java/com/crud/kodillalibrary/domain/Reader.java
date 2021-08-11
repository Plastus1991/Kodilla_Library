package com.crud.kodillalibrary.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "READER")
public class Reader {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "READER_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "CREATE_DATE")
    private Date created;

    @OneToMany(
            targetEntity = CheckOut.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<CheckOut> checkOutList;


    public Reader(Long id, String name, String secondName) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.created = new Date();
    }
}
