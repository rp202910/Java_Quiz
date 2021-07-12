package com.example.onlinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start_button=(Button)findViewById(R.id.start);
        Button about_button=(Button)findViewById(R.id.about);
       final  EditText edit=findViewById(R.id.name);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,StartTest.class);
                intent.putExtra("message",edit.getText().toString());
                startActivity(intent);
            }
        });
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });

    }


}