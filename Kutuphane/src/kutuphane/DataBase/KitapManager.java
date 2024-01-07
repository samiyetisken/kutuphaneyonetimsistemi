/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;

/**
 *
 * @author Sami
 */
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class KitapManager {
     public DefaultListModel<Kitap> getDataBooks() throws SQLException {
        DatabaseManager helper = new DatabaseManager();
        Connection connection = helper.getConnection();
        DefaultListModel<Kitap> listModel = new DefaultListModel<>();
        PreparedStatement ps = connection.prepareStatement("select BOOK_NAME,AUTHOR_NAME,NUMBEROFPAGE,TYPE from books");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listModel.addElement(new Kitap(
                    rs.getString("BOOK_NAME"),
                    rs.getString("AUTHOR_NAME"),
                    rs.getString("NUMBEROFPAGE"),
                    rs.getString("TYPE")));
        }
        return listModel;
    }
    public void editBook(String kitapadi, String yazar, String sayfasayisi, String kategori, String selectedBook){
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try {
            connection = helper.getConnection();
            String sql = "update books set BOOK_NAME = ?, AUTHOR_NAME = ?, NUMBEROFPAGE = ?, TYPE = ? where BOOK_NAME = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, kitapadi);
            statement.setString(2, yazar);
            statement.setString(3, sayfasayisi);
            statement.setString(4, kategori);
            statement.setString(5, selectedBook);
            statement.executeUpdate();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }

    }
    public void insertBook(String kitapadi, String yazar, String sayfasayisi, String kategori) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try {
            connection = helper.getConnection();
            String sql = "insert into books (BOOK_NAME,AUTHOR_NAME,NUMBEROFPAGE,TYPE) values (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, kitapadi);
            statement.setString(2, yazar);
            statement.setString(3, sayfasayisi);
            statement.setString(4, kategori);
            statement.executeUpdate();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public void deleteBook(String kitapadi) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("delete from books where BOOK_NAME =?");
            statement.setString(1, kitapadi);
            statement.executeUpdate();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public int bookControl(String borrowBookName) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("Select * from books where BOOK_NAME=?");
            statement.setString(1, borrowBookName);
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

    public void booksData(String kitapadi, String username) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("select BOOK_NAME,AUTHOR_NAME,NUMBEROFPAGE,TYPE from books where BOOK_NAME=?");
            statement.setString(1, kitapadi.toUpperCase());
            resultSet = statement.executeQuery();
            BorrowKitapManager borrowBookManager = new BorrowKitapManager();
            while (resultSet.next()) {
                borrowBookManager.insert(resultSet.getString("BOOK_NAME"), resultSet.getString("AUTHOR_NAME"),
                        resultSet.getString("NUMBEROFPAGE"), resultSet.getString("TYPE"), username);
                deleteBook(kitapadi);
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }
    public DefaultListModel<Kitap> searchBooks(String keyword) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        DefaultListModel<Kitap> listModel = new DefaultListModel<>();

        try {
            connection = helper.getConnection();
            String sql = "SELECT * FROM books WHERE UPPER(BOOK_NAME) LIKE ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword.toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listModel.addElement(new Kitap(
                        rs.getString("BOOK_NAME"),
                        rs.getString("AUTHOR_NAME"),
                        rs.getString("NUMBEROFPAGE"),
                        rs.getString("TYPE")));
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }

        return listModel;
    }
    
}
