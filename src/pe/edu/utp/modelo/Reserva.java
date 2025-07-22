/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.modelo;

import java.util.Date;
import pe.edu.utp.state.EstadoReserva;

public class Reserva {

    private int idReserva;
    private int idCliente;
    private int idHabitacion;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaReserva;

    private EstadoReserva estadoActual;

    public Reserva() {
    }

    public Reserva(int idReserva, int idCliente, int idHabitacion, Date fechaInicio, Date fechaFin, Date fechaReserva, EstadoReserva estadoActual) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaReserva = fechaReserva;
        this.estadoActual = estadoActual;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    public EstadoReserva getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoReserva estadoActual) {
        this.estadoActual = estadoActual;
    }

    public void mostrarEstado() {
        if (estadoActual != null) {
            estadoActual.mostrarEstado();
        } else {
            System.out.println("Estado no definido.");
        }
    }

    public String getNombreEstado() {
        return (estadoActual != null) ? estadoActual.getNombreEstado() : null;
    }
}
