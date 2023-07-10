package com.example.dam_uc4_luque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btn_registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_registrar = findViewById(R.id.btn_regis);
        btn_registrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Snackbar.make(view, "DATOS REGISTRADOS", Snackbar.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, NotasActivity.class);
                startActivity(i);
            }
        });


    }


}