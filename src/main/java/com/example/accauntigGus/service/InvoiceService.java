package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Invoice;
import com.example.accauntigGus.model.ProductNumber;
import com.example.accauntigGus.repository.InvoiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService implements UniService<Invoice> {
    private final InvoiceRepo invoiceRepo;
    private final RegimentService regimentService;
    private final PerformerService performerService;
    private final TransferService transferService;
    private final StatusService statusService;
    private final ProductInRegimentService productRegimentService;

    @Override
    public List<Invoice> list(String title) {
        return null;
    }

    public List<Invoice> list(Long title) {
        if (title == null) {
            return invoiceRepo.findAll();
        } else {
            return invoiceRepo.findByNumberContains(title.longValue());
        }
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepo.findById(id).orElse(null);
    }

    @Override
    public Invoice findByTitle(String title) {
        return null;
    }

    public Invoice findByTitle(Long title) {
        return invoiceRepo.findByNumber(title.longValue()).orElse(null);
    }

    @Override
    public Invoice saveEntity(Invoice invoice) {
        return invoiceRepo.save(invoice);

    }

    @Override
    public void delete(Invoice entity) {
        invoiceRepo.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        invoiceRepo.deleteById(id);
    }


    public Invoice save(Long senderId, Long recipientId,
                        Long firstPerformerId, Long secondPerformerId, Long transferId, String base, Long statusID, LocalDate date, List<ProductNumber> productNumbers) {
        Invoice invoice = new Invoice();
        invoice.setNumber(invoiceRepo.findMaximumNumber() + 1);
        invoice.setSender(regimentService.findById(senderId));
        invoice.setRecipient(regimentService.findById(recipientId));
        invoice.setFirstPerformer(performerService.findById(firstPerformerId));
        invoice.setSecondPerformer(performerService.findById(secondPerformerId));
        invoice.setTransfer(transferService.findById(transferId));
        invoice.setStatus(statusService.findById(statusID));
        invoice.setDate(date);
        invoice.setProductNumbers(productNumbers);
        for (ProductNumber pn : productNumbers) {
            productRegimentService.correctUp(recipientId, pn.getProduct().getId(), pn.getNumber());
            productRegimentService.correctDown(senderId, pn.getProduct().getId(), pn.getNumber());
        }
        return invoice;
    }

    public Invoice correct(Long id, long number, Long senderId, Long recipientId,
                           Long firstPerformerId, Long secondPerformerId, Long transferId, String base, Long statusID, LocalDate date, List<ProductNumber> productNumbers) {
        Invoice invoice = findById(id);
        if (invoice == null) {
            return null;
        }
        Long oldRecId = invoice.getRecipient().getId();
        Long oldSenId = invoice.getSender().getId();
        List<ProductNumber> oldProdNum = invoice.getProductNumbers();
        for (ProductNumber pn : productNumbers) {
            productRegimentService.correctDown(recipientId, pn.getProduct().getId(), pn.getNumber());
            productRegimentService.correctUp(senderId, pn.getProduct().getId(), pn.getNumber());
        }
        invoice.setNumber(invoiceRepo.findMaximumNumber() + 1);
        invoice.setSender(regimentService.findById(senderId));
        invoice.setRecipient(regimentService.findById(recipientId));
        invoice.setFirstPerformer(performerService.findById(firstPerformerId));
        invoice.setSecondPerformer(performerService.findById(secondPerformerId));
        invoice.setTransfer(transferService.findById(transferId));
        invoice.setStatus(statusService.findById(statusID));
        invoice.setDate(date);
        invoice.setProductNumbers(productNumbers);
        for (ProductNumber pn : productNumbers) {
            productRegimentService.correctUp(recipientId, pn.getProduct().getId(), pn.getNumber());
            productRegimentService.correctDown(senderId, pn.getProduct().getId(), pn.getNumber());
        }
        return invoice;
    }
}