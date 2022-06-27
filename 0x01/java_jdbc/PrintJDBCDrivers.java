import java.sql.*;
import java.util.stream.Collectors;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        DriverManager.drivers()
                .forEach(d -> {
                            System.out.println(d.getClass().getName());
                            System.out.println(d.getMajorVersion());
                        }
                );
    }
}
