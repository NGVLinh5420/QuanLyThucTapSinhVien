package com.example.quanlythuctapsinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    //DECLARE
    Button btnLogIn;
    EditText edtUser, edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_login);

        setControls();
        setEvents();
    }


    private void setEvents() {
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(Login.this, Activity_Main.class);
                startActivity(inte);
            }
        });
    }

    private void setControls() {
        btnLogIn = findViewById(R.id.btnLogIn);
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
    }

}