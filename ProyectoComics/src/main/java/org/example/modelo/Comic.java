package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Comic {
    private int id;
    private String titulo;
    private String guionista;
    private String ilustrador;
    private String editorial;
    private String imagen;

    public Comic() {
    }

    public Comic(int id, String titulo, String guionista, String ilustrador, String editorial, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.guionista = guionista;
        this.ilustrador = ilustrador;
        this.editorial = editorial;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGuionista() {
        return guionista;
    }

    public void setGuionista(String guionista) {
        this.guionista = guionista;
    }

    public String getIlustrador() {
        return ilustrador;
    }

    public void setIlustrador(String ilustrador) {
        this.ilustrador = ilustrador;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", guionista='" + guionista + '\'' +
                ", ilustrador='" + ilustrador + '\'' +
                ", editorial='" + editorial + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

    public ImageIcon obtenerFoto(){
        try{
            URL urlImagen=new URL(this.imagen);
            return new ImageIcon(urlImagen);
        }catch (MalformedURLException mfue){
            return null;
        }
    }
}
