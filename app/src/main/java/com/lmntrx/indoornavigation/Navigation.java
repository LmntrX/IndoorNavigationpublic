package com.lmntrx.indoornavigation;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cocosw.bottomsheet.BottomSheet;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.lmntrx.indoornavigation.PinView;

import org.w3c.dom.Text;

public class Navigation extends AppCompatActivity {

    PointF from_PointF, to_PointF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       final TextView from = (TextView) findViewById(R.id.from);
       final  TextView to = (TextView) findViewById(R.id.to);



        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        imageView.setImage(ImageSource.resource(R.drawable.map));

/*
    CCC = PointF(1650f, 1421f)
    HOD = PointF(2800f, 200f)
    Restroom = PointF(2550f,1675f)
    Staff Room 1 = PointF(1800f,2075f)
    Staff Room 2 = PointF(2620f, 800f)

    Green Start =  PointF(2800f, 200f)
    Yellow Start =  PointF(2800f, 200f)

 */



        from_PointF=new PointF(1000f,700f);
        to_PointF=new PointF(500f, 700f);

        imageView.setPin(from_PointF,to_PointF);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BottomSheet.Builder(Navigation.this, R.style.BottomSheet_StyleDialog).title("Choose Starting Point").sheet(R.menu.content_navigation_menu).listener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        switch (which) {
                            case R.id.ccc : from.setText("CCC");
                                from_PointF=new PointF(1650f, 1421f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;
                            case R.id.hod : from.setText("HOD");
                                from_PointF=new PointF(2800f, 200f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;
                            case R.id.restroom : from.setText("Restroom");
                                from_PointF=new PointF(2550f,1675f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;
                            case R.id.staffroom1  : from.setText("Staff Room 1");
                                from_PointF=new PointF(1800f,2075f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;

                            case R.id.staffroom2  : from.setText("Staff Room 2");
                                from_PointF=new PointF(2620f, 800f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;

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
                            case R.id.ccc : to.setText("CCC");
                                to_PointF=new PointF(1650f, 1421f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;
                            case R.id.hod : to.setText("HOD");
                                to_PointF=new PointF(2800f, 200f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;
                            case R.id.restroom : to.setText("Restroom");
                                to_PointF=new PointF(2550f,1675f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;
                            case R.id.staffroom1  : to.setText("Staff Room 1");
                                to_PointF=new PointF(1800f,2075f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;

                            case R.id.staffroom2  : to.setText("Staff Room 2");
                                to_PointF=new PointF(2620f, 800f);
                                imageView.setPin(from_PointF,to_PointF);
                                break;
                        }

                    }
                }).show();
            }
        });



    }




}
