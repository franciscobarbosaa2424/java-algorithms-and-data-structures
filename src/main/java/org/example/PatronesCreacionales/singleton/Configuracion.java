package org.example.PatronesCreacionales.singleton;

public class Configuracion {
    //3 PARTES
    //✅Una clase con contructor privado
    //✅una variable estatica = constante
    //✅un metodo publico que sea estatico

    private static Configuracion instancia;

    private Configuracion (){
        System.out.println("Inicializando configuracion");
    }

    public static Configuracion getInstancia(){
        if(instancia == null){
            instancia = new Configuracion();
        }

        return instancia;
    }

    //opcional
    public void mostrarMensaje(){
        System.out.println("Configuracion activa");
    }
}
