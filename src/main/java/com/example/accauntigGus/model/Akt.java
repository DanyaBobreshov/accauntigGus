package com.example.accauntigGus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Akt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn
    private Regiment regiment;

    private String industrial;
    private String contract;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="akts_products_numbers",
            joinColumns = @JoinColumn(name="akt_id"),
            inverseJoinColumns = @JoinColumn(name="product_numbers_id"))
    private List<ProductNumber> productNumbers;

}
