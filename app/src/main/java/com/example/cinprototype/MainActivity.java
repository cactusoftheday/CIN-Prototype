package com.example.cinprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.os.Bundle;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox age = findViewById(R.id.age);
        CheckBox hematocrit = findViewById(R.id.hematocrit);
        CheckBox diabetic = findViewById(R.id.diabetic);
        CheckBox anemic = findViewById(R.id.anemic);
        CheckBox IABP = findViewById(R.id.IABP);
        CheckBox CHF = findViewById(R.id.CHF);
        CheckBox CKD = findViewById(R.id.CKD);
        CheckBox eGFR = findViewById(R.id.eGFR);
        Button submit = findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                int risk = 0;
                if(age.isChecked()){
                    risk++;
                    age.setChecked(false);
                }
                if(hematocrit.isChecked()){
                    risk++;
                    hematocrit.setChecked(false);
                }
                if(diabetic.isChecked()){
                    risk++;
                    diabetic.setChecked(false);
                }
                if (anemic.isChecked()){
                    risk++;
                    anemic.setChecked(false);
                }
                if (IABP.isChecked()){
                    risk++;
                    IABP.setChecked(false);
                }
                if (CHF.isChecked()){
                    risk++;
                    CHF.setChecked(false);
                }
                if (CKD.isChecked()){
                    risk++;
                    CKD.setChecked(false);
                }
                if (eGFR.isChecked()){
                    risk++;
                    eGFR.setChecked(false);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                if(risk == 1){
                    builder.setMessage("The patient has a total of "+Integer.toString(risk)+" risk");
                }
                else{
                    builder.setMessage("The patient has a total of "+Integer.toString(risk)+" risks");
                }
                builder.setCancelable(true);
                builder.setTitle("Results:");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}