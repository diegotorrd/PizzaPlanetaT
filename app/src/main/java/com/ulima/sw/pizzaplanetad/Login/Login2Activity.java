package com.ulima.sw.pizzaplanetad.Login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ulima.sw.pizzaplanetad.R;
import com.ulima.sw.pizzaplanetad.beans.Usuario;

public class Login2Activity extends AppCompatActivity implements LoginView{
    private LoginPresenter lPresenter;
    private EditText eteUsuario, etePassword;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        eteUsuario = (EditText) findViewById(R.id.txtUsuario);
        etePassword = (EditText) findViewById(R.id.txtContra);

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
        Usuario user= new Usuario(usuario, password);
        setPresenter(new LoginPresenterImp(this));

        lPresenter.obtenerLoginU(user);
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.lPresenter=presenter;
    }

    @Override
    public void callActiviy(String resp) {
        if (resp.equalsIgnoreCase("1")){
            //Intent intent = new Intent(this, GridActivityT.class);
            //eteUsuario.setText(null);
            //etePassword.setText(null);
            //startActivity(intent);
            Toast.makeText(this,"Credenciales correctas",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Credenciales Erradas", Toast.LENGTH_SHORT).show();

        }
        dialog.dismiss();


    }
}