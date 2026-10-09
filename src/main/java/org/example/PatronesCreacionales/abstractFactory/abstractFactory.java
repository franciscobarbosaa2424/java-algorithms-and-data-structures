

/*
El Patrón Abstract Factory es un patrón de diseño creacional que se utiliza
para crear familias de objetos relacionados o dependientes
sin especificar sus clases concretas. Este patrón proporciona una interfaz
para crear un conjunto de objetos que pertenecen a una misma familia
y que están destinados a funcionar juntos. Es especialmente útil cuando
se requiere garantizar que los productos de una familia sean compatibles entre sí.


La estructura básica del patrón Abstract Factory involucra los siguientes componentes:

Abstract Factory: Es la interfaz que declara los métodos para crear los productos abstractos
 (por ejemplo, crearBoton(), crearMenu()).

Concrete Factory: Implementa la interfaz Abstract Factory y es responsable de crear
los productos concretos pertenecientes a una familia específica
(por ejemplo, BotonWindows, MenuWindows).

Producto Abstracto: Es una interfaz o clase abstracta que define un tipo de producto
(por ejemplo, Boton, Menu).

Producto Concreto: Son las implementaciones concretas de los productos abstractos
(por ejemplo, BotonWindows, MenuWindows).
 */

//1. Interfaces de los Productos Abstractos
interface Rueda{
    void fabricar();
}

interface Motor{
    void ensamblar();
}

//2.Implementaciones Concretas de los Productos
//Estas clases representan las implementaciones concretas de las ruedas y motores para coches y motos.
class RuedaCoche implements Rueda{
    @Override
    public void fabricar(){
        System.out.println("Fabricando rueda de coche.");
    }
}

class RuedaMoto implements Rueda{
    @Override
    public void fabricar(){
        System.out.println("Fabricando rueda de moto.");
    }
}

class MotorCoche implements Motor{
    @Override
    public void ensamblar(){
        System.out.println("Ensamblando motor de coche.");
    }
}

class MotorMoto implements Motor{
    @Override
    public void ensamblar(){
        System.out.println("Ensamblando motor de moto");
    }
}

//3.Interfaz Abstracta para la Fábrica
//Definimos una interfaz para las fábricas que crearán estos componentes.
interface VehiculoFactory{
    Rueda crearRueda();
    Motor crearMotor();
}

//4.Implementaciones Concretas de la Fábrica
//Ahora creamos las fábricas concretas para coches y motos.
//Estas fábricas se encargan de crear los componentes específicos para coches y motos.
class CocheFactory implements VehiculoFactory{
    @Override
    public Rueda crearRueda(){
        return new RuedaCoche();
    }

    @Override
    public Motor crearMotor(){
        return new MotorCoche();
    }
}

class MotoFactory implements VehiculoFactory{
    @Override
    public Rueda crearRueda(){
        return new RuedaMoto();
    }

    @Override
    public Motor crearMotor(){
        return new MotorMoto();
    }
}

//5.Uso del Patrón Abstract Factory
//Finalmente, utilizamos las fábricas para crear los componentes de un vehículo.
class Ensamblaje{
    private Rueda rueda;
    private Motor motor;

    public Ensamblaje(VehiculoFactory factory){
        rueda = factory.crearRueda();
        motor = factory.crearMotor();
    }

    public void ensamblarVehiculo(){
        rueda.fabricar();
        motor.ensamblar();
    }
}

void main() {
    VehiculoFactory factory;

    //Cambiar aqui para crear los componentes de un coche o una moto
    factory = new MotoFactory();

    Ensamblaje ensamblaje = new Ensamblaje(factory);
    ensamblaje.ensamblarVehiculo();

}