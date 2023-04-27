package com.example.accauntigGus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor

public class Status{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;
}