package org.example.PatronesCreacionales.builder;

/*
Como funciona?
1. Director: Opcionalmente, se puede tener una clase director que gestiona el proceso
de construcción utilizando el Builder.

2. Builder: Esta es una interfaz o clase abstracta que define los pasos para
construir el objeto. Cada paso construye una parte del objeto.

3. Concrete Builder: Implementa la interfaz del Builder,
proporcionando implementaciones específicas para los pasos de construcción.
También contiene una referencia al objeto que se está construyendo.

4. Producto: Es el objeto final que se construye, el cual es retornado una vez completado
 el proceso de construcción.

 Ventajas del patron builder
1. Control sobre la construcción: Permite la construcción paso a paso de un objeto,
lo que es ideal para objetos que requieren configuraciones específicas
 o que tienen múltiples parámetros opcionales.

2. Código más limpio: Evita la creación de constructores con una gran cantidad de parámetros,
 lo que puede ser confuso y propenso a errores.

3. Reutilización: Se pueden reutilizar diferentes Builders para
crear diferentes representaciones del objeto complejo.

4. Flexibilidad: El mismo Builder puede usarse para crear distintas versiones
 de un objeto complejo mediante la combinación de diferentes pasos.
 */
//1.CLASE PRODUCTO
class Casa{
    private int puertas;
    private int ventanas;
    private boolean garaje;
    private boolean piscina;

    public Casa(int puertas, int ventanas, boolean garaje, boolean piscina){
        this.puertas = puertas;
        this.ventanas = ventanas;
        this.garaje = garaje;
        this.piscina = piscina;
    }

    @Override
    public String toString(){
        return "Casa [puertas="+ puertas + ", ventanas=" + ventanas +
                " ,garaje=" + garaje + " ,piscina=" + piscina + "]";
    }
}

//2.Interfaz del Builder
interface CasaBuilder {
    CasaBuilder setPuertas(int puertas);
    CasaBuilder setVentanas(int ventanas);
    CasaBuilder setGaraje(boolean garaje);
    CasaBuilder setPiscina(boolean piscina);
    Casa build(); // Construye y retorna la casa final
}

//3.Implementacion del Concrete Builder
class CasaConcretaBuilder implements CasaBuilder{
    private int puertas;
    private int ventanas;
    private boolean garaje;
    private boolean piscina;

    @Override
    public CasaBuilder setPuertas(int puertas){
        this.puertas = puertas;
        return this;
    }

    @Override
    public CasaBuilder setVentanas(int ventanas){
        this.ventanas = ventanas;
        return this;
    }

    @Override
    public CasaBuilder setGaraje(boolean garaje){
        this.garaje = garaje;
        return this;
    }

    @Override
    public CasaBuilder setPiscina(boolean piscina){
        this.piscina = piscina;
        return this;
    }

    @Override
    public Casa build(){
        return new Casa(puertas,ventanas,garaje,piscina);
    }
}

//4.Uso del Builder
class ConstructorDeCasas {
    static void main() {
        CasaBuilder builder = new CasaConcretaBuilder();

        Casa casa1 = builder.setPuertas(4)
                            .setVentanas(10)
                            .setGaraje(true)
                            .setPiscina(true)
                            .build();

        System.out.println(casa1);

        Casa casa2 = builder.setPuertas(9)
                    .setVentanas(2)
                    .setGaraje(false)
                    .setPiscina(false)
                    .build();
        System.out.println(casa2);
    }
}

