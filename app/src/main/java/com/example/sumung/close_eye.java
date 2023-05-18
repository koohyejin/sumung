package com.example.sumung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class close_eye extends AppCompatActivity {

    private Button 눈감음;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close_eye);

        ImageButton 눈감음 = findViewById(R.id.눈감음);
        눈감음.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(close_eye.this , opene_eye.class);
                startActivity(intent);
            }
        });

    }
}