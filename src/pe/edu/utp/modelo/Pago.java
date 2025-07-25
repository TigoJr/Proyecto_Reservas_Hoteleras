/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.modelo;

import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class Pago {
    private int idPago;
    private int idReserva;
    private double monto;
    private Date fecha;
    private String metodoP;

    public Pago() {
    }

    public Pago(int idPago, int idReserva, double monto, Date fecha, String metodoP) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.monto = monto;
        this.fecha = fecha;
        this.metodoP = metodoP;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodoP() {
        return metodoP;
    }

    public void setMetodoP(String metodoP) {
        this.metodoP = metodoP;
    }
    
}