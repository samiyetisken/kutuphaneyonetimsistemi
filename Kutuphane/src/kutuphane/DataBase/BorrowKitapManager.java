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
import javax.swing.DefaultListModel;

public class BorrowKitapManager implements IBaseManager,IOduncAlındı
{
    public DefaultListModel<BorrowKitap> getDataBooks() throws SQLException {
        DatabaseManager helper = new DatabaseManager();
        Connection connection = helper.getConnection();
        DefaultListModel<BorrowKitap> listModel = new DefaultListModel<>();
        PreparedStatement ps = connection.prepareStatement("select BOOK_NAME,AUTHOR_NAME,NUMBEROFPAGE,TYPE,USERNAME from borrowbook");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listModel.addElement(new BorrowKitap(
                    rs.getString("BOOK_NAME"),
                    rs.getString("AUTHOR_NAME"),
                    rs.getString("NUMBEROFPAGE"),
                    rs.getString("TYPE"),
                    rs.getString("USERNAME")));
                    
        }
        return listModel;
    }
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
    
    public void borrowBook(String kitapAdi) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        PreparedStatement borrowStatement;
        ResultSet resultSet;
        KullanıcıManager kullanıcıManager = new KullanıcıManager();
        String loggedInUsername = kullanıcıManager.getLoggedInUsername();
        try {
            connection = helper.getConnection();

            // Kitabın ödünç alınıp alınmadığını kontrol et
            borrowStatement = connection.prepareStatement("SELECT * FROM books WHERE BOOK_NAME = ?");
            borrowStatement.setString(1, kitapAdi.toUpperCase());
            resultSet = borrowStatement.executeQuery();

            if (resultSet.next()) {
                // Kitap var, ödünç alınabilir, borrowbook tablosuna ekle
                borrowStatement = connection.prepareStatement("INSERT INTO borrowbook (BOOK_NAME, AUTHOR_NAME, NUMBEROFPAGE, TYPE, USERNAME) " +
                                                "SELECT BOOK_NAME, AUTHOR_NAME, NUMBEROFPAGE, TYPE, ? " +
                                                "FROM books " +
                                                "WHERE BOOK_NAME = ?");
borrowStatement.setString(1, loggedInUsername);
borrowStatement.setString(2, kitapAdi.toUpperCase());
                
                int affectedRows = borrowStatement.executeUpdate();
                
                if (affectedRows > 0) {
                    // Ödünç alma başarılı, şimdi books tablosundan sil
                    PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM books WHERE BOOK_NAME = ?");
                    deleteStatement.setString(1, kitapAdi.toUpperCase());
                    int deletedRows = deleteStatement.executeUpdate();
                   
                    if (deletedRows > 0) {
                        
                        System.out.println("Kitap başarıyla ödünç alındı ve books tablosundan silindi.");
                    } else {
                        System.out.println("Kitap ödünç alındı ancak books tablosundan silinemedi.");
                    }
                } else {
                    System.out.println("Kitap ödünç alınamadı.");
                }
            } else {
                System.out.println("Kitap bulunamadı.");
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    // İhtiyaç duyulursa bildirim metodu da buraya eklenerek kullanılabilir
    public void bildirim(String userName, String kitapAdi) {
        System.out.println(userName + " " + kitapAdi + " kitabı ödünç aldı.");
    }

    //Burada ödünç alınan kitap borrowbook tablosundan silinip books tablosuna ekleniyor
   public void borrowBookData(String kitapadi) {
    Connection connection;
    DatabaseManager helper = new DatabaseManager();
    PreparedStatement statement;
    ResultSet resultSet;
    KullanıcıManager kullanıcıManager = new KullanıcıManager();
    String loggedInUsername = kullanıcıManager.getLoggedInUsername();
    try {
        connection = helper.getConnection();
        statement = connection.prepareStatement("SELECT BOOK_NAME, AUTHOR_NAME, NUMBEROFPAGE, TYPE FROM borrowbook WHERE BOOK_NAME = ? AND USERNAME = ?");
        statement.setString(1, kitapadi.toUpperCase());
        statement.setString(2, loggedInUsername);
        resultSet = statement.executeQuery();
        KitapManager booksManager = new KitapManager();
        if (resultSet.next()) {
            // Kitap bulundu ve kullanıcıya ait, books tablosuna ekle
            booksManager.insertBook(resultSet.getString("BOOK_NAME"), resultSet.getString("AUTHOR_NAME"), resultSet.getString("NUMBEROFPAGE"), resultSet.getString("TYPE"));
            delete(kitapadi);
        } else {
            // Kitap kullanıcıya ait değil veya bulunamadı
            System.out.println("Bu kitap sizde değil veya ödünç alınmamış.");
        }
    } catch (SQLException exception) {
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
    public DefaultListModel<BorrowKitap> searchBooks(String keyword) {
        Connection connection;
        DatabaseManager helper = new DatabaseManager();
        DefaultListModel<BorrowKitap> listModel = new DefaultListModel<>();

        try {
            connection = helper.getConnection();
            String sql = "SELECT * FROM borrowbook WHERE UPPER(BOOK_NAME) LIKE ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword.toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listModel.addElement(new BorrowKitap(
                        rs.getString("BOOK_NAME"),
                        rs.getString("AUTHOR_NAME"),
                        rs.getString("NUMBEROFPAGE"),
                        rs.getString("TYPE"),
                        rs.getString("USERNAME")));
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }

        return listModel;
    }
    
}
