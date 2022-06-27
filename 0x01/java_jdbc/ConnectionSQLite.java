import java.sql.*;

public class ConnectionSQLite {

    public static void main(String[] args) {
        try {
            //Class.forName("com.sqlite.jdbc.Driver");

            String url = "jdbc:sqlite:sqlite_database_2022.db";
            Connection conn = initConnection(url);

            conn.close();

        } catch (Exception e) {
            //TO-DO
        }
    }

    private static Connection initConnection(String url) {
        try {
            return DriverManager.getConnection(url);
        } catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
