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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cocosw.bottomsheet.BottomSheet;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.lmntrx.indoornavigation.PinView;
import com.shehabic.droppy.DroppyClickCallbackInterface;
import com.shehabic.droppy.DroppyMenuPopup;
import com.shehabic.droppy.animations.DroppyFadeInAnimation;

import org.w3c.dom.Text;

public class Navigation extends AppCompatActivity {

    PointF from_PointF, to_PointF;
    int chooseroute=-1 , fromlocation=0,tolocation=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        Button anchor_to = (Button) findViewById(R.id.ToDropDownBTN);



        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);
        imageView.setZoomEnabled(false);
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

        imageView.setPin(from_PointF,to_PointF,chooseroute);









    }


    public void from_popup(View view) {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        final Button anchor_from = (Button) findViewById(R.id.FromDropDownBTN);
        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this,anchor_from);
        droppyMenu = droppyBuilder.fromMenu(R.menu.content_navigation_menu)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int which) {

                        switch (which) {

                            case R.id.ccc:
                                fromlocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_from.setText("CCC");
                                from_PointF = new PointF(1650f, 1421f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.hod:
                                fromlocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_from.setText("HOD");
                                from_PointF = new PointF(2425f, 260f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.restroom:
                                fromlocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_from.setText("Restroom");
                                from_PointF = new PointF(2550f, 1750f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.staffroom1:
                                fromlocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_from.setText("Staff Room 1");
                                from_PointF = new PointF(1800f, 2075f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;

                            case R.id.staffroom2:
                                fromlocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_from.setText("Staff Room 2");
                                from_PointF = new PointF(2620f, 800f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;

                        }


                    }
                })

        .setPopupAnimation(new DroppyFadeInAnimation())
                .setXOffset(-6)
                .setYOffset(5)
                .build();
        droppyMenu.show();
    }

    public void to_popup(View view) {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        final Button anchor_to = (Button) findViewById(R.id.ToDropDownBTN);
        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this,anchor_to);
        droppyMenu = droppyBuilder.fromMenu(R.menu.content_navigation_menu)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int which) {

                        switch (which) {
                            case R.id.ccc:
                                tolocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_to.setText("CCC");
                                to_PointF = new PointF(1650f, 1421f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.hod:
                                tolocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_to.setText("HOD");
                                to_PointF = new PointF(2425f, 260f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.restroom:
                                tolocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_to.setText("Restroom");
                                to_PointF = new PointF(2550f, 1750f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.staffroom1:
                                tolocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_to.setText("Staff Room 1");
                                to_PointF = new PointF(1800f, 2075f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;

                            case R.id.staffroom2:
                                tolocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_to.setText("Staff Room 2");
                                to_PointF = new PointF(2620f, 800f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;

                        }
                    }
                })


                .setPopupAnimation(new DroppyFadeInAnimation())
                .setXOffset(-6)
                .setYOffset(5)
                .build();
        droppyMenu.show();
    }
}
