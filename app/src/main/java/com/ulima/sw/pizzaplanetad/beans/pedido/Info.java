/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulima.sw.pizzaplanetad.beans.pedido;

/**
 *
 * @author Administrator
 */
public class Info {
    
    private String direccion, nombre, distrito;
    private int estado,id;
    private float montoTot;

    public Info() {
    }
    
    
    public Info(String direccion, String nombre, int estado, int id, String distrito, float montoTot) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.estado = estado;
        this.id = id;
        this.distrito=distrito;
        this.montoTot = montoTot;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public float getMontoTot() {
        return montoTot;
    }

    public void setMontoTot(float montoTot) {
        this.montoTot = montoTot;
    }

    
    
    
}