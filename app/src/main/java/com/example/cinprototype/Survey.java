package com.example.cinprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.*;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Survey extends AppCompatActivity {
    //SQLiteDatabase
    ToggleButton helpful, decisionChange;
    EditText suggestion;
    Button submit;
    ImprovementModel improvementModel;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    String postId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        helpful = findViewById(R.id.helpful);
        decisionChange = findViewById(R.id.decisionChange);
        suggestion = findViewById(R.id.suggestions);
        submit = findViewById(R.id.submitSurvey);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                improvementModel = new ImprovementModel();
                improvementModel.setHelpful(helpful.isChecked());
                improvementModel.setDecisionChange(decisionChange.isChecked());
                improvementModel.setSuggestions(suggestion.getText().toString());
                Toast.makeText(Survey.this, improvementModel.toString(), Toast.LENGTH_SHORT);
                reference = database.getReference("android");
                DatabaseReference pushedReference = reference.push();
                postId = pushedReference.getKey();
                reference.child(postId).setValue(improvementModel);
                //DataBaseHelper dataBaseHelper = new DataBaseHelper(Survey.this);

                //boolean success = dataBaseHelper.addOne(improvementModel);

                Toast.makeText(Survey.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}