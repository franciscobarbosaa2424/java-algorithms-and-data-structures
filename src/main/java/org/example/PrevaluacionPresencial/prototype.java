package org.example.PrevaluacionPresencial;

import java.util.ArrayList;
import java.util.List;

interface PrototipoPersonaje {
    Personaje clonar();
}

class Personaje implements PrototipoPersonaje {
    private String nombre;
    private int nivel;
    private List<String> habilidades;

    public Personaje(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.habilidades = new ArrayList<>();
    }

    private Personaje(Personaje original) {
        // Este constructor construye la copia.
        // "original" es el personaje del que tomás los datos.
        // "this" es el nuevo personaje que estás construyendo.
        this.nombre = original.nombre;
        // 1. Asigná al atributo nombre de this
        //    el valor del atributo nombre de original.
        this.nivel = original.nivel;
        // 2. Hacé lo mismo con el atributo nivel.

        // 3. Inicializá habilidades con un ArrayList nuevo.
        //    Pasale al constructor de ArrayList la lista
        //    de habilidades del personaje original.
        this.habilidades = new ArrayList<>(original.habilidades);
        // No asignes directamente original.habilidades:
        // eso haría que ambos personajes usaran la misma lista.
        //
        // Como los elementos son String (inmutables),
        // alcanza con crear una lista nueva con esos elementos.
    }

    @Override
    public Personaje clonar() {
        // Reemplazá el retorno de null por un Personaje nuevo.
        // Usá "new" e invocá el constructor que recibe un Personaje.
        // Pasale "this": representa al personaje que querés copiar.
        //
        // No devuelvas directamente this:
        // estarías devolviendo el mismo objeto, no una copia.
        return new Personaje(this);
    }

    public void agregarHabilidad(String habilidad) {
        habilidades.add(habilidad);
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    @Override
    public String toString() {
        return "Personaje [nombre=" + nombre
                + ", nivel=" + nivel
                + ", habilidades=" + habilidades + "]";
    }
}
