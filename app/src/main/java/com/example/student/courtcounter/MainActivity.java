package com.example.student.courtcounter;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView countView;
    private TextView countViewTwo;
    private EditText team1Name;
    private EditText team2Name;
    private int scoreOne;
    private int scoreTwo;
    private String winner1;
    private String winner2;
    AlertDialog gameOverAlert;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameOverAlert= new AlertDialog.Builder(MainActivity.this).create();

        countView= (TextView)findViewById(R.id.buttonCounter);
        countView.setText(""+scoreOne);

        countViewTwo= (TextView)findViewById(R.id.buttonClicker);
        countViewTwo.setText(""+scoreTwo);

        team1Name = (EditText) findViewById(R.id.teamNameOne);
        team2Name = (EditText) findViewById(R.id.teamNameTwo);

        scoreOne = 0;
        scoreTwo = 0;

    }

    public void clickFunction1(View view){
        scoreOne++;
        countView.setText(String.valueOf(scoreOne));

        mediaPlayer = MediaPlayer.create(this, R.raw.coin);
        mediaPlayer.start();
    }

    public void clickFunction2(View view){
        scoreTwo++;
        countViewTwo.setText(String.valueOf(scoreTwo));

        mediaPlayer = MediaPlayer.create(this, R.raw.coin);
        mediaPlayer.start();
    }

    public void clickFunction3(View view){
        scoreOne--;
        countView.setText(String.valueOf(scoreOne));

        mediaPlayer = MediaPlayer.create(this, R.raw.coin);
        mediaPlayer.start();
    }

    public void clickFunction4(View view){
        scoreTwo--;
        countViewTwo.setText(String.valueOf(scoreTwo));

        mediaPlayer = MediaPlayer.create(this, R.raw.coin);
        mediaPlayer.start();
    }

    public void gameOverFunction(View view) {

        if (scoreOne > scoreTwo) {
            winner1 = team1Name.getText().toString();
            gameOverAlert.setMessage(winner1 + " wins!");
        }else if (scoreOne < scoreTwo) {
            winner2 = team2Name.getText().toString();
            gameOverAlert.setMessage(winner2 + " wins!");
        } else {
            gameOverAlert.setMessage("DRAW!");
        }

        gameOverAlert.setTitle("GAME OVER!!");


        mediaPlayer = MediaPlayer.create(this, R.raw.damn_son);
        mediaPlayer.start();

        gameOverAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {dialog.dismiss();}
                }
        );

        gameOverAlert.show();

        scoreOne = 0;
        countView.setText(String.valueOf(scoreOne));

        scoreTwo = 0;
        countViewTwo.setText(String.valueOf(scoreTwo));

    }
}
