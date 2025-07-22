/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.dao.ClienteDAO;
import pe.edu.utp.modelo.Cliente;
import pe.edu.utp.vista.PrincipalVista;

/**
 *
 * @author USUARIO
 */
public class GestionClienteControlador implements ActionListener, MouseListener {

    private final ClienteDAO dao;
    private final Cliente modelo;
    private final PrincipalVista vista;
    private Cliente clienteSeleccionado;

    public GestionClienteControlador(ClienteDAO dao, Cliente modelo, PrincipalVista vista) {
        this.dao = dao;
        this.modelo = modelo;
        this.vista = vista;

        agregarEventos();
        cargarTablaClientes();
    }

    private void agregarEventos() {
        vista.getBtnBuscarPC().addActionListener(this);
        vista.getBtnModificarPC().addActionListener(this);
        vista.getBtnEliminarPC().addActionListener(this);
        vista.getBtnRefrescarPC().addActionListener(this);
        vista.getBtnLimpiarPC().addActionListener(this);
        vista.getBtnRegistrarPC().addActionListener(this);
        vista.getTablaClientes().addMouseListener(this);
    }

    private void cargarTablaClientes() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTablaClientes().getModel();
        modeloTabla.setRowCount(0);

        List<Cliente> lista = dao.listarTodos();
        for (Cliente c : lista) {
            modeloTabla.addRow(new Object[]{
                c.getIdCliente(),
                c.getNombre(),
                c.getDni(),
                c.getTelefono(),
                c.getEmail()
            });
        }
    }

    private void limpiarCampos() {
        vista.getTxtIdPC().setText("");
        vista.getTxtNombrePC().setText("");
        vista.getTxtDniPC().setText("");
        vista.getTxtTelefonoPC().setText("");
        vista.getTxtEmailPC().setText("");
        clienteSeleccionado = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vista.getBtnBuscarPC()) {
            String dni = vista.getTxtDniPC().getText().trim();
            Cliente c = buscarPorDni(dni);
            if (c != null) {
                mostrarClienteEnCampos(c);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            }

        } else if (fuente == vista.getBtnModificarPC()) {
            modificarCliente();

        } else if (fuente == vista.getBtnEliminarPC()) {
            eliminarCliente();

        } else if (fuente == vista.getBtnRefrescarPC()) {
            cargarTablaClientes();

        } else if (fuente == vista.getBtnLimpiarPC()) {
            limpiarCampos();

        } else if (fuente == vista.getBtnRegistrarPC()) {
            registrarCliente();
        }
    }

    private Cliente buscarPorDni(String dni) {
        return dao.listarTodos().stream()
                .filter(c -> c.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(null);
    }

    private void mostrarClienteEnCampos(Cliente c) {
        vista.getTxtIdPC().setText(String.valueOf(c.getIdCliente()));
        vista.getTxtNombrePC().setText(c.getNombre());
        vista.getTxtDniPC().setText(c.getDni());
        vista.getTxtTelefonoPC().setText(c.getTelefono());
        vista.getTxtEmailPC().setText(c.getEmail());
        clienteSeleccionado = c;
    }

    private void modificarCliente() {
        if (vista.getTxtIdPC().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona o busca un cliente primero.");
            return;
        }

        Cliente c = new Cliente();
        c.setIdCliente(Integer.parseInt(vista.getTxtIdPC().getText()));
        c.setNombre(vista.getTxtNombrePC().getText().trim());
        c.setDni(vista.getTxtDniPC().getText().trim());
        c.setTelefono(vista.getTxtTelefonoPC().getText().trim());
        c.setEmail(vista.getTxtEmailPC().getText().trim());

        if (!validarModificacion(c)) {
            return;
        }

        if (dao.actualizar(c)) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado.");
            cargarTablaClientes();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente.");
        }
    }

    private void eliminarCliente() {
        if (vista.getTxtIdPC().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona un cliente para eliminar.");
            return;
        }

        int id = Integer.parseInt(vista.getTxtIdPC().getText());

        UIManager.put("Button.background", new Color(70, 130, 180));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("OptionPane.background", new Color(240, 248, 255));
        UIManager.put("Panel.background", new Color(240, 248, 255));

        Object[] opciones = {"Eliminar", "Cancelar"};

        int confirm = JOptionPane.showOptionDialog(
                null,
                "¿Estás seguro de eliminar este cliente?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                opciones,
                opciones[1]
        );

        UIManager.put("OptionPane.background", null);
        UIManager.put("OptionPane.messageForeground", null);

        if (confirm == JOptionPane.YES_OPTION) {
            if (dao.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado.");
                cargarTablaClientes();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar cliente.");
            }
        }
    }

    private void registrarCliente() {
        try {
            modelo.setNombre(vista.getTxtNombrePC().getText().trim());
            modelo.setDni(vista.getTxtDniPC().getText().trim());
            modelo.setTelefono(vista.getTxtTelefonoPC().getText().trim());
            modelo.setEmail(vista.getTxtEmailPC().getText().trim());

            if (!validarEntrada(modelo)) {
                return;
            }

            if (dao.agregar(modelo)) {
                JOptionPane.showMessageDialog(null, "Cliente registrado.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar cliente.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private boolean validarEntrada(Cliente c) {
        if (c.getNombre().isBlank() || c.getDni().isBlank() || c.getTelefono().isBlank() || c.getEmail().isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return false;
        }

        if (!c.getDni().matches("\\d{8}")) {
            JOptionPane.showMessageDialog(null, "El DNI debe tener exactamente 8 dígitos.");
            return false;
        }

        if (!c.getTelefono().matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "El teléfono debe tener 9 dígitos.");
            return false;
        }

        if (!c.getEmail().matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "El email no es válido.");
            return false;
        }

        if (dao.dniExiste(c.getDni())) {
            JOptionPane.showMessageDialog(null, "El DNI ya está registrado.");
            return false;
        }
        if (dao.telefonoExiste(c.getTelefono())) {
            JOptionPane.showMessageDialog(null, "El teléfono ya está registrado.");
            return false;
        }
        if (dao.emailExiste(c.getEmail())) {
            JOptionPane.showMessageDialog(null, "El email ya está registrado.");
            return false;
        }

        return true;
    }
    
    private boolean validarModificacion(Cliente c) {
        if (c.getNombre().isBlank() || c.getDni().isBlank() || c.getTelefono().isBlank() || c.getEmail().isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return false;
        }

        if (!c.getDni().matches("\\d{8}")) {
            JOptionPane.showMessageDialog(null, "El DNI debe tener exactamente 8 dígitos.");
            return false;
        }

        if (!c.getTelefono().matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "El teléfono debe tener 9 dígitos.");
            return false;
        }

        if (!c.getEmail().matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "El email no es válido.");
            return false;
        }

        if (dao.dniExisteEnOtroCliente(c.getDni(), c.getIdCliente())) {
            JOptionPane.showMessageDialog(null, "El DNI ya está registrado por otro cliente.");
            return false;
        }

        if (dao.telefonoExisteEnOtroCliente(c.getTelefono(), c.getIdCliente())) {
            JOptionPane.showMessageDialog(null, "El teléfono ya está registrado por otro cliente.");
            return false;
        }

        if (dao.emailExisteEnOtroCliente(c.getEmail(), c.getIdCliente())) {
            JOptionPane.showMessageDialog(null, "El email ya está registrado por otro cliente.");
            return false;
        }

        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = vista.getTablaClientes().getSelectedRow();
        if (fila >= 0) {
            vista.getTxtIdPC().setText(vista.getTablaClientes().getValueAt(fila, 0).toString());
            vista.getTxtNombrePC().setText(vista.getTablaClientes().getValueAt(fila, 1).toString());
            vista.getTxtDniPC().setText(vista.getTablaClientes().getValueAt(fila, 2).toString());
            vista.getTxtTelefonoPC().setText(vista.getTablaClientes().getValueAt(fila, 3).toString());
            vista.getTxtEmailPC().setText(vista.getTablaClientes().getValueAt(fila, 4).toString());
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
