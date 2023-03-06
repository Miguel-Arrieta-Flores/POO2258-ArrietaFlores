import java.awt.*;
import java.util.Scanner;

public class Gato {
    //Atributos
    private Color color;
    private String nombre;
    private Color colorOjos;
    private String genero;
    private String edad;

    //Metodo constructor
    public Gato(String nombre, Color color,String genero, String edad, Color colorOjos) {
        this.nombre = nombre;
        this.color=color;
        this.genero=genero;
        this.edad=edad;
        this.colorOjos=colorOjos;
    }

    //Metodos de uso general
    public boolean maullar() {
        return true;
    }

    public boolean dormir() {
        System.out.println(nombre+" se esta durmiendo...");
        boolean dormir=Math.random()>0.51;
        return dormir;
    }

    public String comer() {
        System.out.println("Ingresa qué comió: ");
        Scanner sc = new Scanner(System.in);
        String comida=sc.nextLine();
        String resultado=(nombre + " comió " + comida);
        return resultado;
    }

    //Metodos de acceso
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(Color colorOjos) {
        this.colorOjos = colorOjos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //Metodo toString
    public String toString() {
        return "Gato{" +
                "nombre='" + nombre +
                ", color=" + color + '\''  +
                ", genero='" + genero + '\'' +
                ", edad=" + edad +
                ", color de ojos=" + colorOjos +
                '}';
    }
}
