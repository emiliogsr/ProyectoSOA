package com.example.perfil.ws;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig {

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext ctx) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet(); // <- sin args
    servlet.setApplicationContext(ctx);                                // <- asigna el contexto
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/serviciosdigitales/*");
  }

  @Bean(name = "perfil")
  public SimpleWsdl11Definition perfilWsdl() {
    return new SimpleWsdl11Definition(new ClassPathResource("perfil.wsdl"));
  }
}
