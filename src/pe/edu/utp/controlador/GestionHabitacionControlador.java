/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.dao.HabitacionDAO;
import pe.edu.utp.factory.EstadoHabitacionFactory;
import pe.edu.utp.factory.HabitacionFactory;
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.state.EstadoHabitacion;
import pe.edu.utp.vista.PrincipalVista;

/**
 *
 * @author USUARIO
 */
public class GestionHabitacionControlador implements ActionListener, MouseListener {

    private final HabitacionDAO dao;
    private final PrincipalVista vista;
    private Habitacion habitacionSeleccionada;

    public GestionHabitacionControlador(HabitacionDAO dao, PrincipalVista vista) {
        this.dao = dao;
        this.vista = vista;

        agregarEventos();
        cargarTablaHabitaciones();
    }

    private void agregarEventos() {
        vista.getBtnGuardarPH().addActionListener(this);
        vista.getBtnModificarPH().addActionListener(this);
        vista.getBtnEliminarPH().addActionListener(this);
        vista.getBtnBuscarPH().addActionListener(this);
        vista.getBtnLimpiarPH().addActionListener(this);
        vista.getBtnRefrescarPH().addActionListener(this);
        vista.getTablaHabitaciones().addMouseListener(this);
        vista.getCbxTipoPH().addActionListener(this);
    }

    private void cargarTablaHabitaciones() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTablaHabitaciones().getModel();
        modeloTabla.setRowCount(0);

        List<Habitacion> lista = dao.listarTodas();
        for (Habitacion h : lista) {
            modeloTabla.addRow(new Object[]{
                h.getIdHabitacion(),
                h.getNumero(),
                h.getTipo(),
                h.getEstadoActual().getNombreEstado(),
                h.getPrecio()
            });
        }
    }

    private void limpiarCampos() {
        vista.getTxtIdPH().setText("");
        vista.getTxtNumeroPH().setText("");
        vista.getCbxTipoPH().setSelectedIndex(0);
        vista.getCbxEstadoPH().setSelectedIndex(0);
        vista.getTxtPrecioPH().setText("");
        habitacionSeleccionada = null;
    }

    private void actualizarPrecioPorTipo() {
        String tipo = vista.getCbxTipoPH().getSelectedItem().toString();
        Habitacion temp = HabitacionFactory.crearHabitacion(tipo);
        vista.getTxtPrecioPH().setText(String.valueOf(temp.getPrecio()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vista.getBtnGuardarPH()) {
            guardarHabitacion();
        } else if (fuente == vista.getBtnModificarPH()) {
            modificarHabitacion();
        } else if (fuente == vista.getBtnEliminarPH()) {
            eliminarHabitacion();
        } else if (fuente == vista.getBtnBuscarPH()) {
            buscarHabitacionPorNumero();
        } else if (fuente == vista.getBtnLimpiarPH()) {
            limpiarCampos();
        } else if (fuente == vista.getBtnRefrescarPH()) {
            cargarTablaHabitaciones();
        } else if (fuente == vista.getCbxTipoPH()) {
            actualizarPrecioPorTipo();
        }
    }

    private void guardarHabitacion() {
        try {
            String tipo = vista.getCbxTipoPH().getSelectedItem().toString();
            Habitacion h = HabitacionFactory.crearHabitacion(tipo);

            h.setNumero(Integer.parseInt(vista.getTxtNumeroPH().getText()));
            // h.setPrecio(Double.parseDouble(vista.txtPrecio.getText())); // o dejar el precio por defecto de la fábrica

            if (dao.agregar(h)) {
                JOptionPane.showMessageDialog(null, "Habitación registrada con Factory.");
                cargarTablaHabitaciones();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar habitación.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Verifica los campos numéricos.");
        }
    }

    private void modificarHabitacion() {
        if (vista.getTxtIdPH().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona una habitación primero.");
            return;
        }

        try {
            Habitacion h = new Habitacion();
            h.setIdHabitacion(Integer.parseInt(vista.getTxtIdPH().getText()));
            h.setNumero(Integer.parseInt(vista.getTxtNumeroPH().getText()));
            h.setTipo(vista.getCbxTipoPH().getSelectedItem().toString());
            
            String estadoSeleccionado = vista.getCbxEstadoPH().getSelectedItem().toString();
            EstadoHabitacion estado = EstadoHabitacionFactory.crearEstado(estadoSeleccionado);
            
            h.setEstadoActual(estado);
            h.setPrecio(Double.parseDouble(vista.getTxtPrecioPH().getText()));

            if (dao.actualizar(h)) {
                JOptionPane.showMessageDialog(null, "Habitación modificada.");
                cargarTablaHabitaciones();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar habitación.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Datos inválidos.");
        }
    }

    private void eliminarHabitacion() {
        if (vista.getTxtIdPH().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona una habitación para eliminar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta habitación?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(vista.getTxtIdPH().getText());
            if (dao.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Habitación eliminada.");
                cargarTablaHabitaciones();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar habitación.");
            }
        }
    }

    private void buscarHabitacionPorNumero() {
        try {
            int numero = Integer.parseInt(vista.getTxtNumeroPH().getText());
            List<Habitacion> lista = dao.listarTodas();
            for (Habitacion h : lista) {
                if (h.getNumero() == numero) {
                    vista.getTxtIdPH().setText(String.valueOf(h.getIdHabitacion()));
                    vista.getTxtNumeroPH().setText(String.valueOf(h.getNumero()));
                    vista.getCbxTipoPH().setSelectedItem(h.getTipo());
                    vista.getCbxEstadoPH().setSelectedItem(h.getEstadoActual().getNombreEstado());
                    vista.getTxtPrecioPH().setText(String.valueOf(h.getPrecio()));
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Habitación no encontrada.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Número inválido.");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = vista.getTablaHabitaciones().getSelectedRow();
        if (fila >= 0) {
            vista.getTxtIdPH().setText(vista.getTablaHabitaciones().getValueAt(fila, 0).toString());
            vista.getTxtNumeroPH().setText(vista.getTablaHabitaciones().getValueAt(fila, 1).toString());
            vista.getCbxTipoPH().setSelectedItem(vista.getTablaHabitaciones().getValueAt(fila, 2).toString());
            vista.getCbxEstadoPH().setSelectedItem(vista.getTablaHabitaciones().getValueAt(fila, 3).toString());
            vista.getTxtPrecioPH().setText(vista.getTablaHabitaciones().getValueAt(fila, 4).toString());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
