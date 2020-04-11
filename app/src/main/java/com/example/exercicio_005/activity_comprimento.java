package com.example.exercicio_005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_comprimento extends AppCompatActivity {

    private Spinner sp;
    private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprimento);

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

// mm, cm, dm, m, km
        float mm = 0.0f, cm = 0.0f, dm = 0.0f, m = 0.0f, km = 0.0f;

        if(opc.equals("mm")){
            mm = v;
            cm = mm/10;
            dm = cm/10;
            m = dm/10;
            km = m/1000;

        }
        if(opc.equals("cm")){

            cm = v;
            mm = cm*10;
            dm = cm/10;
            m = dm/10;
            km = m/1000;
        }
        if(opc.equals("dm")){

            dm = v;
            mm = dm*100;
            cm = mm/10;
            m = dm/10;
            km = m/1000;
        }
        if(opc.equals("m")){

            m = v;
            mm = m*1000 ;
            cm = mm/10;
            dm = cm/10;
            km = m/1000;
        }
        if(opc.equals("km")){

            km = v;
            mm = km*1000000;
            cm = mm/10;
            dm = cm/10;
            m = dm/10;

        }

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);
        TextView txt4 = (TextView) findViewById(R.id.txt4);
        TextView txt5 = (TextView) findViewById(R.id.txt5);


        txt1.setText(""+ mm + " mm");
        txt2.setText(""+ cm + " cm");
        txt3.setText(""+ dm + " dm");
        txt4.setText(""+ m + " m");
        txt5.setText(""+ km + " km");

    }


}

