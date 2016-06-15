package com.ulima.sw.pizzaplanetad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ulima.sw.pizzaplanetad.R;
import com.ulima.sw.pizzaplanetad.beans.Pizza;

import java.util.List;


/**
 * Created by fixt on 05/05/16.
 */
public class ListadoPizzasAdapter extends BaseAdapter{

    private List<Pizza> lProductos;
    private LayoutInflater mInflater;
    private Context mContext;

    public ListadoPizzasAdapter(List<Pizza> producto,
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
        return lProductos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = mInflater.inflate(R.layout.pizzaitm, null);
            viewHolder = new ViewHolder();
            viewHolder.iviPizza =(ImageView) view.findViewById(R.id.imgpizza);
            viewHolder.tviNombre =  (TextView)view.findViewById(R.id.txtNombre);
            viewHolder.tviTamaño = (TextView)view.findViewById(R.id.txtTam);
            viewHolder.tviNum = (TextView)view.findViewById(R.id.txtOrden);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Pizza pizza = lProductos.get(position);

        viewHolder.tviNum.setText("N#:" + pizza.getId());
        if (pizza.getNombre() == null){
            viewHolder.tviNombre.setText("Nombre: Personalizada");
        }else {
            viewHolder.tviNombre.setText("Nombre: " + pizza.getNombre());
        }
        viewHolder.tviTamaño.setText("Tamaño: " + pizza.getTamaño());
        if (pizza.getId() == 2) {
            viewHolder.iviPizza.setImageResource(R.drawable.bacon);
        }
       //

        return view;
    }

    class ViewHolder{
        ImageView iviPizza;
        TextView tviNombre;
        TextView tviTamaño;
        TextView tviNum;
    }
}
