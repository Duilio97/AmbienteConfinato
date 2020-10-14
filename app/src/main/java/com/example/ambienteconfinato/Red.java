package com.example.ambienteconfinato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static com.example.ambienteconfinato.R.id.green;

public class Red extends AppCompatActivity {
    Button btnLogOut;
    final FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView text;
    LinearLayout green;
    LinearLayout red;
    LinearLayout yel;
    LinearLayout orange;
    private String RealTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red);
        text = (TextView) findViewById(R.id.number);
        green = (LinearLayout) findViewById(R.id.green);
        yel = (LinearLayout) findViewById(R.id.yel);
        orange = (LinearLayout) findViewById(R.id.orange);
        red = (LinearLayout) findViewById(R.id.red);

        DocumentReference docRef = db.collection("VDR").document("Status");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            public synchronized void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("Ambiente Confinato 2", "DocumentSnapshot data: " + document.getData().get("Real Time"));
                        RealTime = document.getData().get("Real Time").toString();
                        text.setText(RealTime);
                        if (RealTime.equals("1")){
                            green.setVisibility(View.VISIBLE);
                            yel.setVisibility(View.GONE);
                            orange.setVisibility(View.GONE);
                            red.setVisibility(View.GONE);
                        }
                        if (RealTime.equals("2")){
                            green.setVisibility(View.VISIBLE);
                            yel.setVisibility(View.VISIBLE);
                            orange.setVisibility(View.GONE);
                            red.setVisibility(View.GONE);
                        }
                        if (RealTime.equals("3")){
                            green.setVisibility(View.VISIBLE);
                            yel.setVisibility(View.VISIBLE);
                            orange.setVisibility(View.VISIBLE);
                            red.setVisibility(View.GONE);
                        }
                        if (RealTime.equals("4")){
                            green.setVisibility(View.VISIBLE);
                            yel.setVisibility(View.VISIBLE);
                            orange.setVisibility(View.VISIBLE);
                            red.setVisibility(View.VISIBLE);
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
}