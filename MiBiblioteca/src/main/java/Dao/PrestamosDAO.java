
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.Bibliotecas;
import Modelo.DetallesLibros;
import Modelo.Libros;
import Modelo.Prestamos;
import Modelo.Recepcionista;
import Modelo.UsuarioFinal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PrestamosDAO {
    private Connection conexion;

    public PrestamosDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(Prestamos prestamo) {
        String query = "INSERT INTO PRESTAMOS (id_biblioteca, id_recepcionista, id_usuarioFinal, ISBN, fecha, estado, multa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, prestamo.getId_biblioteca().getId_biblioteca());
            preparedStatement.setInt(2, prestamo.getId_recepcionista().getId_recepcionista());
            preparedStatement.setInt(3, prestamo.getId_usuarioFinal().getIdUsuario());
            preparedStatement.setString(4, prestamo.getISBN().getISBN());
            preparedStatement.setDate(5, new java.sql.Date(prestamo.getFecha().getTime()));
            preparedStatement.setBoolean(6, prestamo.isEstado());
            preparedStatement.setDouble(7, prestamo.getMulta());
            preparedStatement.executeUpdate();
            System.out.println("Préstamo creado");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear préstamo: " + e);
        }
        return false;
    }

    public void actualizar(Prestamos prestamo) {
        String query = "UPDATE PRESTAMOS SET id_biblioteca = ?, id_recepcionista = ?, id_usuarioFinal = ?, ISBN = ?, fecha = ?, estado = ?, multa = ? WHERE id_prestamos = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, prestamo.getId_biblioteca().getId_biblioteca());
            preparedStatement.setInt(2, prestamo.getId_recepcionista().getId_recepcionista());
            preparedStatement.setInt(3, prestamo.getId_usuarioFinal().getIdUsuario());
            preparedStatement.setString(4, prestamo.getISBN().getISBN());
            preparedStatement.setDate(5, new java.sql.Date(prestamo.getFecha().getTime()));
            preparedStatement.setBoolean(6, prestamo.isEstado());
            preparedStatement.setDouble(7, prestamo.getMulta());
            preparedStatement.setInt(8, prestamo.getId_prestamos());
            preparedStatement.executeUpdate();
            System.out.println("Préstamo actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar préstamo: " + e);
        }
    }

    public void eliminar(int id_prestamo) {
        String query = "DELETE FROM PRESTAMOS WHERE id_prestamos = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_prestamo);
            preparedStatement.executeUpdate();
            System.out.println("Préstamo eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar préstamo: " + e);
        }
    }

    public List<Prestamos> listar() {
        var prestamosList = new ArrayList<Prestamos>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM PRESTAMOS")) {

            while (resultSet.next()) {
                var id_prestamos = resultSet.getInt("id_prestamos");
                var id_biblioteca = resultSet.getInt("id_biblioteca");
                var id_recepcionista = resultSet.getInt("id_recepcionista");
                var id_usuarioFinal = resultSet.getInt("id_usuarioFinal");
                var ISBN = resultSet.getString("ISBN");
                var fecha = resultSet.getDate("fecha");
                var estado = resultSet.getBoolean("estado");
                var multa = resultSet.getDouble("multa");

                Bibliotecas bibliotecas = obtenerBibliotecaPorId(id_biblioteca);
                Recepcionista recepcionista = obtenerRecepcionistaPorId(id_recepcionista);
                UsuarioFinal usuarioFinal = obtenerUsuarioFinalPorId(id_usuarioFinal);
                Libros libros = obtenerLibroPorISBN(ISBN);

                var detallesLibros = obtenerDetallesLibrosPorPrestamo(id_prestamos);

                var prestamo = new Prestamos(id_prestamos, bibliotecas, recepcionista, usuarioFinal, libros, fecha, estado, multa, detallesLibros);
                prestamosList.add(prestamo);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar préstamos: " + e);
        }
        return prestamosList;
    }

    public Optional<Prestamos> obtenerPrestamo(int id_prestamo) {
        String query = "SELECT * FROM PRESTAMOS WHERE id_prestamos = ?";
        Prestamos prestamo = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_prestamo);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var id_biblioteca = resultSet.getInt("id_biblioteca");
                    var id_recepcionista = resultSet.getInt("id_recepcionista");
                    var id_usuarioFinal = resultSet.getInt("id_usuarioFinal");
                    var ISBN = resultSet.getString("ISBN");
                    var fecha = resultSet.getDate("fecha");
                    var estado = resultSet.getBoolean("estado");
                    var multa = resultSet.getDouble("multa");

                    Bibliotecas bibliotecas = obtenerBibliotecaPorId(id_biblioteca);
                    Recepcionista recepcionista = obtenerRecepcionistaPorId(id_recepcionista);
                    UsuarioFinal usuarioFinal = obtenerUsuarioFinalPorId(id_usuarioFinal);
                    Libros libros = obtenerLibroPorISBN(ISBN);

                    var detallesLibros = obtenerDetallesLibrosPorPrestamo(id_prestamo);

                    prestamo = new Prestamos(id_prestamo, bibliotecas, recepcionista, usuarioFinal, libros, fecha, estado, multa, detallesLibros);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar préstamo: " + e);
        }

        return Optional.ofNullable(prestamo);
    }

    // Método para obtener un objeto Bibliotecas por su ID
    private Bibliotecas obtenerBibliotecaPorId(int id_biblioteca) {
        // Debes implementar este método o usar la clase BibliotecasDB para obtener el objeto
        // Bibliotecas por su ID.
        // Ejemplo: BibliotecasDB bibliotecasDB = new BibliotecasDB(conexion);
        // return bibliotecasDB.obtenerBibliotecaPorId(id_biblioteca);
        return null; // Implementa la lógica adecuada aquí.
    }

    // Método para obtener un objeto Recepcionista por su ID
    private Recepcionista obtenerRecepcionistaPorId(int id_recepcionista) {
        // Debes implementar este método o usar la clase RecepcionistaDB para obtener el objeto
        // Recepcionista por su ID.
        // Ejemplo: RecepcionistaDB recepcionistaDB = new RecepcionistaDB(conexion);
        // return recepcionistaDB.obtenerRecepcionistaPorId(id_recepcionista);
        return null; // Implementa la lógica adecuada aquí.
    }

    // Método para obtener un objeto UsuarioFinal por su ID
    private UsuarioFinal obtenerUsuarioFinalPorId(int id_usuarioFinal) {
        // Debes implementar este método o usar la clase UsuarioFinalDB para obtener el objeto
        // UsuarioFinal por su ID.
        // Ejemplo: UsuarioFinalDB usuarioFinalDB = new UsuarioFinalDB(conexion);
        // return usuarioFinalDB.obtenerUsuarioFinalPorId(id_usuarioFinal);
        return null; // Implementa la lógica adecuada aquí.
    }

    // Método para obtener un objeto Libros por su ISBN
    private Libros obtenerLibroPorISBN(String ISBN) {
        // Debes implementar este método o usar la clase LibrosDB para obtener el objeto
        // Libros por su ISBN.
        // Ejemplo: LibrosDB librosDB = new LibrosDB(conexion);
        // return librosDB.obtenerLibroPorISBN(ISBN);
        return null; // Implementa la lógica adecuada aquí.
    }

    // Método para obtener los detalles de libros por ID de préstamo
    private List<DetallesLibros> obtenerDetallesLibrosPorPrestamo(int id_prestamo) {
        // Debes implementar este método o usar la clase DetallesLibrosDB para obtener la lista de
        // detalles de libros por ID de préstamo.
        // Ejemplo: DetallesLibrosDB detallesLibrosDB = new DetallesLibrosDB(conexion);
        // return detallesLibrosDB.obtenerDetallesLibrosPorPrestamo(id_prestamo);
        return new ArrayList<>(); // Implementa la lógica adecuada aquí.
    }
}

