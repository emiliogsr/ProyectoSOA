package com.example.perfil.dto;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"perfil"})
@XmlRootElement(name = "resultadoPerfil", namespace = "http://perfil.com/")
public class ResultadoPerfil {
  @XmlElement(namespace = "http://perfil.com/", required = true)
  private String perfil;

  public String getPerfil() { return perfil; }
  public void setPerfil(String perfil) { this.perfil = perfil; }
}
