package ch.springframework.sfgpetclinic.controllers;

import ch.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final OwnerService ownerService;

    public IndexController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "index";
    }

    @RequestMapping({"/oups"})
    public String findOwners() {
        return "notimplemented";
    }
}
