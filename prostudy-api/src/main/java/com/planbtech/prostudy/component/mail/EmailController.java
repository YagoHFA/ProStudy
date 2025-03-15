package com.planbtech.prostudy.component.mail;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Control Emails Endpoints(to be implemented)")
@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {

    @Autowired
    private JavaMailSender emailSender;

    @Operation(summary = "Send email to recover password(to be implemented)")
    @PostMapping("/recover")
    public String sendEmail(@RequestBody String email) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Recuperação de senha");
            message.setText("Olá! Aqui está o link para redefinir sua senha...");
            emailSender.send(message);
            return "E-mail enviado com sucesso!";
    }

    @Operation(summary = "Send a email to confirm the user account(to be implemented)")
    @PostMapping("/confirm")
    public String confirmEmail(@RequestBody String email){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Recuperação de senha");
            message.setText("Olá! Aqui está o link para redefinir sua senha...");
            emailSender.send(message);
            return "E-mail enviado com sucesso!";
    }
}
