

/*
El patrón Strategy (o Estrategia) es un patrón de diseño de comportamiento que permite
definir una familia de algoritmos, encapsular cada uno de ellos y hacerlos intercambiables.
Este patrón permite que el algoritmo varíe independientemente de los clientes que
lo utilizan, facilitando la extensión y modificación del comportamiento sin cambiar
el código del cliente.

Componentes Principales:

Estrategia (Strategy):
Es una interfaz que define un conjunto de métodos para los algoritmos que serán implementados
por las estrategias concretas.

Estrategias Concretas (Concrete Strategies):
Son las implementaciones concretas de la interfaz de estrategia. Cada clase implementa
un algoritmo específico.

Contexto (Context):
Es la clase que utiliza una estrategia concreta para realizar un comportamiento. El contexto
no implementa los algoritmos por sí mismo, sino que delega su ejecución a la estrategia seleccionada.

VENTAJAS:
Flexibilidad: Permite cambiar el algoritmo usado en tiempo de ejecución sin modificar el código cliente.
Principio de Abierto/Cerrado: Facilita la adición de nuevas estrategias sin alterar las existentes.
Desacoplamiento: Separa el comportamiento de una clase del algoritmo específico que se utiliza.

DESVENTAJAS:
Complejidad adicional: Aumenta el número de clases en el sistema, lo que puede hacer que el diseño sea más complejo.
Mantenimiento: Si hay muchas estrategias, puede ser difícil mantenerlas y entender cómo interactúan entre sí.

 USOS COMUNES:
Compresión de Archivos: Donde diferentes estrategias de compresión (ZIP, RAR, GZIP) pueden ser intercambiadas fácilmente.
Cálculo de Impuestos: Donde diferentes estrategias de cálculo de impuestos pueden ser aplicadas según la región o tipo de producto.
Algoritmos de Búsqueda y Ordenación: Donde diferentes estrategias de búsqueda u ordenación pueden ser aplicadas dependiendo de la situación
 */


//Interfaz Strategy
interface MetodoPago {
    void procesarPago(double monto);
}

//Estrategia Concreta: Pago con tarjeta de credito
class PagoTarjetaCredito implements MetodoPago{
    @Override
    public void procesarPago(double monto){
        System.out.println("Procesando pago de $"+monto+ " con tarjeta de credito.");
    }
}

//Estrategia Concreta: Pago con PayPal
class PagoPayPal implements MetodoPago{
    @Override
    public void procesarPago(double monto){
        System.out.println("Procesando pago de $"+monto+" con PayPal.");
    }
}

class PagoTransferenciaBancaria implements MetodoPago{
    @Override
    public void procesarPago(double monto){
        System.out.println("Procesando pago de $"+monto+" con transferencia bancaria.");
    }
}

//Contexto que utiliza las estrategias de pago
class ProcesadorPago{
    private MetodoPago metodoPago;

    //Se permite cambiar la estrategia en tiempo de ejecucion
    public void setMetodoPago(MetodoPago metodoPago){
        this.metodoPago = metodoPago;
    }

    public void procesar(double monto){
        metodoPago.procesarPago(monto);
    }
}

void main() {
    ProcesadorPago procesador = new ProcesadorPago();

    procesador.setMetodoPago(new PagoTarjetaCredito());
    procesador.procesar(100.0);

    procesador.setMetodoPago(new PagoPayPal());
    procesador.procesar(110.0);

    procesador.setMetodoPago(new PagoTransferenciaBancaria());
    procesador.procesar(200.0);
}