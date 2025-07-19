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
import pe.edu.utp.modelo.Pago;

/**
 *
 * @author USUARIO
 */
public class PagoDao {

    private final Connection conexion;

    public PagoDao() {
        conexion = ConexionBD.getInstancia().getConexion();
    }

    public boolean agregar(Pago pago) {
        String sql = "INSERT INTO Pago (idReserva, monto, fecha, metodoP) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, pago.getIdReserva());
            ps.setDouble(2, pago.getMonto());
            ps.setDate(3, new java.sql.Date(pago.getFecha().getTime()));
            ps.setString(4, pago.getMetodoP());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar pago: " + e.getMessage());
            return false;
        }
    }

    public List<Pago> listarTodos() {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pago";
        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Pago p = new Pago();
                p.setIdPago(rs.getInt("idPago"));
                p.setIdReserva(rs.getInt("idReserva"));
                p.setMonto(rs.getDouble("monto"));
                p.setFecha(rs.getDate("fecha"));
                p.setMetodoP(rs.getString("metodoP"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pagos: " + e.getMessage());
        }
        return lista;
    }
}
