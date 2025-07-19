/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import pe.edu.utp.dao.ClienteDao;
import pe.edu.utp.dao.HabitacionDao;
import pe.edu.utp.dao.PagoDao;
import pe.edu.utp.dao.ReservaDao;
import pe.edu.utp.modelo.Cliente;
import pe.edu.utp.vista.MenuPrincipal;

/**
 *
 * @author USUARIO
 */
public class MenuPrincipalControlador implements ActionListener {

    private final MenuPrincipal menu;

    public MenuPrincipalControlador(MenuPrincipal menu) {
        this.menu = menu;

        personalizarHeader(menu.tablaClientes, new java.awt.Color(102, 51, 255));
        personalizarCuerpoTabla(menu.tablaClientes);
        personalizarScrollPane(menu.scrollTablaClientes);
        
        personalizarHeader(menu.tablaHabitaciones, new java.awt.Color(102, 51, 255));
        personalizarCuerpoTabla(menu.tablaHabitaciones);
        personalizarScrollPane(menu.scrollTablaHabitaciones);
        
        personalizarHeader(menu.tablaReservas, new java.awt.Color(102, 51, 255));
        personalizarCuerpoTabla(menu.tablaReservas);
        personalizarScrollPane(menu.scrollTablaReservas);
        
        personalizarHeader(menu.tablaPagos, new java.awt.Color(102, 51, 255));
        personalizarCuerpoTabla(menu.tablaPagos);
        personalizarScrollPane(menu.scrollTablaPagos);

        menu.btnInicioLateral.addActionListener((ActionListener) this);
        menu.btnCheckLateral.addActionListener((ActionListener) this);
        menu.btnClientesLateral.addActionListener((ActionListener) this);
        menu.btnHabitacionLateral.addActionListener((ActionListener) this);
        menu.btnReservaLateral.addActionListener((ActionListener) this);
        menu.btnPagoLateral.addActionListener((ActionListener) this);
        menu.btnCerrar.addActionListener((ActionListener) this);

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        HabitacionDao habitacionDao = new HabitacionDao();
        ReservaDao reservaDao = new ReservaDao();
        PagoDao pagoDao = new PagoDao();
        
        new GestionHabitacionControlador(habitacionDao, menu);
        new ReservaControlador(menu, clienteDao, habitacionDao, reservaDao);
        new GestionClienteControlador(clienteDao, cliente, menu);
        new PagoControlador(menu, pagoDao, reservaDao);
        new CheckInOutControlador(habitacionDao, menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menu.btnInicioLateral) {
            int index = menu.tabbedMenu.indexOfComponent(menu.panelInicio);
            menu.tabbedMenu.setSelectedIndex(index);

        } else if (e.getSource() == menu.btnClientesLateral) {
            int index = menu.tabbedMenu.indexOfComponent(menu.panelClientes);
            menu.tabbedMenu.setSelectedIndex(index);

        } else if (e.getSource() == menu.btnHabitacionLateral) {
            int index = menu.tabbedMenu.indexOfComponent(menu.panelHabitaciones);
            menu.tabbedMenu.setSelectedIndex(index);

        } else if (e.getSource() == menu.btnReservaLateral) {
            int index = menu.tabbedMenu.indexOfComponent(menu.panelReservas);
            menu.tabbedMenu.setSelectedIndex(index);

        } else if (e.getSource() == menu.btnPagoLateral) {
            int index = menu.tabbedMenu.indexOfComponent(menu.panelPagos);
            menu.tabbedMenu.setSelectedIndex(index);

        } else if (e.getSource() == menu.btnCheckLateral) {
            int index = menu.tabbedMenu.indexOfComponent(menu.panelCheck);
            menu.tabbedMenu.setSelectedIndex(index);

        } else if (e.getSource() == menu.btnCerrar) {
            System.exit(0);
        }
    }

    private static void personalizarHeader(JTable tabla, Color colorFondo) {
        JTableHeader header = tabla.getTableHeader();

        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setBackground(colorFondo != null ? colorFondo : new Color(51, 102, 153));
                setForeground(Color.WHITE);
                setFont(new Font("Segoe UI", Font.BOLD, 14));
                setHorizontalAlignment(JLabel.CENTER);
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(200, 200, 200)),
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                ));
                return this;
            }
        });

        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30));
        header.setReorderingAllowed(false);
    }

    private static void personalizarCuerpoTabla(JTable tabla) {
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.setRowHeight(25);
        tabla.setShowGrid(false);
        tabla.setIntercellSpacing(new Dimension(0, 0));
        tabla.setSelectionBackground(new Color(220, 240, 255));
        tabla.setSelectionForeground(Color.BLACK);
        tabla.setBorder(BorderFactory.createEmptyBorder());

        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    setBackground(row % 2 == 0 ? Color.WHITE : new Color(248, 248, 248));
                }

                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                return this;
            }
        });
    }

    private static void personalizarScrollPane(JScrollPane scrollPane) {
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        JScrollBar horizontal = scrollPane.getHorizontalScrollBar();

        vertical.setUnitIncrement(16);
        horizontal.setUnitIncrement(16);

        vertical.setBackground(Color.WHITE);
        horizontal.setBackground(Color.WHITE);
    }
}
