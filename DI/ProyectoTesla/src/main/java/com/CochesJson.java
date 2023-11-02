/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author at5DAM2
 */
public class CochesJson {

    String modelo;
    int autonomia, precio,potencia;

    public CochesJson(String modelo, int autonomia, int precio, int potencia) {
        this.modelo = modelo;
        this.autonomia = autonomia;
        this.precio = precio;
        this.potencia = potencia;
    }
    public String toCSV(){
    return modelo+","+potencia+","+autonomia+","+precio;
    }
}
