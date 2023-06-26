package com.davidvicario.encriptadorv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Variables globales

    private String cadena;
    private String cifrada = "";
    private int i;

    //Ver el estado del cifrado
    public static Boolean gEstado = true;
    @SuppressWarnings("StaticFieldLeak")
    public static TextView textEstado = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ocultar barra de aplicaciones
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        textEstado = findViewById(R.id.txtEstadoCifrado);

        //Declaración de estrada de textos
        final EditText cifra = findViewById(R.id.editCifra);
        final EditText desci = findViewById(R.id.editDesc);

        //Declaración de botones
        final Button btnCif = findViewById(R.id.btnCifra);
        final Button btnDes = findViewById(R.id.btnDescifra);
        final Button btnAju = findViewById(R.id.btnAjustes);


        //Botón de cifrado
        btnCif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Cifrado César
                if (Ajustes.tCifra == 1){

                    //Entrada de texto desde teclado
                    cadena = String.valueOf(cifra.getText());

                    //Recorrer cadena de texto
                    for (i = 0; i < cadena.length(); i++){

                        //Trasformar el caracter a codigo ASCII
                        int codigo = cadena.codePointAt(i);

                        //Sumar al codigo de ASCII 3
                        char letraMov = (char) (codigo + 3);

                        //Contruir texto cifrado
                        cifrada = cifrada + letraMov;
                    }

                    //Mostrar texto cifrado
                    desci.setText(cifrada);
                    cifrada = "";

                //Cifrado Pares
                } else if (Ajustes.tCifra == 2) {

                    //Entrada de texto desde teclado
                    cadena = String.valueOf(cifra.getText());

                    //Variables
                    char cad1 [] = cadena.toCharArray();
                    char aux;

                    //Recorrer cadena de texto
                    for (i = 0; i < cadena.length(); i++){

                        //Intercalo de posiciones
                        if ((i + 1) < cadena.length()){
                            aux = cad1[i];
                            cad1 [i]= cad1 [i + 1];
                            cad1 [i + 1]=aux;
                            i++;
                        }
                    }

                    //Mostrar texto cifrado
                    desci.setText(String.valueOf(cad1));

                //Cifrado Contraseña
                } else {

                    //Entrada de texto desde teclado
                    cadena = String.valueOf(cifra.getText());

                    String contra = "";
                    int swt = 1;
                    int num;
                    char let;

                    //Recorrer cadena de texto
                    for (i = 0; i < cadena.length(); i++){
                            //Hacer que la contraseña ocupe el largo de la frase introducida.
                            switch (swt){
                                case 1:
                                    contra = contra + "p";
                                break;
                                case 2:
                                    contra = contra + "a";
                                break;
                                case 3:
                                    contra = contra + "t";
                                break;
                                case 4:
                                    contra = contra + "a";
                                break;
                                case 5:
                                    contra = contra + "t";
                                break;
                                case 6:
                                    contra = contra + "a";
                                    swt = 0;
                                break;
                            }
                            swt ++;
                    }//Fin for


                    //Mostrar texto cifrado
                    desci.setText(cifrada);
                    cifrada = "";

                }

            }
        });

        //Botón de descifrado
        btnDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Cifrado César
                if (Ajustes.tCifra == 1){

                    //Entrada de texto desde teclado
                    cadena = String.valueOf(desci.getText());

                    //Recorrer cadena de texto
                    for (i = 0; i < cadena.length(); i++){

                        //Trasformar el caracter a codigo ASCII
                        int codigo = cadena.codePointAt(i);

                        //Restar al codigo de ASCII 3
                        char letraMov = (char) (codigo - 3);

                        //Contruir texto descifrado
                        cifrada = cifrada + letraMov;
                    }

                    //Mostrar texto descifrado
                    cifra.setText(cifrada);
                    cifrada = "";

                //Cifrado Pares
                } else if (Ajustes.tCifra == 2) {

                    //Entrada de texto desde teclado
                    cadena = String.valueOf(desci.getText());

                    //Variables
                    char cad1 [] = cadena.toCharArray();
                    char aux;

                    //Intercalo de posiciones
                    for (i = 0; i < cadena.length(); i++){
                        if ((i + 1) < cadena.length()){
                            aux = cad1[i];
                            cad1 [i]= cad1 [i + 1];
                            cad1 [i + 1]=aux;
                            i++;
                        }
                    }

                    //Mostrar texto descifrado
                    cifra.setText(String.valueOf(cad1));

                //Cifrado Contraseña
                } else {


                }

            }
        });

        //Hacer que boton Ajustes funcione con pulsación larga
        btnAju.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(MainActivity.this, Ajustes.class);
                startActivity(intent);
                return false;
            }
        });
    }

}