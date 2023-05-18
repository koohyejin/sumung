package com.example.sumung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class opene_eye extends AppCompatActivity {

    private Button openeye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opene_eye);

        ImageButton openeye = findViewById(R.id.눈뜸);
        openeye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(opene_eye.this, login.class);
                startActivity(intent);
            }
        });
    }
}