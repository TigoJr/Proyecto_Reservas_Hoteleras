/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.observer;

import pe.edu.utp.modelo.Pago;

/**
 *
 * @author USUARIO
 */
public interface PagoObserver {
     void notificar(Pago pago);
}
