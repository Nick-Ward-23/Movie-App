package com.example.moviesurfers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

    //Find search results and display in webView
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        WebView myWebView = (WebView) findViewById(R.id.webView);
        String url="http://www.omdbapi.com/?apikey=89bbbe58&s=";
        String url_full=url+message;
        myWebView.loadUrl(url_full);

    }
    //take user to poster screen
    public void sendMessage(View view) {
        Intent intent = new Intent(this, PosterActivity.class);

        startActivity(intent);
    }
    //send user to favorites screen
    public void onClick(View view ) {
        Intent intent = new Intent(this, PosterActivity.class);

        startActivity(intent);
    }
}