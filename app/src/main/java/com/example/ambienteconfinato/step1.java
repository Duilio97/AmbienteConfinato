package com.example.ambienteconfinato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class step1 extends AppCompatActivity {
    TextView textview2;
    TextView textview;
    Button btnLogOut;
    ImageView imageview;
    SwipeButton swipeButton;
    ArrayList<String> stepaPassed = new ArrayList<>();
    public static String savedUid;
    public String done;
    public String isAdmin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedUid=ActivityLogin.Uid.toString();
        setContentView(R.layout.activity_step1);
        textview2=(TextView)findViewById(R.id.textitem);
        textview=(TextView)findViewById(R.id.textView);
        imageview = (ImageView) findViewById(R.id.image);
        final String Tempholder=getIntent().getStringExtra("Listviewclickvalue");
        textview2.setText(Tempholder);
        final String Tempholder2=getIntent().getStringExtra("Listviewclickvalue2");
        textview.setText(Tempholder2);
        stepaPassed = getIntent().getStringArrayListExtra("stepsPassed");
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("Users").document(savedUid);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            public synchronized void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("Ambiente Confinato 2", "DocumentSnapshot data: " + document.getData().get("Admin"));
                        isAdmin = document.getData().get("Admin").toString();
                        if (isAdmin.equals("True")){
                            swipeButton.setVisibility(View.VISIBLE);
                        }
                        else{
                            swipeButton.setVisibility(View.GONE);
                        }
                    } else {
                        Log.d("Ambiente confinato 2", "No such document");
                    }
                } else {
                    Log.d("Ambiente Confinato 2", "get failed with ", task.getException());
                }
            }
        });

        swipeButton =findViewById(R.id.swipe_button);
        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                Toast.makeText(step1.this, "Sucessfull", Toast.LENGTH_SHORT).show();
                //savedUid=ActivityLogin.Uid.toString();
                DocumentReference docRef = db.collection("Steps").document(Tempholder2);
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d("Ambiente Confinato 2", "DocumentSnapshot data: " + document.getData().get("situation"));
                                done=document.getData().get("situation").toString();
                                Toast.makeText(step1.this, done, Toast.LENGTH_SHORT).show();
                                if (done.equals("Not Done")){
                                    stepaPassed.add(Tempholder2);
                                    Intent intent= new Intent(step1.this, Navy.class);
                                    intent.putExtra("stepsPassed", stepaPassed);

                                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                                    // Create a Map to store the data we want to set
                                    Map<String, Object> docData = new HashMap<>();
                                    docData.put("situation", "Done");
                                    docData.put("info", Tempholder);
                                    db.collection("Steps").document(Tempholder2).set(docData).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d("Ambiente confinato","DocumentSnapshot added");
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w("Ambiente confinato", "Error adding document", e);
                                        }
                                    });
                                    startActivity(intent);

                                }
                                if (done.equals("Done")) {
                                    stepaPassed.remove(Tempholder2);
                                    Intent intent = new Intent(step1.this, Navy.class);
                                    intent.putExtra("stepsPassed", stepaPassed);
                                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                                    // Create a Map to store the data we want to set
                                    Map<String, Object> docData = new HashMap<>();
                                    docData.put("situation", "Not Done");
                                    docData.put("info", Tempholder);
                                    db.collection("Steps").document(Tempholder2).set(docData).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d("Ambiente confinato","DocumentSnapshot added");
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w("Ambiente confinato", "Error adding document", e);
                                        }
                                    });
                                    startActivity(intent);
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

        });
        }
    }


