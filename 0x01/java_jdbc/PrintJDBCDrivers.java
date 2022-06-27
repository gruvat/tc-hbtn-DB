import java.sql.*;
import java.util.Enumeration;
import java.util.stream.Collectors;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
//        DriverManager.drivers()
//                .forEach(d -> {
//                            System.out.println(d.getClass().getName());
//                            System.out.println(d.getMajorVersion());
//                        }
//                );

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        System.out.println(drivers);
    }
}
