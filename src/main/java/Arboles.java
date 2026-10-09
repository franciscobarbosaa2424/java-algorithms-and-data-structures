class Nodo{
    int valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int item){
        valor = item;
        izquierdo = derecho = null;
    }
}

class ArbolBinario{
    Nodo raiz;

    ArbolBinario(){
        raiz = null;
    }

    void enOrden(Nodo nodo){
        if(nodo != null){
            enOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            enOrden(nodo.derecho);
        }
    }
}

class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda(){
        raiz= null;
    }

    public void insertar(int valor){
        raiz = insertarRecursivo(raiz,valor);
    }

    private Nodo insertarRecursivo(Nodo raiz, int valor){
        if(raiz == null){
            raiz = new Nodo(valor);
            return raiz;
        }

        if(valor < raiz.valor){
            raiz.izquierdo = insertarRecursivo(raiz.izquierdo,valor);
        } else if (valor > raiz.valor){
            raiz.derecho = insertarRecursivo(raiz.derecho, valor);
        }

        return raiz;
    }

    public void inOrder(Nodo nodo){
        if(nodo != null){
            inOrder(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrder(nodo.derecho);
        }
    }
}


void main() {
    ArbolBinario arbol = new ArbolBinario();
    arbol.raiz = new Nodo(1);
    arbol.raiz.izquierdo = new Nodo(2);
    arbol.raiz.derecho = new Nodo(3);
    arbol.raiz.izquierdo.izquierdo = new Nodo(4);
    arbol.raiz.derecho.derecho = new Nodo(5);

    System.out.println("Recorrido en orden del àrbol binario:");
    arbol.enOrden(arbol.raiz);
    System.out.println();

    ArbolBinarioBusqueda arbolb = new ArbolBinarioBusqueda();
    arbolb.insertar(50);
    arbolb.insertar(30);
    arbolb.insertar(70);
    arbolb.insertar(20);
    arbolb.insertar(40);
    arbolb.insertar(60);
    arbolb.insertar(80);

    System.out.println("Recorrido en orden:");
    arbolb.inOrder(arbolb.raiz);
}