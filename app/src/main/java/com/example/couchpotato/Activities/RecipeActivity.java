package com.example.couchpotato.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.couchpotato.Classes.Ingredient;
import com.example.couchpotato.Classes.Recipe;
import com.example.couchpotato.MainActivity;
import com.example.couchpotato.R;

import java.security.cert.LDAPCertStoreParameters;
import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {
    Button button;
    ArrayList <Recipe> store;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        //hi


        listView = findViewById(R.id.listview);
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
        ingredients.add(new Ingredient("Salt", 1.0 , 1, "pinch"));
        ingredients.add(new Ingredient("Dried Pasta", 1.0 , 1, "handful"));
        ingredients.add(new Ingredient("Butter", 1.0 , 2, "tablespoons"));
        ingredients.add(new Ingredient("Grated Parmesan", 2.0 ,1, "tablespoon"));
        ingredients.add(new Ingredient("Black Pepper", 1.0 ,1,  "pinch"));

        store = new ArrayList<>();


        store.add(new Recipe(ingredients, "pasta", "Italian"));
        store.add(new Recipe(ingredients, "noodles", "Chinese"));
        store.add(new Recipe(ingredients, "curry", "India"));
        store.add(new Recipe(ingredients, "baguettes", "French"));
        store.add(new Recipe(ingredients, "rice", "Chinese"));
        store.add(new Recipe(ingredients, "beer", "Germany"));
        store.add(new Recipe(ingredients, "pasta", "Italian"));
        store.add(new Recipe(ingredients, "pasta", "Italian"));
        store.add(new Recipe(ingredients, "pasta", "Italian"));
        store.add(new Recipe(ingredients, "pasta", "Italian"));
        store.add(new Recipe(ingredients, "pasta", "Italian"));


        final ArrayList <String> recipeNames = new ArrayList<>();
        ArrayList <String> recipePreferences = new ArrayList<>();
        for (Recipe r : store){
            recipeNames.add(r.getName());
            recipePreferences.add(r.getPreference());
        }

        MyAdapter adapter = new MyAdapter(this, recipeNames, recipePreferences);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RecipeActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                //add to users cart TODO:
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        ArrayList <String> recipeNames;
        ArrayList <String> recipePreferences;

        MyAdapter (Context c, ArrayList<String> names, ArrayList<String> preferences){
            super(c, R.layout.row, R.id.main_title, names);
            this.context = c;
            this.recipeNames = names;
            this.recipePreferences = preferences;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle;
            myTitle = row.findViewById(R.id.main_title);
            TextView myDescription = row.findViewById(R.id.sub_title);
            myTitle.setText(recipeNames.get(position));
            myDescription.setText(recipePreferences.get(position));

            return row;
        }
    }
}
