package com.bstka.basicwallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

public class RecoveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setNavigationIcon(getDrawable(R.drawable.ic_baseline_arrow_back_24));
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Recovery Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}