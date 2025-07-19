/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.modelo.Habitacion;

/**
 *
 * @author USUARIO
 */
public class HabitacionDao {

    private final Connection conexion;

    public HabitacionDao() {
        conexion = ConexionBD.getInstancia().getConexion();
    }
       
    public boolean existeNumero(int numero) {
        String sql = "SELECT 1 FROM Habitacion WHERE numero = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error al validar número: " + e.getMessage());
            return true;
        }
    }

    public boolean agregar(Habitacion habitacion) {
        if (habitacion.getNumero() <= 0) {
            System.out.println("Número de habitación inválido.");
            return false;
        }

        if (existeNumero(habitacion.getNumero())) {
            System.out.println("❌ Ya existe una habitación con ese número.");
            return false;
        }

        String sql = "INSERT INTO Habitacion (numero, tipo, estado, precio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, habitacion.getNumero());
            ps.setString(2, habitacion.getTipo());
            ps.setString(3, habitacion.getEstado());
            ps.setDouble(4, habitacion.getPrecio());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar habitación: " + e.getMessage());
            return false;
        }
    }

    public List<Habitacion> listarTodas() {
        List<Habitacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Habitacion";
        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Habitacion h = new Habitacion();
                h.setIdHabitacion(rs.getInt("idHabitacion"));
                h.setNumero(rs.getInt("numero"));
                h.setTipo(rs.getString("tipo"));
                h.setEstado(rs.getString("estado"));
                h.setPrecio(rs.getDouble("precio"));
                lista.add(h);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar habitaciones: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizar(Habitacion habitacion) {

        if (habitacion.getNumero() <= 0) {
            System.out.println("Número de habitación inválido.");
            return false;
        }

        if (existeNumero(habitacion.getNumero())) {
            System.out.println("Ya existe una habitación con ese número.");
            return false;
        }

        String sql = "UPDATE Habitacion SET numero=?, tipo=?, estado=?, precio=? WHERE idHabitacion=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, habitacion.getNumero());
            ps.setString(2, habitacion.getTipo());
            ps.setString(3, habitacion.getEstado());
            ps.setDouble(4, habitacion.getPrecio());
            ps.setInt(5, habitacion.getIdHabitacion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar habitación: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idHabitacion) {
        String sql = "DELETE FROM Habitacion WHERE idHabitacion=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idHabitacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar habitación: " + e.getMessage());
            return false;
        }
    }

    public Habitacion buscarPorId(int idHabitacion) {
        String sql = "SELECT * FROM Habitacion WHERE idHabitacion=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idHabitacion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Habitacion(
                        rs.getInt("idHabitacion"),
                        rs.getInt("numero"),
                        rs.getString("tipo"),
                        rs.getString("estado"),
                        rs.getDouble("precio")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar habitación: " + e.getMessage());
        }
        return null;
    }
}
