package com.example.ben.catchphraseagainsthumanity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class StartScreen extends AppCompatActivity {
    int positionitem = 42; // set to 42 for debugging
    Button checkspinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        checkspinner = (Button) findViewById(R.id.button);
        final Spinner spinner = (Spinner) findViewById(R.id.Categories);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Categories, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        checkspinner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                positionitem = spinner.getSelectedItemPosition();
                StartGame();
            }
        });
    }
    //********************************************************************************
    // function name: StartGame
    // input: none
    // output: none
    // function: this sets the intent with the catorgoy number and starts the playscreen activity
    //**********************************************************************************
    public void StartGame(){
        Intent intent = new Intent(this, PlayScreen.class);
        intent.putExtra("category",positionitem); // test the pass
        startActivity(intent);
    }

}
