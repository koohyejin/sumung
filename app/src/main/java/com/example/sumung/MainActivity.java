package com.example.sumung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button btn_matjib,btn_비교과,btn_수뭉이,btn_맛집리스트,btn_로그아웃;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_matjib = findViewById(R.id.btn_matjib);
        btn_matjib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , matjib.class);
                startActivity(intent);
            }
        });


        btn_비교과 = findViewById(R.id.btn_비교과);
        btn_비교과.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , bigyogwa.class);
                startActivity(intent);
            }
        });

        btn_수뭉이 = findViewById(R.id.btn_수뭉이);
        btn_수뭉이.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , soomoongjeongbo.class);
                startActivity(intent);
            }
        });

        btn_맛집리스트 = findViewById(R.id.btn_맛집리스트);
        btn_맛집리스트.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , matzip_main.class);
                startActivity(intent);
            }
        });

        btn_로그아웃 = findViewById(R.id.btn_로그아웃);
        btn_로그아웃.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //로그아웃 하기
                mFirebaseAuth.signOut();
                Intent intent=new Intent(MainActivity.this, login.class);
                startActivity(intent);
                finish();
            }
        });


        //탈퇴처리하기
        //mFirebaseAuth.getCurrentUser().delete();


    }

}