package com.isaac.cincalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;

import com.isaac.cincalculator.R;

public class BootUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_up);
        Button Yes = findViewById(R.id.button2);
        Button No = findViewById(R.id.button);
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondBootUpActivity();
            }
        });

        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BootUp.this);
                builder.setMessage("Please proceed with the test.");
                builder.setCancelable(true);
                builder.setTitle("Result:");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
    public void openSecondBootUpActivity() {
        Intent intent = new Intent(this, BootUpTwo.class);
        startActivity(intent);
    }
}