package org.example.PatronesCreacionales.factoryMethod;

/*
El Patrón Factory Method es un patrón de diseño creacional que define una interfaz
para crear objetos en una clase base, pero permite a las subclases cambiar
el tipo de objetos que se crearán. En lugar de instanciar objetos directamente
con el operador new, delegamos la creación de objetos a través de un metodo fábrica,
lo que hace que el código sea más flexible y fácil de mantener.


Aplicaciones del Patrón Factory Method

Este patrón es útil cuando:
Queremos delegar la creación de objetos a subclases: Esto permite que diferentes subclases
generen diferentes tipos de objetos sin modificar el código base.
Deseamos encapsular la lógica de creación de objetos: Mantener la lógica de creación
 en un único lugar facilita el mantenimiento y la modificación del código.
Tenemos varias clases derivadas que comparten una interfaz común,
pero la implementación específica varía entre ellas.

¿Por qué utilizar el Patrón Factory Method?

Este patrón es útil cuando:
Sistemas de manejo de documentos: Diferentes tipos de documentos (PDF, Word, Excel)
 pueden ser creados mediante un metodo fábrica en lugar de instanciar cada
 tipo de documento manualmente.
Interfaces gráficas: En aplicaciones donde se soportan múltiples estilos de interfaz
 (por ejemplo, Windows, Mac), podemos utilizar un metodo fábrica para crear los componentes
de la interfaz según la plataforma.
Gestión de conexiones de bases de datos: Permite la creación de diferentes
tipos de conexiones de base de datos según la configuración o el entorno.
 */

// Clase abstracta Animal
abstract class Animal {

    public abstract String hacerSonido();
}

// Clase concreta Perro
class Perro extends Animal {

    @Override
    public String hacerSonido() {
        return "Guau";
    }
}

// Clase concreta Gato
class Gato extends Animal {

    @Override
    public String hacerSonido() {
        return "Miau";
    }
}

// Clase encargada de crear los animales
class AnimalFactory {

    public Animal crearAnimal(String tipo) {

        // Si el tipo es "Perro", devolver un nuevo Perro
        if(tipo=="Perro"){
            Animal perro = new Perro();
            return perro;
        }
        // Si el tipo es "Gato", devolver un nuevo Gato
        else if(tipo=="Gato"){
            Animal gato = new Gato();
            return gato;
        }
        // Si no corresponde a ninguno de los anteriores,
        // devolver null
        else{
            return null;
        }

    }
}