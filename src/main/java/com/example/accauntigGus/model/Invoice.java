package com.example.accauntigGus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public
class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn
    private Regiment sender;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn
    private Regiment recipient;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn
    private Performer firstPerformer;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn
    private Performer secondPerformer;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn
    private Transfer transfer;

    private String base;

    private String document;

    private String scan;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn
    private Status status;

    private LocalDate date;



    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="invoice_products_numbers",
            joinColumns = @JoinColumn(name="invoice_id"),
            inverseJoinColumns = @JoinColumn(name="product_numbers_id"))
    private List<ProductNumber> productNumbers;

}

