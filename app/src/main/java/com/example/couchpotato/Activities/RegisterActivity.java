package com.example.couchpotato.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.couchpotato.R;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private Button submit;
    private EditText name, password;

    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        submit = findViewById(R.id.registerButton);
        name = findViewById(R.id.registerName);
        password = findViewById(R.id.registerPassword);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                try {
                    HttpClient httpclient = HttpClients.createDefault();
                    HttpPost httppost = new HttpPost("http://73.71.24.214:8080/register.php");

                    // Request parameters and other properties.
                    List<NameValuePair> params = new ArrayList<NameValuePair>(2);
                    params.add(new BasicNameValuePair("registerName", name.getText().toString()));
                    params.add(new BasicNameValuePair("registerPassword", password.getText().toString()));
                    httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

                    //Execute and get the response.
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    InputStream inputStream = entity.getContent();
                    String text = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());

                    Log.d(TAG, text);
                } catch (Exception e) {
                    Log.d(TAG, "Exception occurred " + e);
                }
            }
        });
    }
}
