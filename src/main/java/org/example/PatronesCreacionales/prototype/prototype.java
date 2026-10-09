package org.example.PatronesCreacionales.prototype;
import java.util.HashMap;
import java.util.Map;
/*
El Patrón Prototype es un patrón de diseño creacional que permite crear nuevos objetos copiando
o clonando una instancia existente, conocida como prototipo. Este patrón es útil cuando
la creación de un nuevo objeto desde cero es costosa en términos de tiempo o recursos,
y se prefiere crear una copia de un objeto ya existente, que luego puede ser modificado según sea necesario.

 Objetivo:
 El objetivo principal del patrón Prototype es reducir el costo de creación de objetos al
 permitir la clonación de un objeto existente, en lugar de construir uno nuevo desde cero.
 Esto es especialmente útil en sistemas que requieren la creación repetitiva de objetos complejos.

Beneficios principales:

Reduce el costo de creación de objetos complejos.
Permite reutilizar configuraciones existentes.
Disminuye el acoplamiento con clases concretas.
Facilita la generación dinámica de nuevas instancias.

Casos de uso frecuentes:

Objetos con procesos de inicialización costosos.
Configuraciones que se repiten con pequeñas variaciones.
Aplicaciones gráficas y editores visuales.
Generación de plantillas o modelos reutilizables.


Clonación Superficial vs. Clonación Profunda

Clonación Superficial (Shallow Copy): En la clonación superficial, se crea una nueva instancia del objeto,
 pero los objetos referenciados (como otros objetos o arrays) no se clonan. En su lugar,
 se copian las referencias a los objetos originales. Esto significa que los cambios
 en los objetos referenciados afectarán tanto al clon como al original.

Clonación Profunda (Deep Copy): En la clonación profunda, no solo se clona el objeto principal,
sino también todos los objetos referenciados, de manera recursiva. De esta forma, el clon y el original
son completamente independientes, y los cambios en uno no afectan al otro.
 */
//1.Prototipo: Es una interfaz que declara el metodo clone(), que es responsable de clonar objetos.
interface VehiculoClonable {

    VehiculoClonable clonar();

    void mostrar();
}


//2. Concrete Prototype: Es una clase que implementa la interfaz Prototype y
//define el metodo clone() para crear una copia de sí misma.

// ----- Auto -----
class Auto implements VehiculoClonable {

    private String marca;

    public Auto(String marca) {
        this.marca = marca;
    }

    @Override
    public VehiculoClonable clonar() {

        // Crear y devolver un nuevo Auto
        // utilizando la misma marca
        VehiculoClonable auto  = new Auto(marca);
        return auto;

    }

    @Override
    public void mostrar() {
        System.out.println("Auto - Marca: " + marca);
    }
}


// ----- Motocicleta -----

class Motocicleta implements VehiculoClonable {

    private String marca;

    public Motocicleta(String marca) {
        this.marca = marca;
    }

    @Override
    public VehiculoClonable clonar() {

        // Crear y devolver una nueva Motocicleta
        // utilizando la misma marca
        VehiculoClonable moto = new Motocicleta(marca);
        return moto;
    }

    @Override
    public void mostrar() {
        System.out.println("Motocicleta - Marca: " + marca);
    }
}


//3. Cliente: El cliente solicita una nueva instancia de un objeto a través de
//la clonación de un prototipo en lugar de crearlo desde cero.
// Almacena los objetos que se utilizarán como prototipos
class VehiculoCache {

    private static Map<String, VehiculoClonable> mapaVehiculos = new HashMap<>();

    public static void cargarCache() {
        mapaVehiculos.put("auto", new Auto("Toyota"));
        mapaVehiculos.put("motocicleta", new Motocicleta("Honda"));
    }

    public static VehiculoClonable obtenerVehiculo(String tipoVehiculo) {
        VehiculoClonable vehiculo = mapaVehiculos.get(tipoVehiculo);

        // Devuelve una copia del vehículo almacenado
        return vehiculo.clonar();
    }
}
