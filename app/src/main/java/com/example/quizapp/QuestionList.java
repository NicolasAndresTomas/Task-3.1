////////// SIT305 Mobile Application Development
//////// Task: Credit Task 3.1
////// Student Name: Nicolas Andres Tomas
//// Student ID: 221351413
// Date: 31-03-2023
package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {
    //defining variables
    String questionTitle;
    String questionDetail;
    String option1;
    String option2;
    String answer;
    String selectedOption;

    //initializing list
    public QuestionList(String questionTitle, String questionDetail, String option1, String option2, String answer, String selectedOption) {
        this.questionTitle = questionTitle;
        this.questionDetail = questionDetail;
        this.option1 = option1;
        this.option2 = option2;
        this.answer = answer;
        this.selectedOption = selectedOption;
    }

    //creating list of questions
    public static List<QuestionList> testQuestions() {
        List<QuestionList> questionList = new ArrayList<>();

        QuestionList question1 = new QuestionList("Addition", "5 + 5 = 10?", "True", "False", "True", "");
        QuestionList question2 = new QuestionList("Subtraction", "3 - 2 = 1?","True", "False", "True", "");
        QuestionList question3 = new QuestionList("Multiplication", "4 x 2 = 9?","True", "False", "False", "");
        QuestionList question4 = new QuestionList("Division", "2 / 6 = 14?","True", "False", "False", "");

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);

        return questionList;
    }

    //getters and setters
    public static List<QuestionList> getQuestions() {
        return testQuestions();
    }
    public String getQuestion() {
        return questionTitle;
    }

    public String getDetail() {
        return questionDetail;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getAnswer() {
        return answer;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
}
// SIT305 Mobile Application Development
//// Task: Credit Task 3.1
////// Student Name: Nicolas Andres Tomas
//////// Student ID: 221351413
////////// Date: 31-03-2023