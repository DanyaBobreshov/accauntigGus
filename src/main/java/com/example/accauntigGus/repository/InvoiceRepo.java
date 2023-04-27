package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
    List<Invoice> findByNumberContains(long number);

    List<Invoice> findByDate(LocalDate date);

    List<Invoice> findByStatusId(Long statusId);

    List<Invoice> findByProductNumbersProductTitleContains(String product);

    Optional<Invoice> findByNumber(long number);

    @Query(value = "SELECT max(i.number) FROM invoice i")
    long findMaximumNumber();
}