package agenda.modelo.clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Modelo {

    private Connection conexion;

    public void conectarBD(String driver, String url, String user, String pass) {
        this.conexion = ConexionBD.getConexion(driver, url, user, pass);
    }

    public Collection<Contacto> obtenerContactos(Categoria cat) {
        try ( Statement stmt = this.conexion.createStatement();) {
            Collection<Contacto> contactos = new ArrayList<>();
            String query = "SELECT * FROM CONTACTOS ";
            switch (cat) {
                case TODOS:
                    query += "";
                    break;
                case OTROS:
                    query += "WHERE categoria is NULL";
                    break;
                default:
                    query += "WHERE categoria = '" + cat.name() + "'";
            }
            try ( ResultSet rs = stmt.executeQuery(query);) {
                while (rs.next()) {
                    contactos.add(generarContacto(rs));
                }
                return contactos;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudieron obtener los contactos", ex);
        }
    }

    public Contacto obtenerContacto(int id) {
        String query = "SELECT * FROM contactos WHERE id = " + id;
        try ( Statement stmt = this.conexion.createStatement();  ResultSet rs = stmt.executeQuery(query);) {
            rs.next();
            Contacto contacto = generarContacto(rs);
            return contacto;
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo obtener contacto con ID " + id, ex);
        }
    }

    public void agregarContacto(Contacto co) throws SQLException {
        String query = "INSERT INTO contactos VALUES (null,?,?,?,?,?,?,?)";
        try ( PreparedStatement ps = this.conexion.prepareStatement(query);) {
            cargarDatosDeContactoEnSentencia(co, ps);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo agregar contacto\n" + co, ex);
        }
    }

    public void actualizarContacto(Contacto co) throws SQLException {
        String campos = "nombre = ?, apellido = ?, mail = ?, telefono = ?";
        campos += ", direccion = ?, fecha_nacimiento = ?, categoria = ?";
        String query = "UPDATE contactos SET " + campos + " WHERE id = " + co.getId();
        PreparedStatement ps = this.conexion.prepareStatement(query);
        cargarDatosDeContactoEnSentencia(co, ps);
        ps.executeUpdate();
    }

    public void borrarContacto(int id) throws SQLException {
        Statement s = conexion.createStatement();
        s.executeUpdate("DELETE FROM contactos WHERE contactos.id = " + id);
    }

    public void vaciarAgenda() throws SQLException {
        Statement s = conexion.createStatement();
        s.executeUpdate("DELETE FROM contactos");
        s.executeUpdate("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='contactos'"); // Reinicia el contador de IDs
    }

    private void cargarDatosDeContactoEnSentencia(Contacto co, PreparedStatement ps) throws SQLException {
        ps.setString(1, co.getNombre());
        ps.setString(2, co.getApellido());
        ps.setString(3, co.getMail());
        ps.setString(4, co.getTelefono());
        ps.setString(5, co.getDireccion());
        ps.setString(6, co.getFechaDeNacimiento().toString());
        String cat = null;
        if (co.getCategoria() != Categoria.OTROS) {
            cat = co.getCategoria().name();
        }
        ps.setString(7, cat);
    }

    private Contacto generarContacto(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String nom = rs.getString(2);
        String ape = rs.getString(3);
        String mail = rs.getString(4);
        String tel = rs.getString(5);
        String dir = rs.getString(6);
        Date fecha = Date.valueOf(rs.getString(7));
        Categoria c = Categoria.OTROS;
        if (rs.getString(8) != null) {
            c = Categoria.valueOf(rs.getString(8));
        }
        return new Contacto(id, nom, ape, mail, tel, dir, fecha, c);
    }
}
