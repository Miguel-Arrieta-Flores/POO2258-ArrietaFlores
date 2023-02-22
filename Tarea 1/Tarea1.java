import java.lang.String;
import java.util.Scanner;

public class Tarea1{
    public static void main (String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Escribe tu nombre, profesión y país de origen: ");
        String entrada = teclado.nextLine();
        String[] separado=entrada.toUpperCase().split(" ");

        System.out.println("Nombre: " + separado[0]);
        System.out.println("Profesión: " + separado[1]);
        System.out.println("País: " + separado[2]); 

    }
}
//Hay un problema UTF-8 y no pude resolverlo