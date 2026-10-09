package org.example.PrevaluacionPresencial;

interface Notificacion {
    void enviar(String destinatario, String mensaje);
}

class NotificacionCorreo implements Notificacion {
    @Override
    public void enviar(String destinatario, String mensaje) {
        // Mostrá un mensaje con este formato exacto:
        // Correo enviado a [destinatario]: [mensaje]
        System.out.println("Correo enviado a "+destinatario+": "+mensaje);
        // Usá los parámetros recibidos para completar los datos.
        // Los corchetes no deben aparecer en la salida.
    }
}

class NotificacionSMS implements Notificacion {
    @Override
    public void enviar(String destinatario, String mensaje) {
        // Mostrá un mensaje con este formato exacto:
        // SMS enviado a [destinatario]: [mensaje]
        System.out.println("SMS enviado a "+destinatario+": "+mensaje);
        // Usá los parámetros recibidos para completar los datos.
        // Respetá los espacios y los dos puntos.
    }
}

abstract class FabricaNotificacion {
    // Este es el Factory Method.
    // Cada fábrica concreta define qué notificación devuelve.
    public abstract Notificacion crearNotificacion();

    public void enviarNotificacion(String destinatario, String mensaje) {
        // 1. Llamá a crearNotificacion() y guardá el resultado
        //    en una variable de tipo Notificacion.
        Notificacion notificacion = crearNotificacion();
        // 2. Sobre esa variable, invocá enviar() y pasale
        //    los parámetros destinatario y mensaje recibidos.
        notificacion.enviar(destinatario,mensaje);
        // No crees directamente objetos de NotificacionCorreo o
        // NotificacionSMS aquí. Tampoco necesitás un if para elegir:
        // la fábrica concreta se encarga de decidir qué objeto crear.
    }
}

class FabricaCorreo extends FabricaNotificacion {
    @Override
    public Notificacion crearNotificacion() {
        // Reemplazá el retorno de null por un objeto nuevo
        // de tipo NotificacionCorreo, utilizando "new".
        // Este método solo crea y devuelve el objeto; no envía mensajes.
        return new NotificacionCorreo();
    }
}

class FabricaSMS extends FabricaNotificacion {
    @Override
    public Notificacion crearNotificacion() {
        // Reemplazá el retorno de null por un objeto nuevo
        // de tipo NotificacionSMS, utilizando "new".
        // Aunque el retorno declarado es Notificacion, podés devolver
        // un objeto de una clase que implemente esa interfaz.
        return new NotificacionSMS();
    }
}
