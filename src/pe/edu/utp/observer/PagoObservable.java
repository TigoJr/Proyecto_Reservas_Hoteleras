/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.observer;

import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.modelo.Pago;

/**
 *
 * @author USUARIO
 */
public class PagoObservable {

    private final List<PagoObserver> observadores = new ArrayList<>();

    public void agregarObservador(PagoObserver obs) {
        observadores.add(obs);
    }

    public void eliminarObservador(PagoObserver obs) {
        observadores.remove(obs);
    }

    public void notificarObservadores(Pago pago) {
        for (PagoObserver obs : observadores) {
            obs.notificar(pago);
        }
    }
}
