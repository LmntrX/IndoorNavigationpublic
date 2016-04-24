package com.lmntrx.indoornavigation;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.shehabic.droppy.DroppyClickCallbackInterface;
import com.shehabic.droppy.DroppyMenuPopup;
import com.shehabic.droppy.animations.DroppyFadeInAnimation;

public class Navigation extends AppCompatActivity {

    PointF from_PointF, to_PointF;
    int chooseroute=-1 , fromlocation=0,tolocation=0;
    public static int from_floor=1,to_floor=1;

    public static int fabControl=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        from_floor=1;
        to_floor=1;
        fabDisplay();




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



        from_PointF=new PointF(800f,400f);
        to_PointF=new PointF(300f, 400f);

        imageView.setPin(from_PointF,to_PointF,chooseroute);









    }


    public void from_popup(View view) {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        final Button anchor_from = (Button) findViewById(R.id.FromDropDownBTN);

        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this,anchor_from);

        droppyMenu = droppyBuilder.fromMenu(R.menu.floor_3_locations)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int which) {

                        switch (which) {

                            case R.id.floor3_ccc:
                                fromlocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_from.setText("CCC");
                                from_PointF = new PointF(1650f, 1421f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.floor3_hod:

                                fromlocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_from.setText("HOD");
                                from_PointF = new PointF(2425f, 260f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.floor3_restroom:

                                fromlocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_from.setText("Restroom");
                                from_PointF = new PointF(2550f, 1750f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.floor3_staffroom1:

                                fromlocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_from.setText("Staff Room 1");
                                from_PointF = new PointF(1800f, 2075f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;

                            case R.id.floor3_staffroom2:

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
        droppyMenu = droppyBuilder.fromMenu(R.menu.floor_3_locations)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int which) {

                        switch (which) {
                            case R.id.floor3_ccc:
                                tolocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_to.setText("CCC");
                                to_PointF = new PointF(1650f, 1421f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.floor3_hod:
                                tolocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_to.setText("HOD");
                                to_PointF = new PointF(2425f, 260f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.floor3_restroom:
                                tolocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_to.setText("Restroom");
                                to_PointF = new PointF(2550f, 1750f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;
                            case R.id.floor3_staffroom1:
                                tolocation = which;
                                chooseroute = fromlocation * 10 + tolocation;
                                anchor_to.setText("Staff Room 1");
                                to_PointF = new PointF(1800f, 2075f);
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                                break;

                            case R.id.floor3_staffroom2:
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

    public void from_floor_popup(View view) {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);
        imageView.setZoomEnabled(false);


        final Button anchor_to = (Button) findViewById(R.id.FromFloorBTN);
        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this,anchor_to);
        droppyMenu = droppyBuilder.fromMenu(R.menu.floor_menu)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int which) {

                        switch (which)
                        {
                            case R.id.floor1 :
                                Navigation.from_floor=1;
                                fabDisplay();
                                imageView.setImage(ImageSource.resource(R.drawable.map1));
                                anchor_to.setText("1");
                                break;
                            case R.id.floor2 :
                                Navigation.from_floor=2;
                                fabDisplay();
                                imageView.setImage(ImageSource.resource(R.drawable.map2));
                                anchor_to.setText("2");
                                break;
                            case R.id.floor3 :
                                Navigation.from_floor=3;
                                fabDisplay();
                                imageView.setImage(ImageSource.resource(R.drawable.map3));
                                anchor_to.setText("3");
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


    public void to_floor_popup(View view) {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        final Button anchor_to = (Button) findViewById(R.id.ToFloorBTN);
        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this,anchor_to);
        droppyMenu = droppyBuilder.fromMenu(R.menu.floor_menu)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int which) {
                        switch (which)
                        {
                            case R.id.floor1 :
                                Navigation.to_floor=1;
                                fabDisplay();
                                anchor_to.setText("1");
                                break;
                            case R.id.floor2 :
                                Navigation.to_floor=2;
                                fabDisplay();
                                anchor_to.setText("2");
                                break;
                            case R.id.floor3 :
                                Navigation.to_floor=3;
                                fabDisplay();
                                anchor_to.setText("3");
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

    public void fabDisplay()
    {
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        if (Navigation.from_floor==Navigation.to_floor)
        {
            floatingActionButton.hide();
        }

        else {
            floatingActionButton.show();
        }

    }

    public void chooseNextFloor(View view) {
        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);
        imageView.setZoomEnabled(false);

        if(fabControl==0)
        {
            if(Navigation.to_floor==1)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map1));
                fabControl=1;
            }

            else if(Navigation.to_floor==2)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map2));
                fabControl=1;
            }

            else if(Navigation.to_floor==3)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map3));
                fabControl=1;
            }

        }


        else
        {
            if(Navigation.from_floor==1)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map1));
                fabControl=0;
            }

            else if(Navigation.from_floor==2)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map2));
                fabControl=0;
            }

            else if(Navigation.from_floor==3)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map3));
                fabControl=0;
            }

        }



    }
}
