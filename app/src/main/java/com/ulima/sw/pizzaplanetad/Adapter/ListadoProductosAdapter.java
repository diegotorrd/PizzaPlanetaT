package com.ulima.sw.pizzaplanetad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ulima.sw.pizzaplanetad.R;
import com.ulima.sw.pizzaplanetad.beans.pedido.ProductoPedido;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by fixt on 05/05/16.
 */
public class ListadoProductosAdapter extends BaseAdapter {

    private List<ProductoPedido> lProductos;
    private LayoutInflater mInflater;
    private Context mContext;

    public ListadoProductosAdapter(List<ProductoPedido> producto,
                                   Context context){
        mContext = context;
        lProductos = producto;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return lProductos.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int acu;
        ViewHolder viewHolder;
            convertView = mInflater.inflate(R.layout.productoitm, null);
            viewHolder = new ViewHolder();
            viewHolder.tviNombre =  (TextView)convertView.findViewById(R.id.txtNombre);
            viewHolder.tviPrecio = (TextView)convertView.findViewById(R.id.txtPrecio);
            viewHolder.tviNum = (TextView)convertView.findViewById(R.id.txtOrden);
            viewHolder.tviCantidad = (TextView)convertView.findViewById(R.id.txtCantidad);


        ProductoPedido producto = lProductos.get(position);
        acu = position +1;
        viewHolder.tviNum.setText("N#"+acu);
        viewHolder.tviNombre.setText("Nombre: "  + producto.getNombre());
        DecimalFormat formatter = new DecimalFormat("#0.00");
        String monto= formatter.format(producto.getPrecio());
        viewHolder.tviPrecio.setText("Precio: " + monto);
        viewHolder.tviCantidad.setText("Cantidad: " + producto.getCantidad());

        //

        return convertView;
    }



    class ViewHolder{
        TextView tviNombre;
        TextView tviCantidad;
        TextView tviPrecio;
        TextView tviNum;
    }
}
