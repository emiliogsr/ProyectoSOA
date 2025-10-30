package com.example.perfil.doa;

import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DataPerfil {
  private final Map<String, String> perfiles = new ConcurrentHashMap<>();

  public DataPerfil() {
    perfiles.put("juan", "premium");
    perfiles.put("ana", "basico");
    perfiles.put("luis", "estandar");
  }

  public String get(String usuario) { return perfiles.get(usuario); }
}
