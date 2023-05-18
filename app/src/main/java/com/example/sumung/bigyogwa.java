package com.example.sumung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.net.Uri;

public class bigyogwa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigyogwa);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.smu.ac.kr/lounge/notice/notice.do?srStartDt=&srEndDt=&mode=list&srCategoryId1=420&srCampus=smuc&srSearchKey=&srSearchVal="));
        startActivity(intent);
    }
}