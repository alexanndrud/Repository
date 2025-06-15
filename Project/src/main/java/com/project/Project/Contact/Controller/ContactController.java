package com.project.Project.Contact.Controller;


import com.project.Project.Contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @PostMapping("/submitContact")
    public String submitContact(@ModelAttribute Contact contact, Model model) {
        sendEmail(contact);
        model.addAttribute("message", "Formularul de contact a fost trimis cu succes!");
        return "successcontact";
    }

    private void sendEmail(Contact contact) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("lalvision@lalvision.ro"); // Setează adresa de email unde vrei să primești datele
        message.setSubject("Formular Nou");

        String emailBody =
                 "Nume și Prenume: " + contact.getNume() + "\n"
                + "Email: " + contact.getEmail() + "\n"
                + "Mesaj: " + contact.getMesaj();

        message.setText(emailBody);
        try {
            mailSender.send(message);
            System.out.println("Email trimis cu succes");
        } catch (Exception e) {
            e.printStackTrace();  // Printează eroarea pentru debugging
        }
    }
}

