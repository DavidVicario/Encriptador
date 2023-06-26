package com.davidvicario.encriptadorv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;

public class Ajustes extends AppCompatActivity {

    public static Integer tCifra = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        //Declaración de botones
        final RadioButton cesar = findViewById(R.id.btnCesar);
        final RadioButton pares = findViewById(R.id.btnPares);
        final RadioButton contra = findViewById(R.id.btnContraseña);
        final Switch estado = findViewById(R.id.swiEstado);

        cesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCifra = new Intent(Ajustes.this, MainActivity.class);
                tCifra = 1;
                startActivity(iCifra);
            }
        });

        pares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCifra = new Intent(Ajustes.this, MainActivity.class);
                tCifra = 2;
                startActivity(iCifra);
            }
        });

        contra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCifra = new Intent(Ajustes.this, MainActivity.class);
                tCifra = 3;
                startActivity(iCifra);
            }
        });

        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (estado.isChecked()){
                    MainActivity.gEstado = true;
                    MainActivity.textEstado.setText("Cifrar al escribir");
                } else {
                    MainActivity.gEstado = false;
                    MainActivity.textEstado.setText("");
                }
            }
        });

    }
}