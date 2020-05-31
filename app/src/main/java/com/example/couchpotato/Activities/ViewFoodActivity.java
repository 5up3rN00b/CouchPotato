package com.example.couchpotato.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.example.couchpotato.MainActivity;
import com.example.couchpotato.R;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewFoodActivity extends AppCompatActivity  {
    public static ArrayList <Ingredient> cart = new ArrayList<>();
    Button button;
    ArrayList<Ingredient> pantry = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food);
        button = findViewById(R.id.back);
        listView = findViewById(R.id.listviewfood);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        pantry = new ArrayList<>();

        pantry.add(new Ingredient("Salt", 0.05 , 1, "teaspoons", -1));
        pantry.add(new Ingredient("Dried Pasta", 0.50 , 1, "handful", -1));
        pantry.add(new Ingredient("Butter", 0.10 , 2, "tablespoon" , 5));
        pantry.add(new Ingredient("Grated Parmesan", 0.50 ,1, "tablespoon", 5));
        pantry.add(new Ingredient("Black Pepper", 0.15 ,1,  "pinch", 5));


        pantry.add(new Ingredient("Noodles", 5.00 , 1, "package", -1));
        pantry.add(new Ingredient("Soy Sauce", 0.45 , 1, "tablespoon", -1));
        pantry.add(new Ingredient("Garlic", 0.30 , 3, "cloves" , 5));
        pantry.add(new Ingredient("Canola Oil", 0.68,2, "tablespoon", 5));
        pantry.add(new Ingredient("Peas", 0.96 ,5,  "ounces", 5));


        pantry.add(new Ingredient("Chicken Thighs", 1.50 , 1, "lb", -1));
        pantry.add(new Ingredient("Black Pepper", 0.15, 2, "teaspoons", -1));
        pantry.add(new Ingredient("Carrots", 0.85 , 2, "Sticks" , 5));
        pantry.add(new Ingredient("Onions", 0.84 ,2, "Balls", 5));
        pantry.add(new Ingredient("Potatoes", 1.00 , 1, "Lump", -1));
        pantry.add(new Ingredient("Ginger", 0.42 , 2, "tablespoons", -1));
        pantry.add(new Ingredient("Garlic", 0.30 , 2, "Cloves" , 5));
        pantry.add(new Ingredient("Canola Oil", 0.68 ,2, "tablespoons", 5));
        pantry.add(new Ingredient("Salt", 0.10 , 2, "teaspoons", -1));
        pantry.add(new Ingredient("Japanese Curry Roux", 2.75 , 7, "ounces", -1));
        pantry.add(new Ingredient("Soy Sauce", 0.90 , 2, "tablespoons" , 5));
        pantry.add(new Ingredient("Ketchup", 0.56 ,2, "tablespoons", 5));


        pantry.add(new Ingredient("Water", 1.20 , 26, "tablespoons", -1));
        pantry.add(new Ingredient("Dry Yeast", 0.32 , 2, "teaspoons", -1));
        pantry.add(new Ingredient("Flour", 0.52 , 4, "cups" , 5));
        pantry.add(new Ingredient("Salt", 0.10 ,2, "teaspoons", 5));


        pantry.add(new Ingredient("Ground Beef", 3.25 , 1, "lb", -1));
        pantry.add(new Ingredient("Chili Powder", 0.52 , 2, "tablespoons", -1));
        pantry.add(new Ingredient("Ground Cumin", 0.15 , 2, "teaspoon" , 5));
        pantry.add(new Ingredient("Salt", 0.05 ,1, "teaspoon", 5));
        pantry.add(new Ingredient("Dried Oregano", 0.15 , 1, "teaspoon", -1));
        pantry.add(new Ingredient("Garlic Powder", 0.15 , 1, "teaspoons", -1));
        pantry.add(new Ingredient("Ground Black Pepper", 0.15 , 1, "teaspoon" , 5));
        pantry.add(new Ingredient("Tomato Sauce", 0.95 ,1, "Cup", 5));
        pantry.add(new Ingredient("Water", 0.99 , 4, "tablespoons", -1));
        pantry.add(new Ingredient("Taco Shells", 8.00 , 12, "shells", -1));


        pantry.add(new Ingredient("White Rice", 0.99 , 2, "cups", -1));
        pantry.add(new Ingredient("Water", 1.20 , 4, "cups", -1));
        pantry.add(new Ingredient("Baby Carrots", 0.87 , 11, "tablespoons" , 5));
        pantry.add(new Ingredient("Green Peas", 0.99 ,8, "tablespoons", 5));
        pantry.add(new Ingredient("Vegetable Oil", 0.68 , 2, "tablespoons", -1));
        pantry.add(new Ingredient("Eggs", 0.99 , 2, "units", -1));
        pantry.add(new Ingredient("Soy Sauce", 0.90 , 2, "tablespoons" , 5));
        pantry.add(new Ingredient("Sesame Oil", 0.45 ,1, "tablespoon", 5));


        pantry.add(new Ingredient("Ground beef", 4.00 , 2, "lb", -1));
        pantry.add(new Ingredient("Worcestershire Sauce", 0.44 , 1, "Tablespoon", -1));
        pantry.add(new Ingredient("Salt", 0.10 , 2, "teaspoons" , 5));
        pantry.add(new Ingredient("Ground Black Pepper", 0.15 ,1, "teaspoons", 5));
        pantry.add(new Ingredient("Vegetable Oil", 0.68 , 2, "tablespoons", -1));
        pantry.add(new Ingredient("Cheese", 2.10 , 4, "slices", -1));
        pantry.add(new Ingredient("Hamburger Buns", 5.50 , 4, "buns" , 5));


        pantry.add(new Ingredient("Pizza Dough", 5.00 , 16, "ounces", -1));
        pantry.add(new Ingredient("Pizza Sauce", 2.00 , 1, "cup", -1));
        pantry.add(new Ingredient("Grated Mozz. Cheese", 3.99 , 12, "ounces" , 5));
        pantry.add(new Ingredient("Ground Black Pepper", 0.15 ,1, "teaspoons", 5));
        pantry.add(new Ingredient("Oregano", 0.15 , 1, "teaspoons", -1));
        pantry.add(new Ingredient("Pepperoni", 6.00 , 19, "slices", -1));

        ArrayList<String> ingName = new ArrayList<>();
        ArrayList<String> ingUnit = new ArrayList<>();
        ArrayList <Double> ingPrice = new ArrayList<>();

        for (Ingredient ing : pantry){
            ingName.add(ing.getName());
            ingUnit.add(ing.getUnit());
            ingPrice.add(ing.getPrice());
        }

        MyAdapter adapter = new MyAdapter(this, pantry, ingName);
        listView.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        ArrayList<Ingredient> pantry;
        ArrayList <String> names;
        Button up, down, toCart;
        TextView countIng;

        MyAdapter (Context c, ArrayList<Ingredient> pantry, ArrayList <String > names){
            super(c, R.layout.row, R.id.main_title, names);
            this.context = c;
            this.pantry = pantry;
            this.names= names;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle;
            myTitle = row.findViewById(R.id.main_title);
            TextView myDescription = row.findViewById(R.id.sub_title);
            myTitle.setText(pantry.get(position).getName());
            myDescription.setText("$" + pantry.get(position).getPrice());

            toCart = row.findViewById(R.id.to_cart);
            up = row.findViewById(R.id.button_up);
            down = row.findViewById(R.id.button_down);
            countIng = row.findViewById(R.id.count);

            countIng.setText("0");

            up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (countIng != null) {
                        countIng = listView.getChildAt(position).findViewById(R.id.count);
                        Integer a = Integer.parseInt(countIng.getText().toString());
                        a++;
                        countIng.setText(a.toString());
                        System.out.println(countIng.toString());
                        pantry.get(position).increase();
                    }
                    return;
                }
            });

            down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countIng = listView.getChildAt(position).findViewById(R.id.count);
                    if (countIng != null) {
                        String s = countIng.getText().toString();
                        Integer a = Integer.parseInt(s) - 1;
                        if (a < 0) {
                            return;
                        }
                        countIng.setText(a.toString());
                        pantry.get(position).decrease();
                    }
                        return;
                }
            });

            toCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ViewFoodActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                    //add to users cart TODO:
                    cart.add(pantry.get(position));

                    return;
                }
            });

            return row;
        }
    }
}
