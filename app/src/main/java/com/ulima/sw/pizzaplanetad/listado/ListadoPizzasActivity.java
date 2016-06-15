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
import com.ulima.sw.pizzaplanetad.R;
import com.ulima.sw.pizzaplanetad.Adapter.ListadoPizzasAdapter;
import com.ulima.sw.pizzaplanetad.beans.Pizza;

import java.util.List;

public class ListadoPizzasActivity extends AppCompatActivity implements ListadoPizzasView, ObservableScrollViewCallbacks {

    private ListadoPizzasPresenter lPresenter;
    private ObservableListView lstPizzas;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Listado Pizzas");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_listado_pizzas);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Cargando... Por favor espere");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


        lstPizzas = (ObservableListView)findViewById(R.id.lstPizza);
        lstPizzas.setScrollViewCallbacks(this);

        setPresenter(new ListadoPizzasPresenterImp(this));
        Intent intentPasado = getIntent();
       // lPresenter.obtenerListaP((List<Pizza>)intentPasado.getSerializableExtra("pizzas"));


    }

    @Override
    public void setPresenter(ListadoPizzasPresenter presenter) {
        this.lPresenter = presenter;
    }

    @Override
    public void mostrarPizzas(List<Pizza> Pizzas) {
        ListadoPizzasAdapter adapter = new ListadoPizzasAdapter(Pizzas,this);
        lstPizzas.setAdapter(adapter);
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
