/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;

/**
 *
 * @author Sami
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowKitapManager implements IBaseManager,IOduncAlındı
{
    @Override
    public void insert(String kitapadi, String yazar, String sayfasayisi, String kategori, String userName)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try{
            connection = helper.getConnection();
            String sql = "insert into borrowbook (BOOK_NAME,AUTHOR_NAME,NUMBEROFPAGE,TYPE,USER_NAME) values (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,kitapadi);
            statement.setString(2,yazar);
            statement.setString(3,sayfasayisi);
            statement.setString(4,kategori);
            statement.setString(5,userName);
            statement.executeUpdate();

        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
    }

    @Override
    public void edit(String kitapadi, String yazar, String sayfasayisi, String kategori) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try {
            connection = helper.getConnection();
            String sql = "update books set BOOK_NAME = ?, AUTHOR_NAME = ?, NUMBEROFPAGE = ?, TYPE = ? where ID = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, kitapadi);
            statement.setString(2, yazar);
            statement.setString(3, sayfasayisi);
            statement.setString(4, kategori);
            statement.setInt(5, 1);
            statement.executeUpdate();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    @Override
    public void delete(String kitapadi)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try{
            connection= helper.getConnection();
            statement = connection.prepareStatement("delete from borrowbook where BOOK_NAME =?");
            statement.setString(1,kitapadi);
            statement.executeUpdate();
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
    }

    public int borrowBookControl(String kitapadi)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        ResultSet resultSet;
        try{
            connection = helper.getConnection();
            statement = connection.prepareStatement("Select * from borrowbook where BOOK_NAME=?");
            statement.setString(1,kitapadi);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return 0;
            }
            else {
                return 1;
            }
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
            return 1;
        }
    }

    //Burada ödünç alınan kitap borrowbook tablosundan silinip books tablosuna ekleniyor
    public void borrowBookData(String kitapadi)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        ResultSet resultSet;
        try{
            connection = helper.getConnection();
            statement = connection.prepareStatement("select BOOK_NAME,AUTHOR_NAME,NUMBEROFPAGE,TYPE from borrowbook where BOOK_NAME=?");
            statement.setString(1,kitapadi.toUpperCase());
            resultSet = statement.executeQuery();
            KitapManager booksManager = new KitapManager();
            while (resultSet.next()){
                booksManager.insertBook(resultSet.getString("BOOK_NAME"),resultSet.getString("AUTHOR_NAME"),resultSet.getString("NUMBEROFPAGE"),resultSet.getString("TYPE"));
                delete(kitapadi);
            }
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
    }

    public String userNameControl(String userName)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        ResultSet resultSet;
        try{
            connection = helper.getConnection();
            statement = connection.prepareStatement("Select * from borrowbook where USER_NAME=?");
            statement.setString(1,userName);
            resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                String borrowBook = resultSet.getString("Book_Name");
                return borrowBook;
            }
            else{
                return "YOK";
            }
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
            return "YOK";
        }
    }
    public void bildirim(String userName,String kitapadi){
        System.out.println(userName +" " +kitapadi + " kitabı ödünç aldı.");
    }
}
