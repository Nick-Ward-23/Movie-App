package com.example.moviesurfers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class PosterActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster);

        imageView = (ImageView) findViewById(R.id.imageView);
        ShowResults();

    }
    //Find posters for movies and display them
    public void ShowResults() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.omdbapi.com/?apikey=89bbbe58&s=";
        Intent intent = getIntent();
        String message = "Dark Knight";

        String url_full = url + message;


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_full,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject film = new JSONObject(response);
                            JSONArray search = film.getJSONArray("Search");
                            JSONObject result = (JSONObject) search.get(0);
                            String poster = result.getString("Poster");
                            System.out.println(poster);

                            Picasso.get().load(poster).into(imageView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}