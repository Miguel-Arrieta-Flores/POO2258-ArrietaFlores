import java.awt.Color;

public class Mainpuerta{
    public static void main(String[] args) {
        Puerta puerta1= new Puerta("Madera", Color.BLACK, "213cm", "90cm", "Phillips");
        Puerta puerta2= new Puerta("Acero", Color.WHITE, "210cm", "85cm", "Dexter");
        System.out.println(puerta1.toString());
        System.out.println(puerta2.toString());
        System.out.println(puerta1.rechinar());
    }
}