/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.dao.ClienteDAO;
import pe.edu.utp.dao.HabitacionDAO;
import pe.edu.utp.dao.ReservaDAO;
import pe.edu.utp.facade.ReservaFacade;
import pe.edu.utp.factory.EstadoReservaFactory;
import pe.edu.utp.modelo.Cliente;
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.modelo.Reserva;
import pe.edu.utp.state.EstadoReserva;
import pe.edu.utp.vista.PrincipalVista;

/**
 *
 * @author USUARIO
 */
public class ReservaControlador implements ActionListener {

    private final PrincipalVista vista;
    private final ClienteDAO clienteDao;
    private final HabitacionDAO habitacionDao;
    private final ReservaDAO reservaDao;

    public ReservaControlador(PrincipalVista vista, ClienteDAO clienteDao, HabitacionDAO habitacionDao, ReservaDAO reservaDao) {
        this.vista = vista;
        this.clienteDao = clienteDao;
        this.habitacionDao = habitacionDao;
        this.reservaDao = reservaDao;

        agregarEventos();

        cargarClientes();
        cargarHabitacionesDisponibles();
        cargarReservasEnTabla();
        vista.getTxtEstadoPR().setText("Confirmada");
    }

    private void agregarEventos() {
        vista.getBtnReservarPR().addActionListener(this);
        vista.getBtnLimpiarPR().addActionListener(this);
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
            if (h.getEstadoActual().getNombreEstado().equalsIgnoreCase("Disponible")) {
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
                r.getEstadoActual().getNombreEstado()
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
            java.sql.Date fechaReservaHoy = java.sql.Date.valueOf(LocalDate.now());

            if (fechaInicio.before(fechaReservaHoy)) {
                JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser anterior a hoy.");
                return;
            }

            if (!fechaFin.after(fechaInicio)) {
                JOptionPane.showMessageDialog(null, "La fecha de fin debe ser posterior a la fecha de inicio.");
                return;
            }

            String estadoReserva = vista.getTxtEstadoPR().getText().trim();

            Reserva r = new Reserva();
            r.setIdCliente(idCliente);
            r.setIdHabitacion(idHabitacion);
            r.setFechaInicio(fechaInicio);
            r.setFechaFin(fechaFin);

            EstadoReserva estado = EstadoReservaFactory.crearEstado(estadoReserva);
            r.setEstadoActual(estado);
            r.setFechaReserva(fechaReservaHoy);
            System.out.println("[Controlador] Fecha reserva seteada: " + fechaReservaHoy);

            ReservaFacade facade = new ReservaFacade(reservaDao, habitacionDao);
            boolean exito = facade.hacerReserva(r);

            if (exito) {
                JOptionPane.showMessageDialog(null, "Reserva procesada correctamente.");
                cargarReservasEnTabla();
                limpiarCampos();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Verifica los datos ingresados: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
