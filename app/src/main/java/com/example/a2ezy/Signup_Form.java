package com.example.a2ezy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Form extends AppCompatActivity {

    EditText txtName,txtEmail, txtPassword, txtConfirmPassword;
    Button btn_register;
    DatabaseReference reff;
    ProgressBar progressBar;
    Customer customer;


    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        getSupportActionBar().setTitle("Signup Form");

        txtName = (EditText)findViewById(R.id.txt_name);
       txtEmail = (EditText)findViewById(R.id.txt_email);

       txtPassword = (EditText)findViewById(R.id.txt_password);
       txtConfirmPassword = (EditText)findViewById(R.id.txt_confirm);
       btn_register = (Button) findViewById(R.id.buttonRegister);
       progressBar = (ProgressBar) findViewById(R.id.progressBar);
       customer = new Customer();
       reff = FirebaseDatabase.getInstance().getReference().child("Customer");

        firebaseAuth=FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmPassword = txtConfirmPassword.getText().toString().trim();

                customer.setName(name);
                customer.setEmail(txtEmail.getText().toString().trim());
                customer.setPassword(txtPassword.getText().toString().trim());


                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Signup_Form.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Signup_Form.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(Signup_Form.this, "Please Enter Confirm_Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length()<6){
                    Toast.makeText(Signup_Form.this, "Password too short", Toast.LENGTH_SHORT).show();
                }

               // progressBar.setVisibility(View.VISIBLE);

                if(password.equals(confirmPassword)){


                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {


                                        reff.push().setValue(customer);


                                        startActivity(new Intent(getApplicationContext(),Login_Form.class));
                                        Toast.makeText(Signup_Form.this, "Registrarion Complete", Toast.LENGTH_SHORT).show();

                                    }

                                    else
                                    {
                                        Toast.makeText(Signup_Form.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });


                }
                else {

                    Toast.makeText(Signup_Form.this, "Password Not Match", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
