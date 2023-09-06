
package Dao;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Modelo.Usuario;

import Modelo.Administrador;

public class AdministradorDAO {
    private Connection conexion;

    public AdministradorDAO(Connection conexion) {
        this.conexion = conexion;
    }

  

public boolean crear(Administrador administrador) {
    String query = "INSERT INTO ADMINISTRADORES (id_usuario) VALUES (?)";
    try (var preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setString(1, administrador.getId_usuario().getIdUsuario());
        preparedStatement.executeUpdate();
        System.out.println("Administrador creado");
        return true;
    } catch (SQLException e) {
        System.out.println("Error al crear administrador: " + e);
    }
    return false;
}

    public void eliminar(String id_administrador) {
        String query = "DELETE FROM ADMINISTRADOR WHERE id_administrador = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, id_administrador);
            preparedStatement.executeUpdate();
            System.out.println("Administrador eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar administrador: " + e);
        }
    }

    public List<Administrador> listar() {
        var administradores = new ArrayList<Administrador>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM ADMINISTRADOR")) {

            while (resultSet.next()) {
                var id_administrador = resultSet.getString("id_administrador");
                var id_usuario = resultSet.getInt("id_usuario");

                Usuario usuario = obtenerUsuarioPorId(id_usuario);

                var administrador = new Administrador(id_administrador, usuario);
                administradores.add(administrador);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar administradores: " + e);
        }
        return administradores;
    }

    public Optional<Administrador> obtenerAdministrador(String id_administrador) {
        String query = "SELECT * FROM ADMINISTRADOR WHERE id_administrador = ?";
        Administrador administrador = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, id_administrador);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var id_usuario = resultSet.getInt("id_usuario");

                    Usuario usuario = obtenerUsuarioPorId(id_usuario);

                    administrador = new Administrador(id_administrador, usuario);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar administrador: " + e);
        }

        return Optional.ofNullable(administrador);
    }

    // Método para obtener un objeto Usuario por su ID utilizando UsuarioDB
    private Usuario obtenerUsuarioPorId(int idUsuario) {
        // Debes implementar este método o usar la clase UsuarioDB para obtener el Usuario por su ID.
        // Ejemplo: UsuarioDB usuarioDB = new UsuarioDB(conexion);
        // return usuarioDB.obtenerUsuarioPorId(idUsuario);
        return null; // Implementa la lógica adecuada aquí.
    }
}

