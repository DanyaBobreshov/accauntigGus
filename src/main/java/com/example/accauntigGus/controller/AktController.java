package com.example.accauntigGus.controller;

import com.example.accauntigGus.model.Product;
import com.example.accauntigGus.service.AktService;
import com.example.accauntigGus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AktController {
    private final AktService aktService;
    private final UserService userService;

    @GetMapping("/allAkts")
    public String getProducts(Principal principal, Model model,
                              @RequestParam(name = "searchWord", required = false) String title) {
        model.addAttribute("akts", aktService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "allAkts";
    }

    @GetMapping("/addAkt")
    public String getAddProduct(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "addAkt";
    }

    @PostMapping("/addAkt")
    public String postAddProduct(@RequestParam("Date")LocalDate date,
                                 @RequestParam("Regiment") Long regimentId,
                                 @RequestParam("Contract") String contract,
                                 @RequestParam("Products") List<Long>products) {
        aktService.save(date, regimentId, contract, products);
        return "redirect:/allAkt";
    }

    @GetMapping("/editProduct/{id}")
    public String getEditProduct(@PathVariable("id") Long id, Model model, Principal principal) {
        Product product = aktService.findById(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("editProduct/{id}")
    public String postEditProduct(@PathVariable("id") Long id,
                                  @RequestParam("Title") String title,
                                  @RequestParam("Module") String module,
                                  @RequestParam("Year") Long year,
                                  @RequestParam("Comment") String comment,
                                  @RequestParam("NomenclatureID") Long nomenclature) {
        aktService.correct(id, title, module, year, comment, nomenclature);
        return "redirect:/allProducts";
    }

    @PostMapping("deleteProduct/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal) {
        aktService.deleteById(id);
        return "redirect:/allProducts";
    }

}
