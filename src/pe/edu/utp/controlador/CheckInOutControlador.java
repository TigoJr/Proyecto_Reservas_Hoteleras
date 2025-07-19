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
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.state.EstadoDisponible;
import pe.edu.utp.state.EstadoOcupado;
import pe.edu.utp.vista.MenuPrincipal;

/**
 *
 * @author USUARIO
 */
public class CheckInOutControlador implements ActionListener {

    private final HabitacionDao habitacionDao;
    private final MenuPrincipal vista;

    public CheckInOutControlador(HabitacionDao habitacionDao, MenuPrincipal vista) {
        this.habitacionDao = habitacionDao;
        this.vista = vista;

        this.vista.btnCheckIn.addActionListener((ActionListener) this);
        this.vista.btnCheckOut.addActionListener(this);
        this.vista.btnRefrescar.addActionListener(this);
        this.vista.cbxHabitacion.addActionListener(this);
        cargarHabitaciones();
    }

    private void cargarHabitaciones() {
        vista.cbxHabitacion.removeAllItems();
        List<Habitacion> lista = habitacionDao.listarTodas();

        for (Habitacion h : lista) {
            if (!h.getEstado().equalsIgnoreCase("Disponible")) {
                vista.cbxHabitacion.addItem(h.getIdHabitacion() + " - Hab. " + h.getNumero() + " (" + h.getEstado() + ")");
            }
        }

        vista.txtEstado.setText("");
        actualizarEstadoActual();
    }

    private void actualizarEstadoActual() {
        if (vista.cbxHabitacion.getSelectedItem() != null) {
            int id = Integer.parseInt(vista.cbxHabitacion.getSelectedItem().toString().split(" - ")[0]);
            Habitacion h = habitacionDao.buscarPorId(id);
            vista.txtEstado.setText(h.getEstado());

            // Habilita o desactiva botones según el estado
            switch (h.getEstado().toLowerCase()) {
                case "reservado" -> {
                    vista.btnCheckIn.setEnabled(true);
                    vista.btnCheckOut.setEnabled(false);
                }
                case "ocupado" -> {
                    vista.btnCheckIn.setEnabled(false);
                    vista.btnCheckOut.setEnabled(true);
                }
                default -> {
                    vista.btnCheckIn.setEnabled(false);
                    vista.btnCheckOut.setEnabled(false);
                }
            }
        }
    }

    private void hacerCheckIn() {
        int id = getHabitacionSeleccionada();
        if (id == -1) {
            return;
        }

        Habitacion h = habitacionDao.buscarPorId(id);

        if (h.getEstado().equalsIgnoreCase("Reservado")) {
            h.setEstadoActual(new EstadoOcupado());
            h.mostrarEstado(); // Imprime mensaje (para consola o logs)
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
        if (id == -1) {
            return;
        }

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
        if (vista.cbxHabitacion.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Selecciona una habitación.");
            return -1;
        }

        return Integer.parseInt(vista.cbxHabitacion.getSelectedItem().toString().split(" - ")[0]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vista.btnRefrescar || fuente == vista.cbxHabitacion) {
            actualizarEstadoActual();
        } else if (fuente == vista.btnCheckIn) {
            hacerCheckIn();
        } else if (fuente == vista.btnCheckOut) {
            hacerCheckOut();
        }
    }
}
