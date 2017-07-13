package com.example.fotolity.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.fotolity.R;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Obtenemos el nombre del Toolbar parala vista
        showToolbar(getResources().getString(R.string.toolbar_title_createaccount), false);

    }


    public void showToolbar(String title, boolean upButton){
        /**
         * Es importante colocar estas dos lineas, para que el toolbar tenga soporte en versiones anteriores a Lollipop
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
