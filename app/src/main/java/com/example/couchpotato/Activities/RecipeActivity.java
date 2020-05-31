package com.example.couchpotato.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
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

import org.w3c.dom.Text;

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

        ArrayList <Ingredient> ingredientsPasta = new ArrayList<>();
        ingredientsPasta.add(new Ingredient("Salt", 0.05 , 1, "teaspoons", -1));
        ingredientsPasta.add(new Ingredient("Dried Pasta", 0.50 , 1, "handful", -1));
        ingredientsPasta.add(new Ingredient("Butter", 0.10 , 2, "tablespoon" , 5));
        ingredientsPasta.add(new Ingredient("Grated Parmesan", 0.50 ,1, "tablespoon", 5));
        ingredientsPasta.add(new Ingredient("Black Pepper", 0.15 ,1,  "pinch", 5));

        ArrayList <Ingredient> ingredientsChowMein = new ArrayList<>();
        ingredientsChowMein.add(new Ingredient("Noodles", 5.00 , 1, "package", -1));
        ingredientsChowMein.add(new Ingredient("Soy Sauce", 0.45 , 1, "tablespoon", -1));
        ingredientsChowMein.add(new Ingredient("Garlic", 0.30 , 3, "cloves" , 5));
        ingredientsChowMein.add(new Ingredient("Canola Oil", 0.68,2, "tablespoon", 5));
        ingredientsChowMein.add(new Ingredient("Peas", 0.96 ,5,  "ounces", 5));

        ArrayList <Ingredient> ingredientsChicCurry = new ArrayList<>();
        ingredientsChicCurry.add(new Ingredient("Chicken Thighs", 1.50 , 1, "lb", -1));
        ingredientsChicCurry.add(new Ingredient("Black Pepper", 0.15, 2, "teaspoons", -1));
        ingredientsChicCurry.add(new Ingredient("Carrots", 0.85 , 2, "Sticks" , 5));
        ingredientsChicCurry.add(new Ingredient("Onions", 0.84 ,2, "Balls", 5));
        ingredientsChicCurry.add(new Ingredient("Potatoes", 1.00 , 1, "Lump", -1));
        ingredientsChicCurry.add(new Ingredient("Ginger", 0.42 , 2, "tablespoons", -1));
        ingredientsChicCurry.add(new Ingredient("Garlic", 0.30 , 2, "Cloves" , 5));
        ingredientsChicCurry.add(new Ingredient("Canola Oil", 0.68 ,2, "tablespoons", 5));
        ingredientsChicCurry.add(new Ingredient("Salt", 0.10 , 2, "teaspoons", -1));
        ingredientsChicCurry.add(new Ingredient("Japanese Curry Roux", 2.75 , 7, "ounces", -1));
        ingredientsChicCurry.add(new Ingredient("Soy Sauce", 0.90 , 2, "tablespoons" , 5));
        ingredientsChicCurry.add(new Ingredient("Ketchup", 0.56 ,2, "tablespoons", 5));

        ArrayList <Ingredient> ingredientsBaguette = new ArrayList<>();
        ingredientsBaguette.add(new Ingredient("Water", 1.20 , 26, "tablespoons", -1));
        ingredientsBaguette.add(new Ingredient("Dry Yeast", 0.32 , 2, "teaspoons", -1));
        ingredientsBaguette.add(new Ingredient("Flour", 0.52 , 4, "cups" , 5));
        ingredientsBaguette.add(new Ingredient("Salt", 0.10 ,2, "teaspoons", 5));

        ArrayList <Ingredient> ingredientsTaco = new ArrayList<>();
        ingredientsTaco.add(new Ingredient("Ground Beef", 3.25 , 1, "lb", -1));
        ingredientsTaco.add(new Ingredient("Chili Powder", 0.52 , 2, "tablespoons", -1));
        ingredientsTaco.add(new Ingredient("Ground Cumin", 0.15 , 2, "teaspoon" , 5));
        ingredientsTaco.add(new Ingredient("Salt", 0.05 ,1, "teaspoon", 5));
        ingredientsTaco.add(new Ingredient("Dried Oregano", 0.15 , 1, "teaspoon", -1));
        ingredientsTaco.add(new Ingredient("Garlic Powder", 0.15 , 1, "teaspoons", -1));
        ingredientsTaco.add(new Ingredient("Ground Black Pepper", 0.15 , 1, "teaspoon" , 5));
        ingredientsTaco.add(new Ingredient("Tomato Sauce", 0.95 ,1, "Cup", 5));
        ingredientsTaco.add(new Ingredient("Water", 0.99 , 4, "tablespoons", -1));
        ingredientsTaco.add(new Ingredient("Taco Shells", 8.00 , 12, "shells", -1));

        ArrayList <Ingredient> ingredientsFriedR = new ArrayList<>();
        ingredientsFriedR.add(new Ingredient("White Rice", 0.99 , 2, "cups", -1));
        ingredientsFriedR.add(new Ingredient("Water", 1.20 , 4, "cups", -1));
        ingredientsFriedR.add(new Ingredient("Baby Carrots", 0.87 , 11, "tablespoons" , 5));
        ingredientsFriedR.add(new Ingredient("Green Peas", 0.99 ,8, "tablespoons", 5));
        ingredientsFriedR.add(new Ingredient("Vegetable Oil", 0.68 , 2, "tablespoons", -1));
        ingredientsFriedR.add(new Ingredient("Eggs", 0.99 , 2, "units", -1));
        ingredientsFriedR.add(new Ingredient("Soy Sauce", 0.90 , 2, "tablespoons" , 5));
        ingredientsFriedR.add(new Ingredient("Sesame Oil", 0.45 ,1, "tablespoon", 5));

        ArrayList <Ingredient> ingredientsBurger = new ArrayList<>();
        ingredientsBurger.add(new Ingredient("Ground beef", 4.00 , 2, "lb", -1));
        ingredientsBurger.add(new Ingredient("Worcestershire Sauce", 0.44 , 1, "Tablespoon", -1));
        ingredientsBurger.add(new Ingredient("Salt", 0.10 , 2, "teaspoons" , 5));
        ingredientsBurger.add(new Ingredient("Ground Black Pepper", 0.15 ,1, "teaspoons", 5));
        ingredientsBurger.add(new Ingredient("Vegetable Oil", 0.68 , 2, "tablespoons", -1));
        ingredientsBurger.add(new Ingredient("Cheese", 2.10 , 4, "slices", -1));
        ingredientsBurger.add(new Ingredient("Hamburger Buns", 5.50 , 4, "buns" , 5));

        ArrayList <Ingredient> ingredientsPizza = new ArrayList<>();
        ingredientsPizza.add(new Ingredient("Pizza Dough", 5.00 , 16, "ounces", -1));
        ingredientsPizza.add(new Ingredient("Pizza Sauce", 2.00 , 1, "cup", -1));
        ingredientsPizza.add(new Ingredient("Grated Mozz. Cheese", 3.99 , 12, "ounces" , 5));
        ingredientsPizza.add(new Ingredient("Ground Black Pepper", 0.15 ,1, "teaspoons", 5));
        ingredientsPizza.add(new Ingredient("Oregano", 0.15 , 1, "teaspoons", -1));
        ingredientsPizza.add(new Ingredient("Pepperoni", 6.00 , 19, "slices", -1));


        store = new ArrayList<>();

        store.add(new Recipe(ingredientsPasta, "Pasta", "Italian", 1));
        store.add(new Recipe(ingredientsChowMein, "Chow Mein", "Chinese", 1));
        store.add(new Recipe(ingredientsChicCurry, "Chicken Curry", "Japanese", 10));
        store.add(new Recipe(ingredientsBaguette, "Baguettes", "French", 1));
        store.add(new Recipe(ingredientsTaco, "Taco", "Mexican", 10));
        store.add(new Recipe(ingredientsFriedR, "Fried Rice", "Chinese", 15));
        store.add(new Recipe(ingredientsBurger, "Burger", "American", 5));
        store.add(new Recipe(ingredientsPizza, "Pizza", "Italian", 11));





        final ArrayList <String> recipeNames = new ArrayList<>();
        ArrayList <Double> recipePrice = new ArrayList<>();
        ArrayList <String> recipeAmount = new ArrayList<>();
        for (Recipe r : store){
            recipeNames.add(r.getName());
            recipePrice.add(r.getPrice());
            recipeAmount.add("2");
        }

        ArrayList<Integer> pictures = new ArrayList<>();
        pictures.add(R.drawable.pasta);
        pictures.add(R.drawable.noodles);
        pictures.add(R.drawable.chickencurry);
        pictures.add(R.drawable.baguette);
        pictures.add(R.drawable.taco);
        pictures.add(R.drawable.friedrice);
        pictures.add(R.drawable.burger);
        pictures.add(R.drawable.pizza);
        pictures.add(R.drawable.burrito);


        MyAdapter adapter = new MyAdapter(this, recipeNames, recipePrice, pictures);




        listView.setAdapter(adapter);


    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        ArrayList <String> recipeNames;
        ArrayList <Double> recipePrice;
        ArrayList <String> recipeAmount;
        ArrayList <Integer> pictures;
        Button up;
        Button down;
        Button toCart;
        TextView countIng;
        ImageView picture;


        MyAdapter (Context c, ArrayList<String> names, ArrayList<Double> price, ArrayList<Integer> pictures){
            super(c, R.layout.row, R.id.main_title, names);
            this.context = c;
            this.recipeNames = names;
            this.recipePrice = price;
            this.pictures = pictures;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle;
            myTitle = row.findViewById(R.id.main_title);
            TextView myDescription = row.findViewById(R.id.sub_title);
            myTitle.setText(recipeNames.get(position));
            myDescription.setText("$" + recipePrice.get(position).toString());
            picture = row.findViewById(R.id.image);
            picture.setImageResource(pictures.get(position));

            toCart = row.findViewById(R.id.to_cart);
            up = row.findViewById(R.id.button_up);
            down = row.findViewById(R.id.button_down);
            countIng = row.findViewById(R.id.count);


            countIng.setText("0");

            up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countIng = listView.getChildAt(position).findViewById(R.id.count);
                    Integer a = Integer.parseInt(countIng.getText().toString());
                    a++;
                    countIng.setText(a.toString());
                    return;
                }
            });

            down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countIng = listView.getChildAt(position).findViewById(R.id.count);
                    String s = countIng.getText().toString();
                    Integer a = Integer.parseInt(s) - 1;
                    if (a<0){
                        return;
                    }
                    countIng.setText(a.toString());
                    return;
                }
            });

            toCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(RecipeActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                    //add to users cart TODO:
                    ArrayList <Ingredient> parts;
                    Recipe r = store.get(position);
                    countIng = listView.getChildAt(position).findViewById(R.id.count);
                    System.out.println(countIng.toString());
                        for (Ingredient i : r.getRecipe()) {
                            i.multAmount(Integer.parseInt(countIng.getText().toString()));
                            ViewFoodActivity.cart.add(i);
                        }
                    return;
                }
            });

            return row;
        }
    }
}
