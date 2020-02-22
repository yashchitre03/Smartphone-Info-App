package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Specifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specifications);

        TextView pe = findViewById(R.id.pixelsedit);
        TextView re = findViewById(R.id.ramedit);
        TextView se = findViewById(R.id.storageedit);
        TextView ce = findViewById(R.id.cameraedit);
        TextView oe = findViewById(R.id.osedit);
        TextView me = findViewById(R.id.fpriceedit);

        Intent intent = getIntent();
        final int position = intent.getIntExtra("itemno", 0);
        // Switch case is used to display the specifications according to the phone selected in the list
        switch (position){
            case 0:
                pe.setText("1080x2400p");
                re.setText("6/8GB");
                se.setText("128GB");
                ce.setText("32MP");
                oe.setText("Android 9.0");
                me.setText("300-400$");
                break;
            case 1:
                pe.setText("1242x2688p");
                re.setText("4GB");
                se.setText("64/256/512GB");
                ce.setText("12MP");
                oe.setText("iOS 13");
                me.setText("900-1150$");
                break;
            case 2:
                pe.setText("1440x3120p");
                re.setText("6GB");
                se.setText("128GB");
                ce.setText("16MP");
                oe.setText("Android 9.0");
                me.setText("700-800$");
                break;
            case 3:
                pe.setText("1440x3040p");
                re.setText("12GB");
                se.setText("256/512GB");
                ce.setText("12MP");
                oe.setText("Android 9.0");
                me.setText("900-1100$");
                break;
            case 4:
                pe.setText("1440x3120p");
                re.setText("6-12GB");
                se.setText("128/256GB");
                ce.setText("48MP");
                oe.setText("Android 9.0");
                me.setText("600-700$");
                break;
            case 5:
                pe.setText("1080x2340p");
                re.setText("8GB");
                se.setText("128/256GB");
                ce.setText("16MP");
                oe.setText("Android 8.1");
                me.setText("550-650$");
                break;
            case 6:
                pe.setText("1440x2960p");
                re.setText("4GB");
                se.setText("64/128GB");
                ce.setText("12MP");
                oe.setText("Android 9.0");
                me.setText("600-850$");
                break;
            case 7:
                pe.setText("1080x2340p");
                re.setText("6/8GB");
                se.setText("64/128/256GB");
                ce.setText("48MP");
                oe.setText("Android 9.0");
                me.setText("300-400$");
                break;
            case 8:
                pe.setText("1440x3040p");
                re.setText("8GB");
                se.setText("128/512GB");
                ce.setText("16MP");
                oe.setText("Android 9.0");
                me.setText("750-850$");
                break;
            case 9:
                pe.setText("1080x2520p");
                re.setText("4/6GB");
                se.setText("64GB");
                ce.setText("12MP");
                oe.setText("Android 9.0");
                me.setText("380-480$");
                break;
            default:
                pe.setText("--");
                re.setText("--");
                se.setText("--");
                ce.setText("--");
                oe.setText("--");
                me.setText("--");
                break;
        }
    }
}
