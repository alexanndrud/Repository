package com.project.Project.Inhiriere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InchiriereController {

    @GetMapping("/inchiriere")
    public String inchirierePage() {
        return "inchiriere";
    }
}

