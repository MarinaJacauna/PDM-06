package com.example.exercicio_005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_temperatura extends AppCompatActivity {
    private Spinner sp;
    private EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        sp = (Spinner)findViewById(R.id.spinnertemperatura);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                calcular(sp.getSelectedItem().toString());
            }
            public void onNothingSelected(AdapterView<?> parent){

            }

        });

        txt = (EditText)findViewById(R.id.valor);
        txt.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event){
                calcular(sp.getSelectedItem().toString());
                return false;
            }
        });
    }

    public void calcular(String opc){

        float v = 0.0f;
        try {
            v = Float.parseFloat(
                    ((EditText) findViewById(R.id.valor)).getText().toString());
        }
        catch (Exception ex){}


        float celsius = 0.0f, fahrenheit  = 0.0f, kelvin = 0.0f;

        if(opc.equals("°C")){
            celsius = v;
            fahrenheit = (celsius*9/5)+32;
            kelvin = celsius + 273.15f;

        }
        if(opc.equals("°F")){
            fahrenheit = v;
            celsius = ( fahrenheit-32.0f)*5/9 ;
            kelvin = celsius + 273.15f;

        }
        if(opc.equals("K")){

            kelvin = v;
            celsius = kelvin - 273.15f;
            fahrenheit  = ((kelvin-273.15f)*9/5)+32.0f;


        }

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);



        txt1.setText(""+ celsius + " °C");
        txt2.setText(""+ fahrenheit + " °F");
        txt3.setText(""+ kelvin + " K");


    }
}
