/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sami
 */
public class BorrowRepository {
    private DatabaseManager databaseManager;

    public BorrowRepository(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

     public int numberOfBorrow()
    {
        int toplam = 0;
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        Statement statement;
        ResultSet resultSet;
        try{
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select (ID) from borrowbook");
            while (resultSet.next()){
                toplam ++;
            }
            return toplam;
        }catch (SQLException exception){
            return toplam;
        }
    }
}
