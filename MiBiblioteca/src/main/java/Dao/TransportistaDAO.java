
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.Bibliotecas;
import Modelo.Transportista;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransportistaDAO {
    private Connection conexion;

    public TransportistaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(Transportista transportista) {
        String query = "INSERT INTO TRANSPORTISTA (id_biblioteca, id_usuario) VALUES (?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, transportista.getId_biblioteca().getId_biblioteca());
            preparedStatement.setInt(2, transportista.getId_usuario().getId_usuario());
            preparedStatement.executeUpdate();
            System.out.println("Transportista creado");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear transportista: " + e);
        }
        return false;
    }

    public void actualizar(Transportista transportista) {
        String query = "UPDATE TRANSPORTISTA SET id_biblioteca = ?, id_usuario = ? WHERE id_transportista = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, transportista.getId_biblioteca().getId_biblioteca());
            preparedStatement.setInt(2, transportista.getId_usuario().getId_usuario());
            preparedStatement.setInt(3, transportista.getId_transportista());
            preparedStatement.executeUpdate();
            System.out.println("Transportista actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar transportista: " + e);
        }
    }

    public void eliminar(int id_transportista) {
        String query = "DELETE FROM TRANSPORTISTA WHERE id_transportista = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_transportista);
            preparedStatement.executeUpdate();
            System.out.println("Transportista eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar transportista: " + e);
        }
    }

    public List<Transportista> listar() {
        var transportistasList = new ArrayList<Transportista>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM TRANSPORTISTA")) {

            while (resultSet.next()) {
                var id_transportista = resultSet.getInt("id_transportista");
                var id_biblioteca = resultSet.getInt("id_biblioteca");
                var id_usuario = resultSet.getInt("id_usuario");

                Bibliotecas biblioteca = obtenerBibliotecaPorId(id_biblioteca);
                Usuario usuario = obtenerUsuarioPorId(id_usuario);

                var transportista = new Transportista(id_transportista, biblioteca, usuario);
                transportistasList.add(transportista);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar transportistas: " + e);
        }
        return transportistasList;
    }

    public Optional<Transportista> obtenerPorId(int id_transportista) {
        Transportista transportista = null;
        try (var preparedStatement = conexion.prepareStatement("SELECT * FROM TRANSPORTISTA WHERE id_transportista = ?")) {
            preparedStatement.setInt(1, id_transportista);
            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var id_biblioteca = resultSet.getInt("id_biblioteca");
                    var id_usuario = resultSet.getInt("id_usuario");

                    Bibliotecas biblioteca = obtenerBibliotecaPorId(id_biblioteca);
                    Usuario usuario = obtenerUsuarioPorId(id_usuario);

                    transportista = new Transportista(id_transportista, biblioteca, usuario);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar transportista por ID: " + e);
        }
        return Optional.ofNullable(transportista);
    }

    // Implementa los métodos para obtener los objetos correspondientes por su ID
    private Bibliotecas obtenerBibliotecaPorId(int id_biblioteca) {
        // Implementa la lógica para obtener una biblioteca por su ID
        // Puedes usar una clase BibliotecasDB o una consulta SQL aquí
        return null;
    }

    private Usuario obtenerUsuarioPorId(int id_usuario) {
        // Implementa la lógica para obtener un usuario por su ID
        // Puedes usar una clase UsuarioDB o una consulta SQL aquí
        return null;
    }
}

