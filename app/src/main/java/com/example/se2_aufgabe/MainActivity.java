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
    private Button calc;
    private TextView server;
    private EditText result;
    private EditText mtrnr;

    //mtr ==01613210 %7=0
    @SuppressLint("WrongViewCast")
    public void calculateNumber(View view){

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=null;

    }



}