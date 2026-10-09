
//package org.example;
/*
import org.example.PatronesCreacionales.singleton.Configuracion;
import org.example.PatronesCreacionales.abstractFactory.*;

public class AlgoritmosYPatronesDeDiseno {
*/
  /*
¿Cómo se clasifican los Patrones de Diseño?

    Los patrones de diseño se clasifican en tres categorías principales según su propósito:

1. Patrones de Diseño Creacionales:
    Estos patrones se enfocan en la creación de objetos.
    El objetivo es abstraer el proceso de instanciación, haciendo que el sistema sea más independiente
    de cómo se crean, componen y representan los objetos.
    Ejemplos: Singleton, Factory Method, Abstract Factory, Builder, Prototype.

2. Patrones de Diseño Estructurales:
    Estos patrones se centran en la composición de clases y objetos.
    Ayudan a garantizar que si una parte del sistema cambia, el sistema completo no se vea afectado.
    Ejemplos: Adapter, Composite, Proxy, Decorator, Facade, Bridge, Flyweight.

3. Patrones de Diseño de Comportamiento:
    Estos patrones están relacionados con la interacción y responsabilidad entre los objetos.
    Se centran en cómo los objetos colaboran y se comunican entre sí.
    Ejemplos: Strategy, Observer, Command, State, Chain of Responsibility, Mediator, Visitor, Iterator, Memento, Template Method, Interpreter.
 */

   // static void main() {
/*SINGLETON:
✅Se utiliza para restringir la creación de instancias de una clase a un solo objeto.
Este patrón asegura que una clase tenga únicamente una instancia
 y proporciona un punto de acceso global a dicha instancia.

//3 PARTES
//✅Una clase con contructor privado
//✅una variable estatica = constante
//✅un metodo publico que sea estatico
*/
        /*
        System.out.println("Patron Singleton:");
        System.out.println("-----------------");
        //❌Configuracion config1 = new Configuracion();
        //❌No se puede intanciar porque tiene constructor privado
        System.out.println("Modulo 1:");
        Configuracion config1 = Configuracion.getInstancia();
        config1.mostrarMensaje();

        System.out.println("Modulo 2:");
        Configuracion config2 = Configuracion.getInstancia();
        config2.mostrarMensaje();

        System.out.println("¿En memoria es la misma instancia?");
        System.out.println(config1==config2);
        System.out.println(config1);
        System.out.println(config2);
        System.out.println();
        System.out.println();
        System.out.println();

*/
/*FACTORY METHOD
El Patrón Factory Method es un patrón de diseño creacional que define una interfaz
para crear objetos en una clase base, pero permite a las subclases
cambiar el tipo de objetos que se crearán. En lugar de instanciar objetos directamente
con el operador new, delegamos la creación de objetos a través de un metodo fábrica,
lo que hace que el código sea más flexible y fácil de mantener
 */
        /*
        System.out.println("Patron Factory Method:");
        System.out.println("-----------------");
EnvioCreator envioCorreo = new EnvioCorreoCreator();
envioCorreo.procesarEnvio();

EnvioCreator envioMoto = new EnvioMotoCreator();
envioMoto.procesarEnvio();

EnvioCreator envioCamion = new EnvioCamionCreator();
envioCamion.procesarEnvio();

        System.out.println();
        System.out.println();
        System.out.println();
*/
/*
ABSTRACT FACTORY
 */
        /*
        System.out.println("Patron Abstract Factory:");
        System.out.println("-----------------");
//Seleccionamos una familia de productos
        OutfitFactory factory = new OutfitUrbanoFactory();
//cliente trabaja sin saber las clases concretas
        TiendaRopa tiendaRopa = new TiendaRopa(factory);

        tiendaRopa.mostrarOutfit();


        System.out.println();
        System.out.println();
        System.out.println();


    }

}
*/