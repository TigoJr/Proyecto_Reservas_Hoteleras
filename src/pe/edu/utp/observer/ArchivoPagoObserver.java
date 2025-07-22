/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.observer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import pe.edu.utp.modelo.Pago;

/**
 *
 * @author USUARIO
 */
public class ArchivoPagoObserver implements PagoObserver {

    private static final String RUTA_ARCHIVO = "pagos.log";

    @Override
    public void notificar(Pago pago) {
        try (FileWriter fw = new FileWriter(RUTA_ARCHIVO, true); PrintWriter pw = new PrintWriter(fw)) {

            pw.println("PAGO | Reserva #" + pago.getIdReserva()
                    + " | Monto: $" + pago.getMonto()
                    + " | Método: " + pago.getMetodoPago()
                    + " | Fecha: " + pago.getFecha());

        } catch (IOException e) {
            System.err.println("Error al escribir en archivo: " + e.getMessage());
        }
    }
}
