package ec.edu.ec.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class MailService {

    public void enviarMail(String destino, String asunto, String cuerpo){
        System.out.println("Se envia el mail a:" +destino);
    }
}
