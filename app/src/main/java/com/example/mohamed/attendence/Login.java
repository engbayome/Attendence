package com.example.mohamed.attendence;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.*;

public class Login extends AppCompatActivity {

    EditText usernameedit;
    EditText passwordedit;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        usernameedit = (EditText)findViewById(R.id.username);
        passwordedit = (EditText)findViewById(R.id.password);

        Button login_btn =(Button)findViewById(R.id.signin);

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        username = usernameedit.getText().toString();
                        password = passwordedit.getText().toString();

                        ParseLogin(username,password);
                    }
                }
        );



    }

    private void ParseLogin(final String username,String password){

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    // Hooray! The user is logged in.
                    Toast.makeText(Login.this, "Sign In success", Toast.LENGTH_SHORT).show();
                    Intent Dashboard= new Intent(getApplicationContext(), Dashboard.class);
                    Dashboard.putExtra("username",username);
                    startActivity(Dashboard);
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                    Toast.makeText(Login.this, "Sign In failed", Toast.LENGTH_SHORT).show();
                    Intent login= new Intent(Login.this , Login.class);
                    startActivity(login);
                }
            }
        });
    }

}
