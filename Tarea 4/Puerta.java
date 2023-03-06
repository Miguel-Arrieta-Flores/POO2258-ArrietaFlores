import java.awt.*;

public class Puerta {
    //Atributos
    private String material;
    private Color color;
    private String altoPuerta;
    private String anchoPuerta;
    private String marcaChapa;

    //Metodo constructor
    public Puerta(String material, Color color, String altoPuerta, String anchoPuerta, String marcaChapa) {
        this.material = material;
        this.color=color;
        this.altoPuerta=altoPuerta;
        this.anchoPuerta=anchoPuerta;
        this.marcaChapa=marcaChapa;
    }

    //Metodos de uso general
    public boolean abrir(){
        return true;
    }
    public boolean rechinar() {
        System.out.println("Va a rechinar...");
        boolean resultado=Math.random()>0.51;
        return resultado;
    }
    public boolean ponerSeguro(){
        return true;
    }


    //Metodos de acceso
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getAltoPuerta() {
        return altoPuerta;
    }

    public void setAltoPuerta(String altoPuerta) {
        this.altoPuerta = altoPuerta;
    }

    public String getAnchoPuerta() {
        return anchoPuerta;
    }

    public void setAnchoPuerta(String anchoPuerta) {
        this.anchoPuerta = anchoPuerta;
    }

    public String getMarcaChapa() {
        return marcaChapa;
    }
    
    public void setMarcaChapa(String marcaChapa) {
        this.marcaChapa = marcaChapa;
    }
    
    //Metodo toString
    public String toString() {
        return "Puerta {" +
                "material='" + material + '\'' +
                ", color=" + color +
                ", alto de puerta='" + altoPuerta + '\'' +
                ", ancho de puerta='" + anchoPuerta + '\'' +
                ", marca de chapa='" + marcaChapa + '\'' +
                '}';
    }
}