package com.example.ben.catchphraseagainsthumanity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PlayScreen extends AppCompatActivity {
    Random rand = new Random();
    int randnum = 0;
    int temp = 0;
    int teamone = 0;
    int teamtwo = 0;
    int category = 2;
    Button next, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        final String[] Postions = getResources().getStringArray(R.array.Postions);
        final String[] CAH = getResources().getStringArray(R.array.CAH);
        final String[] WTF = getResources().getStringArray(R.array.WTF);
        final String[] easy = getResources().getStringArray(R.array.Easy);
        final String[] Medium = getResources().getStringArray(R.array.Medium);
        final String[] Hard = getResources().getStringArray(R.array.Hard);
        final String[] Animals = getResources().getStringArray(R.array.Animals);
        final String[] food = getResources().getStringArray(R.array.Food);
        final String[] HouseholdItems = getResources().getStringArray(R.array.HouseholdItems);
        final String[] People = getResources().getStringArray(R.array.People);
        final String[] Travel = getResources().getStringArray(R.array.Travel);
        Intent intent = getIntent();
        category = intent.getIntExtra("category",2); //sets the category from the start screen
        next = (Button) findViewById(R.id.Next);
        stop = (Button) findViewById(R.id.Stop);

        final MediaPlayer buzzer = MediaPlayer.create(this, R.raw.catch_phrase_timer);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buzzer.start();
                // category = 2;
                switch(category){
                    case 0:
                        temp = 0;
                        temp = randnum;  //temp makes sure the random generator doesnt pick the same number twice
                        while (temp == randnum) {
                            temp = rand.nextInt(10);
                        }
                        switch(temp) {
                            case 0: RadomWord(Postions);
                                break;
                            case 1: RadomWord(CAH);
                                break;
                            case 2: RadomWord(WTF);
                                break;
                            case 3: RadomWord(easy);
                                break;
                            case 4: RadomWord(Medium);
                                break;
                            case 5: RadomWord(Hard);
                                break;
                            case 6: RadomWord(Animals);
                                break;
                            case 7: RadomWord(food);
                                break;
                            case 8: RadomWord(HouseholdItems);
                                break;
                            case 9: RadomWord(People);
                                break;
                            case 10: RadomWord(Travel);
                                break;

                        }
                        break;
                    case 3: RadomWord(Postions);
                        break;
                    case 4: RadomWord(CAH);
                        break;
                    case 5: RadomWord(WTF);
                        break;
                    case 6: RadomWord(easy);
                        break;
                    case 7: RadomWord(Medium);
                        break;
                    case 8: RadomWord(Hard);
                        break;
                    case 9: RadomWord(Animals);
                        break;
                    case 10: RadomWord(food);
                        break;
                    case 11: RadomWord(HouseholdItems);
                        break;
                    case 12: RadomWord(People);
                        break;
                    case 13: RadomWord(Travel);
                        break;
                    case 1 :temp = 0;
                        temp = randnum; //temp makes sure the random generator doesnt pick the same number twice
                        while (temp == randnum) {
                            temp = rand.nextInt(6);
                        }
                        switch (temp) {
                            case 0:
                                RadomWord(easy);
                                break;
                            case 1:
                                RadomWord(Medium);
                                break;
                            case 2:
                                RadomWord(Hard);
                                break;
                            case 3:
                                RadomWord(Animals);
                                break;
                            case 4:
                                RadomWord(HouseholdItems);
                                break;
                            case 5:
                                RadomWord(People);
                                break;
                            case 6:
                                RadomWord(Travel);
                                break;
                        }
                        break;
                    case 2:
                        temp = 0;
                        temp = randnum; //temp makes sure the random generator doesnt pick the same number twice
                        while (temp == randnum) {
                            temp = rand.nextInt(3);
                        }
                        switch (temp) {
                            case 0:
                                RadomWord(Postions);
                                break;
                            case 1:
                                RadomWord(CAH);
                                break;
                            case 2:
                                RadomWord(WTF);
                                break;
                        }
                        break;
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buzzer.stop();
                finish();
            }
        });
    }

    //********************************************************************************
    // function name: teamoneAdd
    // input: view
    // output: none
    // function: add one to teamone then updates the textview for team one's score
    //**********************************************************************************
    public void  teamoneAdd(View view){
        teamone = teamone + 1;
        TextView textView = (TextView) findViewById(R.id.Team1Score);
        textView.setText(Integer.toString(teamone));
    }
    //********************************************************************************
    // function name: teamoneSub
    // input: view
    // output: none
    // function: subtracts one to teamone then updates the textview for team one's score
    //**********************************************************************************
    public void  teamoneSub(View view){
        teamone = teamone - 1;
        TextView textView = (TextView) findViewById(R.id.Team1Score);
        textView.setText(Integer.toString(teamone));
    }
    //********************************************************************************
    // function name: teamTwoAdd
    // input: view
    // output: none
    // function: adds one to teamtwo then updates the textview for team one's score
    //**********************************************************************************
    public void  teamTwoAdd(View view){
        teamtwo = teamtwo + 1;
        TextView textView = (TextView) findViewById(R.id.team2Score);
        textView.setText(Integer.toString(teamtwo));
    }
    //********************************************************************************
    // function name: teamTwoSub
    // input: view
    // output: none
    // function: subtracts one to teamtwo then updates the textview for team one's score
    //**********************************************************************************
    public void  teamTwoSub(View view){
        teamtwo = teamtwo - 1;
        TextView textView = (TextView) findViewById(R.id.team2Score);
        textView.setText(Integer.toString(teamtwo));
    }
    //********************************************************************************
    // function name: RadomWord
    // input: Stirng Array[]
    // output: none
    // function: this is the random genator for the main word. it find a random number the
    // updates the main word textview with the corresponding word in the array
    //**********************************************************************************
    public void RadomWord(String array[]){
        temp  = 0;
        temp = randnum; //temp makes sure the random generator doesnt pick the same number twice
        while (temp == randnum) {
            randnum = rand.nextInt(array.length);
        }
        TextView textView = (TextView) findViewById(R.id.MainWord);
        textView.setText(array[randnum]);
    }
    //********************************************************************************
    // function name: Stop
    // input: view
    // output: none
    // function: this simpley stops the current activity and returns to the start screen
    //**********************************************************************************
    public  void  stop(View view){
        finish();
    }
}
