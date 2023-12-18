package com.example.tic_tac_toe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8 , btn9,reset,nextMove;
    String b1 , b2 , b3 , b4 , b5 , b6 , b7 , b8 , b9;
    int flag = 0,count=0;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();  //you can also declare the variables here

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setReset();
            }
        });
    }

    private void init()
    {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9= findViewById(R.id.btn9);
        reset = findViewById(R.id.reset);
        nextMove = findViewById(R.id.nextMove);
        flag = 0;
        count = 0;
        nextMove.setText("X");
    }

    //Jevha kunitari winner hoil tevha sarve reset honyasathi
    public void setReset()
    {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        nextMove.setText("X");

    }

    public void Check(View view){
        Button btnCurrent = (Button)(view);  //we have to typecast because we are passing view here we know it is button always , so typecast to button
        //Ekach button var double press n honyasathi
        if(!btnCurrent.getText().toString().equals(""))
        {
            Toast.makeText(this,"Invalid Press",Toast.LENGTH_SHORT).show();
            return;
        }

        count++; //ha variable check krto kiti moves zalya te karan apal logic 5th move pasun suru honar ahe

        //he alternation sathi ahe 0 nntr X ani X nntr 0
        if(flag==0){
            play();
            btnCurrent.setText("X");
            nextMove.setText("O");
            flag=1;
        }
        else {
            play();
            btnCurrent.setText("O");
            play();
            nextMove.setText("X");
            flag=0;
        }

        if(count>4)
        {
            //ya strings mdhe apan button var press kelel char gheto ani 5th move nantar check krto
            b1  = btn1.getText().toString();
            b2  = btn2.getText().toString();
            b3  = btn3.getText().toString();
            b4  = btn4.getText().toString();
            b5  = btn5.getText().toString();
            b6  = btn6.getText().toString();
            b7  = btn7.getText().toString();
            b8  = btn8.getText().toString();
            b9  = btn9.getText().toString();

            //ya 8 condition 5th move nantarch yetat
            if(b1.equals(b2) && b1.equals(b3) && !b1.equals("")){
                Toast.makeText(this,"Winner is "+b1,Toast.LENGTH_SHORT).show();
                setReset();
            }
            else if(b1.equals(b4) && b1.equals(b7) && !b1.equals("")){
                Toast.makeText(this,"Winner is "+b1,Toast.LENGTH_SHORT).show();
                setReset();
            }
            else if(b1.equals(b5) && b1.equals(b9) && !b1.equals("")){
                Toast.makeText(this,"Winner is "+b1,Toast.LENGTH_SHORT).show();
                setReset();
            }
            else if(b2.equals(b5) && b2.equals(b8) && !b2.equals("")){
                Toast.makeText(this,"Winner is "+b2,Toast.LENGTH_SHORT).show();
                setReset();
            }
            else if(b3.equals(b6) && b3.equals(b9) && !b3.equals("")){
                Toast.makeText(this,"Winner is "+b3,Toast.LENGTH_SHORT).show();
                setReset();
            }
            else if(b3.equals(b5) && b3.equals(b7) && !b3.equals("")){
                Toast.makeText(this,"Winner is "+b3,Toast.LENGTH_SHORT).show();
                setReset();
            }
            else if(b4.equals(b5) && b4.equals(b6) && !b4.equals("")){
                Toast.makeText(this,"Winner is "+b4,Toast.LENGTH_SHORT).show();
                setReset();
            }
            else if(b7.equals(b8) && b7.equals(b9) && !b7.equals("")){
                Toast.makeText(this,"Winner is "+b7,Toast.LENGTH_SHORT).show();
                setReset();
            }
            else if(!b1.equals("") && !b2.equals("") && !b3.equals("") && !b4.equals("") && !b5.equals("") && !b6.equals("") && !b7.equals("") && !b8.equals("") && !b9.equals("") )
            {
                setReset();
                Toast.makeText(this,"Match is drawn",Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void play(){
        if(player==null){
            player = MediaPlayer.create(this,R.raw.click);
        }
        player.start();
    }

    public void playWin(){
        if(player==null){
            player = MediaPlayer.create(this,R.raw.win);
        }
        player.start();
    }




    
}