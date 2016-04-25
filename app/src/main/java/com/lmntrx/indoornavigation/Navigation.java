package com.lmntrx.indoornavigation;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.shehabic.droppy.DroppyClickCallbackInterface;
import com.shehabic.droppy.DroppyMenuPopup;
import com.shehabic.droppy.animations.DroppyFadeInAnimation;

public class Navigation extends AppCompatActivity {

    PointF from_PointF, to_PointF;
    int chooseroute=-1 , fromlocation=0,tolocation=0;
    public static int destination;
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
        imageView.setImage(ImageSource.resource(R.drawable.map1));

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


        if(from_floor==1) {
            droppyMenu = droppyBuilder.fromMenu(R.menu.floor_1_locations)
                    .triggerOnAnchorClick(false)
                    .setOnClick(new DroppyClickCallbackInterface() {
                        @Override
                        public void call(View v, int which) {

                            switch (which) {

                                case R.id.floor1_langLab:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Language Lab");
                                    from_PointF = new PointF(280f, 1021f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;
                                case R.id.floor1_ecStaffRoom:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("EC Staff Room");
                                    from_PointF = new PointF(500f, 1020f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;
                                case R.id.floor1_ptcSeminarHall:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("PTC Hall");
                                    from_PointF = new PointF(2550f, 1750f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;
                                case R.id.floor1_placementTraining:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Placement Training Center");
                                    from_PointF = new PointF(1800f, 2075f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor1_placementStaffRoom:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Placement Staff Room");
                                    from_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor1_studentCouncil:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Student Council");
                                    from_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor1_gdRoom:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("GD Room");
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

        else if(from_floor==2) {
            droppyMenu = droppyBuilder.fromMenu(R.menu.floor_2_locations)
                    .triggerOnAnchorClick(false)
                    .setOnClick(new DroppyClickCallbackInterface() {
                        @Override
                        public void call(View v, int which) {

                            switch (which) {

                                case R.id.floor2_vicePrincy:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Vice Principal");
                                    from_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_scienceDept:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Science and Humanities Dept");
                                    from_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_csStaffRoom:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("CS Staff Room");
                                    from_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_ecStaffRoom:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("EC Staff Room");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s8eca:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S8 ECA");
                                    from_PointF = new PointF(1800f, 2075f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s8ecb:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S8 EC B");
                                    from_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s6eca:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S6 ECA");
                                    from_PointF = new PointF(2425f, 260f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s6ecb:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S6 EC B");
                                    from_PointF = new PointF(2550f, 1750f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s4csb:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S4 CSB");
                                    from_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_ktu:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("KTU Exam Control Room");
                                    from_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_mg:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("MG Exam Control Room");
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

        else if(from_floor==3) {
            droppyMenu = droppyBuilder.fromMenu(R.menu.floor_3_locations)
                    .triggerOnAnchorClick(false)
                    .setOnClick(new DroppyClickCallbackInterface() {
                        @Override
                        public void call(View v, int which) {

                            switch (which) {

                                case R.id.floor3_csHOD:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("CS HOD");
                                    from_PointF = new PointF(2425f, 260f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_meHOD:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Mech HOD");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;


                                case R.id.floor3_ccc:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("CCC");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_csLibrary:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("CS Library");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s8csa:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S8 CSA");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s8csb:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S8 CSB");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s6csa:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S6 CSA");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s6csb:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S6 CSB");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s4csa:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S4 CSA");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s4mea:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S4 ME A");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s4meb:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("S4 ME B");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_seminarHall1:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Seminar Hall 1");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_seminarHall2:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Seminar Hall 2");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;


                                case R.id.floor3_csStaffRoom1:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("CS Staff Room 1");
                                    from_PointF = new PointF(1800f, 2075f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_csStaffRoom2:

                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("CS Staff Room 2");
                                    from_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_meStaffRoom:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("ME Staff Room");
                                    from_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_serverRoom:
                                    fromlocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_from.setText("Server Room");
                                    from_PointF = new PointF(1650f, 1421f);
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

    public void to_popup(View view) {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        final Button anchor_to = (Button) findViewById(R.id.ToDropDownBTN);
        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this,anchor_to);


        if(from_floor==1) {
            droppyMenu = droppyBuilder.fromMenu(R.menu.floor_1_locations)
                    .triggerOnAnchorClick(false)
                    .setOnClick(new DroppyClickCallbackInterface() {
                        @Override
                        public void call(View v, int which) {

                            switch (which) {

                                case R.id.floor1_langLab:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Language Lab");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;
                                case R.id.floor1_ecStaffRoom:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("EC Staff Room");
                                    to_PointF = new PointF(2425f, 260f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;
                                case R.id.floor1_ptcSeminarHall:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("PTC Hall");
                                    to_PointF = new PointF(2550f, 1750f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;
                                case R.id.floor1_placementTraining:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Placement Training Center");
                                    to_PointF = new PointF(1800f, 2075f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor1_placementStaffRoom:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Placement Staff Room");
                                    to_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor1_studentCouncil:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Student Council");
                                    to_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor1_gdRoom:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("GD Room");
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

        else if(from_floor==2) {
            droppyMenu = droppyBuilder.fromMenu(R.menu.floor_2_locations)
                    .triggerOnAnchorClick(false)
                    .setOnClick(new DroppyClickCallbackInterface() {
                        @Override
                        public void call(View v, int which) {

                            switch (which) {

                                case R.id.floor2_vicePrincy:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Vice Principal");
                                    to_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_scienceDept:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Science And Humanities Dept");
                                    to_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_csStaffRoom:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("CS Staff Room");
                                    to_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_ecStaffRoom:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("EC Staff Room");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s8eca:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S8 ECA");
                                    to_PointF = new PointF(1800f, 2075f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s8ecb:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S8 ECB");
                                    to_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s6eca:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S6 ECA");
                                    to_PointF = new PointF(2425f, 260f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s6ecb:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S6 ECB");
                                    to_PointF = new PointF(2550f, 1750f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_s4csb:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S4 CSB");
                                    to_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_ktu:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("KTU Exam Control Room");
                                    to_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor2_mg:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("MG Exam Control Room");
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

        else if(from_floor==3) {
            droppyMenu = droppyBuilder.fromMenu(R.menu.floor_3_locations)
                    .triggerOnAnchorClick(false)
                    .setOnClick(new DroppyClickCallbackInterface() {
                        @Override
                        public void call(View v, int which) {

                            switch (which) {

                                case R.id.floor3_csHOD:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("CS HOD");
                                    to_PointF = new PointF(2425f, 260f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_meHOD:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Mech HOD");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;


                                case R.id.floor3_ccc:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("CCC");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_csLibrary:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("CS Library");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s8csa:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S8 CSA");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s8csb:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S8 CSB");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s6csa:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S6 CSA");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s6csb:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S6 CSB");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s4csa:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S4 CSA");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s4mea:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S4 ME A");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_s4meb:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("S4 ME B");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_seminarHall1:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Seminar Hall 1");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_seminarHall2:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Seminar Hall 2");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;


                                case R.id.floor3_csStaffRoom1:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("CS Staff Room 1");
                                    to_PointF = new PointF(1800f, 2075f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_csStaffRoom2:

                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("CS Staff Room 2");
                                    to_PointF = new PointF(2620f, 800f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_meStaffRoom:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("ME Staff Room");
                                    to_PointF = new PointF(1650f, 1421f);
                                    imageView.setPin(from_PointF, to_PointF, chooseroute);
                                    break;

                                case R.id.floor3_serverRoom:
                                    tolocation = which;
                                    chooseroute = fromlocation * 100 + tolocation;
                                    anchor_to.setText("Server Room");
                                    to_PointF = new PointF(1650f, 1421f);
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
