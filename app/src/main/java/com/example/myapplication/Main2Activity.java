package com.example.myapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.Keys;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    public static   Keys[] keys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle i=getIntent().getExtras();
        Object[] o=null;
        try {


            if (getIntent().hasExtra("keys")) {
                o = getIntent().getParcelableArrayExtra("keys");
                Gson g= new Gson();
                String s=g.toJson(o);
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                keys=gson.fromJson(s,Keys[].class);
            }
            Log.e("dds",keys[1].toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        ViewPager pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new Addapter(getSupportFragmentManager()));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArray("keys",keys.clone());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        keys=((Keys[]) savedInstanceState.getParcelableArray("keys")).clone();

    }


}
