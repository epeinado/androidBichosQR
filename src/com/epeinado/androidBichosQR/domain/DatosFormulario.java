package com.epeinado.androidBichosQR.domain;

import com.epeinado.androidBichosQR.encoder.Encode;

/**
 * User: epeinado
 * Date: 14/07/14
 * Time: 13:23
 */
public class DatosFormulario {

    public DatosFormulario(long empresa, long cliente, long puntoControl) {
        this.empresa = empresa;
        this.cliente = cliente;
        this.puntoControl = puntoControl;
    }

    public DatosFormulario(String datosQR) {
//        Seleccionmos la parte codificada de la URL
        String[] splits = datosQR.split("/");
        String encode = splits[splits.length-1];
//        La decodificamos para coger sus campos
        Encode encoder = new Encode();
        String decode = encoder.decrypt(encode);
        decode = decode.replace(".html","");
        splits = decode.split("/");
//        Setteamos los valores
        this.empresa = Long.valueOf(splits[0]);
        this.cliente = Long.valueOf(splits[1]);
        this.puntoControl = Long.valueOf(splits[2]);
    }

    long empresa;

    long cliente;

    long puntoControl;

    public long getCliente() {
        return cliente;
    }

    public void setCliente(long cliente) {
        this.cliente = cliente;
    }

    public long getPuntoControl() {
        return puntoControl;
    }

    public void setPuntoControl(long puntoControl) {
        this.puntoControl = puntoControl;
    }

    public long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(long empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatosFormulario that = (DatosFormulario) o;

        if (cliente != that.cliente) return false;
        if (empresa != that.empresa) return false;
        if (puntoControl != that.puntoControl) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (empresa ^ (empresa >>> 32));
        result = 31 * result + (int) (cliente ^ (cliente >>> 32));
        result = 31 * result + (int) (puntoControl ^ (puntoControl >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "DatosFormulario{" +
                "empresa=" + empresa +
                ", cliente=" + cliente +
                ", puntoControl=" + puntoControl +
                '}';
    }
}
