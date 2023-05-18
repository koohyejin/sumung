package com.example.sumung;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.content.Intent;
import android.view.View;

//import androidx.annotation.NonNull;

public class matzip implements Parcelable {
    public String name;
    String call_num;
    int menu_kind;
    String menu1;
    String menu2;
    String menu3;
    String homepage;
    String enroll_date;
    boolean isCheckable;



    public matzip(String name, String call_num, int menu_kind, String menu1, String menu2, String menu3, String homepage, String enroll_date) {
        this.name = name;
        this.call_num = call_num;
        this.menu_kind = menu_kind;
        this.homepage = homepage;
        this.enroll_date = enroll_date;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        boolean isCheckable = false;


    }
    public String getName() {
        String name = this.name;
        return name;
    }

    protected matzip(Parcel in) {
        name = in.readString();
        call_num = in.readString();
        menu_kind = in.readInt();
        menu1 = in.readString();
        menu2 = in.readString();
        menu3 = in.readString();
        homepage = in.readString();
        enroll_date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(name);
        dest.writeString(call_num);
        dest.writeInt(menu_kind);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);
        dest.writeString(homepage);
        dest.writeString(enroll_date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<matzip> CREATOR = new Creator<matzip>() {
        @Override
        public matzip createFromParcel(Parcel source) {
            return new matzip(source);
        }

        @Override
        public matzip[] newArray(int size) {
            return new matzip[size];
        }


    };

}