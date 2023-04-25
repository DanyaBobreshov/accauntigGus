package com.example.accauntigGus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class ProductsInRegiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn
    private Regiment regiment;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn
    private Product product;

    private Long numbers;
}
