package com.lmntrx.indoornavigation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cocosw.bottomsheet.BottomSheet;

import org.w3c.dom.Text;

public class Navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       final TextView from = (TextView) findViewById(R.id.from);
       final  TextView to = (TextView) findViewById(R.id.to);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BottomSheet.Builder(Navigation.this, R.style.BottomSheet_StyleDialog).title("Choose Starting Point").sheet(R.menu.content_navigation_menu).listener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        switch (which) {
                            case R.id.ccc : from.setText("CCC"); break;
                            case R.id.hod : from.setText("HOD");break;
                            case R.id.restroom : from.setText("Restroom");break;
                            case R.id.exit  : from.setText("Exit");break;

                        }

                    }
                }).show();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BottomSheet.Builder(Navigation.this,R.style.BottomSheet_StyleDialog).title("Choose Destination").sheet(R.menu.content_navigation_menu).listener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case R.id.ccc : to.setText("CCC"); break;
                            case R.id.hod : to.setText("HOD");break;
                            case R.id.restroom : to.setText("Restroom");break;
                            case R.id.exit  : to.setText("Exit");break;

                        }

                    }
                }).show();
            }
        });


    }

}
