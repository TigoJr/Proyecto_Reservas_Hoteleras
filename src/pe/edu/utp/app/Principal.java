/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.utp.app;

import javax.swing.JFrame;
import pe.edu.utp.controlador.MenuPrincipalControlador;
import pe.edu.utp.vista.MenuPrincipal;

/**
 *
 * @author USUARIO
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        new MenuPrincipalControlador(menu);

        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

}
