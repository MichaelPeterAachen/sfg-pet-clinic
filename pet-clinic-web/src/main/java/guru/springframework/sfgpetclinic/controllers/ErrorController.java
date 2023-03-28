package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/oups")
@Controller
public class ErrorController {

    @RequestMapping({"", "/"})
    public String findOwners() {
        return "notimplemented";
    }
}
