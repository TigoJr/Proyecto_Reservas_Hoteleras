/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.facade;

import javax.swing.JOptionPane;
import pe.edu.utp.dao.HabitacionDao;
import pe.edu.utp.dao.ReservaDao;
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.modelo.Reserva;
import pe.edu.utp.state.EstadoReservada;

/**
 *
 * @author USUARIO
 */
public class ReservaFacade {

    private final ReservaDao reservaDao;
    private final HabitacionDao habitacionDao;

    public ReservaFacade(ReservaDao reservaDao, HabitacionDao habitacionDao) {
        this.reservaDao = reservaDao;
        this.habitacionDao = habitacionDao;
    }

    public boolean hacerReserva(Reserva reserva) {
        try {
            boolean insertado = reservaDao.agregar(reserva);

            if (!insertado) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la reserva.");
                return false;
            }

            Habitacion h = habitacionDao.buscarPorId(reserva.getIdHabitacion());
            h.setEstadoActual(new EstadoReservada());
            h.mostrarEstado();
            h.setEstado("Reservado");

            boolean actualizada = habitacionDao.actualizar(h);

            if (!actualizada) {
                JOptionPane.showMessageDialog(null, "Reserva creada, pero no se actualizó la habitación.");
            }

            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el proceso de reserva: " + e.getMessage());
            return false;
        }
    }
}
