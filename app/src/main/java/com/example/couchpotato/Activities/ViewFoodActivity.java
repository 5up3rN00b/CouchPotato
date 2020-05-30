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
import com.example.couchpotato.MainActivity;
import com.example.couchpotato.R;

import java.util.ArrayList;

public class ViewFoodActivity extends AppCompatActivity {
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
        pantry.add(new Ingredient("Salt", 1.0 , 1, "pinch"));
        pantry.add(new Ingredient("Dried Pasta", 1.0 , 1, "handful"));
        pantry.add(new Ingredient("Butter", 1.0 , 2, "tablespoons"));
        pantry.add(new Ingredient("Grated Parmesan", 2.0 ,1, "tablespoon"));
        pantry.add(new Ingredient("Black Pepper", 1.0 ,1,  "pinch"));
        pantry.add(new Ingredient("Salt", 1.0 , 1, "pinch"));
        pantry.add(new Ingredient("Dried Pasta", 1.0 , 1, "handful"));
        pantry.add(new Ingredient("Butter", 1.0 , 2, "tablespoons"));
        pantry.add(new Ingredient("Grated Parmesan", 2.0 ,1, "tablespoon"));
        pantry.add(new Ingredient("Black Pepper", 1.0 ,1,  "pinch"));

        ArrayList<String> ingName = new ArrayList<>();
        ArrayList<String> ingUnit = new ArrayList<>();
        ArrayList <Double> ingPrice = new ArrayList<>();

        for (Ingredient ing : pantry){
            ingName.add(ing.getName());
            ingUnit.add(ing.getUnit());
            ingPrice.add(ing.getPrice());
        }

        MyAdapter adapter = new MyAdapter(this, ingName, ingUnit, ingPrice);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ViewFoodActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                //add to users cart TODO:
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        ArrayList<String> ingName;
        ArrayList<String> ingUnit;
        ArrayList <Double> ingPrice;
        Button up, down, toCart;
        TextView countIng;

        MyAdapter (Context c, ArrayList<String> names, ArrayList<String> units, ArrayList <Double> prices){
            super(c, R.layout.row, R.id.main_title, names);
            this.context = c;
            this.ingName = names;
            this.ingUnit = units;
            this.ingPrice = prices;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle;
            myTitle = row.findViewById(R.id.main_title);
            TextView myDescription = row.findViewById(R.id.sub_title);
            myTitle.setText(ingName.get(position));
            myDescription.setText("$" + ingPrice.get(position).toString());

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
                    Toast.makeText(ViewFoodActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                    //add to users cart TODO:
                    return;
                }
            });

            return row;
        }
    }
}
