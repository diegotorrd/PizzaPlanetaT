package com.ulima.sw.pizzaplanetad.listado;

import com.ulima.sw.pizzaplanetad.beans.Pedido;
import com.ulima.sw.pizzaplanetad.beans.Pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 6/05/2016.
 */
public class ListadoPizzasPresenterImp implements ListadoPizzasPresenter {

    private ListadoPizzasView lview;

    public ListadoPizzasPresenterImp(ListadoPizzasView lview) {
        this.lview = lview;
    }


    public void obtenerListaP2() {

        List<Pedido> pedidos = new ArrayList<>();

        List<Pizza> pizzas = new ArrayList<>();
        Pizza pi = new Pizza();
        Pizza p1 = new Pizza();

        pi.setId(1);
        pi.setNombre("Americana");
        pi.setTamaño("M");

        pi.setImg("@drawable/americana");

        pizzas.add(pi);
        p1.setId(2);
        p1.setNombre("Bacon");
        p1.setTamaño("F");
        p1.setImg("@drawable/bacon");

        pizzas.add(p1);



       lview.mostrarPizzas(pizzas);
    }

    @Override
    public void obtenerListaP(List<Pizza> pizzas) {

        lview.mostrarPizzas(pizzas);
    }
}
