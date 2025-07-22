/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.dao.HabitacionDAO;
import pe.edu.utp.dao.PagoDAO;
import pe.edu.utp.dao.ReservaDAO;
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.modelo.Pago;
import pe.edu.utp.modelo.Reserva;
import pe.edu.utp.observer.ArchivoPagoObserver;
import pe.edu.utp.observer.PagoObservable;
import pe.edu.utp.observer.VistaPagoObservable;
import pe.edu.utp.vista.PrincipalVista;

/**
 *
 * @author USUARIO
 */
public class PagoControlador implements ActionListener {

    private final PrincipalVista vista;
    private final PagoDAO pagoDao;
    private final ReservaDAO reservaDao;
    private final HabitacionDAO habitacionDao;
    private final PagoObservable observable = new PagoObservable();
    private boolean bloqueado = false;

    public PagoControlador(PrincipalVista vista, PagoDAO pagoDao, ReservaDAO reservaDao, HabitacionDAO habitacionDao) {
        this.vista = vista;
        this.pagoDao = pagoDao;
        this.reservaDao = reservaDao;
        this.habitacionDao = habitacionDao;

        agregarEventos();
        cargarReservas();
        cargarPagos();

        observable.agregarObservador(new VistaPagoObservable());
        observable.agregarObservador(new ArchivoPagoObserver());

        if (vista.getCbxReservaPP().getItemCount() > 0) {
            vista.getCbxReservaPP().setSelectedIndex(0);
        }

    }

    private void agregarEventos() {
        vista.getBtnRegistrarPP().addActionListener(this);
        vista.getBtnLimpiarPP().addActionListener(this);
        vista.getCbxReservaPP().addItemListener(e -> {
            if (!bloqueado && e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                autocompletarFechaYMonto();
            }
        });
    }

    private void cargarReservas() {
        vista.getCbxReservaPP().removeAllItems();
        List<Reserva> reservas = reservaDao.listarTodas();

        boolean alMenosUna = false;

        for (Reserva r : reservas) {
            if (!pagoDao.existePagoParaReserva(r.getIdReserva())) {
                String nombreCliente = reservaDao.obtenerNombreClientePorId(r.getIdCliente());
                int numHabitacion = reservaDao.obtenerNumeroHabitacion(r.getIdHabitacion());
                String txtCombo = r.getIdReserva() + " - " + nombreCliente + " | Hab. " + numHabitacion;
                vista.getCbxReservaPP().addItem(txtCombo);
                alMenosUna = true;
            }
        }

        bloqueado = false;

        if (alMenosUna) {
            vista.getCbxReservaPP().setSelectedIndex(-1);
            vista.getCbxReservaPP().setSelectedIndex(0);
        }
    }

    private void cargarPagos() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaPagos().getModel();
        modelo.setRowCount(0);

        List<Pago> lista = pagoDao.listarTodos();
        for (Pago p : lista) {
            modelo.addRow(new Object[]{
                p.getIdPago(),
                p.getIdReserva(),
                p.getMonto(),
                p.getFecha(),
                p.getMetodoPago()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vista.getBtnRegistrarPP()) {
            registrarPago();
        } else if (fuente == vista.getBtnLimpiarPP()) {
            limpiar();
        }
    }

    private void limpiar() {
        vista.getTxtMontoPP().setText("");
        vista.getTxtFechaPP().setText("");
        vista.getCbxMetodoPP().setSelectedIndex(0);
        cargarReservas();
    }

    private void registrarPago() {
        try {
            int idReserva = Integer.parseInt(
                    vista.getCbxReservaPP().getSelectedItem().toString().split(" - ")[0]
            );
            double monto = Double.parseDouble(vista.getTxtMontoPP().getText().trim());
            Date fecha = Date.valueOf(vista.getTxtFechaPP().getText().trim());
            String metodo = vista.getCbxMetodoPP().getSelectedItem().toString();

            Pago pago = new Pago();
            pago.setIdReserva(idReserva);
            pago.setMonto(monto);
            pago.setFecha(fecha);
            pago.setMetodoPago(metodo);

            if (pagoDao.agregar(pago)) {
                JOptionPane.showMessageDialog(null, "Pago registrado correctamente.");
                observable.notificarObservadores(pago);
                cargarPagos();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el pago.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Verifica los datos: " + ex.getMessage());
        }
    }

    private void autocompletarFechaYMonto() {
        try {
            int idReserva = Integer.parseInt(vista.getCbxReservaPP().getSelectedItem().toString().split(" - ")[0]);
            Reserva r = reservaDao.buscarPorId(idReserva);

            if (r == null) {
                System.err.println("Reserva no encontrada.");
                return;
            }
            Habitacion h = habitacionDao.buscarPorId(r.getIdHabitacion());

            if (h == null) {
                System.err.println("No se encontró la habitación en la BD.");
                return;
            }

            if (r.getFechaInicio() == null || r.getFechaFin() == null || r.getFechaReserva() == null) {
                System.out.println("Alguna de las fechas está vacia");
                if (r.getFechaInicio() == null) {
                    System.err.println(" - Inicio: " + r.getFechaInicio());
                }
                if (r.getFechaFin() == null) {
                    System.err.println(" - Fin: " + r.getFechaFin());
                }
                if (r.getFechaReserva() == null) {
                    System.err.println(" - Reserva: " + r.getFechaReserva());
                }
                return;
            }
            LocalDate fechaInicio = ((java.sql.Date) r.getFechaInicio()).toLocalDate();
            LocalDate fechaFin = ((java.sql.Date) r.getFechaFin()).toLocalDate();

            long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
            if (dias <= 0) {
                dias = 1;
            }

            double monto = dias * h.getPrecio();

            vista.getTxtFechaPP().setText(r.getFechaReserva().toString());
            vista.getTxtFechaPP().setEditable(false);

            vista.getTxtMontoPP().setText(String.format("%.2f", monto));

        } catch (Exception ex) {
            System.err.println("Error al autocompletar fecha y monto: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
