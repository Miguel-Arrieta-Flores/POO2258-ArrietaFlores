import java.util.Scanner;

public class Cafetera {
    //Atributos
    private int depositoAgua;
    private int depositoCafe;
    private int depositoCrema;
    private int cantidadVasos;
    private boolean encendido;

    //Métodos Constructores
    public Cafetera() {   //Con los parametros predeterminados
        depositoAgua=5000;
        depositoCafe=1000;
        depositoCrema=1500;
        cantidadVasos=50;
        encendido=false;
    }

    public Cafetera(int depositoAgua, int depositoCafe, int depositoCrema, int cantidadVasos, boolean encendido) {
        this.depositoAgua = depositoAgua;
        this.depositoCafe = depositoCafe;
        this.depositoCrema = depositoCrema;
        this.cantidadVasos = cantidadVasos;
        this.encendido = encendido;
    }

    //Métodos de acceso
    public int getDepositoAgua() {
        return depositoAgua;
    }

    public void setDepositoAgua(int depositoAgua) {
        if (depositoAgua<=5000 && depositoAgua<=0) {
            this.depositoAgua = depositoAgua;
        }
        else {
            System.out.println("Cantidad no permitida");
        }
    }

    public int getDepositoCafe() {
        return depositoCafe;
    }

    public void setDepositoCafe(int depositoCafe) {
        if (depositoCafe<=1000 && depositoCafe<=0) {
            this.depositoCafe = depositoCafe;
        }
        else {
            System.out.println("Cantidad no permitida");
        }
    }

    public int getDepositoCrema() {
        return depositoCrema;
    }

    public void setDepositoCrema(int depositoCrema) {
        if (depositoCrema<=1500 && depositoCrema<=0) {
            this.depositoCrema = depositoCrema;
        }
        else {
            System.out.println("Cantidad no permitida");
        }
    }

    public int getCantidadVasos() {
        return cantidadVasos;
    }

    public void setCantidadVasos(int cantidadVasos) {
        if (cantidadVasos<=50 && cantidadVasos<=0) {
            this.cantidadVasos = cantidadVasos;
        } else {
            System.out.println("Cantidad no permitida");
        }
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    @Override
    public String toString() {
        return "Cafetera{" +
                "depositoAgua=" + depositoAgua +
                ", depositoCafe=" + depositoCafe +
                ", depositoCrema=" + depositoCrema +
                ", cantidadVasos=" + cantidadVasos +
                '}';
    }

    //Encender la cafetera
    public boolean encender(){
        System.out.println("Encendiendo la cafetera...");
        return encendido=true;
    }
    //Apagar la cafetera
    public boolean apagar(){
        System.out.println("Apagando cafetera...");
        return encendido=false;
    }

    //Rellena todos los dépositos al máximo
    public void rellenarTodo() {
        depositoAgua=5000;
        depositoCafe=1000;
        depositoCrema=1500;
        cantidadVasos=50;
        System.out.println("Recursos llenados al máximo");
    }

    //Rellena el deposito que seleccione el usuario
    public String rellenar(){
        System.out.println("¿Qué deposito quieres rellenar? \n1.Agua 2.Café 3.Crema 4.Vasos");
        Scanner teclado= new Scanner(System.in);
        int eleccion= Integer.parseInt(teclado.nextLine());
        switch (eleccion){
            case 1:
                depositoAgua=5000;
                return "Relleno de agua exitoso";

            case 2:
                depositoCafe=1000;
                return "Relleno de café exitoso";

            case 3:
                depositoCrema=1500;
                return "Relleno de crema exitoso";
            
            case 4:
                cantidadVasos=50;
                return "Relleno de vasos exitoso";

            case default:
                return "Error. Opción no permitida";
        }
    }

    //Deja todos lo depositos al mínimo
    public void vaciarRecursos(){
        depositoAgua=0;
        depositoCafe=0;
        depositoCrema=0;
        cantidadVasos=0;
    }

    //Te dice la cantidad que contienen los depositos en este momento
    public void revisarRecursos(){
        System.out.println("La cafetera tiene ahora mismo:");
        System.out.println(depositoAgua+" ml de agua, "+depositoCafe+" g de café, "+depositoCrema+" ml de crema y "+cantidadVasos+" vasos");
    }

    //Te dice si aún se puede preparar café
    public void evaluarRecursos(){
        if (depositoAgua<100 || depositoCrema<70 || depositoCafe<14 || cantidadVasos==0){
            System.out.println("No se puede preparar más café");
            revisarRecursos();
        }
        else {
            System.out.println("Aún se puede preparar más café");
        }
    }

    //Prepara Café americano con respecto a la cantidad de cafés que ingreses
    public void prepararAmericano(int cantidad){
        if (encendido==true) {
            if (depositoAgua>=150 && depositoCafe>=15 && cantidadVasos>0){
                boolean capacidad = true;
                for (int i = 0; i < cantidad; i++) {
                    if(depositoAgua>=150 && depositoCafe>=15 && cantidadVasos>0){
                        depositoAgua-=150;
                        depositoCafe-=15;
                        cantidadVasos-=1;
                    }
                    else {
                        //Ya que la cantidad que ingresó no se pude realizar, le pregunta si se le prepara solo máximo posible
                        System.out.println("No hay recursos suficientes para " + cantidad + " cafés");
                        System.out.println("Solo alcanza para " + i + " Cafés Americanos");
                        System.out.println("¿Los quiere? s/n");
                        Scanner sc = new Scanner(System.in);
                        char res = sc.next().charAt(0);
                        if (res != 'n') {
                            System.out.println("Ya están tus " + i + " Cafés Americanos");
                            evaluarRecursos();
                        }
                        i = cantidad;
                        capacidad = false;
                    }
                }
                if (cantidad==1){
                    System.out.println("Ya está tu Americanos");
                    evaluarRecursos();
                }
                else if(cantidad<1) {
                    System.out.println("Seleccionó 0 Americanos");
                    evaluarRecursos();
                }
                else if (capacidad == true) {
                    System.out.println("Ya están tus " + cantidad + " Americanos");
                    evaluarRecursos();
                }
            }
            else {
                System.out.println("No hay recursos suficientes");
                revisarRecursos();
            }
        }
        else {
            System.out.println("Tienes que encender primero la cafetera");
        }
    }

    //Prepara Café expreso con respecto a la cantidad de cafés que ingreses
    public void prepararExpreso(int cantidad){
        if (encendido==true) {
            if (depositoAgua >= 120 && depositoCafe >= 20 && cantidadVasos > 0) {
                boolean capacidad = true;
                for (int i = 0; i < cantidad; i++) {
                    if (depositoAgua >= 120 && depositoCafe >= 20 && cantidadVasos > 0) {
                        depositoAgua -= 120;
                        depositoCafe -= 20;
                        cantidadVasos -= 1;
                    }
                    else {
                        //Ya que la cantidad que ingresó no se pude realizar, le pregunta si se le prepara solo máximo posible
                        System.out.println("No hay recursos suficientes para " + cantidad + " cafés");
                        System.out.println("Solo alcanza para " + i + " Cafés Expresos");
                        System.out.println("¿Los quiere? s/n");
                        Scanner sc = new Scanner(System.in);
                        char res = sc.next().charAt(0);
                        if (res != 'n') {
                            System.out.println("Ya están tus " + i + " Cafés Expresos");
                            evaluarRecursos();
                        }
                        i = cantidad;
                        capacidad = false;
                    }
                }
                if (cantidad == 1) {
                    System.out.println("Ya está tu Expreso");
                    evaluarRecursos();
                }
                else if (cantidad < 1) {
                    System.out.println("Seleccionó 0 Expresos");
                    evaluarRecursos();
                }
                else if (capacidad == true) {
                    System.out.println("Ya están tus " + cantidad + " Expresos");
                    evaluarRecursos();
                }
            }
            else {
                System.out.println("No hay recursos suficientes");
                revisarRecursos();
            }
        }
        else {
            System.out.println("Tienes que encender primero la cafetera");
        }
    }

    //Prepara Café capuchino con respecto a la cantidad de cafés que ingreses
    public void prepararCapuchino(int cantidad){
        if (encendido==true) {
            if (depositoAgua>=100 && depositoCafe>=14 && depositoCrema>=70 && cantidadVasos>0) {
                boolean capacidad = true;
                for (int i = 0; i < cantidad; i++) {
                    if (depositoAgua>=100 && depositoCafe>=14 && depositoCrema>=70 && cantidadVasos>0) {
                        depositoAgua-=100;
                        depositoCafe-=14;
                        depositoCrema-=70;
                        cantidadVasos-=1;
                    }
                    else {
                        //Ya que la cantidad que ingresó no se pude realizar, le pregunta si se le prepara solo máximo posible
                        System.out.println("No hay recursos suficientes para " + cantidad + " cafés");
                        System.out.println("Solo alcanza para " + i + " Cafés Capuchinos");
                        System.out.println("¿Los quiere? s/n");
                        Scanner sc = new Scanner(System.in);
                        char res = sc.next().charAt(0);
                        if (res != 'n') {
                            System.out.println("Ya están tus " + i + " Cafés Capuchinos");
                            evaluarRecursos();
                        }
                        i = cantidad;
                        capacidad = false;
                    }
                }
                if (cantidad==1){
                    System.out.println("Ya está tu Capuchino");
                    evaluarRecursos();
                }
                else if(cantidad<1){
                    System.out.println("Seleccionó 0 Capuchinos");
                    evaluarRecursos();
                }
                else if (capacidad == true) {
                    System.out.println("Ya están tus " + cantidad + " Capuchinos");
                    evaluarRecursos();
                }
            }
            else {
                System.out.println("No hay recursos suficientes");
                revisarRecursos();
            }
        }
        else {
            System.out.println("Tienes que encender primero la cafetera");
        }
    }
}