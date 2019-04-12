package com.example.myapplication;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class AsynTask extends AsyncTask<MainActivity,Void, Void>
{


    @Override
    protected Void doInBackground(MainActivity... splasches) {

       Keys[] k =JsonLoader.getData();
       MainActivity m=splasches[0];
       m.CallMainAndDie(k.clone());
        return null;


    }

    @Override
    protected void onPostExecute(Void v)
    {

    }
}
