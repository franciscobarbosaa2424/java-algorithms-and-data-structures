package org.example.PatronesCreacionales.factoryMethod;

// Clase abstracta Vehiculo
abstract class Vehiculo {

    public abstract String tipoVehiculo();
}

// Clase concreta Auto
class Auto extends Vehiculo {

    @Override
    public String tipoVehiculo(){
        return "Soy un Auto";
    }
}

// Clase concreta Moto
class Moto extends Vehiculo {

    @Override
    public String tipoVehiculo(){
        return "Soy una Moto";
    }
}

// Clase encargada de crear los vehículos
class VehiculoFactory {

    public Vehiculo crearVehiculo(String tipo) {

        // Si el tipo es "Auto", devolver un nuevo Auto
        if(tipo.equals("Auto")){
            Vehiculo auto = new Auto();
            return auto;
        }
        // Si el tipo es "Moto", devolver una nueva Moto
        else if(tipo.equals("Moto")){
            Vehiculo moto = new Moto();
            return moto;
        }
        // Si no corresponde a ninguno de los anteriores,
        // devolver null
        else{
            return null;
        }

    }
}
