package com.example.onlinetest;

class Word {
    int quesNo;
    String ques,op1,op2,op3,op4,ans;
 public Word(int j,String question,String opt1,String opt2,String opt3,String opt4,String answer){
     ques=question;
     quesNo=j;
     op1=opt1;
     op2=opt2;
     op3=opt3;
     op4=opt4;
     ans=answer;

 }
 public String getQues(){
     return  ques;
 }
 public String getOp1(){
     return op1;
 }

    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public String getOp4() {
        return op4;
    }

    public String getAns() {
        return ans;
    }

    public int getQuesNo() {
        return quesNo;
    }
}
