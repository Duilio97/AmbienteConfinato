package com.example.ambienteconfinato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class UserActivity2 extends AppCompatActivity {
    Button btnLogOut;
    FirebaseAuth firebaseAuth;
    LinearLayout red;
    LinearLayout yellow;
    LinearLayout navy;
    LinearLayout purple;
    private FirebaseAuth.AuthStateListener authStateListener;
    private ArrayList<String> stepaPassed = new ArrayList<>();
    public String done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_user);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        red = (LinearLayout) findViewById(R.id.red);
        yellow = (LinearLayout) findViewById(R.id.yellow);
        navy = (LinearLayout) findViewById(R.id.navy);
        purple = (LinearLayout) findViewById(R.id.purple);
        //if (ActivityLogin.isAdmin == true)
        //{
            //purple.setVisibility(View.GONE);
            //purple.setVisibility(View.VISIBLE);
        //}


        for (int i=1; i<30;i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            String strI = sb.toString();
            final String step = "step "+ strI;
            DocumentReference docRef = db.collection("Steps").document(step);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                public synchronized void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d("Ambiente Confinato 2", "DocumentSnapshot data: " + document.getData().get("situation"));
                            done = document.getData().get("situation").toString();
                            if (done.equals("Done")){
                                if (stepaPassed.contains(step)){
                                }
                                else {
                                    stepaPassed.add(step);
                                }
                            }
                        } else {
                            Log.d("Ambiente confinato 2", "No such document");
                        }
                    } else {
                        Log.d("Ambiente Confinato 2", "get failed with ", task.getException());
                    }
                }
            });
        }



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
                I.putExtra("stepsPassed", stepaPassed);
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


