package com.example.accauntigGus.controller;

import com.example.accauntigGus.model.Performer;
import com.example.accauntigGus.service.PerformerService;
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
public class PerformerController {
    private final PerformerService performerService;
    private final UserService userService;

    @GetMapping("/allPerformer")
    public String getAllNomenclatures(Principal principal, Model model,
                                      @RequestParam(name = "searchWord", required = false) String name) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("performers", performerService.list(name));
        model.addAttribute("searchWord", name);
        return "allPerformer";
    }

    @GetMapping("/addPerformer")
    public String getAddNomenclature(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "addPerformer";
    }

    @PostMapping("/addPerformer")
    public String postAddNomenclature(@RequestParam("Name") String name, @RequestParam("Rang") String rang) {
        performerService.save(name, rang);
        return "redirect:/allPerformer";
    }

    @GetMapping("/editPerformer/{id}")
    public String getEditPerformer(@PathVariable("id") Long id, Model model,
                                      Principal principal) {
        Performer performer = performerService.findById(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("performer", performer);
        return "editPerformer";
    }

    @PostMapping("/editPerformer/{id}")
    public String postEditPerformer(@PathVariable("id") Long id, @RequestParam("Name") String name,
                                    @RequestParam("Rang") String rang) {
        performerService.correct(id, name, rang);
        return "redirect:/allPerformer";
    }

    @PostMapping("deletePerformer/{id}")
    public String delete(@PathVariable("id") Long id) {
        performerService.deleteById(id);
        return "redirect:/allPerformer";
    }
}
