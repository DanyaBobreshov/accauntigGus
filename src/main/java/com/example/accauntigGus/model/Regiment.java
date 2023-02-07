package com.example.accauntigGus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

public class Regiment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String address;
    private String telephone;
    private String comment;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn
    private Division division;

}