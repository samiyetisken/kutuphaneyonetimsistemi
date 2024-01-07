/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;

/**
 *
 * @author Sami
 */
import java.sql.*;

public class KullanıcıManager
{
    public void insert(String ad,String soyad,String userName,String password,String unvan)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try{
            connection = helper.getConnection();
            String sql = "insert into users (NAME,SURNAME,USERNAME,PASSWORD,DEGREE) values (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,ad);
            statement.setString(2,soyad);
            statement.setString(3,userName);
            statement.setString(4,password);
            statement.setString(5,unvan);
            statement.executeUpdate();
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
    }

    public int loginControl(String userName, String password)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("Select * from users where USERNAME=? and PASSWORD=?");
            statement.setString(1,userName);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return 0;
            } else {
                return 1;
            }
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
            return 1;
        }
    }
    public int usernameControl(String userName)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("Select * from users where USERNAME=?");
            statement.setString(1,userName);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return 0;
            } else {
                return 1;
            }
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
            return 0;
        }
    }
    public String nameSurname(String userName)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("Select NAME,SURNAME from users where USERNAME=?");
            statement.setString(1,userName);
            resultSet = statement.executeQuery();
            String nameAndSurname = "Hata1";
            while (resultSet.next()){
                nameAndSurname = resultSet.getString("NAME")+" "+resultSet.getString("SURNAME");
            }
            return nameAndSurname;
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
            return "Hata";
        }
    }

    public int numberOfUser()
    {
        int toplam = 0;
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        Statement statement;
        ResultSet resultSet;
        try{
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select (ID) from users");
            while (resultSet.next()){
                toplam ++;
            }
            return toplam;
        }catch (SQLException exception){
            return toplam;
        }
    }
}