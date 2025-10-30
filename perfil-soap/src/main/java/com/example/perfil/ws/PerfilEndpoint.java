package com.example.perfil.ws;

import com.example.perfil.doa.DataPerfil;
import com.example.perfil.dto.ConsultarPerfil;
import com.example.perfil.dto.ResultadoPerfil;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
@Component
public class PerfilEndpoint {

  private static final String NS = "http://perfil.com/";
  private final DataPerfil data;
  private final JmsTemplate jms;

  public PerfilEndpoint(DataPerfil data, JmsTemplate jms) {
    this.data = data;
    this.jms = jms;
  }

  @PayloadRoot(namespace = NS, localPart = "consultarPerfil")
  @ResponsePayload
  public ResultadoPerfil consultar(@RequestPayload ConsultarPerfil req) {
    String perfil = data.get(req.getUsername());
    if (perfil == null) perfil = "No encontrado";

    ResultadoPerfil resp = new ResultadoPerfil();
    resp.setPerfil(perfil);

    // Publicar a Artemis (opcional para orquestador)
    try {
      jms.convertAndSend("perfil.response",
        String.format("{\"username\":\"%s\",\"perfil\":\"%s\"}", req.getUsername(), perfil));
    } catch (Exception ignore) {}

    return resp;
  }
}
