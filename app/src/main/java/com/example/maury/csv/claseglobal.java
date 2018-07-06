package com.example.maury.csv;

import android.app.Activity;
import android.app.Application;

/**
 * Created by Maury on 5/7/2018.
 */

public class claseglobal extends Application {

   private int contador;
    private int contadescrip;
   private String contruccion;
    private String planta;

    public int getContador() {
        return contador;
    }

    public int getContadescrip() {
        return contadescrip;
    }

    public void setContadescrip(int contadescrip) {
        this.contadescrip = contadescrip;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getContruccion() {
        return contruccion;
    }

    public void setContruccion(String contruccion) {
        this.contruccion = contruccion;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }
}
