package com.ulima.sw.pizzaplanetad.Grid;


import com.ulima.sw.pizzaplanetad.Remote.PizzaPService;
import com.ulima.sw.pizzaplanetad.beans.pedido.Info;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GridPresenterImp implements GridPresenter {

    private GridViewT Gview;
    private List<Info> pedidos;

    public GridPresenterImp(GridViewT gview) {
        Gview = gview;
        pedidos= new ArrayList<>();
    }



    @Override
    public void obtenerPedidos(String usuario) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pizzaplanetad.mybluemix.net/webresources/generic/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PizzaPService service = retrofit.create(PizzaPService.class);
        service.getInfo(usuario).enqueue(new Callback<List<Info>>() {
            @Override
            public void onResponse(Call<List<Info>> call, Response<List<Info>> response) {
                pedidos=response.body();
                Gview.mostrarPedidos(pedidos);
            }

            @Override
            public void onFailure(Call<List<Info>> call, Throwable t) {

            }
        });


    }

    @Override
    public void cambiarEstado(int estado, int pedido, String usuario) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pizzaplanetad.mybluemix.net/webresources/generic/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PizzaPService service = retrofit.create(PizzaPService.class);
        service.actualizarEstado(estado,pedido,usuario).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Gview.toAst(response.body());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });

    }
}
