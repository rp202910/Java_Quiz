package com.example.onlinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookmarkActivity extends AppCompatActivity {
    TextView text;
    Button submitbutton, quitbutton, bookMarkbutton;
    RadioGroup radiogrp;
    RadioButton rb1, rb2, rb3, rb4;
    String questions[] = {
            "java.util.Collections is a:",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of the following option leads to the portability and security of Java?",
            "The \\u0021 article referred to as a",
            "_____ is used to find and fix bugs in the Java programs.",
            "What is the return type of Constructors?",
            "What is the return type of the hashCode() method in the Object class?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "Which access specifier on methods  allows  app for upcasting ?"
    };
    String answers[] = {"class","<=","this","Bytecode is executed by JVM","Unicode escape sequence","JDB","None of the mentioned","int","equals()","protected"};
    String opt[] = {
            "class","Interface","Object","None of the Above",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Bytecode is executed by JVM","The applet makes the Java code secure and portable","Use of exception handling","Dynamic binding between objects",
            "Octal escape","Unicode escape sequence","Hexadecimal","Line feed",
            "JVM","JRE","JDB","JDK",
            "int","float","void","None of the mentioned",
            "Object","int","class","long",
            "equals()","Equals()","isequal()","Isequal()",
            "private","protected","static","final"
    };
    int correct, wrong, totalScore, j;
    int count=0;
    ArrayList<Integer>arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bookmark);
        final Intent intent1 = getIntent();
        correct = intent1.getIntExtra("correct", 0);
        wrong = intent1.getIntExtra("wrong", 0);
        totalScore = intent1.getIntExtra("totalScore", 0);
       final ArrayList<Integer> arr = intent1.getIntegerArrayListExtra("arraybookmark");
       arrayList=intent1.getIntegerArrayListExtra("array");

            j = arr.get(count);

            text = (TextView) findViewById(R.id.Question);
            text.setText(j + 1 + ".   " + questions[j]);
            rb1 = findViewById(R.id.radioButton);
            rb2 = findViewById(R.id.radioButton2);
            rb3 = findViewById(R.id.radioButton3);
            rb4 = findViewById(R.id.radioButton4);
            rb1.setText(opt[j * 4]);
            rb2.setText(opt[j * 4 + 1]);
            rb3.setText(opt[j * 4 + 2]);
            rb4.setText(opt[j * 4 + 3]);
            radiogrp = findViewById(R.id.answersgrp);
            radiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton button = group.findViewById(checkedId);
                }
            });
            Button next = findViewById(R.id.button3);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    int id = radiogrp.getCheckedRadioButtonId();
                    if (id == -1) {
                        Toast.makeText(getApplicationContext(), "No option is selected", Toast.LENGTH_LONG).show();

                    } else {
                        RadioButton radio = findViewById(id);
                        if (radio.getText().toString().equals(answers[j])) {
                            correct++;
                            totalScore++;
                        } else {
                            wrong++;
                            totalScore--;
                            arrayList.add(j);
                            //flag++;

                        }
                         count++;
                        radiogrp.clearCheck();

                        if(count<questions.length&&count<arr.size()) {
                            j=arr.get(count);
                            text.setText(j + 1 + ".   " + questions[j]);
                            rb1.setText(opt[j * 4]);
                            rb2.setText(opt[j * 4 + 1]);
                            rb3.setText(opt[j * 4 + 2]);
                            rb4.setText(opt[j * 4 + 3]);
                        }
                        else{
                            Intent intent;
                                intent = new Intent(getApplicationContext(), ResultActivity.class);


                            intent.putExtra("correct",correct);
                            intent.putExtra("wrong",wrong);
                            intent.putExtra("totalScore",totalScore);
                            intent.putExtra("array", intent1.getIntegerArrayListExtra("array"));
                            startActivity(intent);
                        }




                    }


                }


            });
        quitbutton=findViewById(R.id.button4);
        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                for(int i=0;i<arrayList.size();i++){
//                    Log.e("QuestionsActivity","............................ "+arrayList.get(i));
//                }
                Intent intent;
                    intent = new Intent(getApplicationContext(), ResultActivity.class);


                   // intent = new Intent(getApplicationContext(), BookmarkActivity.class);


                intent.putExtra("correct",correct);
                intent.putExtra("wrong",wrong);
                intent.putExtra("totalScore",totalScore);
                intent.putIntegerArrayListExtra("array",arrayList);
                //intent.putExtra("arraybookmark",arrayBookmark);


                startActivity(intent);

            }
        });



    }
    }

