package com.example.exercicio_005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_volume extends AppCompatActivity {
    private Spinner sp;
    private EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        sp = (Spinner)findViewById(R.id.spinnervolume);
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
        float L = 0.0f, cm3 = 0.0f, dm3 = 0.0f, M3 = 0.0f, in3 = 0.0f;

        if(opc.equals("L")){
            L = v;
            cm3 = L/1000;
            dm3 = cm3/1000;
            M3 = dm3/1000;
            in3 =  M3*61023.7f; // valor aproximado alterar para 61024
        }
        if(opc.equals("cm3")){
            cm3 = v;
            L = cm3*1000;
            dm3 = cm3/1000;
            M3 = dm3/1000;
            in3 = M3*61023.7f;
        }
        if(opc.equals("dm3")){

            dm3 = v;
            cm3 = dm3*1000;
            L = cm3*1000;
            M3 = dm3/1000;
            in3 = M3*61023.7f;
        }
        if(opc.equals("M3")){

            M3 = v;
            dm3 = M3*1000;
            cm3 = dm3*1000;
            L = cm3*1000;
            in3 = M3*61023.7f;
        }
        if(opc.equals("in3")){

            in3 = v;
            M3 = in3/61023.7f;
            dm3 = M3*1000;
            cm3 = dm3*1000;
            L = cm3*1000;



        }

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);
        TextView txt4 = (TextView) findViewById(R.id.txt4);
        TextView txt5 = (TextView) findViewById(R.id.txt5);


        txt1.setText(""+ L + " L");
        txt2.setText(""+ cm3 + " cm3");
        txt3.setText(""+ dm3 + " dm3");
        txt4.setText(""+ M3 + " M3");
        txt5.setText(""+ in3 + " in3");

    }
}
