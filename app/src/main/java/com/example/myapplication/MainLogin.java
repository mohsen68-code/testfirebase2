package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainLogin extends AppCompatActivity {


    EditText edtemail,edtpass,edtrepass;
    Button btnLogin;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        btnLogin=findViewById(R.id.btnsign);
        edtemail=findViewById(R.id.edtname);
        edtpass=findViewById(R.id.edtpass);
        edtrepass=findViewById(R.id.edtrepass);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},1);
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        btnLogin.setOnClickListener(v->{

            String email=edtemail.getText().toString();
            String pass=edtpass.getText().toString();
            String config=edtrepass.getText().toString();


            if (!pass.toString().equals(config)){

                Toast.makeText(this, "non-config", Toast.LENGTH_SHORT).show();

            }else{
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()){

                            Toast.makeText(MainLogin.this, "SignUp Complete", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(MainLogin.this,MainSignUp.class));

                        }else {

                            Toast.makeText(MainLogin.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                            Log.i("TAG",task.getException().getMessage());

                        }
                        



                    }
                });






            }









        });







    }
}