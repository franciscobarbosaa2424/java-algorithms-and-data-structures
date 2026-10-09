
/*

El Patrón Adapter es un patrón de diseño estructural que permite que dos clases con
interfaces incompatibles trabajen juntas. Este patrón actúa como un intermediario o "adaptador"
que convierte la interfaz de una clase en otra interfaz que el cliente espera.
Es especialmente útil cuando se necesita utilizar una clase existente, pero su interfaz
no coincide con lo que se requiere en el contexto actual.

Objetivo:
El objetivo principal del Patrón Adapter es facilitar la interoperabilidad entre clases que,
de otra manera, no podrían trabajar juntas debido a diferencias en sus interfaces.
Esto permite que se puedan reutilizar clases existentes sin necesidad de modificar su código,
respetando así el principio de abierto/cerrado (Open/Closed Principle) de SOLID.

 Como funciona?
1. Cliente: La clase que necesita utilizar la funcionalidad de otra clase con una interfaz incompatible.
2. Interfaz Objetivo (Target): La interfaz que el cliente espera.
3. Adaptado (Adaptee): La clase con una interfaz incompatible que se desea utilizar.
4. Adaptador (Adapter): Una clase que implementa la interfaz objetivo y se comunica con el adaptado,
 transformando las llamadas del cliente en algo que el adaptado pueda entender.


Tipos de Adapter

Adapter de Clase: Utiliza herencia para adaptar una clase a la interfaz objetivo.
Adapter de Objeto: Utiliza composición para adaptar una clase a la interfaz objetivo.
Este es el más común en Java, ya que permite mayor flexibilidad.

Usos Comunes del Patrón Adapter

1. Integración de librerías o sistemas antiguos: Cuando se necesita utilizar una librería o sistema que no se puede modificar y cuya interfaz es incompatible con el nuevo código.
2. Compatibilidad de APIs: Para hacer compatible una nueva API con una existente, adaptando las diferencias entre las interfaces.
3. Sistemas de legado: En aplicaciones que han evolucionado con el tiempo, permitiendo que los componentes nuevos se comuniquen con sistemas antiguos.


Ventajas del Patrón Adapter

Reutilización de código existente: Permite usar clases existentes sin necesidad de modificarlas.
Facilita la interoperabilidad: Soluciona problemas de compatibilidad entre clases o componentes.
Respetar el principio de abierto/cerrado: No se necesita modificar las clases originales.
 */


//1.Interfaz EnchufeEuropeo
interface EnchufeEuropeo{
    void conectar();
}

//2.Clase EnchufeAmericano
class EnchufeAmericano{
    public void plugIn(){
        System.out.println("Enchufe americano conectado.");
    }
}

//3.Adaptador AdaptadorEnchufe(Adapter de objeto)
class AdaptadorEnchufe implements EnchufeEuropeo{
    private EnchufeAmericano enchufeAmericano;

    public AdaptadorEnchufe(EnchufeAmericano enchufeAmericano){
        this.enchufeAmericano=enchufeAmericano;
    }

    @Override
    public void conectar(){
        enchufeAmericano.plugIn(); //Adaptación de la llamada
    }
}

//4.Uso del Adaptador
void main() {
    EnchufeAmericano enchufeAmericano = new EnchufeAmericano();
    EnchufeEuropeo enchufeEuropeo = new AdaptadorEnchufe(enchufeAmericano);
    enchufeEuropeo.conectar();
}