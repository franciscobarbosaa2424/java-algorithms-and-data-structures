package org.example.PatronesEstructurales.decorator;

interface Cafe {

    String getDescripcion();

    double getCosto();
}


// Café base
class CafeSimple implements Cafe {

    @Override
    public String getDescripcion() {
        return "Café";
    }

    @Override
    public double getCosto() {
        return 5.0;
    }
}


// Decorador base
abstract class CafeDecorator implements Cafe {

    protected Cafe cafe;

    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion();
    }

    @Override
    public double getCosto() {
        return cafe.getCosto();
    }
}


// Ejemplo de decorador ya implementado
class LecheDecorator extends CafeDecorator {

    public LecheDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + ", Leche";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 1.5;
    }
}


// Decorador de azúcar
class AzucarDecorator extends CafeDecorator {

    public AzucarDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {

        // Agregar "Azúcar" a la descripción actual
        return cafe.getDescripcion()+ ", Azúcar";
    }

    @Override
    public double getCosto() {

        // Agregar 0.5 al costo actual
        return cafe.getCosto() + (double) 0.5;
    }
}


// Decorador de chocolate
class ChocolateDecorator extends CafeDecorator {

    public ChocolateDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {

        // Agregar "Chocolate" a la descripción actual
        return cafe.getDescripcion() + ", Chocolate";
    }

    @Override
    public double getCosto() {

        // Agregar 2.0 al costo actual
        return cafe.getCosto()+ (double) 2.0;
    }
}
