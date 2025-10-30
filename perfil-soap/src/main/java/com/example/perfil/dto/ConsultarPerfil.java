package com.example.perfil.dto;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"username"})
@XmlRootElement(name = "consultarPerfil", namespace = "http://perfil.com/")
public class ConsultarPerfil {
  @XmlElement(namespace = "http://perfil.com/", required = true)
  private String username;

  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }
}
