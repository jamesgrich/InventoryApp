package com.example.android.inventoryapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.inventoryapp.R.string.item_one_name;
import static com.example.android.inventoryapp.R.string.item_one_price;
import static com.example.android.inventoryapp.R.string.item_one_quantity;

/**
 * Created by jamesrichardson on 10/07/2017.
 */

public class InventoryAdapter extends ArrayAdapter<Inventory> {
    public InventoryAdapter(Activity context, ArrayList<Inventory> words) {
        // Initialising the Adapter
        super(context, 0, words);
    }

    static class ViewHolder {
        TextView text1;
        TextView text2;
        TextView text3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        // Checking to see if the view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.text1 = (TextView) convertView.findViewById(R.id.itemName);

            viewHolder.text2 = (TextView) convertView.findViewById(R.id.itemPrice);

            viewHolder.text3 = (TextView) convertView.findViewById(R.id.itemQuantity);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Get the {@link Inventory} object located at this position in the list
        Inventory currentInventoryItem = getItem(position);

        // Set this text on the name TextView
        viewHolder.text1.setText(currentInventoryItem.getItemName());

        viewHolder.text2.setText(currentInventoryItem.getItemPrice());

        viewHolder.text3.setText(currentInventoryItem.getItemQuantity());

        // Return the whole list item layout (containing 3 TextViews)
        return convertView;
    }
}
