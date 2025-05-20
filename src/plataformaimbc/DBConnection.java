/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plataformaimbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Juan Manuel Cubides
 */
public class DBConnection {
    static String url="jdbc:mysql://localhost:3306/colegio";
    static String user="root";
    static String pass="Manuel14";
    
    public static Connection conectar()
    {
        Connection conn=null;
        try
        {
        conn=DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion Exitosa");
        } catch(SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
