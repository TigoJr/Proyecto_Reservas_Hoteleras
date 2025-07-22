/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.modelo;

import pe.edu.utp.state.EstadoHabitacion;

public class Habitacion {

    private int idHabitacion;
    private int numero;
    private String tipo;
    private double precio;
    private EstadoHabitacion estadoActual;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, int numero, String tipo, double precio, EstadoHabitacion estadoActual) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estadoActual = estadoActual;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoHabitacion getEstadoActual() {
        return estadoActual;
    }

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
