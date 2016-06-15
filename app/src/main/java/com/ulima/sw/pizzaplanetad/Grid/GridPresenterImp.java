package com.ulima.sw.pizzaplanetad.Grid;


import com.ulima.sw.pizzaplanetad.Remote.PizzaPService;
import com.ulima.sw.pizzaplanetad.beans.Info;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GridPresenterImp implements GridPresenter {

    private GridViewT Gview;

    public GridPresenterImp(GridViewT gview) {
        Gview = gview;
    }

    @Override
    public void obtenerPedidos() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pizzaplanetac.mybluemix.net/webresources/generic/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PizzaPService service = retrofit.create(PizzaPService.class);
        service.getInfo().enqueue(new Callback<List<Info>>() {
            @Override
            public void onResponse(Call<List<Info>> call, Response<List<Info>> response) {
                Gview.mostrarEquipos(response.body());
            }

            @Override
            public void onFailure(Call<List<Info>>  call, Throwable t) {

            }
        });

//        List<Info> pedidos = new ArrayList<>();
//
//        Info ped = new Info("Av. la molina 258","Diego",2,1);
//        Info ped2 = new Info("Av. San Borja 458","Diana",2,2);
//        Info ped3 = new Info("Av. cipreses 123","Jose",3,3);
//        Info ped4 = new Info("Av. marte 896","Joseph",3,4);
//        Info ped5 = new Info("Av. javier prado 258","Christopher",3,5);
//        Info ped6 = new Info("Av. gran chimu 189","Sergio",2,6);
//
//        pedidos.add(ped);
//        pedidos.add(ped2);
//        pedidos.add(ped3);
//        pedidos.add(ped4);
//        pedidos.add(ped5);
//        pedidos.add(ped6);


//
//        Estado est = new Estado();
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date fecha = new Date();
//
//        est.setId(3);
//        est.setEstado("En Camino");
//        est.setHora(df.format(fecha));
//
//        ped.setEstado(est);
//
//        List<Pizza> pizzas = new ArrayList<>();
//        Pizza p1 = new Pizza();
//        Pizza p2 = new Pizza();
//
//        p1.setId(1);
//        p1.setNombre("Americana");
//        p1.setTamaño("M");
//
//        p1.setImg("@drawable/americana");
//
//        pizzas.add(p1);
//        p2.setId(2);
//        p2.setNombre("Bacon");
//        p2.setTamaño("F");
//        p2.setImg("@drawable/bacon");
//
//        pizzas.add(p2);
//
//        ped.setPizzas(pizzas);
//        pedidos.add(ped);
//
//        Pedido ped2 = new Pedido();
//        ped.setId(2);
//        ped2.setUsuario("Sergio");
//        ped2.setMonto(65.50f);
//        ped2.setDireccion("Av. San Borja 258");
//        Estado est2 = new Estado();
//        Date fecha2 = new Date();
//
//        est.setId(4);
//        est.setEstado("Entregado");
//        est.setHora(df.format(fecha2));
//
//        ped2.setEstado(est);
//
//        ped2.setPizzas(pizzas);



    }

    @Override
    public void cambiarEstado(int estado, int pedido) {

    }
}
