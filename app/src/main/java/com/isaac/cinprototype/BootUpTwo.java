package com.isaac.cinprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;

public class BootUpTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_up_two);
        Button Yes = findViewById(R.id.button2);
        Button No = findViewById(R.id.button);
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BootUpTwo.this);
                builder.setMessage("Please proceed with a non-contrast test.");
                builder.setCancelable(true);
                builder.setTitle("Result:");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}