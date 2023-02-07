package com.example.accauntigGus.controller;

import com.example.accauntigGus.model.Regiment;
import com.example.accauntigGus.service.RegimentService;
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
public class RegimentController {

    private final RegimentService regimentService;
    private final UserService userService;

    @GetMapping("/regiments")
    public String getRegiments(Principal principal, Model model,
                               @RequestParam(name = "searchWord", required = false) String title) {
        model.addAttribute("regiments", regimentService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "allRegiments";
    }

    @GetMapping("/addRegiment")
    public String getAddRegiment(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "addRegiment";
    }

    @PostMapping("/addRegiment")
    public String postAddRegiment(@RequestParam("Title") String title,
                                  @RequestParam("Address") String address,
                                  @RequestParam("Telephone") String telephone,
                                  @RequestParam("Comment") String comment,
                                  @RequestParam("DivisionId") Long divisionId) {
        regimentService.save(title, address, telephone, comment, divisionId);
        return "redirect:/regiments";
    }

    @GetMapping("/editRegiment/{id}")
    public String getEditRegiment(@PathVariable("id") Long id, Model model, Principal principal) {
        Regiment regiment = regimentService.findById(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("regiment", regiment);
        return "editRegiment";
    }

    @PostMapping("editRegiment/{id}")
    public String postAddRegiment(@PathVariable("id") Long id,
                                  @RequestParam("Title") String title,
                                  @RequestParam("Address") String address,
                                  @RequestParam("Telephone") String telephone,
                                  @RequestParam("Comment") String comment,
                                  @RequestParam("DivisionID") Long divisionId) {
        regimentService.correct(id, title, address, telephone, comment, divisionId);
        return "redirect:/regiments";
    }

    @PostMapping("deleteRegiment/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal) {
        regimentService.deleteById(id);
        return "redirect:/regiments";
    }
}