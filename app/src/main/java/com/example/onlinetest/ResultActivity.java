package com.example.onlinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
       final Intent intent=getIntent();
        int correct=intent.getIntExtra("correct",0);
        int wrong=intent.getIntExtra("wrong",0);
        int total=intent.getIntExtra("totalScore",0);

        TextView tx1,tx2,tx3;
        tx1=(TextView)findViewById(R.id.correct);
        tx2=(TextView)findViewById(R.id.wrong);
        tx3=(TextView)findViewById(R.id.total);
        tx1.setText(tx1.getText().toString()+"   "+correct);
        tx2.setText(tx2.getText().toString()+"   "+wrong);
        tx3.setText(tx3.getText().toString()+"   "+total);
        Button btn=findViewById(R.id.wrongQuestions);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),WrongQuestions.class);
                intent1.putExtra("array",intent.getIntegerArrayListExtra("array"));
                startActivity(intent1);
            }
        });
        Button btn1=findViewById(R.id.moreQuestions);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");

                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "rp202910@gmail.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Questions in Quiz app");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,"Wanting more Questions for the app.");
                startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));
            }
        });
    }
}