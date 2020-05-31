package com.example.couchpotato.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.couchpotato.Classes.Ingredient;
import com.example.couchpotato.MainActivity;
import com.example.couchpotato.R;
import java.util.*;

import static com.example.couchpotato.Activities.ViewFoodActivity.cart;

public class BuyActivity extends AppCompatActivity {
    Button button, clearCart;
    ListView listView;
    EditText input;
    int inputValue;
    TextView total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        button = findViewById(R.id.back);
        input = findViewById(R.id.amount);
        listView = (ListView) findViewById(R.id.buy);
        total = findViewById(R.id.total);
        clearCart = findViewById(R.id.clearcart);
        double totalPrice = 0;
        if (cart != null) {
            for (Ingredient ing : cart) {
                totalPrice += (ing.getPrice() * ing.getAmount());
            }
        }

        double roundedPrice = ((int) (totalPrice * 100)) / 100.0;

        total.setText("Total: $" + roundedPrice);

        ArrayList<Ingredient> list = new ArrayList<>();
        if (cart != null) {
            boolean inList = false;
            for (Ingredient ing : cart) {
                inList = false;
                System.out.println(ing.getName() + " " + ing.getAmount());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(ing.getName())) {
                        list.get(i).add(ing.getAmount());
                        inList = true;
                    }
                }
                if (inList == false) {
                    list.add(ing);
                }
            }
        }

        if (list!=null) {
            ArrayAdapter<Ingredient> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);


            BuyActivity.MyAdapter adapter = new MyAdapter(this, list);
            listView.setAdapter(adapter);

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return;
            }
        });
        clearCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.clear();
                startActivity(new Intent(getApplicationContext(), BuyActivity.class));
                finish();
            }
        });
    }


    class MyAdapter extends ArrayAdapter<Ingredient> {
        Context context;
        ArrayList<Ingredient> names;


        MyAdapter (Context c, ArrayList<Ingredient> names){
            super(c, R.layout.buy_layout, R.id.item, names);
            this.context = c;
            this.names = names;
        }
        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.buy_layout, parent, false);
            TextView items;
            TextView amount;

            final TextView price;
            items = row.findViewById(R.id.item);
            amount = row.findViewById(R.id.amount);
            price = row.findViewById(R.id.price);


            items.setText(names.get(position).getName());
            amount.setText(String.valueOf(names.get(position).getAmount()) + " " + names.get(position).getUnit());

            //input.setText(String.valueOf(names.get(position).getAmount()));

            if(input == null){
                double totalPrice = ((int) (names.get(position).getPrice() * names.get(position).getAmount() * 100)) / 100.0;
                price.setText("$" + totalPrice);
            } else{
                inputValue = Integer.valueOf(input.getText().toString());
                amount.setText(Integer.valueOf(input.getText().toString()));

                names.get(position).setAmount(inputValue);
                double totalPrice = ((int) (names.get(position).getPrice() * names.get(position).getAmount() * 100)) / 100.0;
                price.setText("$" + totalPrice);


            }

            return row;
        }
    }
}






