package com.ulima.sw.pizzaplanetad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ulima.sw.pizzaplanetad.Grid.GridPresenter;
import com.ulima.sw.pizzaplanetad.R;
import com.ulima.sw.pizzaplanetad.Remote.PizzaPService;
import com.ulima.sw.pizzaplanetad.beans.Info;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diego Torres on 14/06/2016.
 */
public class ListadoPedidosAdapter extends BaseAdapter {
    private List<Info> lPedidos;
    private LayoutInflater mInflater;
    private Context mContext;
    private GridPresenter gPresenter;
    private ViewHolder viewHolder;

    public ListadoPedidosAdapter(List<Info> pedidos, Context context){
        mContext = context;
        lPedidos = pedidos;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lPedidos.size();
    }

    @Override
    public Object getItem(int position) {
        return lPedidos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lPedidos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null){
            view = mInflater.inflate(R.layout.item_pedido, null);
            viewHolder = new ViewHolder();
            viewHolder.imgE =(ImageView) view.findViewById(R.id.imgE);
            viewHolder.txtPedido = (TextView) view.findViewById(R.id.txtPedidoItem);
            viewHolder.txtNombre=(TextView) view.findViewById(R.id.txtNombre);
            viewHolder.txtDireccion=(TextView) view.findViewById(R.id.txtDireccion);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        final Info pedido = lPedidos.get(position);
        viewHolder.txtPedido.setText("Pedido #"+position+1);
        viewHolder.txtNombre.setText(pedido.getNombre());
        viewHolder.txtDireccion.setText(pedido.getDireccion());
        if (pedido.getEstado() == 2) {
            viewHolder.imgE.setImageResource(R.drawable.verde);
        }else if (pedido.getEstado() == 3) {
            viewHolder.imgE.setImageResource(R.drawable.ambar);
        }

        ImageView moto = (ImageView) view.findViewById( R.id.moto);
        ImageView cart = (ImageView) view.findViewById( R.id.cart);

        moto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://pizzaplanetac.mybluemix.net/webresources/generic/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                PizzaPService service = retrofit.create(PizzaPService.class);
                service.actualizarEstado(pedido.getId(),3).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        viewHolder.imgE.setImageResource(R.drawable.ambar);
                    }

                    @Override
                    public void onFailure(Call<String>  call, Throwable t) {

                    }
                });
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://pizzaplanetac.mybluemix.net/webresources/generic/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                PizzaPService service = retrofit.create(PizzaPService.class);
                service.actualizarEstado(pedido.getId(),4).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                    }

                    @Override
                    public void onFailure(Call<String>  call, Throwable t) {

                    }
                });
            }
        });
        return view;
    }

    class ViewHolder{
        ImageView imgE;
        TextView txtPedido;
        TextView txtNombre;
        TextView txtDireccion;
    }
}
