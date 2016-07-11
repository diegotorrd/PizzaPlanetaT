package com.ulima.sw.pizzaplanetad.beans.pedido;

import java.util.Comparator;

public class Estado implements Comparable<Estado>{

    public static final String NOMBRE_ID1 = "En cola";
    public static final String NOMBRE_ID2 = "En proceso";
    public static final String NOMBRE_ID3 = "Terminado";
    public static final String NOMBRE_ID4 = "En camino";
    public static final String NOMBRE_ID5 = "Entregado";

    private int id;
    private String fechaHora;
    private String username;

    public Estado() {
    }

    public Estado(int id, String fechaHora, String username) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return getNombrePorId(id);
    }
    
    public static String getNombrePorId(int id) {
        switch (id) {
            case 1:
                return NOMBRE_ID1;
            case 2:
                return NOMBRE_ID2;
            case 3:
                return NOMBRE_ID3;
            case 4:
                return NOMBRE_ID4;
            case 5:
                return NOMBRE_ID5;
            default:
                return "";
        }
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(Estado estado) {
        int compareage=((Estado)estado).getId();
        /* For Ascending order*/
        return this.id-compareage;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }
}
