/*
El patrón Observer (u Observador) es un patrón de diseño de comportamiento
que define una relación de dependencia uno-a-muchos entre objetos.
Cuando un objeto cambia su estado, todos los objetos dependientes son notificados
automáticamente. Este patrón es útil para implementar sistemas donde múltiples
partes interesadas (observadores) necesitan estar informadas sobre los cambios
en el estado de otro objeto (el sujeto).

1.Sujeto (Subject):
Es el objeto que mantiene una lista de dependientes (observadores) y
proporciona métodos para agregar o eliminar observadores. Cuando cambia
el estado del sujeto, notifica a todos los observadores registrados.

2.Observador (Observer):
Es una interfaz o clase abstracta que define el metodo update()
que será llamado cuando el sujeto cambie de estado.

3.Sujeto Concreto (Concrete Subject):
Implementa la interfaz del Sujeto. Almacena el estado que los observadores
necesitan conocer y notifica a sus observadores cuando este estado cambia.

4.Observador Concreto (Concrete Observer):
Implementa la interfaz del Observador, manteniendo una referencia
al sujeto concreto. Este recibe las actualizaciones del sujeto y
ejecuta acciones en respuesta a esos cambios.

Ventajas:
Desacoplamiento: Los sujetos y observadores están desacoplados. Un sujeto no necesita conocer todos los detalles de sus observadores.

Flexibilidad: Permite añadir o eliminar observadores en tiempo de ejecución.

Reutilización: Facilita la reutilización de componentes, ya que los observadores pueden ser reutilizados con diferentes sujetos.

Desventajas:
Complejidad: Puede introducir complejidad adicional, especialmente en sistemas con muchos observadores y sujetos.

Posibles problemas de rendimiento: Si el número de observadores es grande, el proceso de notificación puede ser costoso.

 USOS:
 Sistemas de eventos en interfaces gráficas: Donde los elementos de la interfaz deben reaccionar a las acciones del usuario.

Sistemas de notificaciones: Como en aplicaciones de mensajería donde los usuarios reciben notificaciones de mensajes nuevos.

Publicación/Suscripción: En sistemas donde los módulos o servicios deben reaccionar a eventos o datos publicados por otros.

 */

import java.util.ArrayList;
import java.util.List;

interface Observador{
    void actualizar(String estadoClima);
}

interface Sujeto {
    void agregarObservador(Observador observador);
    void eliminarObservador(Observador observador);
    void notificarObservadores();
}

class ServicioMeteorologico implements Sujeto {
    private List<Observador> observadores;
    private String estadoClima;

    public ServicioMeteorologico(){
        this.observadores = new ArrayList<>();
    }

    @Override
    public void agregarObservador(Observador observador){
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(Observador observador){
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(){
        for(Observador observador : observadores){
            observador.actualizar(estadoClima);
        }
    }

    public void cambiarEstadoClima(String nuevoEstadoClima){
        this.estadoClima = nuevoEstadoClima;
        notificarObservadores();
    }
}

class DispositivoMovil implements Observador{
    private String nombreDispositivo;

    public DispositivoMovil(String nombreDispositivo){
        this.nombreDispositivo = nombreDispositivo;
    }

    @Override
    public void actualizar(String estadoClima){
        System.out.println(nombreDispositivo + " ha recibido la actualizacion de clima: "+estadoClima);
    }
}

void main() {
    ServicioMeteorologico servicioMeteorologico = new ServicioMeteorologico();

    Observador dispositivo1 = new DispositivoMovil("Telefono movil 1");
    Observador dispositivo2 = new DispositivoMovil("Telefono movil 2");

    servicioMeteorologico.agregarObservador(dispositivo1);
    servicioMeteorologico.agregarObservador(dispositivo2);

    servicioMeteorologico.cambiarEstadoClima("Soleado");
    servicioMeteorologico.cambiarEstadoClima("Lluvioso");
}

