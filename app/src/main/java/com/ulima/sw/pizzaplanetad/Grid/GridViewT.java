package com.ulima.sw.pizzaplanetad.Grid;

import com.ulima.sw.pizzaplanetad.beans.Pedido;

import java.util.List;

/**
 * Created by Diego Torres on 14/06/2016.
 */
public interface GridViewT {
    public void setPresenter(GridPresenter presenter);
    public void mostrarEquipos(List<Pedido> pedidos);
}
