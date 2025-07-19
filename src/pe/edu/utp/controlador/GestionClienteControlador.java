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
import pe.edu.utp.dao.ClienteDao;
import pe.edu.utp.modelo.Cliente;
import pe.edu.utp.vista.MenuPrincipal;

/**
 *
 * @author USUARIO
 */
public class GestionClienteControlador implements ActionListener, MouseListener {

    private final ClienteDao dao;
    private final Cliente modelo;
    private final MenuPrincipal vista;
    private Cliente clienteSeleccionado;

    public GestionClienteControlador(ClienteDao dao, Cliente modelo, MenuPrincipal vista) {
        this.dao = dao;
        this.modelo = modelo;
        this.vista = vista;

        agregarEventos();
        cargarTablaClientes();
    }

    private void agregarEventos() {
        vista.btnBuscarPC.addActionListener(this);
        vista.btnModificarPC.addActionListener(this);
        vista.btnEliminarPC.addActionListener(this);
        vista.btnRefrescarPC.addActionListener(this);
        vista.btnLimpiarPC.addActionListener(this);
        vista.btnRegistrarPC.addActionListener(this);
        vista.tablaClientes.addMouseListener(this);
    }

    private void cargarTablaClientes() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tablaClientes.getModel();
        modeloTabla.setRowCount(0); // limpia la tabla

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
        vista.txtIdPC.setText("");
        vista.txtNombrePC.setText("");
        vista.txtDniPC.setText("");
        vista.txtTelefonoPC.setText("");
        vista.txtEmailPC.setText("");
        clienteSeleccionado = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vista.btnBuscarPC) {
            String dni = vista.txtDniPC.getText().trim();
            Cliente c = buscarPorDni(dni);
            if (c != null) {
                mostrarClienteEnCampos(c);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            }
        } else if (fuente == vista.btnModificarPC) {
            modificarCliente();
        } else if (fuente == vista.btnEliminarPC) {
            eliminarCliente();
        } else if (fuente == vista.btnRefrescarPC) {
            cargarTablaClientes();
        } else if (fuente == vista.btnLimpiarPC) {
            limpiarCampos();
        } else if (e.getSource() == vista.btnRegistrarPC) {
            registrarCliente();
        }
    }

    private Cliente buscarPorDni(String dni) {
        List<Cliente> lista = dao.listarTodos();
        for (Cliente c : lista) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null;
    }

    private void mostrarClienteEnCampos(Cliente c) {
        vista.txtIdPC.setText(String.valueOf(c.getIdCliente()));
        vista.txtNombrePC.setText(c.getNombre());
        vista.txtDniPC.setText(c.getDni());
        vista.txtTelefonoPC.setText(c.getTelefono());
        vista.txtEmailPC.setText(c.getEmail());
        clienteSeleccionado = c;
    }

    private void modificarCliente() {
        if (vista.txtIdPC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona o busca un cliente primero.");
            return;
        }

        Cliente c = new Cliente();
        c.setIdCliente(Integer.parseInt(vista.txtIdPC.getText()));
        c.setNombre(vista.txtNombrePC.getText().trim());
        c.setDni(vista.txtDniPC.getText().trim());
        c.setTelefono(vista.txtTelefonoPC.getText().trim());
        c.setEmail(vista.txtEmailPC.getText().trim());

        if (dao.actualizar(c)) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado.");
            cargarTablaClientes();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente.");
        }
    }

    private void eliminarCliente() {
        if (vista.txtIdPC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona un cliente para eliminar.");
            return;
        }

        int id = Integer.parseInt(vista.txtIdPC.getText());

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

        // Restaurar valores por defecto (opcional)
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
            modelo.setNombre(vista.txtNombrePC.getText().trim());
            modelo.setDni(vista.txtDniPC.getText().trim());
            modelo.setTelefono(vista.txtTelefonoPC.getText().trim());
            modelo.setEmail(vista.txtEmailPC.getText().trim());

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

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = vista.tablaClientes.getSelectedRow();
        if (fila >= 0) {
            vista.txtIdPC.setText(vista.tablaClientes.getValueAt(fila, 0).toString());
            vista.txtNombrePC.setText(vista.tablaClientes.getValueAt(fila, 1).toString());
            vista.txtDniPC.setText(vista.tablaClientes.getValueAt(fila, 2).toString());
            vista.txtTelefonoPC.setText(vista.tablaClientes.getValueAt(fila, 3).toString());
            vista.txtEmailPC.setText(vista.tablaClientes.getValueAt(fila, 4).toString());
        }
    }

    // Métodos MouseListener que no usaremos pero debemos implementar
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
