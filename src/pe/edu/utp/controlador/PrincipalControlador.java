/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controlador;

/**
 *
 * @author USUARIO
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pe.edu.utp.dao.ClienteDAO;
import pe.edu.utp.dao.HabitacionDAO;
import pe.edu.utp.dao.PagoDAO;
import pe.edu.utp.dao.ReservaDAO;
import pe.edu.utp.estilo.BotonLateralConLabel;
import pe.edu.utp.estilo.Estilos;
import pe.edu.utp.estilo.PaletaColores;
import pe.edu.utp.modelo.Cliente;
import pe.edu.utp.vista.PrincipalVista;

public class PrincipalControlador implements ActionListener {

    private final PrincipalVista vista;
    private final Map<JButton, JPanel> navegacion = new LinkedHashMap<>();

    public PrincipalControlador(PrincipalVista vista) {
        this.vista = vista;
        aplicarEstilos();
        configurarNavegacion();
        personalizarBotonesLateral();
        initControladores();
    }

    private void configurarNavegacion() {
        navegacion.put(vista.getBtnInicio(), vista.getPanelInicio());
        navegacion.put(vista.getBtnClientes(), vista.getPanelClientes());
        navegacion.put(vista.getBtnHabitaciones(), vista.getPanelHabitaciones());
        navegacion.put(vista.getBtnReservaciones(), vista.getPanelReservas());
        navegacion.put(vista.getBtnPagos(), vista.getPanelPagos());
        navegacion.put(vista.getBtnCheck(), vista.getPanelCheck());

        for (JButton btn : navegacion.keySet()) {
            btn.addActionListener(this);
        }
    }

    private void initControladores() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        ReservaDAO reservaDao = new ReservaDAO();
        PagoDAO pagoDao = new PagoDAO();

        new GestionHabitacionControlador(habitacionDAO, vista);
        new ReservaControlador(vista, clienteDAO, habitacionDAO, reservaDao);
        new GestionClienteControlador(clienteDAO, cliente, vista);
        new PagoControlador(vista, pagoDao, reservaDao, habitacionDAO);
        new CheckInOutControlador(habitacionDAO, vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();

        for (Map.Entry<JButton, JPanel> entry : navegacion.entrySet()) {
            JButton boton = entry.getKey();
            JPanel panel = entry.getValue();

            if (origen == boton) {
                int index = vista.getTabbedContenido().indexOfComponent(panel);
                vista.getTabbedContenido().setSelectedIndex(index);

                Estilos.resaltarBotonActivo(boton, navegacion.keySet());
                break;
            }
        }
    }

    private void aplicarEstilos() {
        Estilos.panelPrincipal(vista.getPanelPrincipal());
        Estilos.panelTitulo(vista.getPanelTitulo());
        Estilos.panelLateral(vista.getPanelLateral());
        Estilos.panelContenido(vista.getPanelContenido());

        JPanel[] secciones = {
            vista.getPanelInicio(), vista.getPanelClientes(),
            vista.getPanelHabitaciones(), vista.getPanelReservas(),
            vista.getPanelPagos(), vista.getPanelCheck()
        };

        personalizarBotonesFormulario();
        personalizarTablas();
        personalizarCamposTexto();
        personalizarCombos();
        personalizarLabels();
        personalizarTabbedPane();
    }

    private void personalizarBotonesLateral() {
        Set<JButton> grupoBotones = new LinkedHashSet<>();

        Estilos.botonLateralConLabel(new BotonLateralConLabel(vista.getBtnInicio(), vista.getLblBtnInicio()), grupoBotones);
        Estilos.botonLateralConLabel(new BotonLateralConLabel(vista.getBtnClientes(), vista.getLblBtnClientes()), grupoBotones);
        Estilos.botonLateralConLabel(new BotonLateralConLabel(vista.getBtnHabitaciones(), vista.getLblBtnHabitaciones()), grupoBotones);
        Estilos.botonLateralConLabel(new BotonLateralConLabel(vista.getBtnReservaciones(), vista.getLblBtnReservaciones()), grupoBotones);
        Estilos.botonLateralConLabel(new BotonLateralConLabel(vista.getBtnPagos(), vista.getLblBtnPagos()), grupoBotones);
        Estilos.botonLateralConLabel(new BotonLateralConLabel(vista.getBtnCheck(), vista.getLblBtnCheck()), grupoBotones);
    }

    private void personalizarBotonesFormulario() {
        JButton[] positivos = {
            vista.getBtnRegistrarPC(), vista.getBtnRegistrarPP(),
            vista.getBtnReservarPR(), vista.getBtnGuardarPH(),
            vista.getBtnCheckIn(), vista.getBtnCheckOut()
        };
        for (JButton b : positivos) {
            Estilos.botonFormulario(b, PaletaColores.ACCION_POSITIVA);
        }

        JButton[] destructivos = {
            vista.getBtnEliminarPC(), vista.getBtnEliminarPH()
        };
        for (JButton b : destructivos) {
            Estilos.botonFormulario(b, PaletaColores.ACCION_DESTRUCTIVA);
        }

        JButton[] neutros = {
            vista.getBtnModificarPC(), vista.getBtnModificarPH(),
            vista.getBtnLimpiarPC(), vista.getBtnLimpiarPH(),
            vista.getBtnLimpiarPP(), vista.getBtnLimpiarPR(),
            vista.getBtnRefrescarPC(), vista.getBtnRefrescarPCK(),
            vista.getBtnRefrescarPH()
        };
        for (JButton b : neutros) {
            Estilos.botonFormulario(b, PaletaColores.ACCION_NEUTRA);
        }

        JButton[] secundarios = {
            vista.getBtnBuscarPC(), vista.getBtnBuscarPH()
        };
        for (JButton b : secundarios) {
            Estilos.botonFormulario(b, PaletaColores.ACCION_SECUNDARIA);
        }
    }

    private void personalizarTablas() {
        Estilos.personalizarTabla(vista.getTablaClientes());
        Estilos.personalizarTabla(vista.getTablaHabitaciones());
        Estilos.personalizarTabla(vista.getTablaReservas());
        Estilos.personalizarTabla(vista.getTablaPagos());
    }

    private void personalizarCamposTexto() {
        JTextField[] campos = {
            vista.getTxtDniPC(), vista.getTxtEmailPC(),
            vista.getTxtEstadoPCK(), vista.getTxtEstadoPR(),
            vista.getTxtFechaFinPR(), vista.getTxtFechaInicioPR(),
            vista.getTxtFechaPP(), vista.getTxtIdPC(),
            vista.getTxtIdPH(), vista.getTxtIdPH(),
            vista.getTxtNombrePC(), vista.getTxtNumeroPH(),
            vista.getTxtPrecioPH(), vista.getTxtTelefonoPC(),
            vista.getTxtMontoPP(), vista.getTxtFechaReservaPR()
        };

        for (JTextField campo : campos) {
            Estilos.personalizarCampoTexto(campo);
        }
    }

    private void personalizarCombos() {
        JComboBox<?>[] combos = {
            vista.getCbxClientePR(), vista.getCbxEstadoPH(),
            vista.getCbxHabitacionPCK(), vista.getCbxHabitacionPR(),
            vista.getCbxMetodoPP(), vista.getCbxReservaPP(),
            vista.getCbxTipoPH()
        };

        for (JComboBox<?> combo : combos) {
            Estilos.personalizarComboBox(combo);
        }
    }

    private void personalizarLabels() {
        JLabel[] labelsLateral = {
            vista.getLblBtnInicio(), vista.getLblBtnClientes(), vista.getLblBtnHabitaciones(),
            vista.getLblBtnReservaciones(), vista.getLblBtnPagos(), vista.getLblBtnCheck()
        };
        for (JLabel lbl : labelsLateral) {
            Estilos.labelLateral(lbl);
        }

        Estilos.labelTitulo(vista.getLblTitulo());

        JLabel[] labelsFormularios = {
            vista.getLblDniPC(), vista.getLblEmailPC(), vista.getLblEstadoActual(),
            vista.getLblEstadoPH(), vista.getLblEstadoPR(), vista.getLblFechaFinPR(),
            vista.getLblFechaInicioPR(), vista.getLblFechaPP(), vista.getLblHabitacionPCK(),
            vista.getLblIdPC(), vista.getLblIdPH(), vista.getLblMontoPP(), vista.getLblNombrePC(),
            vista.getLblNumeroPH(), vista.getLblPrecioPH(), vista.getLblTelefonoPC(),
            vista.getLblTipoPH(), vista.getLblFechaReservaPR()
        };
        for (JLabel lbl : labelsFormularios) {
            Estilos.labelFormulario(lbl);
        }
    }

    private void personalizarTabbedPane() {
        Estilos.estilizarTabbedPane(vista.getTabbedContenido());
    }

}
