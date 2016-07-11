package com.ulima.sw.pizzaplanetad.Remote;

import com.ulima.sw.pizzaplanetad.beans.pedido.Info;
import com.ulima.sw.pizzaplanetad.beans.pedido.ProductoPedido;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fixt on 11/05/16.
 */

    public interface PizzaPService {
    @GET("loginTrabajador")
    Call<String> obtenerLogin(@Query("usuario") String usuario, @Query("password") String password);

    @GET("getInfo")
    Call<List<Info>> getInfo(@Query("username") String usuario);

    @GET("actualizarEstado")
    Call<Integer> actualizarEstado(@Query("estado") int idestado,@Query("pedido") int idPedido,@Query("username") String usuario );

    @GET("obtenerPedido")
    Call<List<ProductoPedido>> obtenerPedido(@Query("pedido") int idPedido );







    }


