package com.discography.beans;

import org.springframework.stereotype.Component;

@Component("myFirstBean")

public class MyFirstBean {

    // @Value("Hola desde Spring con Anotaciones!") // not necessary if we use
    // applicationContext.xml
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}