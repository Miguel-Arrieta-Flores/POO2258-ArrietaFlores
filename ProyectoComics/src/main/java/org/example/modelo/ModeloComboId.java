package org.example.modelo;

import org.example.persistencia.ComicDAO;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloComboId implements ComboBoxModel {
    ArrayList<Integer> info;
    int selected;
    private ComicDAO cd;

    public ModeloComboId() {
        cd = new ComicDAO();
        info = new ArrayList<>();
        info.add(10);
    }

    public ModeloComboId(ArrayList<Integer> info) {
        this.info = info;
    }

    @Override
    public void setSelectedItem(Object o) {
        this.selected = (int) o;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return info.size();
    }

    @Override
    public Object getElementAt(int index) {
        return info.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    public void cargar(){
        try {
            info=cd.obtenerId();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    public void agregarId (int id){
        info.add(id);
    }
    public void eliminarId(int index){
        info.remove(index);
    }
}
