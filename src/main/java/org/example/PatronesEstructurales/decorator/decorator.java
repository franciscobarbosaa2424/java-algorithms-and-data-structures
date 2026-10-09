
/*
El Patrón Decorator es un patrón de diseño estructural que permite agregar funcionalidades
a objetos de manera flexible y dinámica. A diferencia de la herencia, que agrega comportamiento
a una clase en su totalidad, el Decorator agrega o modifica funcionalidades en un solo objeto
de manera selectiva.

Cuando usar el patron decorator?
-Cuando quieres agregar funcionalidades a un objeto individual, sin afectar el comportamiento
de otros objetos de la misma clase.
-Cuando necesitas añadir responsabilidades adicionales a los objetos de forma flexible y reversible.
-Cuando la herencia no es viable debido a la necesidad de múltiples combinaciones de responsabilidades.

Estructura del patron
1.Componente (Component):
Es una interfaz o clase abstracta que define las operaciones que pueden ser decoradas.
2.Componente Concreto (ConcreteComponent):
Es una implementación del Componente, que puede ser decorada.
3.Decorador (Decorator):
Es una clase abstracta que implementa la interfaz del Componente y contiene una referencia
a un objeto del tipo Componente.
4.Decoradores Concretos (ConcreteDecorators):
Son clases que extienden el Decorador y agregan funcionalidades adicionales al Componente.
 */

//1.Definicion del Componente
interface Ventana{
    void dibujar();
}

class VentanaSimple implements Ventana{
    @Override
    public void dibujar(){
        System.out.println("Dibujar ventana simple");
    }
}

//2.Definicion del Decorador
abstract class DecoradorVentana implements Ventana{
    protected Ventana ventanaDecorada;

    public DecoradorVentana(Ventana ventanaDecorada){
        this.ventanaDecorada = ventanaDecorada;
    }

    @Override
    public void dibujar(){
        ventanaDecorada.dibujar();
    }
}

//3.Implementacion de Decoradores Concretos
class BordeDecorador extends DecoradorVentana{
    public BordeDecorador(Ventana ventanaDecorada){
        super(ventanaDecorada);
    }

    private void dibujarBorde(){
        System.out.println("Dibujar un borde a la ventana");
    }

    @Override
    public void dibujar(){
        super.dibujar();
        dibujarBorde();
    }
}

class BarraDesplazamientoDecorador extends DecoradorVentana{
    public BarraDesplazamientoDecorador(Ventana ventanaDecorada){
        super(ventanaDecorada);
    }

    private void dibujarBarraDesplazamiento(){
        System.out.println("Dibujar una barra de desplazamiento");
    }

    @Override
    public void dibujar(){
        super.dibujar();
        dibujarBarraDesplazamiento();
    }
}

void main() {
    //Crear una ventana simple
    Ventana ventanaSimple = new VentanaSimple();

    //Decorar la ventana con un borde
    Ventana ventanaConBorde = new BordeDecorador(ventanaSimple);
    ventanaConBorde.dibujar();
    System.out.println();

    //Decorar la ventana con un borde y una barra de desplazamiento
    Ventana ventanaConBordeYBarra = new BarraDesplazamientoDecorador(ventanaConBorde);
    ventanaConBordeYBarra.dibujar();

}