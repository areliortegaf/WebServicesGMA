/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areli.emp;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author asortega
 */
public class OracleJDBCCon {
    
    public static void main(String[] args) {
        System.out.println("-------- Test de coneccion ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontraron los Drivers de Oracle para la coneccion");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver registrado");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@host:puerto/iddb", "usuario", "contraseña");

        } catch (SQLException e) {

            System.out.println("Coneccion fallida!");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("Se ha conectado exitosamente");
        } else {
            System.out.println("Fallo la coneccion!");
        }
    }
}
    
    

