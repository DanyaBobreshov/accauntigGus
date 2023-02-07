package com.example.accauntigGus.controller;

import com.example.accauntigGus.model.Product;
import com.example.accauntigGus.service.ProductService;
import com.example.accauntigGus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/allProducts")
    public String getProducts(Principal principal, Model model,
                              @RequestParam(name = "searchWord", required = false) String title) {
        model.addAttribute("products", productService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "allProducts";
    }

    @GetMapping("/addProduct")
    public String getAddProduct(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String postAddProduct(@RequestParam("Title") String title,
                                 @RequestParam("Module") String module,
                                 @RequestParam("Year") Long year,
                                 @RequestParam("Comment") String comment,
                                 @RequestParam("NomenclatureID") Long nomenclature) {
        productService.save(title, module, year, comment, nomenclature);
        return "redirect:/allProducts";
    }

    @GetMapping("/editProduct/{id}")
    public String getEditProduct(@PathVariable("id") Long id, Model model, Principal principal) {
        Product product = productService.findById(id);
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
        productService.correct(id, title, module, year, comment, nomenclature);
        return "redirect:/allProducts";
    }

    @PostMapping("deleteProduct/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal) {
        productService.deleteById(id);
        return "redirect:/allProducts";
    }

}