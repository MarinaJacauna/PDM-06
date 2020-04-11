package com.example.exercicio_005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_tempo extends AppCompatActivity {


    private Spinner sp;
    private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo);

        sp = (Spinner)findViewById(R.id.spinnercomp);
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

// ms, s, min, hora, dia
        float ms = 0.0f, s = 0.0f, min = 0.0f, hr = 0.0f, dia = 0.0f;

        if(opc.equals("ms")){
            ms = v;
            s = ms/1000;
            min = s/60;
            hr = min/60;
            dia = hr/24;
        }
        if(opc.equals("s")){

            s = v;
            ms = s*1000;
            min = s/60;
            hr = min/60;
            dia = hr/24;
        }
        if(opc.equals("min")){

            min = v;
            s = min*60;
            ms = s*1000;
            hr = min/60;
            dia = hr/24;
        }
        if(opc.equals("hr")){

            hr = v;
            min = hr*60;
            s = min*60;
            ms = min*1000;
            dia = hr/24;
        }
        if(opc.equals("dia")){

            dia = v;
            hr = dia*24;
            min = hr*60;
            s = min*60;
            ms = s*1000;


        }

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);
        TextView txt4 = (TextView) findViewById(R.id.txt4);
        TextView txt5 = (TextView) findViewById(R.id.txt5);


        txt1.setText(""+ ms + " ms");
        txt2.setText(""+ s + " seg");
        txt3.setText(""+ min + " min");
        txt4.setText(""+ hr + " hr");
        txt5.setText(""+ dia + " dia");

    }
}
