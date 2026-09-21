package org.springframework.samples.petclinic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Batch - 010: Handle requests for the PetClinic home page.
@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

}
