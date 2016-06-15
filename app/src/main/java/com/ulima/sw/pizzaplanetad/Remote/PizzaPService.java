package com.ulima.sw.pizzaplanetad.Remote;

import com.ulima.sw.pizzaplanetad.beans.Info;
import com.ulima.sw.pizzaplanetad.beans.Pedido;

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

        @GET("getPedidos")
        Call<List<Pedido>> obtenerPedidos();

    @GET("getInfo")
    Call<List<Info>> getInfo();

    @GET("actualizarEstado")
    Call<String> actualizarEstado(@Query("estado") int idestado,@Query("pedido") int idPedido );


        //@GET("equipos")
        //Call<List<Equipo>> obtenerEquipos();

        //@GET("equipos/{id}")
        //Call<Equipo> obtenerEquipoID(@Path("id") int id);


        //@GET("alumnos?sin_equipo=true")
        //Call<List<Alumno>> obtenerAlumnosSEqu();

        //@POST("equipos/{id}/{codigo_alumno}")
        //Call<Mensaje> agregarAlumnoaEquipo(@Path("id") int id, @Path("codigo_alumno") String codigo);
    }


