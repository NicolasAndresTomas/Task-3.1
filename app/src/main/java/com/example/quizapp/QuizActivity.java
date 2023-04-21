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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    //defining variables
    TextView progressNumber;
    ProgressBar progressBar;
    TextView questionTitle;
    TextView questionDetail;
    Button option1;
    Button option2;
    Button nextBtn;
    List<QuestionList> questionList;


    //defining count and empty value
    int buttonCount = 0;
    int questionCount = 0;
    int correctAnswerCount = 0;
    int incorrectAnswerCount = 0;
    String selectedOption = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //initializing defined variables
        progressNumber = findViewById(R.id.progressNumber);
        progressBar = findViewById(R.id.progressBar);
        questionTitle = findViewById(R.id.questionTitle);
        questionDetail = findViewById(R.id.questionDetail);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        nextBtn = findViewById(R.id.nextBtn);
        questionList = QuestionList.getQuestions();

        //initializing progress for defined variables
        progressNumber.setText((questionCount + 1) + "/" + questionList.size());
        progressBar.setMax(questionList.size());
        questionTitle.setText(questionList.get(0).getQuestion());
        questionDetail.setText(questionList.get(0).getDetail());
        option1.setText(questionList.get(0).getOption1());
        option2.setText(questionList.get(0).getOption2());

        //send toast message
        String name = getIntent().getStringExtra("usersName");
        Toast.makeText(QuizActivity.this, "Welcome " + name + "!", Toast.LENGTH_SHORT).show();
    }

    public void onClickOption1(View view) {
        //storing "option1" into "selectedOption"
        selectedOption = option1.getText().toString();

        //setting and determining the users "selectedOption"
        questionList.get(questionCount).setSelectedOption(selectedOption);

        //set text for "nextBtn"
        nextBtn.setText("SUBMIT");
    }

    public void onClickOption2(View view) {
        //storing "option2" into "selectedOption"
        selectedOption = option2.getText().toString();

        //setting and determining the users "selectedOption"
        questionList.get(questionCount).setSelectedOption(selectedOption);

        //set new text for "nextBtn"
        nextBtn.setText("SUBMIT");
    }

    public void onClickNextBtn(View view) {
        //"buttonCount" is counted and incremented by 1 each time "onClickNextBtn" is on clicked
        buttonCount++;

        //if "selectedOption" is empty, send toast message and reset "buttonCount"
        if (selectedOption.isEmpty()){
            Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
            buttonCount = 0;
        }
        //else if "buttonCount" is equal to 1, reveal answer and set new text for "nextBtn"
        else if (buttonCount == 1) {
            revealAnswer();
            nextBtn.setText("Next");
        }
        //else if "buttonCount" is equal to 2, change to next question and reset "buttonCount"
        else if (buttonCount == 2) {
            changeNextQuestion();
            buttonCount = 0;
        }
    }

    public void changeNextQuestion() {
        //"questionCount" is counted and incremented by 1 each time "onClickNextBtn" is carried out
        questionCount++;

        //set progress
        progressBar.setProgress(questionCount);

        //if "questionCount" is less than "questionList" size, carry out "changeNextQuestion" logic
        if (questionCount < questionList.size()) {
            //reset "selectedOption"
            selectedOption = "";

            //initializing new progress for defined variables
            progressNumber.setText((questionCount + 1) + "/" + questionList.size());

            questionTitle.setText(questionList.get(questionCount).getQuestion());
            questionDetail.setText(questionList.get(questionCount).getDetail());
            option1.setText(questionList.get(questionCount).getOption1());
            option2.setText(questionList.get(questionCount).getOption2());

            option1.setBackgroundResource(R.drawable.normal);
            option2.setBackgroundResource(R.drawable.normal);
        }
        //else start next activity and finish current activity
        else {
            String name = getIntent().getStringExtra("usersName");

            Intent intent = new Intent(QuizActivity.this, QuizResult.class);
            intent.putExtra("usersName", name);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getIncorrectAnswers());
            startActivity(intent);
            finish();
        }
    }

    public int getCorrectAnswers() {
        //if "i" is less than "questionList" size, loop until "i" is greater
        for (int i = 0; i < questionList.size(); i++) {
            //storing users selected answer and answer into string variable
            String getUserSelectedAnswer = questionList.get(i).getSelectedOption();
            String getAnswer = questionList.get(i).getAnswer();

            //if "getUserSelectedAnswer" is equal to answer, increment "correctAnswerCount" by 1
            if (getUserSelectedAnswer.equals(getAnswer)){
                correctAnswerCount++;
            }
        }
        return correctAnswerCount;
    }

    public int getIncorrectAnswers() {
        //if "i" is less than "questionList" size, loop until "i" is greater
        for (int i = 0 ; i < questionList.size(); i++) {
            //storing users selected answer and answer into string variable
            String getUserSelectedAnswer = questionList.get(i).getSelectedOption();
            String getAnswer = questionList.get(i).getAnswer();

            //if "getUserSelectedAnswer" is not equal to answer, increment "incorrectAnswerCount" by 1
            if (!getUserSelectedAnswer.equals(getAnswer)){
                incorrectAnswerCount++;
            }
        }
        return incorrectAnswerCount;
    }

    public void revealAnswer() {
        //storing answered question and selection into string variable
        String getAnswer = questionList.get(questionCount).getAnswer();
        String getUserSelectedAnswer = questionList.get(questionCount).getSelectedOption();

        //if "option1" matches answer, display green
        if (option1.getText().toString().matches(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green10);
        }
        //else display red
        else {
            option1.setBackgroundResource(R.drawable.round_back_red10);
        }
        //if "option1" does not match answer, display normal
        if (!option1.getText().toString().matches(getUserSelectedAnswer)){
            option1.setBackgroundResource(R.drawable.normal);
        }
        //if "option2" matches answer, display green
        if (option2.getText().toString().matches(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green10);
        }
        //else display red
        else {
            option2.setBackgroundResource(R.drawable.round_back_red10);
        }
        //if "option1" does not match answer, display normal
        if (!option2.getText().toString().matches(getUserSelectedAnswer)){
            option2.setBackgroundResource(R.drawable.normal);
        }
    }
}
// SIT305 Mobile Application Development
//// Task: Credit Task 3.1
////// Student Name: Nicolas Andres Tomas
//////// Student ID: 221351413
////////// Date: 31-03-2023