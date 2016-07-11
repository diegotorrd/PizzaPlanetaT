package com.ulima.sw.pizzaplanetad.Grid;

/**
 * Created by Diego Torres on 14/06/2016.
 */
public interface GridPresenter {
    public void obtenerPedidos(String usuario);
    public void cambiarEstado(int estado, int pedido, String usuario);
}
