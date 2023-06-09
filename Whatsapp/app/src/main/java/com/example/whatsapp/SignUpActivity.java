package com.example.whatsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.whatsapp.Models.Users;
import com.example.whatsapp.databinding.ActivitySignUpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        auth= FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account...");
        progressDialog.setMessage("we're creating your account...");

        binding.btnSignUp.setOnClickListener(view ->
        {
            progressDialog.show();
            auth.createUserWithEmailAndPassword(binding.etEmail.getText().toString() , binding.etPassword.getText().toString()).addOnCompleteListener(task -> {
               progressDialog.dismiss();

               if(task.isSuccessful())
               {
                   Users user = new Users(binding.etUserName.getText().toString(),binding.etEmail.getText().toString(),binding.etPassword.getText().toString());

                   String id =task.getResult().getUser().getUid();
                    database.getReference("Users").child(id).setValue(user);

                   Toast.makeText(SignUpActivity.this, "User Created Successfully",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(SignUpActivity.this,task.getException().getMessage() ,Toast.LENGTH_SHORT).show();
               }
            });

        });

        binding.tvalreadyAccount.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(intent);
        });

    }
}