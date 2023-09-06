
package Dao;

/**
 *
 * @author moisibot
 */


import Modelo.Usuario;
import Modelo.UsuarioFinal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioFinalDAO {
    private Connection conexion;

    public UsuarioFinalDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(UsuarioFinal usuarioFinal) {
        String query = "INSERT INTO USUARIO_FINAL (saldoinicial, id_usuario) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setDouble(1, usuarioFinal.getSaldoinicial());
            preparedStatement.setInt(2, usuarioFinal.getId_usuario().getId_usuario());
            preparedStatement.executeUpdate();
            System.out.println("Usuario final creado");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario final: " + e);
        }
        return false;
    }

    public void actualizar(UsuarioFinal usuarioFinal) {
        String query = "UPDATE USUARIO_FINAL SET saldoinicial = ?, id_usuario = ? WHERE id_usuariofinal = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setDouble(1, usuarioFinal.getSaldoinicial());
            preparedStatement.setInt(2, usuarioFinal.getId_usuario().getId_usuario());
            preparedStatement.setInt(3, usuarioFinal.getId_usuariofinal());
            preparedStatement.executeUpdate();
            System.out.println("Usuario final actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario final: " + e);
        }
    }

    public void eliminar(int id_usuariofinal) {
        String query = "DELETE FROM USUARIO_FINAL WHERE id_usuariofinal = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_usuariofinal);
            preparedStatement.executeUpdate();
            System.out.println("Usuario final eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario final: " + e);
        }
    }

    public List<UsuarioFinal> listar() {
        List<UsuarioFinal> usuariosFinales = new ArrayList<>();
        String query = "SELECT * FROM USUARIO_FINAL UF INNER JOIN USUARIO U ON UF.id_usuario = U.id_usuario";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id_usuariofinal = resultSet.getInt("id_usuariofinal");
                    double saldoinicial = resultSet.getDouble("saldoinicial");
                    int id_usuario = resultSet.getInt("id_usuario");
                    String nombre = resultSet.getString("nombre");
                    String username = resultSet.getString("username");
                    boolean estado = resultSet.getBoolean("estado");
                    String tipoStr = resultSet.getString("tipo");
                    String contrasenia = resultSet.getString("contrasenia");
                    String email = resultSet.getString("email");

                    Usuario.TipoUsuario tipo = Usuario.TipoUsuario.valueOf(tipoStr);
                    Usuario usuario = new Usuario(id_usuario, nombre, username, estado, tipo, contrasenia, email);
                    UsuarioFinal usuarioFinal = new UsuarioFinal(id_usuariofinal, saldoinicial, usuario);
                    usuariosFinales.add(usuarioFinal);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuarios finales: " + e);
        }
        return usuariosFinales;
    }

    public Optional<UsuarioFinal> obtenerPorId(int id_usuariofinal) {
        String query = "SELECT * FROM USUARIO_FINAL UF INNER JOIN USUARIO U ON UF.id_usuario = U.id_usuario WHERE id_usuariofinal = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_usuariofinal);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    double saldoinicial = resultSet.getDouble("saldoinicial");
                    int id_usuario = resultSet.getInt("id_usuario");
                    String nombre = resultSet.getString("nombre");
                    String username = resultSet.getString("username");
                    boolean estado = resultSet.getBoolean("estado");
                    String tipoStr = resultSet.getString("tipo");
                    String contrasenia = resultSet.getString("contrasenia");
                    String email = resultSet.getString("email");

                    Usuario.TipoUsuario tipo = Usuario.TipoUsuario.valueOf(tipoStr);
                    Usuario usuario = new Usuario(id_usuario, nombre, username, estado, tipo, contrasenia, email);
                    UsuarioFinal usuarioFinal = new UsuarioFinal(id_usuariofinal, saldoinicial, usuario);
                    return Optional.of(usuarioFinal);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario final por ID: " + e);
        }
        return Optional.empty();
    }
}
