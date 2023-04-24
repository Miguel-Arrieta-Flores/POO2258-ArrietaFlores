public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cuadrado cuadrado=new Cuadrado();
        cuadrado.setLado(5);
        System.out.println("Area="+cuadrado.calcularArea());
        Circulo circulo=new Circulo();
        circulo.setRadio(2.4);
        System.out.println("Área del círculo: "+circulo.calcularArea());
        AlumnoDeportistaArtista ada =new AlumnoDeportistaArtista();
        ada.setNombre("Juan");
        ada.setArte("Pintura");
        ada.setDeporte("Basket ball");
        System.out.println(ada);
        ada.ensayar("Oleo");
        ada.entrenar();
        ada.presentarCompetencia("Naucalli");
    }
}