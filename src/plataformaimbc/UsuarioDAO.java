/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plataformaimbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // INSERTAR
    public void insertarUsuario(int idUsuario, int idCurso, String nombre, String contrasena, String rol, String estado) {
        String sql = "INSERT INTO usuario (id_Usuario, id_Curso_Usuario, nom_Usuario, contrasena, rol, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idCurso);
            pstmt.setString(3, nombre);
            pstmt.setString(4, contrasena);
            pstmt.setString(5, rol);
            pstmt.setString(6, estado);
            pstmt.executeUpdate();

            System.out.println("✅ Usuario insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar usuario:");
            e.printStackTrace();
        }
    }

    // CONSULTAR
    public List<String> obtenerUsuarios() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = DBConnection.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String usuario = "ID: " + rs.getInt("id_Usuario") +
                        ", Curso: " + rs.getInt("id_Curso_Usuario") +
                        ", Nombre: " + rs.getString("nom_Usuario") +
                        ", Rol: " + rs.getString("rol") +
                        ", Estado: " + rs.getString("estado");
                lista.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar usuarios:");
            e.printStackTrace();
        }
        return lista;
    }

    // ACTUALIZAR
    public void actualizarUsuario(int idUsuario, int idCurso, String nombre, String contrasena, String rol, String estado) {
        String sql = "UPDATE usuario SET id_Curso_Usuario = ?, nom_Usuario = ?, contrasena = ?, rol = ?, estado = ? WHERE id_Usuario = ?";

        try (Connection conn = DBConnection.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCurso);
            pstmt.setString(2, nombre);
            pstmt.setString(3, contrasena);
            pstmt.setString(4, rol);
            pstmt.setString(5, estado);
            pstmt.setInt(6, idUsuario);
            pstmt.executeUpdate();

            System.out.println("✅ Usuario actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar usuario:");
            e.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE id_Usuario = ?";

        try (Connection conn = DBConnection.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            pstmt.executeUpdate();

            System.out.println("✅ Usuario eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar usuario:");
            e.printStackTrace();
        }
    }
}

