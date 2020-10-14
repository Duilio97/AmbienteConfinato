package com.example.ambienteconfinato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ambienteconfinato.model.ListDetails;
import com.example.ambienteconfinato.model.Model;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Navy extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Model> models;
    private Adapter adapter;
    private ArrayList<String> stepaPassed = new ArrayList<>();
    public static String savedUid;
    public String done;
    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navy);
        listView = (ListView) findViewById(R.id.list_view);
        models = ListDetails.getList();
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        savedUid=ActivityLogin.Uid.toString();

        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Navy.this, UserActivity2.class);
                startActivity(I);

            }
        });

        if (getIntent().getStringArrayListExtra("stepsPassed")!= null)
           stepaPassed = getIntent().getStringArrayListExtra("stepsPassed");



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
        adapter = new com.example.ambienteconfinato.adapter.Adapter(Navy.this,models, stepaPassed);
        listView.setAdapter((ListAdapter) adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((TextView)view.findViewById(R.id.name)).getText().toString();
                String selected2 = ((TextView)view.findViewById(R.id.desc)).getText().toString();
                Toast.makeText(Navy.this, selected, Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Navy.this, step1.class);
                intent.putExtra("Listviewclickvalue", selected2);
                intent.putExtra("Listviewclickvalue2", selected);
                intent.putExtra("stepsPassed", stepaPassed);
                startActivity(intent);
            }

        });

        }
    }

