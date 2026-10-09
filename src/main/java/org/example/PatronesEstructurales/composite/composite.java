

/*
El patrón Composite es un patrón estructural que permite crear estructuras de objetos
en forma de árbol para representar jerarquías de "partetodo". Este patrón trata a los objetos individuales
y a las composiciones de objetos de manera uniforme, es decir,
permite que los objetos compuestos de otros objetos se traten como si fueran objetos individuales.

Este patrón es muy útil cuando necesitas trabajar con una estructura que puede contener objetos individuales
(hojas) y también otros objetos compuestos (nodos). El objetivo es que tanto las hojas como los nodos
se manejen de manera uniforme a través de una interfaz común.

Aplicaciones Comunes:
-Sistemas de archivos: Donde los directorios pueden contener archivos u otros directorios.

-Interfaz gráfica de usuario (GUI): Donde los componentes gráficos pueden contener otros componentes.

-Documentos estructurados: Como XML o HTML, donde los elementos pueden contener otros elementos o texto.

Estructura del patron:
-Componente (Component):
Es una interfaz o clase abstracta que declara las operaciones comunes que se deben implementar en hojas
 y nodos compuestos.

-Hoja (Leaf):
Implementa las operaciones declaradas en el componente, representando los objetos individuales
en la estructura.

-Compuesto (Composite):
Implementa las operaciones del componente y tiene la capacidad de contener otros componentes,
ya sean hojas u otros compuestos.

Ventajas:
Simplicidad: Permite tratar objetos individuales y compuestos de manera uniforme.

Flexibilidad: Facilita la adición de nuevos tipos de componentes (hojas o compuestos) sin cambiar el código existente.

Mantenimiento: Mejora la organización del código al manejar las jerarquías de objetos de manera más estructurada.
 */

import java.util.ArrayList;
import java.util.List;

//Componente
interface FileSystemComponent {
    void showDetails();
}

//Hoja: Representa un archivo
class File implements FileSystemComponent{
    private String name;

    public File(String name){
        this.name = name;
    }

    @Override
    public void showDetails(){
        System.out.println("File: "+name);
    }
}

//Compuesto: Representa una carpeta que puede contener archivos y otras carpetas
class Directory implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name){
        this.name = name;
    }

    public void addComponent(FileSystemComponent component){
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component){
        components.remove(component);
    }

    @Override
    public void showDetails(){
        System.out.println("Directory: "+ name);
        for(FileSystemComponent component : components){
            component.showDetails();
        }
    }

}

void main() {
      File file1 = new File("Document1.txt");
      File file2 = new File("Image1.png");
      File file3 = new File("Video1.mp4");

      Directory directory1 = new Directory("Documents");
      Directory directory2 = new Directory("Media");
      Directory rootDirectory = new Directory("Root");

      directory1.addComponent(file1);
      directory2.addComponent(file2);
      directory2.addComponent(file3);
      rootDirectory.addComponent(directory1);
      rootDirectory.addComponent(directory2);
}