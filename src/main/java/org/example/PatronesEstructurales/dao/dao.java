package org.example.PatronesEstructurales.dao;

import java.util.ArrayList;
import java.util.List;

interface EmpleadoDAO {
    List<Empleado> obtenerTodosLosEmpleados();
    Empleado obtenerEmpleadoPorId(int id);
    void agregarEmpleado(Empleado empleado);
    void actualizarEmpleado(Empleado empleado);
    void eliminarEmpleado(int id);
}

class Empleado {
    private int id;
    private String nombre;
    private String cargo;
    private double salario;

    // Constructor
    public Empleado(int id, String nombre, String cargo, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}

class EmpleadoDAOImpl implements EmpleadoDAO {
    //Completa la clase, siguiendo la pauta dada, aquí
    private List<Empleado> empleados = new ArrayList<>();


    @Override
    public List<Empleado> obtenerTodosLosEmpleados(){
        return empleados;
    }

    @Override
    public Empleado obtenerEmpleadoPorId(int id){
        for(Empleado e : empleados){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

    @Override
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    @Override
    public void actualizarEmpleado(Empleado empleado){
       /* for(Empleado e: empleados){
            if(e.getId() == empleado.getId()){

            }
        }*/
        int indice = empleados.indexOf(empleado);
        if(indice != -1){
            empleados.set(indice,empleado);
        }
    }

    @Override
    public void eliminarEmpleado(int id){
        Empleado aux = null;
        for(Empleado e : empleados){
            if(e.getId() == id){
                aux = e;
                break;
            }
        }
        if(aux != null){
            empleados.remove(aux);
        }

    }


}