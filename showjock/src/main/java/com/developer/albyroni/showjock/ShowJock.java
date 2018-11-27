package com.developer.albyroni.showjock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJock extends AppCompatActivity {
    private TextView showJocktv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jock);
        showJocktv = findViewById(R.id.showjock);
        if (getIntent() != null) {
            if (getIntent().hasExtra("JOCK")) {
                showJocktv.setText(getIntent().getExtras().getString("JOCK"));
            }
        }
    }
}
