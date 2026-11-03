/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;

public class LibroDAO {

    public List<Libro> listar() {

        List<Libro> lista = new ArrayList<>();

        try {

            Connection con = Conexion.getConnection();
            
            if (con == null) {
               System.out.println("LA CONEXION ES NULL");
               return lista;
            }
            String sql = "SELECT * FROM libros";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            System.out.println("Consulta ejecutada");
            while (rs.next()) {
            System.out.println(
        "Libro encontrado: "
        + rs.getString("titulo")
            );
    Libro libro = new Libro();

    libro.setId(rs.getInt("id"));
    libro.setTitulo(rs.getString("titulo"));
    libro.setAutor(rs.getString("autor"));
    libro.setDescripcion(rs.getString("descripcion"));
    libro.setImagen(rs.getString("imagen"));

    lista.add(libro);
}

        } catch (SQLException e) {
        }
        System.out.println("Total libros: " + lista.size()
        );
        return lista;
    }

    public void eliminar(int id) {
        String sql =
            "DELETE FROM libros WHERE id=?";

        try (
             Connection con = Conexion.getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)
         ) {

            ps.setInt(1, id);
            ps.executeUpdate();

         } catch (Exception e) {
         }
}

    public void insertar(Libro libro) {

        String sql =
           "INSERT INTO libros(titulo, autor, descripcion, imagen) VALUES (?, ?, ?, ?)";

        try (
             Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
          ) {

             ps.setString(1, libro.getTitulo());
             ps.setString(2, libro.getAutor());
             ps.setString(3, libro.getDescripcion());
             ps.setString(4, libro.getImagen());

             ps.executeUpdate();

          } catch (Exception e) {
              e.printStackTrace();
          }
    }
    public void actualizar(Libro libro) {

        String sql =
           "UPDATE libros SET titulo=?, autor=?, descripcion=?, imagen=? WHERE id=?";

        try (
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getDescripcion());
            ps.setString(4, libro.getImagen());
            ps.setInt(5, libro.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
}  
    
    public Libro buscarPorId(int id) {

    Libro libro = null;

    String sql = "SELECT * FROM libros WHERE id=?";

    try (
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            libro = new Libro();

            libro.setId(rs.getInt("id"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(rs.getString("autor"));
            libro.setDescripcion(rs.getString("descripcion"));
            libro.setImagen(rs.getString("imagen"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return libro;
}
}