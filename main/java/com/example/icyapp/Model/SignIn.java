package com.example.icyapp.Model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.icyapp.Common.Common;
import com.example.icyapp.HomeActivity;
import com.example.icyapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {
    EditText edtPhone,edtPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPassword=(MaterialEditText)findViewById(R.id.edtPassword);
        edtPhone=(MaterialEditText)findViewById(R.id.edtPhone);
        btnSignIn=findViewById(R.id.btnSignIn);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Perfavore attendi...");
                mDialog.show();
                table_user.addListenerForSingleValueEvent(new ValueEventListener() {


                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //Controlla se l'utente non esiste nel database
                            if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {

                                //Ottieni dati Utente
                                mDialog.dismiss();
                                UserModel userModel = dataSnapshot.child(edtPhone.getText().toString()).getValue(UserModel.class);
                                goToHomeActivity(userModel);
                                assert userModel != null;
                                if (userModel.getPassword().equals(edtPassword.getText().toString())) {
                                    Intent homeIntent = new Intent(SignIn.this, HomeActivity.class);
                                    Common.currentUser = userModel;
                                    startActivity(homeIntent);
                                    finish();
                                } else {
                                    Toast.makeText(SignIn.this, "Accesso Fallito!", Toast.LENGTH_SHORT).show();
                                }

                            }
                               else {
                               mDialog.dismiss();
                                Toast.makeText(SignIn.this,"Utente non esistente",Toast.LENGTH_SHORT).show();
                            }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }

            private void goToHomeActivity(UserModel userModel)  {
                Common.currentUser= userModel;
                startActivity(new Intent(SignIn.this,HomeActivity.class));
                finish();
            }
        });



    }}


