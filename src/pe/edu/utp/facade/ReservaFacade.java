/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.facade;

import pe.edu.utp.dao.HabitacionDAO;
import pe.edu.utp.dao.ReservaDAO;
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.modelo.Reserva;
import pe.edu.utp.state.EstadoOcupada;

public class ReservaFacade {

    private final ReservaDAO reservaDao;
    private final HabitacionDAO habitacionDao;

    public ReservaFacade(ReservaDAO reservaDao, HabitacionDAO habitacionDao) {
        this.reservaDao = reservaDao;
        this.habitacionDao = habitacionDao;
    }

    /**
     * Realiza la reserva y actualiza el estado de la habitación.
     * Devuelve true si ambos procesos fueron exitosos.
     */
    public boolean hacerReserva(Reserva reserva) {
        try {
            boolean insertado = reservaDao.agregar(reserva);
            if (!insertado) return false;

            Habitacion habitacion = habitacionDao.buscarPorId(reserva.getIdHabitacion());
            if (habitacion == null) return false;

            habitacion.setEstadoActual(new EstadoOcupada());

            return habitacionDao.actualizar(habitacion);

        } catch (Exception e) {
            System.err.println("Error en hacerReserva(): " + e.getMessage());
            return false;
        }
    }
}
