package com.example.exercicio_005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TelaTempo(View v){
        Intent intent1 = new Intent(getApplicationContext(), activity_tempo.class);
        startActivity(intent1);

    }

    public void TelaVolume(View v){
        Intent intent2 = new Intent(getApplicationContext(), activity_volume.class);
        startActivity(intent2);

    }

    public void TelaPeso(View v){
        Intent intent3 = new Intent(getApplicationContext(), activity_peso.class);
        startActivity(intent3);

    }

    public void TelaArea(View v){
        Intent intent4 = new Intent(getApplicationContext(), activity_area.class);
        startActivity(intent4);

    }

    public void TelaComprimento(View v){
        Intent intent5 = new Intent(getApplicationContext(), activity_comprimento.class);
        startActivity(intent5);

    }

    public void TelaTemperatura(View v){
        Intent intent6 = new Intent(getApplicationContext(), activity_temperatura.class);
        startActivity(intent6);

    }
}
