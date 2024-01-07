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
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // Singleton örneği
    private static DatabaseManager instance;

    // Veritabanı bağlantısı
    private Connection connection;

    // Veritabanı bağlantı bilgileri
    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String kullaniciAdi = "root";
    private static final String sifre = "1234";

    // Özel kurucu metot
    public DatabaseManager() {
        try {
            // Veritabanı bağlantısını oluştur
            connection = DriverManager.getConnection(url, kullaniciAdi, sifre);
        } catch (SQLException e) {
            System.err.println("Veritabanına bağlantı hatası: " + e.getMessage());
        }
    }

    // Singleton örneğini alma metodu
    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    // Veritabanı bağlantısını alma metodu
    public Connection getConnection() {
        return connection;
    }
    public void showErrorMessage(SQLException exception)
    {
        System.out.println("Error : "+exception.getMessage());
        System.out.println("Error code : "+exception.getErrorCode());
    }
    public static void main(String[] args) {
        // Singleton örneğini alma
        DatabaseManager databaseManager = DatabaseManager.getInstance();

        // Veritabanı bağlantısı alma
        Connection connection = databaseManager.getConnection();

        // Veritabanı bağlantısı kontrolü
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Veritabanına bağlantı başarılı!");

                // Buraya veritabanı işlemlerini ekleyebilirsiniz

            } else {
                System.out.println("Veritabanına bağlantı başarısız!");
            }
        } catch (SQLException e) {
            System.err.println("Veritabanına bağlantı hatası: " + e.getMessage());
        }
    }
}
