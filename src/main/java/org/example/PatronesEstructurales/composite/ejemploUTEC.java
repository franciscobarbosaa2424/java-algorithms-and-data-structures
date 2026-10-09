package org.example.PatronesEstructurales.composite;

import java.util.ArrayList;
import java.util.List;

interface ElementoOrganizacional {
    double calcularCosteTotal();
}


// Elemento individual
class Empleado implements ElementoOrganizacional {

    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    @Override
    public double calcularCosteTotal() {
        return salario;
    }

    @Override
    public String toString() {
        return nombre + " (Salario: $" + salario + ")";
    }
}


// Grupo de elementos
// Se proporciona como ejemplo del patrón Composite
class Departamento implements ElementoOrganizacional {

    private String nombre;
    private List<ElementoOrganizacional> elementos = new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public void agregarElemento(ElementoOrganizacional elemento) {
        elementos.add(elemento);
    }

    public void eliminarElemento(ElementoOrganizacional elemento) {
        elementos.remove(elemento);
    }

    @Override
    public double calcularCosteTotal() {

        double costeTotal = 0;

        for (ElementoOrganizacional elemento : elementos) {
            costeTotal += elemento.calcularCosteTotal();
        }

        return costeTotal;
    }

    @Override
    public String toString() {
        return nombre;
    }
}


// Proyecto compuesto por empleados y/o departamentos
class Proyecto implements ElementoOrganizacional {

    private String nombre;
    private List<ElementoOrganizacional> participantes = new ArrayList<>();

    public Proyecto(String nombre) {
        this.nombre = nombre;
    }

    public void agregarParticipante(ElementoOrganizacional participante) {

        // Agregar el participante a la lista
        participantes.add(participante);
    }

    public void eliminarParticipante(ElementoOrganizacional participante) {

        // Eliminar el participante de la lista
        participantes.remove(participante);
    }

    @Override
    public double calcularCosteTotal() {

        double costeTotal = 0;

        // Recorrer los participantes
        // y sumar el costo de cada uno
        for(ElementoOrganizacional participante: participantes){
            costeTotal+=participante.calcularCosteTotal();
        }

        return costeTotal;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
