package com.ulima.sw.pizzaplanetad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ulima.sw.pizzaplanetad.Grid.GridActivityT;
import com.ulima.sw.pizzaplanetad.Grid.GridPresenter;
import com.ulima.sw.pizzaplanetad.R;
import com.ulima.sw.pizzaplanetad.beans.pedido.Info;

import java.util.List;

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
        int cont;
        if (view == null){
            view = mInflater.inflate(R.layout.item_pedido, null);
            viewHolder = new ViewHolder();
            viewHolder.imgE =(ImageView) view.findViewById(R.id.imgE);
            viewHolder.txtPedido = (TextView) view.findViewById(R.id.txtPedidoItem);
            viewHolder.txtNombre=(TextView) view.findViewById(R.id.txtNombre);
            viewHolder.txtDireccion=(TextView) view.findViewById(R.id.txtDireccion);
            viewHolder.txtDistrito=(TextView) view.findViewById(R.id.txtDistrito);
            viewHolder.txtMonto=(TextView) view.findViewById(R.id.txtMonto);
            //viewHolder.idpedido=(TextView) view.findViewById(R.id.idPedido);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        final Info pedido = lPedidos.get(position);
        cont=position+1;
        viewHolder.txtPedido.setText("Pedido #"+cont);
        viewHolder.txtNombre.setText("Cliente: "+pedido.getNombre());
        viewHolder.txtDireccion.setText(pedido.getDireccion());
        viewHolder.txtDistrito.setText(pedido.getDistrito());
        //viewHolder.idpedido.setText(pedido.getId());
        viewHolder.txtMonto.setText("Monto: "+Float.toString( pedido.getMontoTot()));
        if (pedido.getEstado() == 2) {
            viewHolder.imgE.setImageResource(R.drawable.verde);
        }else if (pedido.getEstado() == 3) {
            viewHolder.imgE.setImageResource(R.drawable.ambar);
        }else if (pedido.getEstado() == 4) {
            viewHolder.imgE.setImageResource(R.drawable.celeste);
        }

        ImageView camino =(ImageView) view.findViewById(R.id.moto);
        ImageView entregado =(ImageView) view.findViewById(R.id.cart);
        final String usuario =((GridActivityT) mContext).getUsuario();

        camino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GridActivityT) mContext).cambioEstado(3,pedido.getId(),usuario);
            }
        });

        entregado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GridActivityT) mContext).cambioEstado(4,pedido.getId(),usuario);
            }
        });

        return view;
    }

    class ViewHolder{
        ImageView imgE;
        TextView txtPedido;
        TextView txtDireccion;
        TextView txtDistrito;
        TextView txtNombre;
        TextView txtMonto;
        TextView idpedido;

    }
}
