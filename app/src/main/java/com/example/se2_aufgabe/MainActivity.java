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


public class MainActivity extends AppCompatActivity {

    private Button sendtoserver;
    private Connection net;
    private EditText editText;
    private Button number;
    private TextView server;
    private EditText final_mtrnr;
    private EditText mtrnr;

    //mtr ==01613210 %7=0
    @SuppressLint("WrongViewCast")
    public void calculateNumber(View view){



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


                }

        );


    }



}