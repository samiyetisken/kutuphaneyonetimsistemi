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
public class BookRepository {
    private DatabaseManager databaseManager;

    public BookRepository(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public int getNumberOfBooks() {
        int total = 0;
        try (Connection connection = databaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM books")) {
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        } catch (SQLException exception) {
            exception.printStackTrace(); // Gerçek uygulamada loglama yapılmalıdır.
        }
        return total;
    }
}
