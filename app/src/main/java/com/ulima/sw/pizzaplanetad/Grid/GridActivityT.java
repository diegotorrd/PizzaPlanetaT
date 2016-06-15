package com.ulima.sw.pizzaplanetad.Grid;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.github.ksoichiro.android.observablescrollview.ObservableGridView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.ulima.sw.pizzaplanetad.Adapter.ListadoPedidosAdapter;
import com.ulima.sw.pizzaplanetad.R;
import com.ulima.sw.pizzaplanetad.beans.Info;

import java.util.List;

public class GridActivityT extends AppCompatActivity implements GridViewT,ObservableScrollViewCallbacks {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ProgressDialog dialog;
    private ObservableGridView GridPedidos;
    private GridPresenter GPresenter;
    private ListadoPedidosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Pedidos");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_grid);
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Cargando... Por favor espere");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        GridPedidos = (ObservableGridView)findViewById(R.id.grdPedidos);
        GridPedidos.setScrollViewCallbacks(this);

        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                refreshItems();
            }
        });

        setPresenter(new GridPresenterImp(this));
        GPresenter.obtenerPedidos();
    }

    @Override
    public void setPresenter(GridPresenter presenter) {
        this.GPresenter = presenter;
    }

    @Override
    public void mostrarEquipos(final List<Info> pedidos) {
        adapter = new ListadoPedidosAdapter(pedidos,this);
        GridPedidos.setAdapter(adapter);
        dialog.dismiss();
//        GridPedidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(GridActivityT.this, ListadoPizzasActivity.class);
//                intent.putExtra("pizzas",(Serializable)pedidos.get(position).getPizzas());
//                startActivity(intent);
//
//            }
//
//        });

    }


    public void refreshItems() {
        // Load items
        // ...
        GPresenter.obtenerPedidos();
        // Load complete
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        // NOSOTROS NO LO USAMOS PORQUE EL FLUJO YA ESTA CORRECTO

        // Stop refresh animation
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

        ActionBar ab = getSupportActionBar();
        if (ab == null) {
            return;
        }
        if (scrollState == ScrollState.UP) {
            if (ab.isShowing()) {
                ab.hide();
            }
        } else if (scrollState == ScrollState.DOWN) {
            if (!ab.isShowing()) {
                ab.show();
            }
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                if (getParentActivityIntent() == null) {
                    Log.i("TAG", "You have forgotten to specify the parentActivityName in the AndroidManifest!");
                    onBackPressed();
                } else {
                    NavUtils.navigateUpFromSameTask(this);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
