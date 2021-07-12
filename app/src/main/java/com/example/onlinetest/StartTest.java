package com.example.onlinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StartTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
        Button button=findViewById(R.id.start);
        Intent intent1 = getIntent();
        String s=intent1.getStringExtra("message");
        TextView text=(TextView)findViewById(R.id.nameSpace);

        if(s.trim().equals("")){
        text.setText("Hello , Friend");
        }
        else{
            text.setText("Hello , "+s);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),QuestionsActivity.class);
                startActivity(intent);
            }
        });
    }

}