
package com.alexander.modelo;

public class Cliente {
    int id;
    int numeroCedula;
    int estados;
    
    

    public Cliente() {
    }

    public Cliente(int id, int numeroCedula, int estados) {
        this.id = id;
        this.numeroCedula = numeroCedula;
        this.estados = estados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(int numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public int getEstados() {
        return estados;
    }

    public void setEstados(int estados) {
        this.estados = estados;
    }

   
   

    
    
    
}
