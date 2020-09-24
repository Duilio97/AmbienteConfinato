package com.example.ambienteconfinato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class UserActivity2 extends AppCompatActivity {
    Button btnLogOut;
    FirebaseAuth firebaseAuth;
    LinearLayout red;
    LinearLayout yellow;
    LinearLayout navy;
    LinearLayout purple;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        red = (LinearLayout) findViewById(R.id.red);
        yellow = (LinearLayout) findViewById(R.id.yellow);
        navy = (LinearLayout) findViewById(R.id.navy);
        purple = (LinearLayout) findViewById(R.id.purple);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(UserActivity2.this, ActivityLogin.class);
                startActivity(I);

            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivity2.this, Red.class);
                startActivity(I);

            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivity2.this, Yellow.class);
                startActivity(I);

            }
        });
        navy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivity2.this, Navy.class);
                startActivity(I);

            }
        });
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivity2.this, Purple.class);
                startActivity(I);

            }
        });

    }

}


