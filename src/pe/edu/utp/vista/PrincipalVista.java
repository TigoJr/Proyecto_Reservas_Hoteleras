/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.utp.vista;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author USUARIO
 */
public class PrincipalVista extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalVista
     */
    public PrincipalVista() {
        initComponents();
        setSize(1320, 760);
        setLocationRelativeTo(null);

        try {
            URL iconUrl = PrincipalVista.class.getResource("/pe/edu/utp/imagen/LUMIERE_RESERVAS_100x100.png");
            if (iconUrl != null) {
                ImageIcon icon = new ImageIcon(iconUrl);
                setIconImage(icon.getImage());
                
                java.util.List<Image> icons = new java.util.ArrayList<>();
                icons.add(icon.getImage());
                icons.add(icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
                setIconImages(icons);
            } else {
                System.err.println("Icono no encontrado");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar el icono: " + e.getMessage());
        }
    }

    public javax.swing.JButton getBtnBuscarPC() {
        return btnBuscarPC;
    }

    public javax.swing.JButton getBtnBuscarPH() {
        return btnBuscarPH;
    }

    public javax.swing.JButton getBtnCheck() {
        return btnCheck;
    }

    public javax.swing.JButton getBtnCheckIn() {
        return btnCheckIn;
    }

    public javax.swing.JButton getBtnCheckOut() {
        return btnCheckOut;
    }

    public javax.swing.JButton getBtnClientes() {
        return btnClientes;
    }

    public javax.swing.JButton getBtnEliminarPC() {
        return btnEliminarPC;
    }

    public javax.swing.JButton getBtnEliminarPH() {
        return btnEliminarPH;
    }

    public javax.swing.JButton getBtnGuardarPH() {
        return btnGuardarPH;
    }

    public javax.swing.JButton getBtnHabitaciones() {
        return btnHabitaciones;
    }

    public javax.swing.JButton getBtnInicio() {
        return btnInicio;
    }

    public javax.swing.JButton getBtnLimpiarPC() {
        return btnLimpiarPC;
    }

    public javax.swing.JButton getBtnLimpiarPH() {
        return btnLimpiarPH;
    }

    public javax.swing.JButton getBtnLimpiarPP() {
        return btnLimpiarPP;
    }

    public javax.swing.JButton getBtnLimpiarPR() {
        return btnLimpiarPR;
    }

    public javax.swing.JButton getBtnModificarPC() {
        return btnModificarPC;
    }

    public javax.swing.JButton getBtnModificarPH() {
        return btnModificarPH;
    }

    public javax.swing.JButton getBtnPagos() {
        return btnPagos;
    }

    public javax.swing.JButton getBtnRefrescarPC() {
        return btnRefrescarPC;
    }

    public javax.swing.JButton getBtnRefrescarPCK() {
        return btnRefrescarPCK;
    }

    public javax.swing.JButton getBtnRefrescarPH() {
        return btnRefrescarPH;
    }

    public javax.swing.JButton getBtnRegistrarPC() {
        return btnRegistrarPC;
    }

    public javax.swing.JButton getBtnRegistrarPP() {
        return btnRegistrarPP;
    }

    public javax.swing.JButton getBtnReservaciones() {
        return btnReservaciones;
    }

    public javax.swing.JButton getBtnReservarPR() {
        return btnReservarPR;
    }

    public javax.swing.JComboBox<String> getCbxClientePR() {
        return cbxClientePR;
    }

    public javax.swing.JComboBox<String> getCbxEstadoPH() {
        return cbxEstadoPH;
    }

    public javax.swing.JComboBox<String> getCbxHabitacionPCK() {
        return cbxHabitacionPCK;
    }

    public javax.swing.JComboBox<String> getCbxHabitacionPR() {
        return cbxHabitacionPR;
    }

    public javax.swing.JComboBox<String> getCbxMetodoPP() {
        return cbxMetodoPP;
    }

    public javax.swing.JComboBox<String> getCbxReservaPP() {
        return cbxReservaPP;
    }

    public javax.swing.JComboBox<String> getCbxTipoPH() {
        return cbxTipoPH;
    }

    public javax.swing.JLabel getLblBtnCheck() {
        return lblBtnCheck;
    }

    public javax.swing.JLabel getLblBtnClientes() {
        return lblBtnClientes;
    }

    public javax.swing.JLabel getLblBtnHabitaciones() {
        return lblBtnHabitaciones;
    }

    public javax.swing.JLabel getLblBtnInicio() {
        return lblBtnInicio;
    }

    public javax.swing.JLabel getLblBtnPagos() {
        return lblBtnPagos;
    }

    public javax.swing.JLabel getLblBtnReservaciones() {
        return lblBtnReservaciones;
    }

    public javax.swing.JLabel getLblDniPC() {
        return lblDniPC;
    }

    public javax.swing.JLabel getLblEmailPC() {
        return lblEmailPC;
    }

    public javax.swing.JLabel getLblEstadoActual() {
        return lblEstadoActual;
    }

    public javax.swing.JLabel getLblEstadoPH() {
        return lblEstadoPH;
    }

    public javax.swing.JLabel getLblEstadoPR() {
        return lblEstadoPR;
    }

    public javax.swing.JLabel getLblFechaFinPR() {
        return lblFechaFinPR;
    }

    public javax.swing.JLabel getLblFechaInicioPR() {
        return lblFechaInicioPR;
    }
    
    public javax.swing.JLabel getLblFechaReservaPR() {
        return lblFechaReservaPR;
    }

    public javax.swing.JLabel getLblFechaPP() {
        return lblFechaPP;
    }

    public javax.swing.JLabel getLblHabitacionPCK() {
        return lblHabitacionPCK;
    }

    public javax.swing.JLabel getLblIdPC() {
        return lblIdPC;
    }

    public javax.swing.JLabel getLblIdPH() {
        return lblIdPH;
    }

    public javax.swing.JLabel getLblImagenInicio() {
        return lblImagenInicio;
    }

    public javax.swing.JLabel getLblMontoPP() {
        return lblMontoPP;
    }

    public javax.swing.JLabel getLblNombrePC() {
        return lblNombrePC;
    }

    public javax.swing.JLabel getLblNumeroPH() {
        return lblNumeroPH;
    }

    public javax.swing.JLabel getLblPrecioPH() {
        return lblPrecioPH;
    }

    public javax.swing.JLabel getLblTelefonoPC() {
        return lblTelefonoPC;
    }

    public javax.swing.JLabel getLblTipoPH() {
        return lblTipoPH;
    }

    public javax.swing.JLabel getLblTitulo() {
        return lblTitulo;
    }

    public javax.swing.JPanel getPanelCheck() {
        return panelCheck;
    }

    public javax.swing.JPanel getPanelClientes() {
        return panelClientes;
    }

    public javax.swing.JPanel getPanelContenido() {
        return panelContenido;
    }

    public javax.swing.JPanel getPanelHabitaciones() {
        return panelHabitaciones;
    }

    public javax.swing.JPanel getPanelInicio() {
        return panelInicio;
    }

    public javax.swing.JPanel getPanelLateral() {
        return panelLateral;
    }

    public javax.swing.JPanel getPanelPagos() {
        return panelPagos;
    }

    public javax.swing.JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public javax.swing.JPanel getPanelReservas() {
        return panelReservas;
    }

    public javax.swing.JPanel getPanelTitulo() {
        return panelTitulo;
    }

    public javax.swing.JScrollPane getScrollTablaClientes() {
        return scrollTablaClientes;
    }

    public javax.swing.JScrollPane getScrollTablaHabitaciones() {
        return scrollTablaHabitaciones;
    }

    public javax.swing.JScrollPane getScrollTablaPagos() {
        return scrollTablaPagos;
    }

    public javax.swing.JScrollPane getScrollTablaReservas() {
        return scrollTablaReservas;
    }

    public javax.swing.JTabbedPane getTabbedContenido() {
        return tabbedContenido;
    }

    public javax.swing.JTable getTablaClientes() {
        return tablaClientes;
    }

    public javax.swing.JTable getTablaHabitaciones() {
        return tablaHabitaciones;
    }

    public javax.swing.JTable getTablaPagos() {
        return tablaPagos;
    }

    public javax.swing.JTable getTablaReservas() {
        return tablaReservas;
    }

    public javax.swing.JTextField getTxtDniPC() {
        return txtDniPC;
    }

    public javax.swing.JTextField getTxtEmailPC() {
        return txtEmailPC;
    }

    public javax.swing.JTextField getTxtEstadoPCK() {
        return txtEstadoPCK;
    }

    public javax.swing.JTextField getTxtEstadoPR() {
        return txtEstadoPR;
    }

    public javax.swing.JTextField getTxtFechaFinPR() {
        return txtFechaFinPR;
    }

    public javax.swing.JTextField getTxtFechaInicioPR() {
        return txtFechaInicioPR;
    }
    
    public javax.swing.JTextField getTxtFechaReservaPR() {
        return txtFechaReservaPR;
    }

    public javax.swing.JTextField getTxtFechaPP() {
        return txtFechaPP;
    }

    public javax.swing.JTextField getTxtIdPC() {
        return txtIdPC;
    }

    public javax.swing.JTextField getTxtIdPH() {
        return txtIdPH;
    }

    public javax.swing.JTextField getTxtMontoPP() {
        return txtMontoPP;
    }

    public javax.swing.JTextField getTxtNombrePC() {
        return txtNombrePC;
    }

    public javax.swing.JTextField getTxtNumeroPH() {
        return txtNumeroPH;
    }

    public javax.swing.JTextField getTxtPrecioPH() {
        return txtPrecioPH;
    }

    public javax.swing.JTextField getTxtTelefonoPC() {
        return txtTelefonoPC;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        panelLateral = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        lblBtnInicio = new javax.swing.JLabel();
        btnClientes = new javax.swing.JButton();
        lblBtnClientes = new javax.swing.JLabel();
        btnHabitaciones = new javax.swing.JButton();
        lblBtnHabitaciones = new javax.swing.JLabel();
        btnReservaciones = new javax.swing.JButton();
        lblBtnReservaciones = new javax.swing.JLabel();
        btnPagos = new javax.swing.JButton();
        lblBtnPagos = new javax.swing.JLabel();
        btnCheck = new javax.swing.JButton();
        lblBtnCheck = new javax.swing.JLabel();
        panelContenido = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblImgLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblSlogan = new javax.swing.JLabel();
        tabbedContenido = new javax.swing.JTabbedPane();
        panelInicio = new javax.swing.JPanel();
        lblImgInicio = new javax.swing.JLabel();
        panelClientes = new javax.swing.JPanel();
        lblDniPC = new javax.swing.JLabel();
        lblIdPC = new javax.swing.JLabel();
        lblNombrePC = new javax.swing.JLabel();
        lblEmailPC = new javax.swing.JLabel();
        lblTelefonoPC = new javax.swing.JLabel();
        txtDniPC = new javax.swing.JTextField();
        txtTelefonoPC = new javax.swing.JTextField();
        txtEmailPC = new javax.swing.JTextField();
        txtIdPC = new javax.swing.JTextField();
        txtNombrePC = new javax.swing.JTextField();
        btnLimpiarPC = new javax.swing.JButton();
        btnBuscarPC = new javax.swing.JButton();
        btnModificarPC = new javax.swing.JButton();
        btnEliminarPC = new javax.swing.JButton();
        btnRefrescarPC = new javax.swing.JButton();
        btnRegistrarPC = new javax.swing.JButton();
        scrollTablaClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        panelHabitaciones = new javax.swing.JPanel();
        lblIdPH = new javax.swing.JLabel();
        lblNumeroPH = new javax.swing.JLabel();
        lblPrecioPH = new javax.swing.JLabel();
        lblTipoPH = new javax.swing.JLabel();
        lblEstadoPH = new javax.swing.JLabel();
        txtIdPH = new javax.swing.JTextField();
        txtNumeroPH = new javax.swing.JTextField();
        txtPrecioPH = new javax.swing.JTextField();
        cbxTipoPH = new javax.swing.JComboBox<>();
        cbxEstadoPH = new javax.swing.JComboBox<>();
        btnLimpiarPH = new javax.swing.JButton();
        btnBuscarPH = new javax.swing.JButton();
        btnModificarPH = new javax.swing.JButton();
        btnEliminarPH = new javax.swing.JButton();
        btnRefrescarPH = new javax.swing.JButton();
        btnGuardarPH = new javax.swing.JButton();
        scrollTablaHabitaciones = new javax.swing.JScrollPane();
        tablaHabitaciones = new javax.swing.JTable();
        panelReservas = new javax.swing.JPanel();
        cbxClientePR = new javax.swing.JComboBox<>();
        cbxHabitacionPR = new javax.swing.JComboBox<>();
        lblFechaInicioPR = new javax.swing.JLabel();
        lblFechaFinPR = new javax.swing.JLabel();
        lblEstadoPR = new javax.swing.JLabel();
        lblFechaReservaPR = new javax.swing.JLabel();
        txtFechaInicioPR = new javax.swing.JTextField();
        txtFechaFinPR = new javax.swing.JTextField();
        txtEstadoPR = new javax.swing.JTextField();
        txtFechaReservaPR = new javax.swing.JTextField();
        btnLimpiarPR = new javax.swing.JButton();
        btnReservarPR = new javax.swing.JButton();
        scrollTablaReservas = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        panelPagos = new javax.swing.JPanel();
        cbxReservaPP = new javax.swing.JComboBox<>();
        cbxMetodoPP = new javax.swing.JComboBox<>();
        lblFechaPP = new javax.swing.JLabel();
        lblMontoPP = new javax.swing.JLabel();
        txtFechaPP = new javax.swing.JTextField();
        txtMontoPP = new javax.swing.JTextField();
        btnRegistrarPP = new javax.swing.JButton();
        btnLimpiarPP = new javax.swing.JButton();
        scrollTablaPagos = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();
        panelCheck = new javax.swing.JPanel();
        lblHabitacionPCK = new javax.swing.JLabel();
        lblEstadoActual = new javax.swing.JLabel();
        cbxHabitacionPCK = new javax.swing.JComboBox<>();
        txtEstadoPCK = new javax.swing.JTextField();
        btnCheckIn = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        btnRefrescarPCK = new javax.swing.JButton();
        lblImagenInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        panelLateral.setMaximumSize(new java.awt.Dimension(90, 32767));
        panelLateral.setMinimumSize(new java.awt.Dimension(90, 0));
        panelLateral.setPreferredSize(new java.awt.Dimension(90, 530));
        panelLateral.setLayout(new java.awt.GridBagLayout());

        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/icono/icon_home.png"))); // NOI18N
        btnInicio.setBorder(null);
        btnInicio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnInicio.setMaximumSize(new java.awt.Dimension(70, 56));
        btnInicio.setMinimumSize(new java.awt.Dimension(70, 56));
        btnInicio.setPreferredSize(new java.awt.Dimension(70, 56));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(btnInicio, gridBagConstraints);

        lblBtnInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnInicio.setText("Inicio");
        lblBtnInicio.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblBtnInicio.setMaximumSize(new java.awt.Dimension(70, 20));
        lblBtnInicio.setMinimumSize(new java.awt.Dimension(70, 20));
        lblBtnInicio.setPreferredSize(new java.awt.Dimension(70, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(lblBtnInicio, gridBagConstraints);

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/icono/icon_clientes.png"))); // NOI18N
        btnClientes.setBorder(null);
        btnClientes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnClientes.setMaximumSize(new java.awt.Dimension(70, 56));
        btnClientes.setMinimumSize(new java.awt.Dimension(70, 56));
        btnClientes.setPreferredSize(new java.awt.Dimension(70, 56));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(btnClientes, gridBagConstraints);

        lblBtnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnClientes.setText("Clientes");
        lblBtnClientes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblBtnClientes.setMaximumSize(new java.awt.Dimension(70, 20));
        lblBtnClientes.setMinimumSize(new java.awt.Dimension(70, 20));
        lblBtnClientes.setPreferredSize(new java.awt.Dimension(70, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(lblBtnClientes, gridBagConstraints);

        btnHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/icono/icon_hotel.png"))); // NOI18N
        btnHabitaciones.setBorder(null);
        btnHabitaciones.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnHabitaciones.setMaximumSize(new java.awt.Dimension(70, 56));
        btnHabitaciones.setMinimumSize(new java.awt.Dimension(70, 56));
        btnHabitaciones.setPreferredSize(new java.awt.Dimension(70, 56));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(btnHabitaciones, gridBagConstraints);

        lblBtnHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnHabitaciones.setText("Habitaciones");
        lblBtnHabitaciones.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblBtnHabitaciones.setMaximumSize(new java.awt.Dimension(70, 20));
        lblBtnHabitaciones.setMinimumSize(new java.awt.Dimension(70, 20));
        lblBtnHabitaciones.setPreferredSize(new java.awt.Dimension(70, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(lblBtnHabitaciones, gridBagConstraints);

        btnReservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/icono/icon_reservas.png"))); // NOI18N
        btnReservaciones.setBorder(null);
        btnReservaciones.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnReservaciones.setMaximumSize(new java.awt.Dimension(70, 56));
        btnReservaciones.setMinimumSize(new java.awt.Dimension(70, 56));
        btnReservaciones.setPreferredSize(new java.awt.Dimension(70, 56));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(btnReservaciones, gridBagConstraints);

        lblBtnReservaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnReservaciones.setText("Reservaciones");
        lblBtnReservaciones.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblBtnReservaciones.setMaximumSize(new java.awt.Dimension(70, 20));
        lblBtnReservaciones.setMinimumSize(new java.awt.Dimension(70, 20));
        lblBtnReservaciones.setPreferredSize(new java.awt.Dimension(70, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(lblBtnReservaciones, gridBagConstraints);

        btnPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/icono/icon_pagos.png"))); // NOI18N
        btnPagos.setBorder(null);
        btnPagos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPagos.setMaximumSize(new java.awt.Dimension(70, 56));
        btnPagos.setMinimumSize(new java.awt.Dimension(70, 56));
        btnPagos.setPreferredSize(new java.awt.Dimension(70, 56));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(btnPagos, gridBagConstraints);

        lblBtnPagos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnPagos.setText("Pagos");
        lblBtnPagos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblBtnPagos.setMaximumSize(new java.awt.Dimension(70, 20));
        lblBtnPagos.setMinimumSize(new java.awt.Dimension(70, 20));
        lblBtnPagos.setPreferredSize(new java.awt.Dimension(70, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(lblBtnPagos, gridBagConstraints);

        btnCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/icono/icon_check.png"))); // NOI18N
        btnCheck.setBorder(null);
        btnCheck.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCheck.setMaximumSize(new java.awt.Dimension(70, 56));
        btnCheck.setMinimumSize(new java.awt.Dimension(70, 56));
        btnCheck.setPreferredSize(new java.awt.Dimension(70, 56));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelLateral.add(btnCheck, gridBagConstraints);

        lblBtnCheck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnCheck.setText("Check");
        lblBtnCheck.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblBtnCheck.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblBtnCheck.setMaximumSize(new java.awt.Dimension(70, 20));
        lblBtnCheck.setMinimumSize(new java.awt.Dimension(70, 20));
        lblBtnCheck.setPreferredSize(new java.awt.Dimension(70, 24));
        lblBtnCheck.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelLateral.add(lblBtnCheck, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 1.0;
        panelPrincipal.add(panelLateral, gridBagConstraints);

        panelContenido.setLayout(new javax.swing.BoxLayout(panelContenido, javax.swing.BoxLayout.Y_AXIS));

        panelTitulo.setMaximumSize(new java.awt.Dimension(32767, 140));
        panelTitulo.setMinimumSize(new java.awt.Dimension(0, 140));
        panelTitulo.setPreferredSize(new java.awt.Dimension(811, 140));
        panelTitulo.setLayout(new java.awt.GridBagLayout());

        lblImgLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/imagen/LUMIERE_RESERVAS_100x100.png"))); // NOI18N
        lblImgLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        panelTitulo.add(lblImgLogo, gridBagConstraints);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo.setText("LUMIÈRE RESERVAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(25, -5, 0, 25);
        panelTitulo.add(lblTitulo, gridBagConstraints);

        lblSlogan.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblSlogan.setForeground(new java.awt.Color(255, 255, 255));
        lblSlogan.setText("La excelencia, perfectamente reservada.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, -5, 0, 0);
        panelTitulo.add(lblSlogan, gridBagConstraints);

        panelContenido.add(panelTitulo);

        panelInicio.setLayout(new java.awt.GridBagLayout());

        lblImgInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/imagen/img_inicio.png"))); // NOI18N
        lblImgInicio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 20);
        panelInicio.add(lblImgInicio, gridBagConstraints);

        tabbedContenido.addTab("Inicio", panelInicio);

        panelClientes.setLayout(new java.awt.GridBagLayout());

        lblDniPC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDniPC.setText("N° DNI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelClientes.add(lblDniPC, gridBagConstraints);

        lblIdPC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdPC.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 5, 5);
        panelClientes.add(lblIdPC, gridBagConstraints);

        lblNombrePC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombrePC.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelClientes.add(lblNombrePC, gridBagConstraints);

        lblEmailPC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmailPC.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelClientes.add(lblEmailPC, gridBagConstraints);

        lblTelefonoPC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelefonoPC.setText("Teléfono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        panelClientes.add(lblTelefonoPC, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelClientes.add(txtDniPC, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 50);
        panelClientes.add(txtTelefonoPC, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 50);
        panelClientes.add(txtEmailPC, gridBagConstraints);

        txtIdPC.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        panelClientes.add(txtIdPC, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelClientes.add(txtNombrePC, gridBagConstraints);

        btnLimpiarPC.setText("LIMPIAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        panelClientes.add(btnLimpiarPC, gridBagConstraints);

        btnBuscarPC.setText("BUSCAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        panelClientes.add(btnBuscarPC, gridBagConstraints);

        btnModificarPC.setText("MODIFICAR");
        btnModificarPC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        panelClientes.add(btnModificarPC, gridBagConstraints);

        btnEliminarPC.setText("ELIMINAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        panelClientes.add(btnEliminarPC, gridBagConstraints);

        btnRefrescarPC.setText("REFRESCAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 50);
        panelClientes.add(btnRefrescarPC, gridBagConstraints);

        btnRegistrarPC.setText("REGISTRAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 50, 0, 5);
        panelClientes.add(btnRegistrarPC, gridBagConstraints);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "DNI", "Telefono", "Email"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // ← esto bloquea la edición
            }
        });
        scrollTablaClientes.setViewportView(tablaClientes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 48, 20, 48);
        panelClientes.add(scrollTablaClientes, gridBagConstraints);

        tabbedContenido.addTab("Clientes", panelClientes);

        panelHabitaciones.setLayout(new java.awt.GridBagLayout());

        lblIdPH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdPH.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 5, 5);
        panelHabitaciones.add(lblIdPH, gridBagConstraints);

        lblNumeroPH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumeroPH.setText("N° Habitación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelHabitaciones.add(lblNumeroPH, gridBagConstraints);

        lblPrecioPH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecioPH.setText("Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelHabitaciones.add(lblPrecioPH, gridBagConstraints);

        lblTipoPH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipoPH.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        panelHabitaciones.add(lblTipoPH, gridBagConstraints);

        lblEstadoPH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstadoPH.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelHabitaciones.add(lblEstadoPH, gridBagConstraints);

        txtIdPH.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 2, 5);
        panelHabitaciones.add(txtIdPH, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 5, 5);
        panelHabitaciones.add(txtNumeroPH, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 5, 5);
        panelHabitaciones.add(txtPrecioPH, gridBagConstraints);

        cbxTipoPH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple", "Doble", "Suite" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 4, 50);
        panelHabitaciones.add(cbxTipoPH, gridBagConstraints);

        cbxEstadoPH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupada", "Mantenimiento" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 5, 50);
        panelHabitaciones.add(cbxEstadoPH, gridBagConstraints);

        btnLimpiarPH.setText("LIMPIAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        panelHabitaciones.add(btnLimpiarPH, gridBagConstraints);

        btnBuscarPH.setText("BUSCAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        panelHabitaciones.add(btnBuscarPH, gridBagConstraints);

        btnModificarPH.setText("MODIFICAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        panelHabitaciones.add(btnModificarPH, gridBagConstraints);

        btnEliminarPH.setText("ELIMINAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        panelHabitaciones.add(btnEliminarPH, gridBagConstraints);

        btnRefrescarPH.setText("REFRESCAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 50);
        panelHabitaciones.add(btnRefrescarPH, gridBagConstraints);

        btnGuardarPH.setText("GARDAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(15, 50, 0, 5);
        panelHabitaciones.add(btnGuardarPH, gridBagConstraints);

        tablaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "N° Habitación", "Tipo", "Estado", "Precio"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // ← esto bloquea la edición
            }
        });
        scrollTablaHabitaciones.setViewportView(tablaHabitaciones);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 48, 20, 48);
        panelHabitaciones.add(scrollTablaHabitaciones, gridBagConstraints);

        tabbedContenido.addTab("Habitaciones", panelHabitaciones);

        panelReservas.setLayout(new java.awt.GridBagLayout());

        cbxClientePR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar Cliente", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 5, 5);
        panelReservas.add(cbxClientePR, gridBagConstraints);

        cbxHabitacionPR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar Habitacion", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelReservas.add(cbxHabitacionPR, gridBagConstraints);

        lblFechaInicioPR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaInicioPR.setText("Fecha de Inicio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        panelReservas.add(lblFechaInicioPR, gridBagConstraints);

        lblFechaFinPR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaFinPR.setText("Fecha de Fin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelReservas.add(lblFechaFinPR, gridBagConstraints);

        lblEstadoPR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstadoPR.setText("Estado");
        lblEstadoPR.setMaximumSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelReservas.add(lblEstadoPR, gridBagConstraints);

        lblFechaReservaPR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaReservaPR.setText("Fecha de Reserva");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelReservas.add(lblFechaReservaPR, gridBagConstraints);

        txtFechaInicioPR.setMinimumSize(new java.awt.Dimension(260, 28));
        txtFechaInicioPR.setPreferredSize(new java.awt.Dimension(260, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 2, 5);
        panelReservas.add(txtFechaInicioPR, gridBagConstraints);

        txtFechaFinPR.setMinimumSize(new java.awt.Dimension(260, 28));
        txtFechaFinPR.setPreferredSize(new java.awt.Dimension(260, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 5);
        panelReservas.add(txtFechaFinPR, gridBagConstraints);

        txtEstadoPR.setEditable(false);
        txtEstadoPR.setMaximumSize(new java.awt.Dimension(200, 2147483647));
        txtEstadoPR.setMinimumSize(new java.awt.Dimension(200, 28));
        txtEstadoPR.setPreferredSize(new java.awt.Dimension(200, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 5, 5);
        panelReservas.add(txtEstadoPR, gridBagConstraints);

        txtFechaReservaPR.setEditable(false);
        txtFechaReservaPR.setMinimumSize(new java.awt.Dimension(260, 28));
        txtFechaReservaPR.setPreferredSize(new java.awt.Dimension(260, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 5);
        panelReservas.add(txtFechaReservaPR, gridBagConstraints);

        btnLimpiarPR.setText("LIMPIAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(4, 50, 4, 50);
        panelReservas.add(btnLimpiarPR, gridBagConstraints);

        btnReservarPR.setText("RESERVAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 4, 50);
        panelReservas.add(btnReservarPR, gridBagConstraints);

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Habitación", "Fecha de Inicio", "Fecha de Fin", "Estado"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // ← esto bloquea la edición
            }
        });
        scrollTablaReservas.setViewportView(tablaReservas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 48, 20, 49);
        panelReservas.add(scrollTablaReservas, gridBagConstraints);

        tabbedContenido.addTab("Reservaciones", panelReservas);

        panelPagos.setLayout(new java.awt.GridBagLayout());

        cbxReservaPP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 5, 5);
        panelPagos.add(cbxReservaPP, gridBagConstraints);

        cbxMetodoPP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Efectivo", "Tarjeta" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelPagos.add(cbxMetodoPP, gridBagConstraints);

        lblFechaPP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaPP.setText("Fecha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        panelPagos.add(lblFechaPP, gridBagConstraints);

        lblMontoPP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMontoPP.setText("Monto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelPagos.add(lblMontoPP, gridBagConstraints);

        txtFechaPP.setMinimumSize(new java.awt.Dimension(260, 28));
        txtFechaPP.setPreferredSize(new java.awt.Dimension(260, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 2, 20);
        panelPagos.add(txtFechaPP, gridBagConstraints);

        txtMontoPP.setMinimumSize(new java.awt.Dimension(260, 28));
        txtMontoPP.setPreferredSize(new java.awt.Dimension(260, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 5, 20);
        panelPagos.add(txtMontoPP, gridBagConstraints);

        btnRegistrarPP.setText("REGISTRAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 4, 50);
        panelPagos.add(btnRegistrarPP, gridBagConstraints);

        btnLimpiarPP.setText("LIMPIAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(4, 50, 5, 50);
        panelPagos.add(btnLimpiarPP, gridBagConstraints);

        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pago", "ID Reserva", "Monto", "Fecha", "Método de Pago"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // ← esto bloquea la edición
            }
        });
        scrollTablaPagos.setViewportView(tablaPagos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 48, 20, 49);
        panelPagos.add(scrollTablaPagos, gridBagConstraints);

        tabbedContenido.addTab("Pagos", panelPagos);

        panelCheck.setLayout(new java.awt.GridBagLayout());

        lblHabitacionPCK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHabitacionPCK.setText("Habitación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(80, 50, 10, 5);
        panelCheck.add(lblHabitacionPCK, gridBagConstraints);

        lblEstadoActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstadoActual.setText("Estado actual");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 5);
        panelCheck.add(lblEstadoActual, gridBagConstraints);

        cbxHabitacionPCK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(80, 10, 10, 50);
        panelCheck.add(cbxHabitacionPCK, gridBagConstraints);

        txtEstadoPCK.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 50);
        panelCheck.add(txtEstadoPCK, gridBagConstraints);

        btnCheckIn.setText("CHECK - IN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 75);
        panelCheck.add(btnCheckIn, gridBagConstraints);

        btnCheckOut.setText("CHECK - OUT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 75);
        panelCheck.add(btnCheckOut, gridBagConstraints);

        btnRefrescarPCK.setText("REFRESCAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 75);
        panelCheck.add(btnRefrescarPCK, gridBagConstraints);

        lblImagenInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagenInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/imagen/db_operador.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelCheck.add(lblImagenInicio, gridBagConstraints);

        tabbedContenido.addTab("Check", panelCheck);

        panelContenido.add(tabbedContenido);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelPrincipal.add(panelContenido, gridBagConstraints);

        getContentPane().add(panelPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPC;
    private javax.swing.JButton btnBuscarPH;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEliminarPC;
    private javax.swing.JButton btnEliminarPH;
    private javax.swing.JButton btnGuardarPH;
    private javax.swing.JButton btnHabitaciones;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLimpiarPC;
    private javax.swing.JButton btnLimpiarPH;
    private javax.swing.JButton btnLimpiarPP;
    private javax.swing.JButton btnLimpiarPR;
    private javax.swing.JButton btnModificarPC;
    private javax.swing.JButton btnModificarPH;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnRefrescarPC;
    private javax.swing.JButton btnRefrescarPCK;
    private javax.swing.JButton btnRefrescarPH;
    private javax.swing.JButton btnRegistrarPC;
    private javax.swing.JButton btnRegistrarPP;
    private javax.swing.JButton btnReservaciones;
    private javax.swing.JButton btnReservarPR;
    private javax.swing.JComboBox<String> cbxClientePR;
    private javax.swing.JComboBox<String> cbxEstadoPH;
    private javax.swing.JComboBox<String> cbxHabitacionPCK;
    private javax.swing.JComboBox<String> cbxHabitacionPR;
    private javax.swing.JComboBox<String> cbxMetodoPP;
    private javax.swing.JComboBox<String> cbxReservaPP;
    private javax.swing.JComboBox<String> cbxTipoPH;
    private javax.swing.JLabel lblBtnCheck;
    private javax.swing.JLabel lblBtnClientes;
    private javax.swing.JLabel lblBtnHabitaciones;
    private javax.swing.JLabel lblBtnInicio;
    private javax.swing.JLabel lblBtnPagos;
    private javax.swing.JLabel lblBtnReservaciones;
    private javax.swing.JLabel lblDniPC;
    private javax.swing.JLabel lblEmailPC;
    private javax.swing.JLabel lblEstadoActual;
    private javax.swing.JLabel lblEstadoPH;
    private javax.swing.JLabel lblEstadoPR;
    private javax.swing.JLabel lblFechaFinPR;
    private javax.swing.JLabel lblFechaInicioPR;
    private javax.swing.JLabel lblFechaPP;
    private javax.swing.JLabel lblFechaReservaPR;
    private javax.swing.JLabel lblHabitacionPCK;
    private javax.swing.JLabel lblIdPC;
    private javax.swing.JLabel lblIdPH;
    private javax.swing.JLabel lblImagenInicio;
    private javax.swing.JLabel lblImgInicio;
    private javax.swing.JLabel lblImgLogo;
    private javax.swing.JLabel lblMontoPP;
    private javax.swing.JLabel lblNombrePC;
    private javax.swing.JLabel lblNumeroPH;
    private javax.swing.JLabel lblPrecioPH;
    private javax.swing.JLabel lblSlogan;
    private javax.swing.JLabel lblTelefonoPC;
    private javax.swing.JLabel lblTipoPH;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelCheck;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelHabitaciones;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelPagos;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelReservas;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollTablaClientes;
    private javax.swing.JScrollPane scrollTablaHabitaciones;
    private javax.swing.JScrollPane scrollTablaPagos;
    private javax.swing.JScrollPane scrollTablaReservas;
    private javax.swing.JTabbedPane tabbedContenido;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaHabitaciones;
    private javax.swing.JTable tablaPagos;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTextField txtDniPC;
    private javax.swing.JTextField txtEmailPC;
    private javax.swing.JTextField txtEstadoPCK;
    private javax.swing.JTextField txtEstadoPR;
    private javax.swing.JTextField txtFechaFinPR;
    private javax.swing.JTextField txtFechaInicioPR;
    private javax.swing.JTextField txtFechaPP;
    private javax.swing.JTextField txtFechaReservaPR;
    private javax.swing.JTextField txtIdPC;
    private javax.swing.JTextField txtIdPH;
    private javax.swing.JTextField txtMontoPP;
    private javax.swing.JTextField txtNombrePC;
    private javax.swing.JTextField txtNumeroPH;
    private javax.swing.JTextField txtPrecioPH;
    private javax.swing.JTextField txtTelefonoPC;
    // End of variables declaration//GEN-END:variables
}
