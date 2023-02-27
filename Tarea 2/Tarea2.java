import java.lang.String;
import java.util.Scanner;

public class Tarea2 {
    public static void main(String[] args) {

        int eva1=0;
        int eva2=0;
        int j=0;
        boolean resultado=true;
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un texto: ");
        String input = teclado.nextLine();
        Integer[] frase= new Integer[input.length()];

        for (int i = 0; i < input.length(); i++) {
            frase[i]=(int) input.charAt(i);

            if (i==0) {
                j=0;
            }   
            else{
                j=i-1;  
                eva1=frase[i];
                eva2=frase[j]+1; 

                if (eva1==eva2) {
                    resultado=true;
                } 
                else {
                    i=input.length();
                    resultado=false; 
                }
            }    
        }

        if (resultado==true) {        
            System.out.println("True");
        }                 
        else {
            System.out.println("False");
        }   
          
    }
}
