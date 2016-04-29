package com.brioal.pendingtranslationtest.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.brioal.pendingtranslationtest.R;

public class OtherActivity extends AppCompatActivity {
    private int inAnim;
    private int outAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        inAnim = getIntent().getIntExtra("InAnim", android.R.anim.fade_in);
        outAnim = getIntent().getIntExtra("OutAnim", android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        overridePendingTransition(inAnim, outAnim);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        overridePendingTransition(inAnim, outAnim);
        super.onPause();
    }
}
