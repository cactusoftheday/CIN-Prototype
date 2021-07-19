package com.example.cinprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//
public class Survey extends AppCompatActivity {
    //SQLiteDatabase
    ToggleButton helpful, decisionChange;
    EditText suggestion, years;
    Button submit;
    ImprovementModel improvementModel;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    String postId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        Spinner spinner = (Spinner) findViewById(R.id.profession);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.profession_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        years = findViewById(R.id.editTextNumberSigned);
        helpful = findViewById(R.id.helpful);
        decisionChange = findViewById(R.id.decisionChange);
        suggestion = findViewById(R.id.suggestions);
        submit = findViewById(R.id.submitSurvey);

        submit.setOnClickListener(v -> {
            improvementModel = new ImprovementModel();
            improvementModel.setHelpful(helpful.isChecked());
            improvementModel.setDecisionChange(decisionChange.isChecked());
            improvementModel.setSuggestions(suggestion.getText().toString());
            improvementModel.setProfession(spinner.getSelectedItem().toString());
            improvementModel.setYears(Integer.valueOf(years.getText().toString()));
            improvementModel.setPlatform("Android");
            //Toast.makeText(Survey.this, improvementModel.toString(), Toast.LENGTH_SHORT);
            reference = database.getReference();
            DatabaseReference pushedReference = reference.push();
            postId = pushedReference.getKey();
            reference.child(postId).setValue(improvementModel);
            //DataBaseHelper dataBaseHelper = new DataBaseHelper(Survey.this);

            //boolean success = dataBaseHelper.addOne(improvementModel);

            Toast.makeText(Survey.this, "Success", Toast.LENGTH_SHORT).show();
        });
    }
}