/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.observer;

import javax.swing.JOptionPane;
import pe.edu.utp.modelo.Pago;

/**
 *
 * @author USUARIO
 */
public class VistaPagoObservable implements PagoObserver {

    @Override
    public void notificar(Pago pago) {
        String mensaje = "Notificación: Pago de $" + pago.getMonto()
                + " realizado para la reserva #" + pago.getIdReserva()
                + " con método: " + pago.getMetodoPago();

        JOptionPane.showMessageDialog(null, mensaje, "Notificación de Pago", JOptionPane.INFORMATION_MESSAGE);
    }
}
