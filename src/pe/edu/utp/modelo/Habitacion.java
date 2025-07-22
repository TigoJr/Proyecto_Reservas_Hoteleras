/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.modelo;

import pe.edu.utp.state.EstadoHabitacion;

/**
 *
 * @author USUARIO
 */
public class Habitacion {

    private int idHabitacion;
    private int numero;
    private String tipo;
    private String estado;
    private double precio;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, int numero, String tipo, String estado, double precio) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
        this.precio = precio;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    private EstadoHabitacion estadoActual;

    public void setEstadoActual(EstadoHabitacion estadoActual) {
        this.estadoActual = estadoActual;
    }

    public void mostrarEstado() {
        if (estadoActual != null) {
            estadoActual.mostrarEstado();
        } else {
            System.out.println("Estado no definido.");
        }

    }
}
