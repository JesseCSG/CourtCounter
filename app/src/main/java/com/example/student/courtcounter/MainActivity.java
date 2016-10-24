package com.example.student.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView countView;
    public int scoreOne = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView= (TextView)findViewById(R.id.buttonCounter);
        countView.setText(scoreOne);

    }

    public void clickFunction1(View view){
        countView.setText(String.valueOf(scoreOne));
        scoreOne++;
    }
}
