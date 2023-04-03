package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/owners")
@Controller
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @RequestMapping({"", "/","/index","/index.html"})
    public String listOwner(Model model) {
        log.warn("Get all owners");
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        log.warn("Find owner not implemented");
        return "notimplemented";
    }
}
