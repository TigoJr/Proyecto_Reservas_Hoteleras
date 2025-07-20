/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.estilo;

/**
 *
 * @author USUARIO
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class Estilos {

    private static final Map<JButton, Boolean> botonesActivos = new HashMap<>();
    private static final Map<JButton, JLabel> botonesLabels = new HashMap<>();

    public static void panelPrincipal(JPanel panel) {
        panel.setBackground(PaletaColores.FONDO_CLARO);
    }

    public static void panelTitulo(JPanel panel) {
        panel.setBackground(PaletaColores.FONDO_ALTERNO);
    }

    public static void panelLateral(JPanel panel) {
        panel.setBackground(PaletaColores.PRIMARIO_CLARO);
    }

    public static void panelContenido(JPanel panel) {
        panel.setBackground(PaletaColores.FONDO_CLARO);
    }

    public static void panelSeccion(JPanel panel) {
        panel.setBackground(PaletaColores.ACENTO_VERDE);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    public static void botonLateralConLabel(BotonLateralConLabel par, Set<JButton> grupo) {
        JButton boton = par.boton;
        JLabel label = par.label;

        botonesActivos.put(boton, false);
        botonesLabels.put(boton, label);

        boton.setBackground(PaletaColores.PRIMARIO_CLARO);
        boton.setForeground(PaletaColores.TEXTO_CLARO);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(true);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);

        label.setOpaque(true);
        label.setBackground(PaletaColores.PRIMARIO_CLARO);
        label.setForeground(PaletaColores.TEXTO_CLARO);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!Boolean.TRUE.equals(botonesActivos.get(boton))) {
                    boton.setBackground(PaletaColores.PRIMARIO_OSCURO);
                    label.setBackground(PaletaColores.PRIMARIO_OSCURO);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!Boolean.TRUE.equals(botonesActivos.get(boton))) {
                    boton.setBackground(PaletaColores.PRIMARIO_CLARO);
                    label.setBackground(PaletaColores.PRIMARIO_CLARO);
                }
            }
        });
    }

    public static void resaltarBotonActivo(JButton activo, Set<JButton> grupo) {
        for (JButton btn : grupo) {
            boolean esActivo = (btn == activo);
            botonesActivos.put(btn, esActivo);

            Color color = esActivo ? PaletaColores.PRIMARIO_OSCURO : PaletaColores.PRIMARIO_CLARO;
            btn.setBackground(color);

            JLabel lbl = botonesLabels.get(btn);
            if (lbl != null) {
                lbl.setBackground(color);
            }
        }
    }

    public static void botonFormulario(JButton boton, Color colorFondo) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setForeground(PaletaColores.TEXTO_CLARO);
        boton.setBackground(colorFondo);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);

        Color hover = colorFondo.darker();

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorFondo);
            }
        });
    }

    public static void personalizarTabla(JTable tabla) {
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.setForeground(PaletaColores.TABLA_TEXTO);
        tabla.setRowHeight(28);
        tabla.setGridColor(PaletaColores.TABLA_BORDE);
        tabla.setSelectionBackground(PaletaColores.TABLA_SELECCION);
        tabla.setSelectionForeground(Color.WHITE);
        tabla.setShowGrid(true);
        tabla.setIntercellSpacing(new Dimension(1, 1));

        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0
                            ? PaletaColores.TABLA_FILA_PAR
                            : PaletaColores.TABLA_FILA_IMPAR);
                    c.setForeground(PaletaColores.TABLA_TEXTO);
                }
                return c;
            }
        });

        JTableHeader header = tabla.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(PaletaColores.TABLA_HEADER_FONDO);
        header.setForeground(PaletaColores.TABLA_HEADER_TEXTO);
        header.setReorderingAllowed(false);

        personalizarScrollTabla(tabla);
    }

    private static void personalizarScrollTabla(JTable tabla) {
        JScrollPane scroll = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, tabla);
        if (scroll != null) {
            scroll.setBorder(BorderFactory.createLineBorder(PaletaColores.TABLA_SELECCION, 2));
            scroll.getViewport().setBackground(PaletaColores.FONDO_CLARO);

            JScrollBar vertical = scroll.getVerticalScrollBar();
            vertical.setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = PaletaColores.TABLA_SELECCION;
                    this.trackColor = PaletaColores.FONDO_CLARO;
                }
            });

            JScrollBar horizontal = scroll.getHorizontalScrollBar();
            horizontal.setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = PaletaColores.TABLA_SELECCION;
                    this.trackColor = PaletaColores.FONDO_CLARO;
                }
            });
        }
    }

    public static void personalizarCampoTexto(JTextField campo) {
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        campo.setForeground(PaletaColores.CAMPO_TEXTO);
        campo.setBackground(PaletaColores.CAMPO_FONDO);

        Border paddingBorder = BorderFactory.createEmptyBorder(4, 10, 4, 10);
        Border lineBorder = BorderFactory.createLineBorder(PaletaColores.CAMPO_BORDE);
        campo.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));

        campo.setCaretColor(PaletaColores.PRIMARIO_CLARO);

        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (campo.isEnabled()) {
                    Border focusBorder = BorderFactory.createLineBorder(PaletaColores.CAMPO_BORDE_FOCUS, 2);
                    campo.setBorder(BorderFactory.createCompoundBorder(focusBorder, paddingBorder));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (campo.isEnabled()) {
                    campo.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
                }
            }
        });

        campo.addPropertyChangeListener("enabled", evt -> {
            boolean habilitado = campo.isEnabled();
            campo.setBackground(habilitado ? PaletaColores.CAMPO_FONDO : PaletaColores.CAMPO_FONDO_INACTIVO);
            campo.setForeground(habilitado ? PaletaColores.CAMPO_TEXTO : PaletaColores.CAMPO_TEXTO_INACTIVO);
        });

        if (!campo.isEnabled()) {
            campo.setBackground(PaletaColores.CAMPO_FONDO_INACTIVO);
            campo.setForeground(PaletaColores.CAMPO_TEXTO_INACTIVO);
        }
    }

    public static void marcarCampoError(JTextField campo) {
        campo.setBorder(BorderFactory.createLineBorder(PaletaColores.CAMPO_BORDE_ERROR, 2));
    }

    public static void limpiarErrorCampo(JTextField campo) {
        campo.setBorder(BorderFactory.createLineBorder(PaletaColores.CAMPO_BORDE));
    }

    public static void personalizarComboBox(JComboBox<?> combo) {
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        combo.setForeground(PaletaColores.COMBO_TEXTO);
        combo.setBackground(PaletaColores.COMBO_FONDO);
        combo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        combo.setBorder(BorderFactory.createLineBorder(PaletaColores.COMBO_BORDE));
        combo.setFocusable(false);

        combo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (combo.isEnabled()) {
                    combo.setBorder(BorderFactory.createLineBorder(PaletaColores.COMBO_BORDE_FOCUS, 2));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (combo.isEnabled()) {
                    combo.setBorder(BorderFactory.createLineBorder(PaletaColores.COMBO_BORDE));
                }
            }
        });

        combo.addPropertyChangeListener("enabled", evt -> {
            boolean habilitado = combo.isEnabled();
            combo.setBackground(habilitado ? PaletaColores.COMBO_FONDO : PaletaColores.COMBO_FONDO_INACTIVO);
            combo.setForeground(habilitado ? PaletaColores.COMBO_TEXTO : PaletaColores.COMBO_TEXTO_INACTIVO);
        });

        if (!combo.isEnabled()) {
            combo.setBackground(PaletaColores.COMBO_FONDO_INACTIVO);
            combo.setForeground(PaletaColores.COMBO_TEXTO_INACTIVO);
        }

        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lbl.setOpaque(true);

                if (isSelected) {
                    lbl.setBackground(PaletaColores.PRIMARIO_CLARO);
                    lbl.setForeground(Color.WHITE);
                } else {
                    lbl.setBackground(Color.WHITE);
                    lbl.setForeground(PaletaColores.COMBO_TEXTO);
                }

                return lbl;
            }
        });
    }

    public static void labelLateral(JLabel label) {
        label.setForeground(PaletaColores.LABEL_LATERAL_TEXTO);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(false);
    }

    public static void labelTitulo(JLabel label) {
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(PaletaColores.LABEL_TITULO);
        label.setHorizontalAlignment(SwingConstants.LEFT);
    }

    public static void labelFormulario(JLabel label) {
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setForeground(PaletaColores.LABEL_FORMULARIO);
    }

    public static void estilizarTabbedPane(JTabbedPane tabbedPane) {
        tabbedPane.setUI(new BasicTabbedPaneUI() {
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
                return 0;
            }
        });

        tabbedPane.setBorder(BorderFactory.createEmptyBorder());
        tabbedPane.setBackground(PaletaColores.FONDO_CLARO);
    }

}
