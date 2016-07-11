package com.ulima.sw.pizzaplanetad.listado;

import com.ulima.sw.pizzaplanetad.Remote.PizzaPService;
import com.ulima.sw.pizzaplanetad.beans.pedido.ProductoPedido;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoProductosPresenterImp implements ListadoProductosPresenter {

    private ListadoProductosView lview;

    public ListadoProductosPresenterImp(ListadoProductosView lview) {
        this.lview = lview;
    }

    @Override
    public void obtenerListaP(int idPedido) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pizzaplanetad.mybluemix.net/webresources/generic/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PizzaPService service = retrofit.create(PizzaPService.class);
        service.obtenerPedido(idPedido).enqueue(new Callback<List<ProductoPedido>>() {
            @Override
            public void onResponse(Call<List<ProductoPedido>> call, Response<List<ProductoPedido>> response) {
                lview.mostrarPedido(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductoPedido>> call, Throwable t) {

            }
        });

    }
}
