public class CafeteraDriver {
    public static void main(String[] args) {
        //Cafetera 1
        Cafetera maquina=new Cafetera();
        maquina.revisarRecursos();
        maquina.encender();
        maquina.prepararAmericano(13);
        maquina.prepararExpreso(11);
        maquina.prepararCapuchino(9);
        maquina.prepararExpreso(5);
        maquina.prepararCapuchino(2);
        maquina.rellenarTodo();
        maquina.revisarRecursos();

        //Cafetera 2
        Cafetera cafe=new Cafetera(2000,700,1500,30,false);
        cafe.prepararExpreso(2);
        cafe.encender();
        cafe.prepararCapuchino(0);
        cafe.prepararExpreso(18);
        cafe.rellenarTodo();
        cafe.prepararAmericano(20);
        cafe.prepararCapuchino(20);
        System.out.println(cafe.rellenar());
        cafe.apagar();
    }
}
