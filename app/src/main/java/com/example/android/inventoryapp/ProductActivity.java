package com.example.android.inventoryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by jamesrichardson on 10/07/2017.
 */

public class ProductActivity extends AppCompatActivity {

    // EditText for the name of the Product
    private EditText mNameEditText;

    // EditText for the Price of the Product
    private EditText mPriceEditText;

    // EditText for the Product quantity
    private EditText mQuantityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_product);

        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mPriceEditText = (EditText) findViewById(R.id.priceEditText);
        mQuantityEditText = (EditText) findViewById(R.id.quantityEditText);
}

}
