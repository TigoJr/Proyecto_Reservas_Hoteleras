/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.state;

/**
 *
 * @author USUARIO
 */
public class EstadoConfirmada implements EstadoReserva {

    @Override
    public void mostrarEstado() {
        System.out.println("La reserva ha sido confirmada.");
    }

    @Override
    public String getNombreEstado() {
        return "Confirmada";
    }
}
