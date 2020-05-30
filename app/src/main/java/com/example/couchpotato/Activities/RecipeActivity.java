package com.example.couchpotato.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.couchpotato.Classes.Ingredient;
import com.example.couchpotato.Classes.Recipe;
import com.example.couchpotato.MainActivity;
import com.example.couchpotato.R;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {
    Button button;
    ArrayList <Recipe> listOfDishes;
    TextView showIngredients;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        showIngredients = findViewById(R.id.textView2);
        button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        ArrayList <Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Salt", 1.0 , "1 pinch"));
        ingredients.add(new Ingredient("Dried Pasta", 1.0 , "1 handful"));
        ingredients.add(new Ingredient("Butter", 1.0 , "2 tablespoons"));
        ingredients.add(new Ingredient("Grated Parmesan", 2.0 , "1 tablespoon"));
        ingredients.add(new Ingredient("Black Pepper", 1.0 , "1 pinch"));

        listOfDishes = new ArrayList<>();
        Recipe pasta = new Recipe(ingredients, "pasta", "Italian");

        showIngredients.setText(pasta.getRecipe().get(1).getName());
    }
}
