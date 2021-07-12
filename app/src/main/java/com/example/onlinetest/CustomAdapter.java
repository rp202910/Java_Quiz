package com.example.onlinetest;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class CustomAdapter extends ArrayAdapter<Word> {


    public CustomAdapter(@NonNull Context context, ArrayList<Word>k ) {
        super(context,0,k);
    }
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView =convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list, parent, false);
        }
        Word current=getItem(position);


        TextView textView=listItemView.findViewById(R.id.Question);
        textView.setText((current.getQuesNo()+1)+".   "+current.getQues());

        RadioButton radio1,radio2,radio3,radio4;
        radio1=listItemView.findViewById(R.id.radioButton);
        radio1.setText(current.getOp1());



        radio2=listItemView.findViewById(R.id.radioButton2);
        radio2.setText(current.getOp2());
        radio3=listItemView.findViewById(R.id.radioButton3);
        radio3.setText(current.getOp3());
        radio4=listItemView.findViewById(R.id.radioButton4);
        radio4.setText(current.getOp4());
        if(current.getOp1().toString().equals(current.getAns())){
            radio1.setChecked(true);
        }
        else if(current.getOp2().toString().equals(current.getAns())) {
            radio2.setChecked(true);
        }
         else  if(current.getOp3().toString().equals(current.getAns())){
                radio3.setChecked(true);
            }
         else if(current.getOp4().toString().equals(current.getAns())) {
            radio4.setChecked(true);
        }


        return listItemView;

    }
}
