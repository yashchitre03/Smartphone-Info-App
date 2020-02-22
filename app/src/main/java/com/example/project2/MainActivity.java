package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    // Smartphone name array
    String[] name = {"Samsung Galaxy A70",
                    "Apple iPhone 11 Pro Max",
                    "LG G8 ThinQ",
                    "Samsung Note 10 Plus",
                    "OnePlus 7 Pro",
                    "Oppo FindX",
                    "Google Pixel 3XL",
                    "Redmi K20 Pro",
                    "Samsung Galaxy S10",
                    "Sony Xperia 10 Plus"};

    // Smartphone screen size and price range array
    String[] price = {
            "Size: 6.7\" Price: 300-400$",
            "Size: 6.5\" Price: 900-1150$",
            "Size: 6.1\" Price: 700-800$",
            "Size: 6.8\" Price: 900-1100$",
            "Size: 6.67\" Price: 600-700$",
            "Size: 6.42\" Price: 550-650$",
            "Size: 6.3\" Price: 600-850$",
            "Size: 6.39\" Price: 300-400$",
            "Size: 6.1\" Price: 750-850$",
            "Size: 6.5\" Price: 380-480$"};

    // smartphone image icon resource array
    Integer[] image = {R.drawable.galaxya70i,
            R.drawable.iphone11promaxi,
            R.drawable.lgg8thinqi,
            R.drawable.note10plusi,
            R.drawable.oneplus7proi,
            R.drawable.oppofindxi,
            R.drawable.pixel3xli,
            R.drawable.redmik20proi,
            R.drawable.s10i,
            R.drawable.xperia10plusi};

    // Website link array
    String[] link = {"https://www.samsung.com/uk/smartphones/galaxy-a70/SM-A705FZKUBTU/",
            "https://www.apple.com/shop/buy-iphone/iphone-11-pro",
            "https://www.lg.com/us/mobile-phones/g8-thinq",
            "https://www.samsung.com/us/mobile/galaxy-note10/",
            "https://www.oneplus.com/7pro#/",
            "https://www.oppo.com/en/smartphone-find_x/",
            "https://store.google.com/product/pixel_3",
            "https://www.mi.com/in/redmi-k20-pro/",
            "https://www.samsung.com/us/mobile/galaxy-s10/",
            "https://www.sonymobile.com/us/products/phones/xperia-10-plus/#gref"};

    // Main Activity on-create method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter forlist = new CustomListAdapter(this, name, price, image);
        listView = findViewById(R.id.listviewID);
        listView.setAdapter(forlist);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg) {
                Intent intent = new Intent(MainActivity.this, HighResActivity.class);
                intent.putExtra("itemno",position);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Calls the garbage collector
        System.gc();
    }

    // Context menu on-create method
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose an option");
        getMenuInflater().inflate(R.menu.list_menu, menu);
    }

    // When an item is selected from the context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int item_no = info.position;
        switch (item.getItemId()){
            case R.id.specs:
                // Calls specifications activity
                Intent s = new Intent(MainActivity.this, Specifications.class);
                s.putExtra("itemno",item_no);
                startActivity(s);
                break;
            case R.id.image:
                // Calls high resolution image activity
                Intent h = new Intent(MainActivity.this, HighResActivity.class);
                h.putExtra("itemno",item_no);
                startActivity(h);
                break;
            case R.id.webpage:
                // Opens webpage with the given link
                Intent in = new Intent();
                in.setAction(Intent.ACTION_VIEW);
                in.addCategory(Intent.CATEGORY_BROWSABLE);
                in.setData(Uri.parse(link[item_no]));
                startActivity(in);
                break;
        }
        return super.onContextItemSelected(item);


    }


}
