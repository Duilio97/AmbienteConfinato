package com.example.ambienteconfinato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RegCode extends AppCompatActivity {
    public EditText emailId, passwd;
    Button btnSignUp;
    TextView signIn;
    FirebaseAuth firebaseAuth;
    public String code;
    //private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("Users/Document");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_code);
        firebaseAuth = FirebaseAuth.getInstance();
        passwd = findViewById(R.id.ETpassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String paswd = passwd.getText().toString();
                if (paswd.isEmpty()) {
                    passwd.setError("Insert the Code");
                    passwd.requestFocus();
                } else if (!paswd.isEmpty()) {
                    DocumentReference docRef = db.collection("Code").document("Registration code");
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    Log.d("Ambiente Confinato 2", "DocumentSnapshot data: " + document.getData().get("code"));
                                    code =document.getData().get("code").toString();
                                    if (code.equals(paswd)){
                                        Intent intent = new Intent(RegCode.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(RegCode.this, "Not sucessfull", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    Log.d("Ambiente confinato 2", "No such document");
                                }
                            } else {
                                Log.d("Ambiente Confinato 2", "get failed with ", task.getException());
                                Toast.makeText(RegCode.this.getApplicationContext(),
                                        "SignUp unsuccessful: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(RegCode.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}