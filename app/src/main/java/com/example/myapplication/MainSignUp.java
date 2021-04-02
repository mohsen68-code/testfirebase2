package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainSignUp extends AppCompatActivity {

    EditText edtemail,edtpass;
    Button btnok,btnout;
    TextView txtuser;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
        edtemail=findViewById(R.id.edtemailsig);
        edtpass=findViewById(R.id.edtpasssig);
        btnok=findViewById(R.id.btnsig);
        txtuser=findViewById(R.id.txtuser);
        btnout=findViewById(R.id.btnout);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},1);

        mAuth=FirebaseAuth.getInstance();


            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser == null) {
//No one signed in
                startActivity(new Intent(this, MainLogin.class));
                this.finish();
            }else {

                txtuser.setText(currentUser.getEmail());

            }






        btnout.setOnClickListener(V->{

            mAuth.signOut();

            startActivity(new Intent(this, MainLogin.class));

            MainSignUp.this.finish();


        });


    }
}