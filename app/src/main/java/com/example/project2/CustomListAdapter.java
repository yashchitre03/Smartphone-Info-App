package com.example.project2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {
    private final Activity context;
    private final Integer[] imageID;
    private final String[] name;
    private final String[] price;

    // sets the data in the list item
    public CustomListAdapter(Activity context, String[] name, String[] price, Integer[] imageID){

        super(context,R.layout.listview_row , name);

        this.context = context;
        this.imageID = imageID;
        this.name = name;
        this.price = price;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null,true);

        TextView nameTextField = rowView.findViewById(R.id.nameViewID);
        TextView infoTextField = rowView.findViewById(R.id.priceViewID);
        ImageView imageView = rowView.findViewById(R.id.imageViewID);

        nameTextField.setText(name[position]);
        infoTextField.setText(price[position]);
        imageView.setImageResource(imageID[position]);

        return rowView;

    }
}
