package com.example.exercicio_005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_area extends AppCompatActivity {

    private Spinner sp;
    private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_area);

        sp = (Spinner)findViewById(R.id.spinnerarea);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                calcular(sp.getSelectedItem().toString());
            }
            public void onNothingSelected(AdapterView<?> parent){

            }

        });

        txt = (EditText)findViewById(R.id.valora);
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
                    ((EditText) findViewById(R.id.valora)).getText().toString());
        }
        catch (Exception ex){}

// cm², dm², m², in², ft²
        float cm = 0.0f, dm = 0.0f, m = 0.0f, in = 0.0f, ft = 0.0f;

        if(opc.equals("cm²")){
            cm = v;
            dm = cm/100;
            m = dm/100;
            in = m/0.00064516f;
            ft = in/144;
        }
        if(opc.equals("dm²")){

            dm = v;
            cm = dm*100;
            m = dm/100;
            in = m/0.00064516f;
            ft = in/144;
        }
        if(opc.equals("m²")){

            m = v;
            cm = m*10000 ;
            dm = cm/100;
            in = m/0.00064516f;
            ft = in/144;
        }
        if(opc.equals("in²")){

            in = v;
            cm = in*6.4516f;
            dm = cm/100;
            m = dm/100;
            ft = in/144;
        }
        if(opc.equals("ft²")){

            ft = v;
            in = ft*144;
            cm = in*6.4516f;
            dm = cm/10;
            m = dm/10;
        }

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);
        TextView txt4 = (TextView) findViewById(R.id.txt4);
        TextView txt5 = (TextView) findViewById(R.id.txt5);


        txt1.setText(""+ cm + " cm²");
        txt2.setText(""+ dm + " dm²");
        txt3.setText(""+ m + " m²");
        txt4.setText(""+ in + " in²");
        txt5.setText(""+ ft + " ft²");

    }


}
