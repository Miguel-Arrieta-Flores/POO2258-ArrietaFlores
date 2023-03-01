import java.util.Scanner;
import java.lang.String;

public class Tarea3 {
    public static void main(String[] args) {

        char seguir;
        Scanner teclado = new Scanner(System.in);

        do
        {   
            System.out.println("\nSolo se permiten los siguientes carácteres [X,O,_] y tienen que ser 9 caracteres");
            System.out.println("Introduce la cadena: ");
            String input=teclado.nextLine();
            boolean valido = true;
            String v1=input;

            if(input.length() != 9){
                System.out.println("Tienen que ser 9 caracteres");
                input="000000000";
            }
    
            String ren1=input.substring(0, 3); //Renglones
            String ren2=input.substring(3, 6);
            String ren3=input.substring(6, 9);
               
            input = input.replaceAll("[^X^O]", "");  //Evaluación
            if(!input.substring(0).matches("_")){
                valido = true;
            }
                
            if(!input.substring(0).matches("")){
                valido = true;
            }
            else{
                valido = false;
            }

            //Construcción del Gato
            if (valido==true) {
                for (int i = 0; i < 5; i++) {
                    switch (i) {
                        case 0:
                            System.out.println("-----");
                            break;
                        case 1:
                            System.out.println("|"+ren1+"|");
                            break;
                                
                        case 2:
                            System.out.println("|"+ren2+"|");
                            break;
                        case 3:
                            System.out.println("|"+ren3+"|");
                            break;
                        case 4:
                            System.out.println("-----");
                            break;
        
                        default:
                            break;
                    }
                }       
            }
            
            if (v1.length()==9 && valido==false){
                System.out.println("La cadena tiene carácteres no permitidos");      
            }
                
            System.out.printf("¿Desea hacerlo otra vez (S/N)?: ");
            seguir = teclado.next().charAt(0);
            teclado.nextLine();

            //Vaciar variables
            input=null;
            ren1=null;
            ren2=null;
            ren3=null; 
            
        }
        while(seguir!='N');

        System.out.printf("Terminado");
        teclado.close();
    }
}