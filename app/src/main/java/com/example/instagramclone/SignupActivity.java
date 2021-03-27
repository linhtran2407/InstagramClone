package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivtiy";
    private EditText etNewUserName;
    private EditText etNewPassword;
    private EditText etNewEmail;
    private EditText etPhone;
    private Button btnFinishSignup;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etNewUserName = findViewById(R.id.etNewUserName);
        etNewPassword = findViewById(R.id.etNewPassword);
        etNewEmail = findViewById(R.id.etNewEmail);
        etPhone = findViewById(R.id.etPhone);
        btnFinishSignup = findViewById(R.id.btnSignup);

        btnFinishSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick Finish signup button");
                // Create the ParseUser
                ParseUser user = new ParseUser();

                String username = etNewUserName.getText().toString();
                String password = etNewPassword.getText().toString();
                String email = etNewEmail.getText().toString();
                String phone = etPhone.getText().toString();

                // Set core properties
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                // Set custom properties
                user.put("phone", phone);

                // Invoke signUpInBackground
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
//                            Intent intent = new Intent(this, MainActivity.class);
//                            startActivity(intent);
//                            finish();
                            goLoginActivity();

                        } else {
                            Log.e(TAG, "Issue with sign up", e);
                            Toast.makeText(SignupActivity.this, "Issue with sign up", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
            }
        });
    }

    private void goLoginActivity(){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
    }

}
