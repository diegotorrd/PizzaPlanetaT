package com.ulima.sw.pizzaplanetad.listado;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.ulima.sw.pizzaplanetad.Adapter.ListadoProductosAdapter;
import com.ulima.sw.pizzaplanetad.R;
import com.ulima.sw.pizzaplanetad.beans.pedido.ProductoPedido;

import java.util.List;

public class ListadoProductosActivity extends AppCompatActivity implements ListadoProductosView, ObservableScrollViewCallbacks {

    private ListadoProductosPresenter lPresenter;
    private ObservableListView lstProductos;
    private ProgressDialog dialog;
    private int idPedido;
    private ActionBar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeButtonEnabled(true);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intentPasado = getIntent();

        setContentView(R.layout.activity_listado_productos);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Cargando... Por favor espere");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


        lstProductos = (ObservableListView)findViewById(R.id.lstProductos);
        lstProductos.setScrollViewCallbacks(this);

        setPresenter(new ListadoProductosPresenterImp(this));
        idPedido=intentPasado.getIntExtra("id",0);
        lPresenter.obtenerListaP(idPedido);


    }

    @Override
    public void setPresenter(ListadoProductosPresenter presenter) {
        this.lPresenter = presenter;
    }

    @Override
    public void mostrarPedido(List<ProductoPedido> pedidos) {
        ListadoProductosAdapter adapter = new ListadoProductosAdapter(pedidos,this);
        lstProductos.setAdapter(adapter);
        dialog.dismiss();

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
}
