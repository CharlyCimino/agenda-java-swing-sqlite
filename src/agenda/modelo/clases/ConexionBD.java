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

    public static Connection getConexion(String driver, String url, String user, String pass) throws SQLException, ClassNotFoundException {
        if (con == null) {
            Runtime.getRuntime().addShutdownHook(new MiShutDownHook()); // Agregar hook de fin de programa
            Class.forName(driver); // Chequeo de Driver (sujeto a excepciones)
            con = DriverManager.getConnection(url, user, pass); // Obtener la conexión
            System.out.println("Conexión exitosa: " + con.getClass().getName());
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
           a este metodo donde podemos cerrar la conexion */
        public void run() {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Recursos liberados");
                }
            } catch (Exception ex) {
                System.out.println("Error liberando recursos al terminar app: " + ex.getMessage());
            }
        }
    }
}
