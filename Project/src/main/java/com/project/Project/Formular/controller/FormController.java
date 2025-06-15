package com.project.Project.Formular.controller;

import com.project.Project.Formular.model.FormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("formData", new FormData());
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute FormData formData, Model model) {
        sendEmail(formData);
        model.addAttribute("message", "Formularul de inregistrare a fost trimis cu succes!");
        return "successform";
    }

    private void sendEmail(FormData formData) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("lalvision@lalvision.ro"); // Setează adresa de email unde vrei să primești datele
        message.setSubject("Formular Nou");

        String emailBody = "Platforma: " + formData.getPlatforma() + "\n"
                + "Nume și Prenume: " + formData.getNume() + "\n"
                + "Email: " + formData.getEmail() + "\n"
                + "Telefon: " + formData.getTelefon() + "\n"
                + "Oraș: " + formData.getOras() + "\n"
                + "Observații: " + formData.getObservatii();

        message.setText(emailBody);
        try {
            mailSender.send(message);
            System.out.println("Email trimis cu succes");
        } catch (Exception e) {
            e.printStackTrace();  // Printează eroarea pentru debugging
        }
    }
}