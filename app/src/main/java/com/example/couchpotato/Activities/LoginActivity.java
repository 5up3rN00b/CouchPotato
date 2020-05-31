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

import com.example.couchpotato.MainActivity;
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

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private Button submit;
    private EditText name, password;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        submit = findViewById(R.id.loginButton);
        name = findViewById(R.id.loginName);
        password = findViewById(R.id.loginPassword);

        // Need new thread but I will implement later
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Button tempButton = findViewById(R.id.loginButton2);

        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                try {
                    HttpClient httpclient = HttpClients.createDefault();
                    HttpPost httppost = new HttpPost("http://73.71.24.214:8080/login.php");

                    // Request parameters and other properties.
                    List<NameValuePair> params = new ArrayList<NameValuePair>(2);
                    params.add(new BasicNameValuePair("loginName", name.getText().toString()));
                    params.add(new BasicNameValuePair("loginPassword", password.getText().toString()));
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
