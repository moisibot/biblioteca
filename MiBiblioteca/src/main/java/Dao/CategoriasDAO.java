
package Dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Modelo.Categorias;


public class CategoriasDAO {
    private Connection conexion;

    public CategoriasDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(Categorias categoria) {
        String query = "INSERT INTO CATEGORIAS (nombre, descripcion) VALUES (?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, categoria.getNombre());
            preparedStatement.setString(2, categoria.getDescripcion());
            preparedStatement.executeUpdate();
            System.out.println("Categoría creada");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear categoría: " + e);
        }
        return false;
    }

    public void actualizar(Categorias categoria) {
        String query = "UPDATE CATEGORIAS SET nombre = ?, descripcion = ? WHERE id_categoria = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, categoria.getNombre());
            preparedStatement.setString(2, categoria.getDescripcion());
            preparedStatement.setInt(3, categoria.getId_categoria());
            preparedStatement.executeUpdate();
            System.out.println("Categoría actualizada");
        } catch (SQLException e) {
            System.out.println("Error al actualizar categoría: " + e);
        }
    }

    public void eliminar(int id) {
        String query = "DELETE FROM CATEGORIAS WHERE id_categoria = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Categoría eliminada");
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría: " + e);
        }
    }

    public List<Categorias> listar() {
        var categorias = new ArrayList<Categorias>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM CATEGORIAS")) {

            while (resultSet.next()) {
                var id = resultSet.getInt("id_categoria");
                var nombre = resultSet.getString("nombre");
                var descripcion = resultSet.getString("descripcion");
                var categoria = new Categorias(id, nombre, descripcion);
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar categorías: " + e);
        }
        return categorias;
    }

    public Optional<Categorias> obtenerCategoria(int id) {
        String query = "SELECT * FROM CATEGORIAS WHERE id_categoria = ?";
        Categorias categoria = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var nombre = resultSet.getString("nombre");
                    var descripcion = resultSet.getString("descripcion");
                    categoria = new Categorias(id, nombre, descripcion);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar categoría: " + e);
        }

        return Optional.ofNullable(categoria);
    }
}


    

