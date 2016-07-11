package com.ulima.sw.pizzaplanetad.listado;

import com.ulima.sw.pizzaplanetad.beans.pedido.ProductoPedido;

import java.util.List;

/**
 * Created by Admin on 6/05/2016.
 */
public interface ListadoProductosView {
    public void setPresenter(ListadoProductosPresenter presenter);
    public void mostrarPedido(List<ProductoPedido> pedidos);
}
