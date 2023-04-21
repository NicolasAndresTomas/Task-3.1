////////// SIT305 Mobile Application Development
//////// Task: Credit Task 3.1
////// Student Name: Nicolas Andres Tomas
//// Student ID: 221351413
// Date: 31-03-2023
package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //defining variables
    EditText usersName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing defined variables
        usersName = findViewById(R.id.usersName);
    }

    public void onClickStart(View view) {
        //storing edit text into string variable
        String name = usersName.getText().toString();

        //if "name" is empty, send toast message
        if (name.matches(""))
        {
            Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
        }
        //else start next activity and finish current activity
        else {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra("usersName", name);
            startActivity(intent);
            finish();
        }
    }
}
// SIT305 Mobile Application Development
//// Task: Credit Task 3.1
////// Student Name: Nicolas Andres Tomas
//////// Student ID: 221351413
////////// Date: 31-03-2023