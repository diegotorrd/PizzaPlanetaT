package com.ulima.sw.pizzaplanetad.Grid;

import com.ulima.sw.pizzaplanetad.beans.pedido.Info;

import java.util.List;

/**
 * Created by Diego Torres on 14/06/2016.
 */
public interface GridViewT {
    public void setPresenter(GridPresenter presenter);
    public void mostrarPedidos(List<Info> pedidos);
    public void toAst(int num);
}
