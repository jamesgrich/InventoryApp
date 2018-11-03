package com.example.android.inventoryapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.inventoryapp.data.InventoryContract.InventoryEntry;

/**
 * {@link ItemCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of pet data as its data source. This adapter knows
 * how to create list items for each row of pet data in the {@link Cursor}.
 */
public class ItemCursorAdapter extends CursorAdapter {

    /**
     * Constructs a new {@link ItemCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public ItemCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * This method binds the pet data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current pet can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(final View view, final Context context, final Cursor cursor) {

        // Find product name, price and quantity fields to populate when inflating view
        TextView itemName = (TextView) view.findViewById(R.id.itemName);
        TextView itemPrice = (TextView) view.findViewById(R.id.itemPrice);
        TextView itemQuantity = (TextView) view.findViewById(R.id.itemQuantity);

        // Extract values from Cursor object
        String name = cursor.getString(cursor.getColumnIndexOrThrow(InventoryEntry.COLUMN_INVENTORY_NAME));
        final int price = cursor.getInt(cursor.getColumnIndexOrThrow(InventoryEntry.COLUMN_INVENTORY_PRICE));
        final int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(InventoryEntry.COLUMN_INVENTORY_QUANTITY));
        final Uri uri = ContentUris.withAppendedId(InventoryEntry.CONTENT_URI, cursor.getInt(cursor.getColumnIndexOrThrow(InventoryEntry._ID)));

        // Populate TextViews with values extracted from Cursor object
        itemName.setText(name);
        itemPrice.setText(Integer.toString(price));
        itemQuantity.setText(Integer.toString(quantity));

        // Find sale Button
        Button saleButton = (Button) view.findViewById(R.id.saleButton);
        // Set Button click listener
        saleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if quantity in stock is higher than zero
                Log.d("inventoryapp", "assigning quantity value");
                if (quantity > 0) {
                    // Assign a new quantity value of minus one to show that one item sold
                    Log.d("inventoryapp", "new quantity value of -1 to indicate a sale");
                    int newQuantity = quantity - 1;
                    // Create and initialise a new ContentValue object with the new quantity
                    Log.d("inventoryapp", "creating a new ContentValue object");
                    ContentValues values = new ContentValues();
                    Log.d("inventoryapp", "putting the value in as the new quantity");
                    values.put(InventoryEntry.COLUMN_INVENTORY_QUANTITY, newQuantity);
                    // Update the database
                    Log.d("inventoryapp", "updating database");
                    context.getContentResolver().update(uri, values, null, null);
                    Log.d("inventoryapp", "updating database complete");
                } else {
                    // Inform the user that quantity is zero and can't be updated
                    Toast.makeText(context, context.getString(R.string.toast_item_out_stock), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}