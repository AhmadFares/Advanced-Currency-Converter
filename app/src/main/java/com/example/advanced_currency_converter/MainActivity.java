package com.example.advanced_currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText e;
    String r;
    Button btn1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = findViewById(R.id.editTextNumberDecimal);
        r = String.valueOf(e.getText());
btn1 = (Button) findViewById(R.id.button);

btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        DownloadTask task = new DownloadTask();
        String link = "https://192.168.0.105/mobile_project/sendToDB.php?value=2";
        task.execute(link);
    }
});
    }
    public class DownloadTask extends AsyncTask<String, Void, String> {
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
                //Toast.makeText(MainActivity.this,"reached 1", Toast.LENGTH_LONG).show();

                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}



