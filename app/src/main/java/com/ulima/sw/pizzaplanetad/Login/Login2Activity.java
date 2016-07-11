package com.ulima.sw.pizzaplanetad.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ulima.sw.pizzaplanetad.Grid.GridActivityT;
import com.ulima.sw.pizzaplanetad.R;
import com.ulima.sw.pizzaplanetad.beans.usuario.Usuario;

public class Login2Activity extends AppCompatActivity implements LoginView{
    private LoginPresenter lPresenter;
    private EditText eteUsuario, etePassword;
    private ProgressDialog dialog;
    private Usuario gusuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        eteUsuario = (EditText) findViewById(R.id.txtUsuario);
        etePassword = (EditText) findViewById(R.id.txtContra);
        gusuario= new Usuario();

    }

    public void onLoginClicked(View view){
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Cargando... Por favor espere");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        String usuario = eteUsuario.getText().toString().trim();
        String password = etePassword.getText().toString();
        gusuario.setUsername(usuario);
        gusuario.setPassword(password);
        setPresenter(new LoginPresenterImp(this));

        lPresenter.obtenerLoginU(gusuario);
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.lPresenter=presenter;
    }

    @Override
    public void callActiviy(String resp) {
        if (resp.equalsIgnoreCase("1")){
            Toast.makeText(this,"Credenciales correctas",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, GridActivityT.class);
            intent.putExtra("usuario",gusuario.getUsername());
            eteUsuario.setText(null);
            etePassword.setText(null);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Credenciales Erradas", Toast.LENGTH_SHORT).show();

        }
        dialog.dismiss();


    }
}
