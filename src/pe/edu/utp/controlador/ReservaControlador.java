/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.dao.ClienteDao;
import pe.edu.utp.dao.HabitacionDao;
import pe.edu.utp.dao.ReservaDao;
import pe.edu.utp.facade.ReservaFacade;
import pe.edu.utp.modelo.Cliente;
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.modelo.Reserva;
import pe.edu.utp.vista.PrincipalVista;

/**
 *
 * @author USUARIO
 */
public class ReservaControlador implements ActionListener {

    private final PrincipalVista vista;
    private final ClienteDao clienteDao;
    private final HabitacionDao habitacionDao;
    private final ReservaDao reservaDao;

    public ReservaControlador(PrincipalVista vista, ClienteDao clienteDao, HabitacionDao habitacionDao, ReservaDao reservaDao) {
        this.vista = vista;
        this.clienteDao = clienteDao;
        this.habitacionDao = habitacionDao;
        this.reservaDao = reservaDao;

        cargarClientes();
        cargarHabitacionesDisponibles();
        cargarReservasEnTabla();
        vista.getTxtEstadoPR().setText("Confirmada");
    }

    private void cargarClientes() {
        List<Cliente> clientes = clienteDao.listarTodos();
        vista.getCbxClientePR().removeAllItems();
        for (Cliente c : clientes) {
            vista.getCbxClientePR().addItem(c.getIdCliente() + " - " + c.getNombre());
        }
    }

    private void cargarHabitacionesDisponibles() {
        List<Habitacion> habitaciones = habitacionDao.listarTodas();
        vista.getCbxHabitacionPR().removeAllItems();
        for (Habitacion h : habitaciones) {
            if (h.getEstado().equalsIgnoreCase("Disponible")) {
                vista.getCbxHabitacionPR().addItem(h.getIdHabitacion() + " - Hab. " + h.getNumero());
            }
        }
    }

    private void cargarReservasEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaReservas().getModel();
        modelo.setRowCount(0);

        List<Reserva> reservas = reservaDao.listarTodas();
        for (Reserva r : reservas) {
            modelo.addRow(new Object[]{
                r.getIdReserva(),
                r.getIdCliente(),
                r.getIdHabitacion(),
                r.getFechaInicio(),
                r.getFechaFin(),
                r.getEstado()
            });
        }
    }

    private void limpiarCampos() {
        vista.getTxtEstadoPR().setText("Confirmada");
        vista.getTxtFechaFinPR().setText("");
        vista.getTxtFechaInicioPR().setText("");
        cargarHabitacionesDisponibles();
        cargarClientes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnReservarPR()) {
            registrarReserva();
        } else if (e.getSource() == vista.getBtnLimpiarPR()) {
            limpiarCampos();
        }
    }

    private void registrarReserva() {
        try {
            int idCliente = Integer.parseInt(vista.getCbxClientePR().getSelectedItem().toString().split(" - ")[0]);
            int idHabitacion = Integer.parseInt(vista.getCbxHabitacionPR().getSelectedItem().toString().split(" - ")[0]);

            Date fechaInicio = java.sql.Date.valueOf(vista.getTxtFechaInicioPR().getText().trim());
            Date fechaFin = java.sql.Date.valueOf(vista.getTxtFechaFinPR().getText().trim());
            String estadoReserva = vista.getTxtEstadoPR().getText().trim();

            Reserva r = new Reserva();
            r.setIdCliente(idCliente);
            r.setIdHabitacion(idHabitacion);
            r.setFechaInicio(fechaInicio);
            r.setFechaFin(fechaFin);
            r.setEstado(estadoReserva);

            ReservaFacade facade = new ReservaFacade(reservaDao, habitacionDao);
            boolean exito = facade.hacerReserva(r);

            if (exito) {
                JOptionPane.showMessageDialog(null, "Reserva procesada correctamente.");
                cargarReservasEnTabla();
                limpiarCampos();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Verifica los datos ingresados: " + ex.getMessage());
        }
    }
}

