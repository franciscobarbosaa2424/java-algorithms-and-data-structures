package org.example.PatronesCreacionales.prototype;
import java.util.HashMap;
import java.util.Map;

interface VehiculoClonable1 {

    VehiculoClonable1 clonar();

    void mostrar();
}


// ----- Auto1 -----

class Auto1 implements VehiculoClonable1 {

    private String marca;
    private String color;

    @Override
    public VehiculoClonable1 clonar() {

        // Crear un nuevo Auto1
        Auto1 clon = new Auto1();
        // Copiar la marca y el color del objeto original
        clon.setMarca(this.marca);
        clon.setColor(this.color);
        // Devolver el clon
        return clon;

    }

    @Override
    public void mostrar() {
        System.out.println("Auto1: " + marca + ", Color: " + color);
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


// ----- Camioneta -----

class Camioneta implements VehiculoClonable1 {

    private String marca;
    private String color;

    @Override
    public VehiculoClonable1 clonar() {

        // Crear una nueva Camioneta
        Camioneta clon = new Camioneta();
        // Copiar la marca y el color del objeto original
        clon.setMarca(this.marca);
        clon.setColor(this.color);
        // Devolver el clon
        return clon;
    }

    @Override
    public void mostrar() {
        System.out.println("Camioneta: " + marca + ", Color: " + color);
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


// Almacena los objetos que se utilizarán como prototipos
class VehiculoCache1 {

    private static Map<String, VehiculoClonable1> mapaVehiculos = new HashMap<>();

    public static void cargarCache() {

        Auto1 Auto1 = new Auto1();
        Auto1.setMarca("Toyota");
        Auto1.setColor("Rojo");
        mapaVehiculos.put("Auto1", Auto1);

        Camioneta camioneta = new Camioneta();
        camioneta.setMarca("Ford");
        camioneta.setColor("Azul");
        mapaVehiculos.put("camioneta", camioneta);
    }

    public static VehiculoClonable1 obtenerVehiculo(String tipoVehiculo) {

        VehiculoClonable1 vehiculo = mapaVehiculos.get(tipoVehiculo);

        // Devolver un clon del vehículo encontrado
        return vehiculo.clonar();
    }
}