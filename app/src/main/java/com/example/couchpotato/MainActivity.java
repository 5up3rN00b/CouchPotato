package com.example.couchpotato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.couchpotato.Activities.BuyActivity;
import com.example.couchpotato.Activities.LoginActivity;
import com.example.couchpotato.Activities.RecipeActivity;
import com.example.couchpotato.Activities.RegisterActivity;
import com.example.couchpotato.Activities.ViewFoodActivity;

public class MainActivity extends AppCompatActivity {

    Button mLogout, mToRecipe, mToViewFood, mBuy;
    TextView nameScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogout = findViewById(R.id.logout);
        mToRecipe = findViewById(R.id.view_recipes);
        mToViewFood = findViewById(R.id.view_foods);
        mBuy = findViewById(R.id.checkout);
        nameScreen = findViewById(R.id.textView3);

        if(LoginActivity.nameUser != null){
            nameScreen.setText(LoginActivity.nameUser);
        } else{
            nameScreen.setText(RegisterActivity.nameRegister);
        }


        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

        mToViewFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ViewFoodActivity.class));
                finish();
            }
        });

        mToRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecipeActivity.class));
                finish();
            }
        });

        mBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BuyActivity.class));
                finish();
            }
        });

    }
}
