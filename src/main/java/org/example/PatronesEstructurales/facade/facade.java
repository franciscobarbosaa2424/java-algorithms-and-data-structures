

/*
El patrón Facade es un patrón estructural que proporciona una interfaz simplificada y unificada
a un conjunto de interfaces de un subsistema o un sistema complejo. La idea principal es ocultar
la complejidad del sistema proporcionando una interfaz más fácil de usar y accesible,
lo que facilita a los clientes interactuar con el sistema sin necesidad de conocer
los detalles internos de su implementación.

Este patrón es particularmente útil cuando un sistema es complejo o difícil de entender,
y se quiere proporcionar una interfaz de uso sencillo que permita realizar
operaciones comunes de manera más directa y menos propensa a errores.

Aplicaciones Comunes:
-Sistemas de bibliotecas complejas:
Donde se quiere encapsular la complejidad de una biblioteca en una interfaz simple.
-Sistemas de grandes aplicaciones empresariales:
Donde diferentes subsistemas pueden ser encapsulados para reducir la complejidad.
-Sistemas legacy:
Al integrar sistemas antiguos con nuevas aplicaciones,
el patrón Facade puede ser utilizado para simplificar la interacción.

Ventajas:
Simplificación: Ofrece una interfaz fácil de usar, ocultando la complejidad de las interacciones internas.
Desacoplamiento: Reduce la dependencia entre los clientes y los subsistemas, facilitando cambios en la implementación interna sin afectar a los clientes.
Mantenimiento: Facilita el mantenimiento y la evolución del sistema al centralizar las interacciones comunes en un solo lugar.

Desventajas:
Posible sobrefuncionalidad: La interfaz del Facade puede volverse demasiado amplia, incluyendo funcionalidades que no todos los clientes necesitan.
Menos flexibilidad: Puede limitar el acceso a las funcionalidades completas de los subsistemas para los usuarios que necesitan operaciones más específicas.
 */

//Subsistemas
class Luces{
    public void encender(){
        System.out.println("Luces encendidas");
    }

    public void apagar(){
        System.out.println("Luces apagadas");
    }
}

class Climatizacion{
    public void encender(){
        System.out.println("Climatizacion encendida");
    }

    public void ajustarTemperatura(int grados){
        System.out.println("Temperatura ajustada a "+ grados + " grados");
    }

    public void apagar(){
        System.out.println("Climatizacion apagada");
    }
}

class Seguridad{
    public void activar(){
        System.out.println("Sistema de seguridad activado");
    }

    public void desactivar(){
        System.out.println("Sistema de seguridad descativado");
    }
}


//Facade
class HomeFacade{
    private Luces luces;
    private Climatizacion climatizacion;
    private Seguridad seguridad;

    public HomeFacade(){
        this.luces = new Luces();
        this.climatizacion = new Climatizacion();
        this.seguridad = new Seguridad();
    }

    public void llegarACasa(){
        luces.encender();
        climatizacion.ajustarTemperatura(22);
        seguridad.desactivar();
        System.out.println("Bienvenido a casa");
        System.out.println();
    }

    public void salirDeCasa(){
        luces.apagar();
        climatizacion.apagar();
        seguridad.activar();
        System.out.println("Hasta luego. Su hogar está seguro");
        System.out.println();
    }
}

//Uso del patron Facade
void main() {
HomeFacade homeFacade = new HomeFacade();

//llegar a casa
homeFacade.llegarACasa();

//salir de casa
homeFacade.salirDeCasa();
}