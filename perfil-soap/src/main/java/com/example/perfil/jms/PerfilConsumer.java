package com.example.perfil.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PerfilConsumer {

    @JmsListener(destination = "perfil.response")
    public void recibirMensaje(String mensaje) {
        System.out.println("📩 Mensaje recibido desde perfil.response: " + mensaje);
    }
}
