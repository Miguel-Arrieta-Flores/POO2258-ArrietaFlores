package org.example.vista;

import org.example.modelo.ModeloComboId;

import javax.swing.*;
import java.awt.*;

public class VentanaComic extends JFrame {
    private JLabel lblId;
    private JLabel lblTitulo;
    private JLabel lblGuionista;
    private JLabel lblIlustrador;
    private JLabel lblEditorial;
    private JLabel lblImagen;
    private JTextField txtId;
    private JTextField txtTitulo;
    private JTextField txtGuionista;
    private JTextField txtIlustrador;
    private JTextField txtEditorial;
    private JTextField txtImagen;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JTable tblComic;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1; //Formulario para capturar comics
    private JPanel panel2; //Tabla para mostrar los comics
    private JPanel panel3; //Muestra la imagen seleccionada
    private JPanel panel4; //Formulario para eliminar o modificar comics
    private JLabel imagenComic;
    private JLabel mdf1;
    private JLabel mdf2;
    private JLabel mdf3;
    private JLabel mdf4;
    private JLabel mdf5;
    private JLabel mdf6;
    private JTextField mdfId;
    private JTextField mdfTitulo;
    private JTextField mdfGuionista;
    private JTextField mdfIlustrador;
    private JTextField mdfEditorial;
    private JTextField mdfImagen;
    private JComboBox comboId;
    private ModeloComboId modeloCombo;

    public VentanaComic(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 800);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        //panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(222, 166, 144));

        lblId = new JLabel("Id: ");
        lblTitulo = new JLabel("Titulo: ");
        lblGuionista = new JLabel("Guionista: ");
        lblIlustrador = new JLabel("Ilustrador: ");
        lblEditorial = new JLabel("Editorial: ");
        lblImagen = new JLabel("Imagen(url): ");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtTitulo = new JTextField(20);
        txtGuionista = new JTextField(15);
        txtIlustrador = new JTextField(15);
        txtEditorial = new JTextField(15);
        txtImagen = new JTextField(30);
        btnAgregar = new JButton("Agregar");

        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblTitulo);
        panel1.add(txtTitulo);
        panel1.add(lblGuionista);
        panel1.add(txtGuionista);
        panel1.add(lblIlustrador);
        panel1.add(txtIlustrador);
        panel1.add(lblEditorial);
        panel1.add(txtEditorial);
        panel1.add(lblImagen);
        panel1.add(txtImagen);
        panel1.add(btnAgregar);

        //panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(168, 222, 138));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblComic = new JTable();
        scrollPane = new JScrollPane(tblComic);
        panel2.add(scrollPane);

        //panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(211, 128, 131));
        imagenComic = new JLabel("...");
        panel3.add(imagenComic);

        //panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(149, 120, 175));
        mdf1 = new JLabel("Id: ");
        mdf2 = new JLabel("Titulo: ");
        mdf3 = new JLabel("Guionista: ");
        mdf4 = new JLabel("Ilustrador: ");
        mdf5 = new JLabel("Editorial: ");
        mdf6 = new JLabel("Imagen(url): ");
        mdfId = new JTextField(3);
        mdfId.setEnabled(false);
        mdfTitulo = new JTextField(20);
        mdfGuionista = new JTextField(15);
        mdfIlustrador = new JTextField(15);
        mdfEditorial = new JTextField(15);
        mdfImagen = new JTextField(30);
        modeloCombo=new ModeloComboId();
        comboId=new JComboBox(modeloCombo);

        btnEliminar = new JButton("Eliminar");
        btnModificar = new JButton("Modificar");

        panel4.add(mdf1);
        //panel4.add(mdfId);
        panel4.add(comboId);
        panel4.add(mdf2);
        panel4.add(mdfTitulo);
        panel4.add(mdf3);
        panel4.add(mdfGuionista);
        panel4.add(mdf4);
        panel4.add(mdfIlustrador);
        panel4.add(mdf5);
        panel4.add(mdfEditorial);
        panel4.add(mdf6);
        panel4.add(mdfImagen);
        panel4.add(btnEliminar);
        panel4.add(btnModificar);

        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JLabel getLblGuionista() {
        return lblGuionista;
    }

    public void setLblGuionista(JLabel lblGuionista) {
        this.lblGuionista = lblGuionista;
    }

    public JLabel getLblIlustrador() {
        return lblIlustrador;
    }

    public void setLblIlustrador(JLabel lblIlustrador) {
        this.lblIlustrador = lblIlustrador;
    }

    public JLabel getLblEditorial() {
        return lblEditorial;
    }

    public void setLblEditorial(JLabel lblEditorial) {
        this.lblEditorial = lblEditorial;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(JTextField txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public JTextField getTxtGuionista() {
        return txtGuionista;
    }

    public void setTxtGuionista(JTextField txtGuionista) {
        this.txtGuionista = txtGuionista;
    }

    public JTextField getTxtIlustrador() {
        return txtIlustrador;
    }

    public void setTxtIlustrador(JTextField txtIlustrador) {
        this.txtIlustrador = txtIlustrador;
    }

    public JTextField getTxtEditorial() {
        return txtEditorial;
    }

    public void setTxtEditorial(JTextField txtEditorial) {
        this.txtEditorial = txtEditorial;
    }

    public JTextField getTxtImagen() {
        return txtImagen;
    }

    public void setTxtImagen(JTextField txtImagen) {
        this.txtImagen = txtImagen;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JTable getTblComic() {
        return tblComic;
    }

    public void setTblComic(JTable tblComic) {
        this.tblComic = tblComic;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getImagenComic() {
        return imagenComic;
    }

    public void setImagenComic(JLabel imagenComic) {
        this.imagenComic = imagenComic;
    }

    public JLabel getMdf1() {
        return mdf1;
    }

    public void setMdf1(JLabel mdf1) {
        this.mdf1 = mdf1;
    }

    public JLabel getMdf2() {
        return mdf2;
    }

    public void setMdf2(JLabel mdf2) {
        this.mdf2 = mdf2;
    }

    public JLabel getMdf3() {
        return mdf3;
    }

    public void setMdf3(JLabel mdf3) {
        this.mdf3 = mdf3;
    }

    public JLabel getMdf4() {
        return mdf4;
    }

    public void setMdf4(JLabel mdf4) {
        this.mdf4 = mdf4;
    }

    public JLabel getMdf5() {
        return mdf5;
    }

    public void setMdf5(JLabel mdf5) {
        this.mdf5 = mdf5;
    }

    public JLabel getMdf6() {
        return mdf6;
    }

    public void setMdf6(JLabel mdf6) {
        this.mdf6 = mdf6;
    }

    public JTextField getMdfId() {
        return mdfId;
    }

    public void setMdfId(JTextField mdfId) {
        this.mdfId = mdfId;
    }

    public JTextField getMdfTitulo() {
        return mdfTitulo;
    }

    public void setMdfTitulo(JTextField mdfTitulo) {
        this.mdfTitulo = mdfTitulo;
    }

    public JTextField getMdfGuionista() {
        return mdfGuionista;
    }

    public void setMdfGuionista(JTextField mdfGuionista) {
        this.mdfGuionista = mdfGuionista;
    }

    public JTextField getMdfIlustrador() {
        return mdfIlustrador;
    }

    public void setMdfIlustrador(JTextField mdfIlustrador) {
        this.mdfIlustrador = mdfIlustrador;
    }

    public JTextField getMdfEditorial() {
        return mdfEditorial;
    }

    public void setMdfEditorial(JTextField mdfEditorial) {
        this.mdfEditorial = mdfEditorial;
    }

    public JTextField getMdfImagen() {
        return mdfImagen;
    }

    public void setMdfImagen(JTextField mdfImagen) {
        this.mdfImagen = mdfImagen;
    }

    public JComboBox getComboId() {
        return comboId;
    }

    public void setComboId(JComboBox comboId) {
        this.comboId = comboId;
    }

    public ModeloComboId getModeloCombo() {
        return modeloCombo;
    }

    public void setModeloCombo(ModeloComboId modeloCombo) {
        this.modeloCombo = modeloCombo;
    }

    public void limpiarPanel1(){
        txtTitulo.setText("");
        txtGuionista.setText("");
        txtIlustrador.setText("");
        txtEditorial.setText("");
        txtImagen.setText("");
    }
    public void limpiarPanel4(){
        mdfId.setText("");
        mdfTitulo.setText("");
        mdfGuionista.setText("");
        mdfIlustrador.setText("");
        mdfEditorial.setText("");
        mdfImagen.setText("");
        imagenComic.setIcon(null);
        comboId.setSelectedItem(null);
    }
}
