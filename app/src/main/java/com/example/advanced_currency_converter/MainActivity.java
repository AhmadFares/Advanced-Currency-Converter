package com.example.advanced_currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText e;
    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = findViewById(R.id.editTextNumberDecimal);
        r = String.valueOf(e.getText());


    }

    public void covert(View view) {

        DownloadName task = new DownloadName();
        String link = "http://localhost/mobile_project/sendToDB.php?value=" + r;
        task.execute(link);

    }

    public class DownloadName extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int data = reader.read();
                while (data != -1) {

                    result = result + reader.readLine();
                    data = reader.read();
                }

                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }
}




