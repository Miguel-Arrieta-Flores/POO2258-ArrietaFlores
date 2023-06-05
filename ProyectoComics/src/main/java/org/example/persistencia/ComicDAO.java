package org.example.persistencia;

import org.example.modelo.Comic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ComicDAO implements InterfazDAO {

    public ComicDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert="INSERT INTO comics(titulo, guionista, ilustrador, editorial, 'imagen(url)') VALUES(?, ?, ?, ?, ?)";
        int rowCount=0;
        PreparedStatement pstm=ConexionSingleton.getInstance("comics.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((Comic)obj).getTitulo());
        pstm.setString(2,((Comic)obj).getGuionista());
        pstm.setString(3,((Comic)obj).getIlustrador());
        pstm.setString(4,((Comic)obj).getEditorial());
        pstm.setString(5,((Comic)obj).getImagen());
        rowCount=pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate="UPDATE comics SET titulo=?, guionista=?, ilustrador=?, editorial=?, 'imagen(url)'=? WHERE id=?;";
        int rowCount=0;
        PreparedStatement pstm=ConexionSingleton.getInstance("comics.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((Comic)obj).getTitulo());
        pstm.setString(2,((Comic)obj).getGuionista());
        pstm.setString(3,((Comic)obj).getIlustrador());
        pstm.setString(4,((Comic)obj).getEditorial());
        pstm.setString(5,((Comic)obj).getImagen());
        pstm.setInt(6,((Comic)obj).getId());
        rowCount=pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete="DELETE FROM comics WHERE id=?;";
        int rowCount=0;
        PreparedStatement pstm=ConexionSingleton.getInstance("comics.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount=pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql="SELECT * FROM comics";
        ArrayList<Comic> resultado=new ArrayList<>();

        Statement stm=ConexionSingleton.getInstance("comics.db").getConnection().createStatement();
        ResultSet rst=stm.executeQuery(sql);
        while (rst.next()) {
            resultado.add(new Comic(rst.getInt(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql="SELECT * FROM comics WHERE id=?;";
        Comic comic =null;
        PreparedStatement pstm=ConexionSingleton.getInstance("comics.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        ResultSet rst=pstm.executeQuery();
        if (rst.next()) {
            comic = new Comic(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5),rst.getString(6));
            return comic;
        }
        return null;
    }

    public ArrayList<Integer> obtenerId() throws SQLException{
        String sql="SELECT id FROM comics";
        ArrayList<Integer> resultado=new ArrayList<>();

        Statement stm=ConexionSingleton.getInstance("comics.db").getConnection().createStatement();
        ResultSet rst=stm.executeQuery(sql);
        while (rst.next()) {
            resultado.add(rst.getInt(1));
        }
        return resultado;
    }
}
