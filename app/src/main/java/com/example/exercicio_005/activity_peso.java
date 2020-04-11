package com.example.exercicio_005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_peso extends AppCompatActivity {

    private Spinner sp;
    private EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);
        sp = (Spinner)findViewById(R.id.spinnerpeso);
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

// mg, g, kg, lb, oz
        float mg = 0.0f, g = 0.0f, kg = 0.0f, lb = 0.0f, oz = 0.0f;

        if(opc.equals("mg")){
            mg = v;
            g = mg/1000;
            kg = g/1000;
            lb = kg*2.20462f; // valor aproximado alterar para 2.205
            oz = lb*16;
        }
        if(opc.equals("g")){

            g = v;
            mg = g*1000 ;
            kg = g/1000;
            lb = kg*2.20462f;
            oz = lb*16;
        }
        if(opc.equals("kg")){

            kg = v;
            g = kg*1000;
            mg = g*1000;
            lb = kg*2.20462f;
            oz = lb*16;
        }
        if(opc.equals("lb")){

            lb = v;
            kg = lb*2.20462f;
            g = kg*1000;
            mg = g*1000;
            oz = lb*16;
        }
        if(opc.equals("oz")){

            oz = v;
            lb = oz/16;;
            kg = lb*2.20462f;
            g = kg*1000;
            mg = g*1000;





        }

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);
        TextView txt4 = (TextView) findViewById(R.id.txt4);
        TextView txt5 = (TextView) findViewById(R.id.txt5);


        txt1.setText(""+ mg + " mg");
        txt2.setText(""+ g + " g");
        txt3.setText(""+ kg + " kg");
        txt4.setText(""+ lb + " lb");
        txt5.setText(""+ oz + " oz");

    }
}
