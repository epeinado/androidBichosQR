package com.epeinado.androidBichosQR;

/**
 * User: epeinado
 * Date: 14/07/14
 * Time: 13:23
 */
public class Datos {

    public Datos(int cliente, int puntoControl) {
        this.cliente = cliente;
        this.puntoControl = puntoControl;
    }

    public Datos(String datosQR) {
        for (String campos: datosQR.split(",")) {
                    String[] campoValor = campos.split("=");
                    if (campoValor[0].equals("cliente")) {
                        this.cliente = Integer.valueOf(campoValor[1]);
                    } else if (campoValor[0].equals("puntoControl")) {
                        this.puntoControl = Integer.valueOf(campoValor[1]);
                    }
                }
    }

    int cliente;

    int puntoControl;

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getPuntoControl() {
        return puntoControl;
    }

    public void setPuntoControl(int puntoControl) {
        this.puntoControl = puntoControl;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "cliente=" + cliente +
                ", puntoControl=" + puntoControl +
                '}';
    }
}
