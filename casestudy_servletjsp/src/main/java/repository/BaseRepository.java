package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/database_casestudy";
    private String username = "root";
    private String password = "fsuesm79";
    private Connection connection;

    public BaseRepository() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
    }

    //    public static void main(String[] args) {
//        BaseRepository baseRepository = new BaseRepository();
//        baseRepository.getConnectionJavaToDB();
//        System.out.println( baseRepository.getConnectionJavaToDB());
//    }
    public Connection getConnectionJavaToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}