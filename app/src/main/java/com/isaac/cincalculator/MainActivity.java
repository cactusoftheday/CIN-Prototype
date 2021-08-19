package com.isaac.cincalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.app.AlertDialog;
import android.widget.ToggleButton;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton age = findViewById(R.id.age);
        ToggleButton sepsis = findViewById(R.id.sepsis);
        ToggleButton nephrotoxic = findViewById(R.id.nephrotoxic);
        ToggleButton CKD = findViewById(R.id.CKD);
        ToggleButton hypotensive = findViewById(R.id.hypotensive);
        ToggleButton AKI = findViewById(R.id.AKI);
        ToggleButton contrast = findViewById(R.id.contrast);
        ToggleButton hypovolemic = findViewById(R.id.hypovolemic);

        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int risk = 0;
                if(age.isChecked()){
                    risk++;
                    age.setChecked(false);
                }
                if(sepsis.isChecked()){//take out
                    risk++;
                    sepsis.setChecked(false);
                }
                if(nephrotoxic.isChecked()){
                    risk++;
                    nephrotoxic.setChecked(false);
                }
                if (hypotensive.isChecked()){//take out
                    risk++;
                    hypotensive.setChecked(false);
                }
                if (AKI.isChecked()){//take out
                    risk++;
                    AKI.setChecked(false);
                }
                if (contrast.isChecked()){//take out
                    risk++;
                    contrast.setChecked(false);
                }
                if (CKD.isChecked()){
                    risk++;
                    CKD.setChecked(false);
                }
                if (hypovolemic.isChecked()){
                    risk++;
                    hypovolemic.setChecked(false);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                if(risk == 1){
                    builder.setMessage("The patient has a total of "+Integer.toString(risk)+" risk for developing CIN.");
                }
                else{
                    builder.setMessage("The patient has a total of "+Integer.toString(risk)+" risks for developing CIN.");
                }
                builder.setCancelable(true);
                builder.setTitle("Results:");
                builder.setPositiveButton("Continue to survey", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openSurvey();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
    public void openSurvey(){
        Intent intent = new Intent(this, Survey.class);
        startActivity(intent);
    }
}