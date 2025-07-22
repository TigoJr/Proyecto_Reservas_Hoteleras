/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import pe.edu.utp.dao.HabitacionDao;
import pe.edu.utp.dao.ReservaDao;
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.modelo.Reserva;
import pe.edu.utp.state.EstadoDisponible;
import pe.edu.utp.state.EstadoOcupado;
import pe.edu.utp.vista.PrincipalVista;

/**
 *
 * @author USUARIO
 */
public class CheckInOutControlador implements ActionListener {

    private final HabitacionDao habitacionDao;
    private final PrincipalVista vista;

    public CheckInOutControlador(HabitacionDao habitacionDao, PrincipalVista vista) {
        this.habitacionDao = habitacionDao;
        this.vista = vista;
                
        agregarEventos();
        cargarHabitaciones();
    }
    
    private void agregarEventos() {
        vista.getBtnCheckIn().addActionListener(this);
        vista.getBtnCheckOut().addActionListener(this);
        vista.getBtnRefrescarPC().addActionListener(this);
        vista.getCbxHabitacionPCK().addActionListener(this);
    }

    private void cargarHabitaciones() {
        vista.getCbxHabitacionPCK().removeAllItems();
        List<Reserva> reservasPagadas = new ReservaDao().listarReservasPagadas();

        for (Reserva r : reservasPagadas) {
            Habitacion h = habitacionDao.buscarPorId(r.getIdHabitacion());
            if (!h.getEstado().equalsIgnoreCase("Disponible")) {
                String texto = h.getIdHabitacion() + " - Hab. " + h.getNumero() + " (" + h.getEstado() + ")";
                vista.getCbxHabitacionPCK().addItem(texto);
            }
        }

        vista.getTxtEstadoPCK().setText("");
        actualizarEstadoActual();
    }

    private void actualizarEstadoActual() {
        if (vista.getCbxHabitacionPCK().getSelectedItem() != null) {
            int id = Integer.parseInt(
                vista.getCbxHabitacionPCK().getSelectedItem().toString().split(" - ")[0]
            );
            Habitacion h = habitacionDao.buscarPorId(id);
            vista.getTxtEstadoPCK().setText(h.getEstado());

            switch (h.getEstado().toLowerCase()) {
                case "reservado" -> {
                    vista.getBtnCheckIn().setEnabled(true);
                    vista.getBtnCheckOut().setEnabled(false);
                }
                case "ocupado" -> {
                    vista.getBtnCheckIn().setEnabled(false);
                    vista.getBtnCheckOut().setEnabled(true);
                }
                default -> {
                    vista.getBtnCheckIn().setEnabled(false);
                    vista.getBtnCheckOut().setEnabled(false);
                }
            }
        }
    }

    private void hacerCheckIn() {
        int id = getHabitacionSeleccionada();
        if (id == -1) return;

        Habitacion h = habitacionDao.buscarPorId(id);
        if (h.getEstado().equalsIgnoreCase("Reservado")) {
            h.setEstadoActual(new EstadoOcupado());
            h.mostrarEstado();
            h.setEstado("Ocupado");
            habitacionDao.actualizar(h);

            JOptionPane.showMessageDialog(null, "Check-In realizado. Habitación ahora está OCUPADA.");
            cargarHabitaciones();
        } else {
            JOptionPane.showMessageDialog(null, "Esta habitación no está reservada.");
        }
    }

    private void hacerCheckOut() {
        int id = getHabitacionSeleccionada();
        if (id == -1) return;

        Habitacion h = habitacionDao.buscarPorId(id);
        if (h.getEstado().equalsIgnoreCase("Ocupado")) {
            h.setEstadoActual(new EstadoDisponible());
            h.mostrarEstado();
            h.setEstado("Disponible");
            habitacionDao.actualizar(h);

            JOptionPane.showMessageDialog(null, "Check-Out realizado. Habitación ahora está DISPONIBLE.");
            cargarHabitaciones();
        } else {
            JOptionPane.showMessageDialog(null, "Esta habitación no está ocupada.");
        }
    }

    private int getHabitacionSeleccionada() {
        if (vista.getCbxHabitacionPCK().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Selecciona una habitación.");
            return -1;
        }

        return Integer.parseInt(
            vista.getCbxHabitacionPCK().getSelectedItem().toString().split(" - ")[0]
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vista.getBtnRefrescarPC() || fuente == vista.getCbxHabitacionPCK()) {
            actualizarEstadoActual();
        } else if (fuente == vista.getBtnCheckIn()) {
            hacerCheckIn();
        } else if (fuente == vista.getBtnCheckOut()) {
            hacerCheckOut();
        }
    }
}

