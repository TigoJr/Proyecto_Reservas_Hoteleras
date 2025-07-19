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
import pe.edu.utp.dao.HabitacionDao;
import pe.edu.utp.factory.HabitacionFactory;
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.vista.MenuPrincipal;

/**
 *
 * @author USUARIO
 */
public class GestionHabitacionControlador implements ActionListener, MouseListener {

    private final HabitacionDao dao;
    private final MenuPrincipal vista;
    private Habitacion habitacionSeleccionada;

    public GestionHabitacionControlador(HabitacionDao dao, MenuPrincipal vista) {
        this.dao = dao;
        this.vista = vista;

        agregarEventos();
        cargarTablaHabitaciones();
    }

    private void agregarEventos() {

        vista.btnGuardarPH.addActionListener(this);
        vista.btnModificarPH.addActionListener(this);
        vista.btnEliminarPH.addActionListener(this);
        vista.btnBuscarPH.addActionListener(this);
        vista.btnLimpiarPH.addActionListener(this);
        vista.btnRefrescarPH.addActionListener(this);
        vista.tablaHabitaciones.addMouseListener(this);
        vista.cbxTipoPH.addActionListener(this);
    }

    private void cargarTablaHabitaciones() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tablaHabitaciones.getModel();
        modeloTabla.setRowCount(0); // limpiar tabla

        List<Habitacion> lista = dao.listarTodas();
        for (Habitacion h : lista) {
            modeloTabla.addRow(new Object[]{
                h.getIdHabitacion(),
                h.getNumero(),
                h.getTipo(),
                h.getEstado(),
                h.getPrecio()
            });
        }
    }

    private void limpiarCampos() {
        vista.txtIdPH.setText("");
        vista.txtNumeroPH.setText("");
        vista.cbxTipoPH.setSelectedIndex(0);
        vista.cbxEstadoPH.setSelectedIndex(0);
        vista.txtPrecioPH.setText("");
        habitacionSeleccionada = null;
    }

    private void actualizarPrecioPorTipo() {
        String tipo = vista.cbxTipoPH.getSelectedItem().toString();
        Habitacion temp = HabitacionFactory.crearHabitacion(tipo);
        vista.txtPrecioPH.setText(String.valueOf(temp.getPrecio()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vista.btnGuardarPH) {
            guardarHabitacion();
        } else if (fuente == vista.btnModificarPH) {
            modificarHabitacion();
        } else if (fuente == vista.btnEliminarPH) {
            eliminarHabitacion();
        } else if (fuente == vista.btnBuscarPH) {
            buscarHabitacionPorNumero();
        } else if (fuente == vista.btnLimpiarPH) {
            limpiarCampos();
        } else if (fuente == vista.btnRefrescarPH) {
            cargarTablaHabitaciones();
        } else if (fuente == vista.cbxTipoPH) {
            actualizarPrecioPorTipo();
        }
    }

    private void guardarHabitacion() {
        try {
            String tipo = vista.cbxTipoPH.getSelectedItem().toString();
            Habitacion h = HabitacionFactory.crearHabitacion(tipo);

            h.setNumero(Integer.parseInt(vista.txtNumeroPH.getText()));
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
        if (vista.txtIdPH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona una habitación primero.");
            return;
        }

        try {
            Habitacion h = new Habitacion();
            h.setIdHabitacion(Integer.parseInt(vista.txtIdPH.getText()));
            h.setNumero(Integer.parseInt(vista.txtNumeroPH.getText()));
            h.setTipo(vista.cbxTipoPH.getSelectedItem().toString());
            h.setEstado(vista.cbxEstadoPH.getSelectedItem().toString());
            h.setPrecio(Double.parseDouble(vista.txtPrecioPH.getText()));

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
        if (vista.txtIdPH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona una habitación para eliminar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta habitación?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(vista.txtIdPH.getText());
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
            int numero = Integer.parseInt(vista.txtNumeroPH.getText());
            List<Habitacion> lista = dao.listarTodas();
            for (Habitacion h : lista) {
                if (h.getNumero() == numero) {
                    vista.txtIdPH.setText(String.valueOf(h.getIdHabitacion()));
                    vista.txtNumeroPH.setText(String.valueOf(h.getNumero()));
                    vista.cbxTipoPH.setSelectedItem(h.getTipo());
                    vista.cbxEstadoPH.setSelectedItem(h.getEstado());
                    vista.txtPrecioPH.setText(String.valueOf(h.getPrecio()));
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
        int fila = vista.tablaHabitaciones.getSelectedRow();
        if (fila >= 0) {
            vista.txtIdPH.setText(vista.tablaHabitaciones.getValueAt(fila, 0).toString());
            vista.txtNumeroPH.setText(vista.tablaHabitaciones.getValueAt(fila, 1).toString());
            vista.cbxTipoPH.setSelectedItem(vista.tablaHabitaciones.getValueAt(fila, 2).toString());
            vista.cbxEstadoPH.setSelectedItem(vista.tablaHabitaciones.getValueAt(fila, 3).toString());
            vista.txtPrecioPH.setText(vista.tablaHabitaciones.getValueAt(fila, 4).toString());
        }
    }

    // Métodos vacíos de MouseListener obligatorios
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
