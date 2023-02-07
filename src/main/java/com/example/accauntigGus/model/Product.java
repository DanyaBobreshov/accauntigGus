package com.example.accauntigGus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String module;
    private String comment;
    private Long year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Nomenclature nomenclature;
}