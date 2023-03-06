import java.awt.Color;

public class Maingato{
    public static void main(String[] args) {
        Gato gato1=new Gato("Michi", Color.BLACK, "Hembra", "5", Color.gray);
        Gato gato2=new Gato("Copito", Color.orange, "Macho", "7", Color.yellow);
        System.out.println(gato1.toString());
        System.out.println(gato2.toString());
        System.out.println(gato1.dormir());
        System.out.println(gato2.comer());
    }
}