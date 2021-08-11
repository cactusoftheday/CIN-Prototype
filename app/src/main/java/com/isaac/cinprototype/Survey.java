package com.isaac.cinprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;

//
public class Survey extends AppCompatActivity {
    //SQLiteDatabase
    ToggleButton helpful, decisionChange;
    EditText suggestion, years;
    Button submit;
    Spinner training, profession;
    ImprovementModel improvementModel;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    String postId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        profession = (Spinner) findViewById(R.id.profession);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.profession_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        profession.setAdapter(adapter);
        training = (Spinner) findViewById(R.id.training);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.resident_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        training.setAdapter(adapter2);
        years = findViewById(R.id.editTextNumberSigned);
        helpful = findViewById(R.id.helpful);
        decisionChange = findViewById(R.id.decisionChange);
        suggestion = findViewById(R.id.suggestions);
        submit = findViewById(R.id.submitSurvey);
        //FIX ME: Training array must change based on what profession was selected.
        /*profession.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // Create an ArrayAdapter using the string array and a default spinner layout

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                training = (Spinner) findViewById(R.id.training);
                String professionString = profession.getItemAtPosition(position).toString();
                if (professionString == "Resident/Fellow"){
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Survey.this, R.array.resident_array, android.R.layout.simple_spinner_item);
                    // Specify the layout to use when the list of choices appears
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    // Apply the adapter to the spinner
                    training.setAdapter(adapter2);
                }
                else if (professionString == "Physician"){
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Survey.this, R.array.physician_array, android.R.layout.simple_spinner_item);
                    // Specify the layout to use when the list of choices appears
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    // Apply the adapter to the spinner
                    training.setAdapter(adapter2);
                }
                else if (professionString == "Nurse Practitioner"){
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Survey.this, R.array.nurse_array, android.R.layout.simple_spinner_item);
                    // Specify the layout to use when the list of choices appears
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    // Apply the adapter to the spinner
                    training.setAdapter(adapter2);
                }
                else{
                    Toast.makeText(Survey.this,"Whoops, please relaunch the app.", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Spinner training = (Spinner) findViewById(R.id.training);
                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Survey.this, R.array.resident_array, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                training.setAdapter(adapter2);
            }
        });*/

        submit.setOnClickListener(v -> {
            improvementModel = new ImprovementModel();
            improvementModel.setHelpful(helpful.isChecked());
            improvementModel.setDecisionChange(decisionChange.isChecked());
            improvementModel.setSuggestions(suggestion.getText().toString());
            improvementModel.setProfession(profession.getSelectedItem().toString());
            improvementModel.setTraining(training.getSelectedItem().toString());
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