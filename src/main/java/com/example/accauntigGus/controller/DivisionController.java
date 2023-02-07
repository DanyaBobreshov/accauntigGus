package com.example.accauntigGus.controller;

import com.example.accauntigGus.model.Division;
import com.example.accauntigGus.service.DivisionService;
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
public class DivisionController {

    private final DivisionService divisionService;
    private final UserService userService;

    @GetMapping("/divisions")
    public String getDivisions(Principal principal, Model model,
                               @RequestParam(name = "searchWord", required = false) String title) {
        model.addAttribute("divisions", divisionService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "allDivisions";
    }

    @GetMapping("/addDivision")
    public String getAddDivision(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "addDivision";
    }

    @PostMapping("/addDivision")
    public String postAddDivision(@RequestParam("Title") String title,
                                  @RequestParam("Address") String address,
                                  @RequestParam("Telephone") String telephone,
                                  @RequestParam("TOSotdel") String TOSOtdel) {
        divisionService.save(title, address, telephone, TOSOtdel);
        return "redirect:/divisions";
    }

    @GetMapping("/editDivision/{id}")
        public String getEditDivision (@PathVariable("id") Long id, Model model, Principal principal){
            Division division = divisionService.findById(id);
            model.addAttribute("user", userService.getUserByPrincipal(principal));
            model.addAttribute("division", division);
            return "editDivision";
        }

        @PostMapping("/editDivision/{id}")
        public String postEditDivision (@PathVariable("id") Long id,
                @RequestParam("Title") String title,
                @RequestParam("Address") String address,
                @RequestParam("Telephone") String telephone,
                @RequestParam("TOSotdel") String TOSOtdel){
            divisionService.correct(id, title, address, telephone, TOSOtdel);
            return "redirect:/divisions";
        }


        @PostMapping("deleteDivision/{id}")
            public String delete (@PathVariable("id") Long id, Principal principal){
                divisionService.deleteById(id);
                return "redirect:/divisions";
            }
}