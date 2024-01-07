/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;
import java.sql.*;
/**
 *
 * @author Sami
 */
public class AdminManager {
    public void Admininsert(String ad,String soyad,String userName,String password,String unvan)
    {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement statement;
        try{
            connection = helper.getConnection();
            String sql = "insert into admins (NAME,SURNAME,USERNAME,PASSWORD,DEGREE) values (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,ad);
            statement.setString(2,soyad);
            statement.setString(3,userName);
            statement.setString(4,password);
            statement.setString(5,unvan);
             int affectedRows = statement.executeUpdate();
              if (affectedRows > 0) {
                System.out.println("Satır başarıyla eklendi.");
            } else {
                System.out.println("Satır eklenirken bir hata oluştu.");
            }
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
    }
}
