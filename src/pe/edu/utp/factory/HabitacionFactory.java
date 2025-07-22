/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.factory;

import pe.edu.utp.modelo.Habitacion;

/**
 *
 * @author USUARIO
 */
public class HabitacionFactory {
    
  public static Habitacion crearHabitacion(String tipo) {
        Habitacion h = new Habitacion();
        h.setTipo(tipo);

        switch (tipo.toLowerCase()) {
            case "simple":
                h.setPrecio(50.00);
                break;
            case "doble":
                h.setPrecio(80.00);
                break;
            case "suite":
                h.setPrecio(150.00);
                break;
            default:
                h.setPrecio(0.00); // tipo desconocido
                break;
        }

        h.setEstado("Disponible"); // estado por defecto
        return h;
    }  
}
