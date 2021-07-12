package com.example.onlinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class WrongQuestions extends AppCompatActivity {
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
    public ArrayList<Integer> arr=new ArrayList<>();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        arr=intent.getIntegerArrayListExtra("array");
        if(arr.size()<=0){
            setContentView(R.layout.wrong_basic);
                    }
        else {
            setContentView(R.layout.activity_wrong_questions);

            ListView listView = findViewById(R.id.list_item);
            ArrayList<Word> arrayList = new ArrayList<>();
            int j;

            for (int i = 0; i < arr.size(); i++) {
                j = arr.get(i);
                arrayList.add(new Word(j, questions[j], opt[j * 4], opt[j * 4 + 1], opt[j * 4 + 2], opt[j * 4 + 3], answers[j]));
                Log.e("WrongQuestions", " working ......................................                             ");
            }

            CustomAdapter custom = new CustomAdapter(this, arrayList);
            listView.setAdapter(custom);


        }
    }
}