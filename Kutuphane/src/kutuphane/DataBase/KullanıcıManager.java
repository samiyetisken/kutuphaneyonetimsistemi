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
    
    public void delete(String kullanıcıadi) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("delete from users where USERNAME =?");
            statement.setString(1, kullanıcıadi);
            statement.executeUpdate();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }
    public void edit(String ad,String soyad,String userName,String password,String unvan,String selectedUser){
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try {
            connection = helper.getConnection();
            String sql = "update users set NAME = ?, SURNAME = ?, USERNAME = ?, PASSWORD = ?,DEGREE = ? WHERE USERNAME = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,ad);
            statement.setString(2,soyad);
            statement.setString(3,userName);
            statement.setString(4,password);
            statement.setString(5,unvan);
            statement.setString(6, selectedUser); 

            statement.executeUpdate();
        } catch (SQLException exception) {
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
    public void removeUserFromLoginTable() {
        Connection connection = null;
    PreparedStatement statement = null;
    DatabaseManager helper = new DatabaseManager();

    try {
        connection = helper.getConnection();
        String sql = "DELETE FROM giris";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("Tüm kullanıcılar silindi.");
    } catch (SQLException exception) {
        helper.showErrorMessage(exception);
    } finally {
        // Bağlantı ve ifadeyi kapat
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
     public void addUserToLoginTable(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        DatabaseManager helper = new DatabaseManager();

        try {
            connection = helper.getConnection();
            String sql = "insert into giris (USERNAME) values (?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            // Bağlantı ve ifadeyi kapat
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean isUser(String userName) {
    Connection connection;
    DatabaseManager helper = new DatabaseManager();
    PreparedStatement statement;
    ResultSet resultSet;
    try {
        connection = helper.getConnection();

        // İlk olarak users tablosunda kontrol et
        statement = connection.prepareStatement("SELECT * FROM users WHERE USERNAME = ?");
        statement.setString(1, userName);
        resultSet = statement.executeQuery();

        return resultSet.next(); // Eğer kullanıcı varsa true, yoksa false döner
    } catch (SQLException exception) {
        helper.showErrorMessage(exception);
        return false;
    }
}

    public boolean isAdmin(String userName) {
    Connection connection;
    DatabaseManager helper = new DatabaseManager();
    PreparedStatement statement;
    ResultSet resultSet;
    try {
        connection = helper.getConnection();
        
        // İlk olarak admins tablosunda kontrol et
        statement = connection.prepareStatement("SELECT * FROM admins WHERE USERNAME = ?");
        statement.setString(1, userName);
        resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            // Kullanıcı admins tablosunda bulunuyorsa admin olarak kabul et
            return true;
        } else {
            // Eğer admins tablosunda bulunmuyorsa, users tablosunda kontrol et
            statement = connection.prepareStatement("SELECT * FROM users WHERE USERNAME = ? AND DEGREE = 'Admin'");
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            
            return resultSet.next(); // Eğer admin ise true, değilse false döner
        }
    } catch (SQLException exception) {
        helper.showErrorMessage(exception);
        return false;
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
    public String getLoggedInUsername() {
        Connection connection;
    DatabaseManager helper = new DatabaseManager();
    PreparedStatement statement;
    ResultSet resultSet;

    try {
        connection = helper.getConnection();
        statement = connection.prepareStatement("SELECT * FROM giris");
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String usernameFromGirisTable = resultSet.getString("USERNAME");

            // Eğer usernameFromGirisTable null değilse ve boş değilse bu değeri döndür
            if (usernameFromGirisTable != null && !usernameFromGirisTable.isEmpty()) {
                return usernameFromGirisTable;
            } else {
                return null;
            }
        } else {
            return null; // Giriş yapmış kullanıcı yoksa null dönebilirsiniz.
        }
    } catch (SQLException exception) {
        helper.showErrorMessage(exception);
        return null;
    }
    }

   
}