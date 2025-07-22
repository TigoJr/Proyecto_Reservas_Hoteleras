/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.factory;

import pe.edu.utp.state.EstadoDisponible;
import pe.edu.utp.state.EstadoHabitacion;
import pe.edu.utp.state.EstadoMantenimiento;
import pe.edu.utp.state.EstadoOcupada;

/**
 *
 * @author USUARIO
 */
public class EstadoHabitacionFactory {

    public static EstadoHabitacion crearEstado(String estadoTexto) {
        if (estadoTexto == null) return null;

        return switch (estadoTexto.trim().toLowerCase()) {
            case "disponible" -> new EstadoDisponible();
            case "ocupada" -> new EstadoOcupada();
            case "mantenimiento" -> new EstadoMantenimiento();
            default -> null;
        };
    }
}