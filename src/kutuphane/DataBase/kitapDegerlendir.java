/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Sami
 */
public class kitapDegerlendir {
    
    private siralamaManager sortManager;
     public kitapDegerlendir(siralamaManager sortManager) {
        this.sortManager = sortManager;
    }
      public kitapDegerlendir() {
        
    }
    
     public DefaultListModel<Degerlendir> getSortedDegerlendirmeBooks() throws SQLException {
        DefaultListModel<Degerlendir> listModel = getDegerlendirmeBooks();
        return sortManager.sirala(listModel);
    }
     
    public DefaultListModel<Degerlendir> getDegerlendirmeBooks() throws SQLException {
        DatabaseManager helper = new DatabaseManager();
        Connection connection = helper.getConnection();
        DefaultListModel<Degerlendir> listModel = new DefaultListModel<>();
        PreparedStatement ps = connection.prepareStatement("select kitapadi,degerlendirme,puan,kullaniciadi from degerlendirme");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listModel.addElement(new Degerlendir(
                    rs.getString("kitapadi"),
                    rs.getString("degerlendirme"),
                    rs.getString("puan"),
                    rs.getString("kullaniciadi")));
        }
        return listModel;
    }
    
    public DefaultListModel<Degerlendir> searchDegerlendirme(String keyword) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        DefaultListModel<Degerlendir> listModel = new DefaultListModel<>();

        try {
            connection = helper.getConnection();
            String sql = "SELECT * FROM degerlendirme WHERE UPPER(kitapadi) LIKE ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword.toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listModel.addElement(new Degerlendir(
                        rs.getString("kitapadi"),
                        rs.getString("degerlendirme"),
                        rs.getString("puan"),
                        rs.getString("kullaniciadi")));
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }

        return listModel;
    }
    public void insertDegerlendirme(String kitap_adi, String degerlendirme, String puan, String kullaniciadi) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try {
            connection = helper.getConnection();
            String sql = "insert into degerlendirme (kitapadi,degerlendirme,puan,kullaniciadi) values (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, kitap_adi);
            statement.setString(2, degerlendirme);
            statement.setString(3, puan);
            statement.setString(4, kullaniciadi);
            statement.executeUpdate();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }
    
    public void deleteDegerlendirme(String kitap_adi,String kullaniciadi) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("delete from degerlendirme where kitapadi=? and kullaniciadi =? ");
            statement.setString(1, kitap_adi);
            statement.setString(2, kullaniciadi);
            statement.executeUpdate();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }
    
    public int silmeControl(String borrowBookName,String kullanici_adi) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("Select * from degerlendirme where kitapadi=? and kullaniciadi=?");
            statement.setString(1, borrowBookName);
            statement.setString(2, kullanici_adi);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return 0;
            } else {
                return 1;
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
            return 1;
        }
    }
}
