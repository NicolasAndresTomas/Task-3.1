////////// SIT305 Mobile Application Development
//////// Task: Credit Task 3.1
////// Student Name: Nicolas Andres Tomas
//// Student ID: 221351413
// Date: 31-03-2023
package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizResult extends AppCompatActivity {
    //defining variables
    TextView usersName;
    TextView score;
    Button finishBtn;
    List<QuestionList> questionsLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        //initializing defined variables
        usersName = findViewById(R.id.usersName);
        score = findViewById(R.id.score);
        finishBtn = findViewById(R.id.finishBtn);

        //set text to congratulate user
        String enteredName = getIntent().getStringExtra("usersName");
        usersName.setText("Congratulations " + enteredName + "!");

        //set text to get score
        questionsLists = QuestionList.getQuestions();
        int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        score.setText(getCorrectAnswers + "/" + questionsLists.size());
    }

    public void onClickTakeNewQuizBtn(View view) {
        //start next activity and finish current activity
        startActivity(new Intent(QuizResult.this, MainActivity.class));
        finish();
    }

    public void onClickFinishBtn(View view) {
        //exit app and finish current activity
        System.exit(0);
        finish();
    }
}
// SIT305 Mobile Application Development
//// Task: Credit Task 3.1
////// Student Name: Nicolas Andres Tomas
//////// Student ID: 221351413
////////// Date: 31-03-2023