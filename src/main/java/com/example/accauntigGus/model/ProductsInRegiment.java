package com.example.accauntigGus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<Akt> akts=new ArrayList<>();

    //@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
   // private List<Invoice>invoicesIn=new ArrayList<>();
}
