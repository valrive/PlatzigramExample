package com.siva.platzigram.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.siva.platzigram.R;

public class CreateAccountActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_tittle_createAccount), true);

    }

    public void showToolbar(String tittle, boolean upBoton){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        //para que el toolbar pueda verse bien en versiones anteriores a lollipop
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBoton);
    }
}
