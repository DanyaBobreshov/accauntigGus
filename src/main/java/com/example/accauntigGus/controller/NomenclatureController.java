package com.example.accauntigGus.controller;

import com.example.accauntigGus.model.Nomenclature;
import com.example.accauntigGus.service.NomenclatureService;
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
public class NomenclatureController{
    private final NomenclatureService nomenclatureService;
    private final UserService userService;

    @GetMapping("/nomenclaturs")
    public String getNomenclaturs(Principal principal, Model model,
                                  @RequestParam(name = "searchWord", required = false) String title){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("nomenclaturs", nomenclatureService.list(title);
        model.addAttribute("searchWord", title);
        return "allNomenclaturs";
    }

    @GetMapping ("/addNomenclatur")
    public String getAddNomenclatur(Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "addNomenclaturs";
    }

    @PostMapping("/addNomenclatur")
        public String postAddNomenclatur(@RequestParam("Nomenclature") Nomenclature nomenclature){
            nomenclatureService.save(nomenclature);
            return "redirect:/allNomenclaturs";

            @GetMapping("/editNomenclature/{id}")
                public String getEditNomenclature(@PathVariable("id") Long id, Model model, Principal principal){
                    Nomenclature nomenclature = nomenclatureService.findById(id);
                    model.addAtribute("user", userService.getUserByPrincipal(principal));
                    model.addAtribute("nomenclature", nomenclature);
                    return "editNomenclature";
                }

                @PostMapping("/editNomenclature/{id}"){
                    public String postEditNomenclature(@PathVariable("id"), @RequestParam("title") String title){
                        Nomenclature nomenclature = nomenclatureService.findById(id);
                        nomenclatureService.correct(nomenclature, title);
                        return "redirect:/allNomenclaturs";
                    }

                    @PostMapping("deleteNomenclature/{id}"){
                        public String delete(@PathVariable("id") Long id){
                            nomenclatureService.deleteById(id);
                            return "redirect:/allNomenclaturs";
                        }
