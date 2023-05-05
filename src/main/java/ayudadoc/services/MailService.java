package ayudadoc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ayudadoc.entities.MailEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MailService {
    
    public Mono<MailEntity> createMail(MailEntity mail) {
        return Mono.just(mail);
    }
}
