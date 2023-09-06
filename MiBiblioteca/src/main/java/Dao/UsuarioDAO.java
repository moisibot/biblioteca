
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(Usuario usuario) {
        String query = "INSERT INTO USUARIO (nombre, username, estado, tipo, contrasenia, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getUsername());
            preparedStatement.setBoolean(3, usuario.isEstado());
            preparedStatement.setString(4, usuario.getTipo().name());
            preparedStatement.setString(5, usuario.getContrasenia());
            preparedStatement.setString(6, usuario.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("Usuario creado");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
        }
        return false;
    }

    public void actualizar(Usuario usuario) {
        String query = "UPDATE USUARIO SET nombre = ?, username = ?, estado = ?, tipo = ?, contrasenia = ?, email = ? WHERE id_usuario = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getUsername());
            preparedStatement.setBoolean(3, usuario.isEstado());
            preparedStatement.setString(4, usuario.getTipo().name());
            preparedStatement.setString(5, usuario.getContrasenia());
            preparedStatement.setString(6, usuario.getEmail());
            preparedStatement.setInt(7, usuario.getId_usuario());
            preparedStatement.executeUpdate();
            System.out.println("Usuario actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
    }

    public void eliminar(int id_usuario) {
        String query = "DELETE FROM USUARIO WHERE id_usuario = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_usuario);
            preparedStatement.executeUpdate();
            System.out.println("Usuario eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
    }

    public List<Usuario> listar() {
        var usuariosList = new ArrayList<Usuario>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM USUARIO")) {

            while (resultSet.next()) {
                var id_usuario = resultSet.getInt("id_usuario");
                var nombre = resultSet.getString("nombre");
                var username = resultSet.getString("username");
                var estado = resultSet.getBoolean("estado");
                var tipoStr = resultSet.getString("tipo");
                var contrasenia = resultSet.getString("contrasenia");
                var email = resultSet.getString("email");

                var tipo = Usuario.TipoUsuario.valueOf(tipoStr);

                var usuario = new Usuario(id_usuario, nombre, username, estado, tipo, contrasenia, email);
                usuariosList.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuarios: " + e);
        }
        return usuariosList;
    }

    public Optional<Usuario> obtenerPorId(int id_usuario) {
        Usuario usuario = null;
        try (var preparedStatement = conexion.prepareStatement("SELECT * FROM USUARIO WHERE id_usuario = ?")) {
            preparedStatement.setInt(1, id_usuario);
            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var nombre = resultSet.getString("nombre");
                    var username = resultSet.getString("username");
                    var estado = resultSet.getBoolean("estado");
                    var tipoStr = resultSet.getString("tipo");
                    var contrasenia = resultSet.getString("contrasenia");
                    var email = resultSet.getString("email");

                    var tipo = Usuario.TipoUsuario.valueOf(tipoStr);

                    usuario = new Usuario(id_usuario, nombre, username, estado, tipo, contrasenia, email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario por ID: " + e);
        }
        return Optional.ofNullable(usuario);
    }
}

