package com.example.caosapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    String[] categorias = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        loadInformation();
        onItemSelectetSpinner();
    }

    private void onItemSelectetSpinner() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, categorias);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(getCategoria(position)==getString(R.string.hombre)){
                    goToHombre(view);
                }
                else if (getCategoria(position)==getString(R.string.mujer)){
                    goToMujer(view);
                }
                else if (getCategoria(position)==getString(R.string.nino)){
                    goToNiño(view);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initComponent() {
        spinner = findViewById(R.id.spinnerCategorias);
    }

    private void loadInformation() {

        categorias[0]=getString(R.string.vacio);
        categorias[1]=getString(R.string.hombre);
        categorias[2]=getString(R.string.mujer);
        categorias[3]=getString(R.string.nino);
    }

    private String getCategoria(int index){
        return categorias[index];
    }
    public void goToHombre(View view) {
        Intent intent = new Intent(this, VistaCategoriaHombresActivity.class);
        startActivity(intent);
    }
    public void goToMujer(View view) {
        Intent intent = new Intent(this, VistacategoriamujeressActivity.class);
        startActivity(intent);
    }
    public void goToNiño(View view) {
        Intent intent = new Intent(this, VistaCategoriaNinossActivity.class);
        startActivity(intent);
    }

}
