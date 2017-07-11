package com.siva.platzigram;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.siva.platzigram.actividades.ContainerActivity;
import com.siva.platzigram.actividades.CreateAccountActivity;
import com.siva.platzigram.actividades.PictureDetailActivity;

public class loginActivity extends AppCompatActivity {

    Button login;
    TextView crearCuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.boton_login);
        crearCuenta = (TextView)findViewById(R.id.crearCuenta);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this, ContainerActivity.class));
            }
        });

        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this, CreateAccountActivity.class));
            }
        });
    }

}
