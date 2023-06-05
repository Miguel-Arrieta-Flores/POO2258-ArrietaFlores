package org.example.modelo;

import org.example.persistencia.ComicDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaComic implements TableModel {
    public static final int COLUMNS=6;
    private ArrayList<Comic> datos;
    private ComicDAO cdao;

    public ModeloTablaComic() {
        cdao =new ComicDAO();
        datos=new ArrayList<>();
    }

    public ModeloTablaComic(ArrayList<Comic> datos) {
        this.datos = datos;
        cdao =new ComicDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "Id";
            case 1:
                return "Título";
            case 2:
                return "Guionista";
            case 3:
                return "Ilustrador";
            case 4:
                return "Editorial";
            case 5:
                return "Imagen";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Comic tmp=datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getTitulo();
            case 2:
                return tmp.getGuionista();
            case 3:
                return tmp.getIlustrador();
            case 4:
                return tmp.getEditorial();
            case 5:
                return tmp.getImagen();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int colIndex) {
        switch (colIndex){
            case 0:
                //datos.get(rowIndex).setId(0);
                break;
            case 1:
                datos.get(rowIndex).setTitulo((String) o);
                break;
            case 2:
                datos.get(rowIndex).setGuionista((String) o);
                break;
            case 3:
                datos.get(rowIndex).setIlustrador((String) o);
                break;
            case 4:
                datos.get(rowIndex).setEditorial((String) o);
                break;
            case 5:
                datos.get(rowIndex).setImagen((String) o);
                break;
            default:
                System.out.println("No se modifica nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos(){
        try {
            ArrayList<Comic> tirar= cdao.obtenerTodo();
            System.out.println(tirar);
            datos= cdao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarComic(Comic comic){
        boolean resultado=false;
        try {
            if(cdao.insertar(comic)){
                datos.add(comic);
                resultado=true;
            }else {
                resultado=false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

        return resultado;
    }

    public boolean modificarComic(Comic comic,int index){
        boolean resultado=false;
        try {
            if(cdao.update(comic)){
                datos.remove(index);
                datos.add(index,comic);
                resultado=true;
            }else {
                resultado=false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

        return resultado;
    }

    public boolean eliminarComic(Comic comic,int index){
        boolean resultado=false;
        try {
            if(cdao.delete(Integer.toString(comic.getId()))){
                datos.remove(index);
                resultado=true;
            }else {
                resultado=false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

        return resultado;
    }

    public Comic getComicAtIndex(int idx){
        return datos.get(idx);
    }
}
