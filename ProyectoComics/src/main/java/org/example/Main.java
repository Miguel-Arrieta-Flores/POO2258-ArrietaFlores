package org.example;

import org.example.controlador.ControladorComic;
import org.example.vista.VentanaComic;

public class Main {
    public static void main(String[] args) {
        VentanaComic view=new VentanaComic("Proyecto");
        ControladorComic controller=new ControladorComic(view);
    }
}