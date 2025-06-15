package com.project.Project.Despre;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DespreController {

        @GetMapping("/despre")
        public String contactPage() {
            return "despre";
        }
}
