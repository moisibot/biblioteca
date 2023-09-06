
package Dao;

/**
 *
 * @author moisibot
 */


import Modelo.Bibliotecas;
import Modelo.Recepcionista;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecepcionistaDAO {
    private Connection conexion;

    public RecepcionistaDAO(Connection conexion) {
        this.conexion = conexion;
    }
public boolean crear(Recepcionista recepcionista) {
    String query = "INSERT INTO RECEPCIONISTAS (id_biblioteca, id_usuario) VALUES (?, ?)";
    try (var preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setInt(1, recepcionista.getId_biblioteca().getIdBiblioteca());
        preparedStatement.setString(2, recepcionista.getId_usuario().getIdUsuario());
        preparedStatement.executeUpdate();
        System.out.println("Recepcionista creado");
        return true;
    } catch (SQLException e) {
        System.out.println("Error al crear recepcionista: " + e);
    }
    return false;
}

public void actualizar(Recepcionista recepcionista) {
    String query = "UPDATE RECEPCIONISTAS SET id_biblioteca = ?, id_usuario = ? WHERE id_recepcionista = ?";

    try (var preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setInt(1, recepcionista.getId_biblioteca().getIdBiblioteca());
        preparedStatement.setString(2, recepcionista.getId_usuario().getIdUsuario());
        preparedStatement.setInt(3, recepcionista.getId_recepcionista());
        preparedStatement.executeUpdate();
        System.out.println("Recepcionista actualizado");
    } catch (SQLException e) {
        System.out.println("Error al actualizar recepcionista: " + e);
    }
}

    public void eliminar(int id_recepcionista) {
        String query = "DELETE FROM RECEPCIONISTA WHERE id_recepcionista = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_recepcionista);
            preparedStatement.executeUpdate();
            System.out.println("Recepcionista eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar recepcionista: " + e);
        }
    }

    public List<Recepcionista> listar() {
        var recepcionistasList = new ArrayList<Recepcionista>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM RECEPCIONISTA")) {

            while (resultSet.next()) {
                var id_recepcionista = resultSet.getInt("id_recepcionista");
                var id_biblioteca = resultSet.getInt("id_biblioteca");
                var id_usuario = resultSet.getInt("id_usuario");

                Bibliotecas bibliotecas = obtenerBibliotecaPorId(id_biblioteca);
                Usuario usuario = obtenerUsuarioPorId(id_usuario);

                var recepcionista = new Recepcionista(id_recepcionista, bibliotecas, usuario);
                recepcionistasList.add(recepcionista);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar recepcionistas: " + e);
        }
        return recepcionistasList;
    }

    public Optional<Recepcionista> obtenerRecepcionista(int id_recepcionista) {
        String query = "SELECT * FROM RECEPCIONISTA WHERE id_recepcionista = ?";
        Recepcionista recepcionista = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_recepcionista);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var id_biblioteca = resultSet.getInt("id_biblioteca");
                    var id_usuario = resultSet.getInt("id_usuario");

                    Bibliotecas bibliotecas = obtenerBibliotecaPorId(id_biblioteca);
                    Usuario usuario = obtenerUsuarioPorId(id_usuario);

                    recepcionista = new Recepcionista(id_recepcionista, bibliotecas, usuario);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar recepcionista: " + e);
        }

        return Optional.ofNullable(recepcionista);
    }

    // Método para obtener un objeto Bibliotecas por su ID
    private Bibliotecas obtenerBibliotecaPorId(int id_biblioteca) {
        // Debes implementar este método o usar la clase BibliotecasDB para obtener el objeto
        // Bibliotecas por su ID.
        // Ejemplo: BibliotecasDB bibliotecasDB = new BibliotecasDB(conexion);
        // return bibliotecasDB.obtenerBibliotecaPorId(id_biblioteca);
        return null; // Implementa la lógica adecuada aquí.
    }

    // Método para obtener un objeto Usuario por su ID
    private Usuario obtenerUsuarioPorId(int id_usuario) {
        // Debes implementar este método o usar la clase UsuarioDB para obtener el objeto
        // Usuario por su ID.
        // Ejemplo: UsuarioDB usuarioDB = new UsuarioDB(conexion);
        // return usuarioDB.obtenerUsuarioPorId(id_usuario);
        return null; // Implementa la lógica adecuada aquí.
    }
}

