/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.dao.PagoDao;
import pe.edu.utp.dao.ReservaDao;
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
    private final PagoDao pagoDao;
    private final ReservaDao reservaDao;
    private final PagoObservable observable = new PagoObservable();

    public PagoControlador(PrincipalVista vista, PagoDao pagoDao, ReservaDao reservaDao) {
        this.vista = vista;
        this.pagoDao = pagoDao;
        this.reservaDao = reservaDao;

        cargarReservas();
        cargarPagos();

        observable.agregarObservador(new VistaPagoObservable());
        observable.agregarObservador(new ArchivoPagoObserver());
    }

    private void cargarReservas() {
        vista.getCbxReservaPP().removeAllItems();
        List<Reserva> reservas = reservaDao.listarTodas();

        for (Reserva r : reservas) {
            vista.getCbxReservaPP().addItem(
                r.getIdReserva() + " - Cliente " + r.getIdCliente() + " | Hab. " + r.getIdHabitacion()
            );
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
                p.getMetodoP()
            });
        }
    }

    private void limpiar() {
        vista.getTxtMontoPP().setText("");
        vista.getTxtFechaPP().setText("");
        vista.getCbxMetodoPP().setSelectedIndex(0);
        cargarReservas();
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
            pago.setMetodoP(metodo);

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
}

