package com.example.android.inventoryapp;

/**
 * Created by jamesrichardson on 10/07/2017.
 */

public class Inventory {

    // Name of the Inventory Item
    private String mItemName;

    // Name of the Inventory Item
    private String mItemQuantity;

    // Name of the Inventory Item
    private String mItemPrice;

    /*
    * Create a new Attraction object
    * */

    public Inventory(String itemName, String itemQuantity, String itemPrice) {
        mItemName = itemName;
        mItemQuantity = itemQuantity;
        mItemPrice = itemPrice;
    }

    /**
     * Get the name of the Android version
     */
    public String getItemName() {
        return mItemName;
    }

    /**
     * Get the name of the Android version
     */
    public String getItemQuantity() {
        return mItemQuantity;
    }

    /**
     * Get the name of the Android version
     */
    public String getItemPrice() {
        return mItemPrice;
    }
}
