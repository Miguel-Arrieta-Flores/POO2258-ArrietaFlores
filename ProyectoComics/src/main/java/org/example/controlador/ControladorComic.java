package org.example.controlador;

import org.example.modelo.Comic;
import org.example.modelo.ModeloComboId;
import org.example.modelo.ModeloTablaComic;
import org.example.vista.VentanaComic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorComic extends MouseAdapter implements ActionListener {

    private VentanaComic view;
    private ModeloTablaComic modelo;
    private ModeloComboId combo;

    private ImageIcon icono=new ImageIcon("estrella.png");

    public ControladorComic(VentanaComic view) {
        this.view = view;
        this.view.getComboId().addActionListener(this);
        this.view.getTblComic().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
        this.view.getBtnModificar().addMouseListener(this);
        combo=new ModeloComboId();
        modelo=new ModeloTablaComic();
        this.view.getTblComic().setModel(modelo);
        this.view.getComboId().setModel(combo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ComboBox
        if (e.getSource()==view.getComboId()){
            int index = this.view.getComboId().getSelectedIndex();
            Comic cm = modelo.getComicAtIndex(index);
            this.view.getMdfId().setText(Integer.toString(cm.getId()));
            this.view.getMdfTitulo().setText(cm.getTitulo());
            this.view.getMdfGuionista().setText(cm.getGuionista());
            this.view.getMdfIlustrador().setText(cm.getIlustrador());
            this.view.getMdfEditorial().setText(cm.getEditorial());
            this.view.getMdfImagen().setText(cm.getImagen());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Boton Cargar
        if (e.getSource()==this.view.getBtnCargar()){
            modelo.cargarDatos();
            combo.cargar();
            this.view.getTblComic().setModel(modelo);
            this.view.getTblComic().updateUI();
        }else{
            System.out.println("Error");
        }

        //Boton Agregar
        if (e.getSource()==this.view.getBtnAgregar()){
            Comic comic =new Comic();
            comic.setId(0);
            comic.setTitulo(this.view.getTxtTitulo().getText());
            comic.setGuionista(this.view.getTxtGuionista().getText());
            comic.setIlustrador(this.view.getTxtIlustrador().getText());
            comic.setEditorial(this.view.getTxtEditorial().getText());
            comic.setImagen(this.view.getTxtImagen().getText());
            if (modelo.agregarComic(comic)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE,icono);
                this.view.getTblComic().updateUI();
                combo.agregarId(comic.getId());
            }else{
                JOptionPane.showMessageDialog(view,
                        "No se pudo agregar a la base de datos. Por favor revise su conexión",
                        "Error al insertar",
                        JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiarPanel1();
        }

        //Boton Modificar
        if (e.getSource()==view.getBtnModificar()){
            Comic comic=new Comic();
            comic.setId(Integer.parseInt(this.view.getMdfId().getText()));
            comic.setTitulo(this.view.getMdfTitulo().getText());
            comic.setGuionista(this.view.getMdfGuionista().getText());
            comic.setIlustrador(this.view.getMdfIlustrador().getText());
            comic.setEditorial(this.view.getMdfEditorial().getText());
            comic.setImagen(this.view.getMdfImagen().getText());
            int index=this.view.getComboId().getSelectedIndex();
            int respuesta=JOptionPane.showConfirmDialog(view,"¿Estás seguro de modificar el registro?",
                    "Confirmación",JOptionPane.YES_NO_OPTION);
            if (respuesta==JOptionPane.YES_OPTION){
                if (modelo.modificarComic(comic,index)){
                    JOptionPane.showMessageDialog(view,"Se modificó correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE,icono);
                    this.view.getTblComic().updateUI();
                }else{
                    JOptionPane.showMessageDialog(view,
                            "No se pudo modificar en la base de datos. Por favor revise su conexión",
                            "Error al modificar",
                            JOptionPane.ERROR_MESSAGE);
                }
            }else {
                System.out.println("No se va a modificar");
            }
        }

        //Boton Eliminar
        if (e.getSource()==view.getBtnEliminar()){
            Comic comic=new Comic();
            comic.setId(Integer.parseInt(this.view.getMdfId().getText()));
            int index=this.view.getComboId().getSelectedIndex();

            int respuesta=JOptionPane.showConfirmDialog(view,"¿Estás seguro de eliminar el registro?",
                    "Confirmación",JOptionPane.YES_NO_OPTION);
            if (respuesta==JOptionPane.YES_OPTION){
                if (modelo.eliminarComic(comic,index)){
                    JOptionPane.showMessageDialog(view,"Se eliminó correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE,icono);
                    this.view.getTblComic().updateUI();
                    combo.eliminarId(index);
                }else{
                    JOptionPane.showMessageDialog(view,
                            "No se pudo eliminar en la base de datos. Por favor revise su conexión",
                            "Error al eliminar",
                            JOptionPane.ERROR_MESSAGE);
                }
                this.view.limpiarPanel4();
            }else {
                System.out.println("No se va a eliminar");
            }
        }

        //Tabla
        if (e.getSource()==view.getTblComic()){
            System.out.println("Evento en la tabla");
            int index=this.view.getTblComic().getSelectedRow();
            combo.setSelectedItem(modelo.getValueAt(index,0));
            this.view.getComboId().updateUI();
            Comic tmp=modelo.getComicAtIndex(index);
            //Colocar datos en el panel 4
            this.view.getMdfId().setText(Integer.toString(tmp.getId()));
            this.view.getMdfTitulo().setText(tmp.getTitulo());
            this.view.getMdfGuionista().setText(tmp.getGuionista());
            this.view.getMdfIlustrador().setText(tmp.getIlustrador());
            this.view.getMdfEditorial().setText(tmp.getEditorial());
            this.view.getMdfImagen().setText(tmp.getImagen());
            //Mostrar imagen en el panel 3
            this.view.getImagenComic().setIcon(tmp.obtenerFoto());
            if (tmp.obtenerFoto()!=null){
                this.view.getImagenComic().setText("");
            }else {
                this.view.getImagenComic().setText("No se pudo encontrar la imagen");
            }
        }
    }
}
