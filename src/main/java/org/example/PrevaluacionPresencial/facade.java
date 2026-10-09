package org.example.PrevaluacionPresencial;

class Luces {
    public void encender() {
        System.out.println("Luces encendidas");
    }

    public void apagar() {
        System.out.println("Luces apagadas");
    }
}

class Proyector {
    public void encender() {
        System.out.println("Proyector encendido");
    }

    public void apagar() {
        System.out.println("Proyector apagado");
    }
}

class AireAcondicionado {
    public void encender() {
        System.out.println("Aire acondicionado encendido");
    }

    public void apagar() {
        System.out.println("Aire acondicionado apagado");
    }
}

class AulaFacade {
    private Luces luces;
    private Proyector proyector;
    private AireAcondicionado aire;

    public AulaFacade(Luces luces, Proyector proyector, AireAcondicionado aire) {
        // Guardá cada dispositivo recibido en el atributo correspondiente.
        // Como los parámetros y los atributos tienen el mismo nombre,
        // utilizá "this." para referirte al atributo del objeto.
        // No crees dispositivos nuevos: conservá los que recibís.
        this.luces = luces;
        this.proyector = proyector;
        this.aire = aire;
    }

    public void iniciarClase() {
        // 1. Mostrá exactamente: Preparando el aula...
        System.out.println("Preparando el aula...");
        // 2. Invocá el método encender() del atributo luces.
        luces.encender();
        // 3. Invocá el método encender() del atributo proyector.
        proyector.encender();
        // 4. Invocá el método encender() del atributo aire.
        aire.encender();
        //
        // Cada dispositivo ya imprime su propio mensaje.
        // Aquí debés llamar a sus métodos, no repetir esos mensajes.


    }

    public void finalizarClase() {
        // 1. Mostrá exactamente: Cerrando el aula...
        System.out.println("Cerrando el aula...");
        // 2. Invocá el método apagar() del atributo luces.
        luces.apagar();
        // 3. Invocá el método apagar() del atributo proyector.
        proyector.apagar();
        // 4. Invocá el método apagar() del atributo aire.
        aire.apagar();
    }
}