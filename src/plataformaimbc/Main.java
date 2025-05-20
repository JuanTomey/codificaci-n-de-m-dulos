/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plataformaimbc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // Insertar nuevo usuario
        dao.insertarUsuario(1, 1, "Sildana Lucia", "abc123", "admin", "activo");

        // Consultar todos los usuarios
        List<String> usuarios = dao.obtenerUsuarios();
        System.out.println("👥 Lista de usuarios:");
        for (String usuario : usuarios) {
            System.out.println(usuario);
        }

        // Actualizar usuario
        dao.actualizarUsuario(1, 1, "Sildana L. Chacon", "abc456", "admin", "activo");

        // Eliminar usuario
        dao.eliminarUsuario(1);
    }
}
