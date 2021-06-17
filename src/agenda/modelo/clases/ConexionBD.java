package agenda.modelo.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class ConexionBD {

    private static Connection con;

    public static Connection getConexion(String driver, String url, String user, String pass) {
        if (con == null) {
            try {
                Runtime.getRuntime().addShutdownHook(new MiShutDownHook()); // Agregar hook de fin de programa
                Class.forName(driver); // Chequeo de Driver (sujeto a excepciones)
                con = DriverManager.getConnection(url, user, pass); // Obtener la conexión
                System.out.println("Conexión exitosa: " + con.getClass().getName());
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException("No se encuentra driver " + driver, ex);
            } catch (Exception ex) {
                throw new RuntimeException("No se pudo establecer conexión con la BD", ex);
            }
        }
        return con;
    }

    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        ResourceBundle rb = ResourceBundle.getBundle("bd-params");
        String driver = rb.getString("driver");
        String url = rb.getString("url");
        String user = rb.getString("user");
        String pass = rb.getString("pass");
        return getConexion(driver, url, user, pass);
    }

    private static class MiShutDownHook extends Thread {

        /* Justo antes de finalizar el programa la JVM invocará
           a este método donde podemos cerrar la conexion */
        @Override
        public void run() {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection liberada");
                }
            } catch (Exception ex) {
                System.out.println("Error liberando Connection al finalizar app: " + ex.getMessage());
            }
        }
    }
}
