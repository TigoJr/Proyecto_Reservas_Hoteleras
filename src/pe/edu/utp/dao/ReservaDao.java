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
import pe.edu.utp.modelo.Reserva;

/**
 *
 * @author USUARIO
 */
public class ReservaDao {

    private final Connection conexion;

    public ReservaDao() {
        conexion = ConexionBD.getInstancia().getConexion();
    }

    public boolean agregar(Reserva reserva) {
        String sql = "INSERT INTO Reservas (idCliente, idHabitacion, fechaDEinicio, fechaDEfin, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdCliente());
            ps.setInt(2, reserva.getIdHabitacion());
            ps.setDate(3, new java.sql.Date(reserva.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(reserva.getFechaFin().getTime()));
            ps.setString(5, reserva.getEstado());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar reserva: " + e.getMessage());
            return false;
        }
    }

    public List<Reserva> listarTodas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM Reservas";
        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Reserva r = new Reserva();
                r.setIdReserva(rs.getInt("idReservas"));
                r.setIdCliente(rs.getInt("idCliente"));
                r.setIdHabitacion(rs.getInt("idHabitacion"));
                r.setFechaInicio(rs.getDate("fechaDEinicio"));
                r.setFechaFin(rs.getDate("fechaDEfin"));
                r.setEstado(rs.getString("estado"));
                lista.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar reservas: " + e.getMessage());
        }
        return lista;
    }
}
