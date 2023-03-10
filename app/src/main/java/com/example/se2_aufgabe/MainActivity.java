package com.example.se2_aufgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ServerSocket;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button sendtoserver;
    private Connection net;
    private EditText editText;
    private Button number;
    private TextView server;
    private EditText final_result;
    private EditText mtrnr;

    //mtr ==01613210 %7=0
    @SuppressLint("WrongViewCast")
    public void calculateNumber(View view){
        number=findViewById(R.id.calculate);
        editText=findViewById(R.id.mtrnr);
        String text=editText.getText().toString();
        for(int i=0;i<text.length();i++){
            boolean prime=true;
            int number=Integer.parseInt(String.valueOf(text.charAt(i)));
            System.out.println(number);
            if(number<=1){ // 0&1 no primes
                prime=false;
            }
            for(int j=2;j<number;j++){
                if(number%j==0){
                    prime=false;
                }
            }


            if(prime){
                StringBuilder builder=new StringBuilder();
                builder.append(number);
                for(int k=0;k<builder.length();k++){
                    System.out.println(builder.charAt(k)+" TEST");
                    text=Integer.toString(builder.charAt(k));
                    final_result = findViewById(R.id.number_mtr);
                    mtrnr =findViewById(R.id.result);
                    mtrnr.setText(text);
                    final_result.setText(text);
                }

                
            }
        }




    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=null;
        setContentView(R.layout.activity_main);
        editText= findViewById(R.id.mtrnr);
        sendtoserver=findViewById(R.id.calculate);
        sendtoserver.setOnClickListener(
                a ->{

                    net = new Connection(editText.getText().toString());
                    net.start();
                    try{
                        net.join();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    Log.i("info", String.valueOf(editText));
                    server = findViewById(R.id.server);
                    server.setText(net.getResult());
                    calculateNumber(a);

                }

        );


    }



}