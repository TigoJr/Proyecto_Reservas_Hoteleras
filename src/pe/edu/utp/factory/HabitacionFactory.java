/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.factory;

import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.state.EstadoDisponible;

/**
 *
 * @author USUARIO
 */
public class HabitacionFactory {

    public static Habitacion crearHabitacion(String tipo) {
        Habitacion h = new Habitacion();
        h.setTipo(tipo);

        switch (tipo.toLowerCase()) {
            case "Simple" -> h.setPrecio(50.00);
            case "doble" -> h.setPrecio(80.00);
            case "suite" -> h.setPrecio(150.00);
            default -> h.setPrecio(0.00);
        }

        h.setEstadoActual(new EstadoDisponible());

        return h;
    }
}

