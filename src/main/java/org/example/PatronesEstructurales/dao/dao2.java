package org.example.PatronesEstructurales.dao;

import java.util.ArrayList;
import java.util.List;

class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(int id, String titulo, String autor, int anioPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                '}';
    }
}

interface LibroDAO {
    void agregarLibro(Libro libro);
    Libro obtenerLibroPorId(int id);
    void actualizarLibro(Libro libro);
    void eliminarLibro(int id);
    List<Libro> obtenerTodosLosLibros();
}

class LibroDAOImpl implements LibroDAO {
//Completa la clase, siguiendo la pauta dada, aquí.


    private List<Libro> libros = new ArrayList<>();

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }

    @Override
    public Libro obtenerLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public void agregarLibro(Libro libro) {
        if (obtenerLibroPorId(libro.getId()) != null) {
            actualizarLibro(libro);
        } else {
            libros.add(libro);
        }
    }

    @Override
    public void actualizarLibro(Libro libro) {
        Libro existente = obtenerLibroPorId(libro.getId());

        if (existente != null) {
            existente.setTitulo(libro.getTitulo());
            existente.setAutor(libro.getAutor());
            existente.setAnioPublicacion(libro.getAnioPublicacion());
        }
    }

    @Override
    public void eliminarLibro(int id) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == id) {
                libros.remove(i);
                return;
            }
        }
    }

}