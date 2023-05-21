package org.example;

import org.example.controlador.ControladorLibro;
import org.example.vista.VentanaLibro;

public class Main {
    public static void main(String[] args) {
        VentanaLibro view=new VentanaLibro("MVC y JDBC");
        ControladorLibro controladorLibro=new ControladorLibro(view);
    }
}