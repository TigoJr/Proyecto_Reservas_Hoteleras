/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.factory;

import pe.edu.utp.state.EstadoCancelada;
import pe.edu.utp.state.EstadoConfirmada;
import pe.edu.utp.state.EstadoFinalizada;
import pe.edu.utp.state.EstadoPendiente;
import pe.edu.utp.state.EstadoReserva;

/**
 *
 * @author USUARIO
 */
public class EstadoReservaFactory {

    public static EstadoReserva crearEstado(String estadoTexto) {
        if (estadoTexto == null) return null;

        return switch (estadoTexto.trim().toLowerCase()) {
            case "pendiente" -> new EstadoPendiente();
            case "confirmada" -> new EstadoConfirmada();
            case "cancelada" -> new EstadoCancelada();
            case "finalizada" -> new EstadoFinalizada();
            default -> null;
        };
    }
}

