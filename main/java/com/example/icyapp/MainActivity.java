package com.example.icyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.icyapp.Common.Common;
import com.example.icyapp.Model.SignIn;
import com.example.icyapp.Model.SignUp;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference userRef;

    Button btnSignIn,btnSignUp;
    TextView txtSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSignIn=findViewById(R.id.btnSignIn);
        btnSignUp=findViewById(R.id.btnSignUp);

        txtSlogan=findViewById(R.id.txtSlogan);
        Typeface face= Typeface.createFromAsset(getAssets(),"fonts/PlayfairDisplay.ttf");
        txtSlogan.setTypeface(face);


        btnSignIn.setOnClickListener(v -> {

        });

        btnSignUp.setOnClickListener(v -> {
            Intent signUp = new Intent(MainActivity.this, SignUp.class);
            startActivity(signUp);

        });
       btnSignIn.setOnClickListener(v -> {
           Intent signIn = new Intent(MainActivity.this, SignIn.class);
           startActivity(signIn);
       });




    }
}
