package com.example.android.inventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.inventoryapp.R.string.item_one_name;
import static com.example.android.inventoryapp.R.string.item_one_price;
import static com.example.android.inventoryapp.R.string.item_one_quantity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });

        // Create a list of Inventory items
        final ArrayList<Inventory> inventory = new ArrayList<>();
        inventory.add(new Inventory(getString(item_one_name),(getString(item_one_price)),(getString(item_one_quantity))));
        inventory.add(new Inventory(getString(item_one_name),(getString(item_one_price)),(getString(item_one_quantity))));
        inventory.add(new Inventory(getString(item_one_name),(getString(item_one_price)),(getString(item_one_quantity))));
        inventory.add(new Inventory(getString(item_one_name),(getString(item_one_price)),(getString(item_one_quantity))));
        inventory.add(new Inventory(getString(item_one_name),(getString(item_one_price)),(getString(item_one_quantity))));

        // Create a AttractionAdapter, whose data source is a list of Cafes.
        InventoryAdapter adapter = new InventoryAdapter(this, inventory);

        // Find the ListView object in the view hierarchy
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Make the ListView use the AttractionAdapter created above, so that the
        // ListView will display list items for each Cafe in the list.
        listView.setAdapter(adapter);

        // Find the View that shows the numbers category
        ImageView arrow = (ImageView) findViewById(R.id.arrow);

//// Set a click listener on that View
//        arrow.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the numbers View is clicked on.
//            @Override
//            public void onClick(View view) {
//                Intent detailIntent = new Intent(MainActivity.this, InventoryDetail.class);
//                startActivity(detailIntent);
//            }
//        });

    }
}

//    /**
//     * This method is called when the minus button is clicked.
//     */
//
//    public void decrement(View view) {
//        if (quantity == 1) {
//            // Show an error message in a toast
//            Toast.makeText(this, "This product is now sold out", Toast.LENGTH_SHORT).show();
//            // Exit this method early because there's nothing left to do
//            return;
//        }
//        quantity = quantity - 1;
//        displayQuantity(quantity);
//    }

//    /**
//     * This method is called when the plus button is clicked.
//     */
//
//    public void decrement(View view) {
//        if (quantity > 1) {
//            // Show an error message in a toast
//            Toast.makeText(this, "This product is now sold out", Toast.LENGTH_SHORT).show();
//            // Exit this method early because there's nothing left to do
//            return;
//        }
//        quantity = quantity + 1;
//        displayQuantity(quantity);
//    }

