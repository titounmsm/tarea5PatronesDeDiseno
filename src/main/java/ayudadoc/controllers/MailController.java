package ayudadoc.controllers;

import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ayudadoc.entities.MailEntity;
import ayudadoc.helpers.AyudocLog;
import ayudadoc.helpers.mail.SMTPMailSender;
import reactor.core.publisher.Mono;

import ayudadoc.services.MailService;
@RestController
@RequestMapping("api-mail")
public class MailController {
    
    
    @Autowired
    private MailService MailService;

    @PostMapping("/c2")
    public Mono<MailEntity> createMailC2(@RequestBody MailEntity Mail) {
        
        try {
            SMTPMailSender mailSender = SMTPMailSender.getInstance("null", "null", "null", "null");

            mailSender.sendMail(Mail);
        } catch (MessagingException e) {
            e.printStackTrace();
            AyudocLog.getInstance().log("debug", "Creando con mail hacia: " + Mail.getTo() );

        }

        return MailService.createMail( Mail );
    }



}
