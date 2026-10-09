package org.example.PrevaluacionPresencial;

interface Documento {
    void mostrar();
}

class DocumentoReal implements Documento {
    private String nombre;

    public DocumentoReal(String nombre) {
        this.nombre = nombre;
        cargarDocumento();
    }

    private void cargarDocumento() {
        System.out.println("Cargando documento: " + nombre);
    }

    @Override
    public void mostrar() {
        System.out.println("Mostrando contenido de: " + nombre);
    }
}

class ProxyDocumento implements Documento {
    private String nombre;
    private String rol;
    private DocumentoReal documentoReal;

    public ProxyDocumento(String nombre, String rol) {
        // 1. Guardá el nombre recibido en el atributo nombre.
        // 2. Guardá el rol recibido en el atributo rol.
        // Usá "this." para distinguir atributos y parámetros.
        this.nombre = nombre;
        this.rol = rol;
        // No crees un DocumentoReal aquí.
        // El atributo documentoReal ya comienza en null.
    }

    @Override
    public void mostrar() {
        // 1. Comprobá si el rol es DOCENTE o ADMINISTRADOR.
        //    Usá equalsIgnoreCase() y uní las comparaciones con ||.
        //    Podés guardar el resultado en un boolean.
        boolean esPermitido = rol.equalsIgnoreCase("docente") || rol.equalsIgnoreCase("administrador");
        //    Pista: invocá equalsIgnoreCase(rol) sobre cada texto
        //    permitido. Así también evitás un error si rol es null.

        // 2. Organizá el acceso con un if y un else:
        //    - if: el rol tiene permiso.
        //    - else: el rol no tiene permiso.
        if(esPermitido){


            // 3. Dentro del caso autorizado:
            //    Comprobá con otro if si documentoReal es null.
            //    Si lo es, creá un DocumentoReal usando el nombre
            //    guardado y asignalo al atributo documentoReal.
            if(documentoReal == null){
                documentoReal = new DocumentoReal(nombre);
            }
            documentoReal.mostrar();
        }else{
            System.out.println("Acceso denegado para el rol: "+rol);
        }
        // 4. Después de ese if interno, pero todavía dentro
        //    del caso autorizado, invocá mostrar() del documentoReal.
        //
        //    Esa llamada debe ejecutarse en cada acceso autorizado,
        //    no solamente cuando se crea el documento.

        // 5. En el else del control de permisos, mostrá:
        //    Acceso denegado para el rol: [rol]
        //    Reemplazá [rol] por el valor recibido, sin corchetes.
        //
        //    En este caso no debés crear ni mostrar el documento.
    }
}
