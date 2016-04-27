package com.lmntrx.indoornavigation;

/**
 * Created by ACJLionsRoar on 4/14/16.
 */

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;



public class PinView extends SubsamplingScaleImageView {

    Paint paint = new Paint();

    public static boolean fabClicked=false;
    public static int fabCounter=0;

    private int chooseRouteInMap;
    private int choose;

    private PointF sPin,sPin2;
    private Bitmap pin,pin2;

    public PinView(Context context) {
        this(context, null);
        paint.setColor(Color.BLACK);
    }

    public PinView(Context context, AttributeSet attr) {
        super(context, attr);
        paint.setColor(Color.BLACK);
        initialise();
    }

    public void setPin(PointF sPin,PointF sPin2,int chooseRoute) {
        this.sPin = sPin;
        this.sPin2 = sPin2;
        this.chooseRouteInMap=chooseRoute;
        initialise();
        invalidate();


    }

    public PointF getPin() {
        return sPin;
    }




    private void initialise() {
        float density = getResources().getDisplayMetrics().densityDpi;
        pin = BitmapFactory.decodeResource(this.getResources(), R.drawable.pin);
        float w = (density/420f) * pin.getWidth();
        float h = (density/420f) * pin.getHeight();
        pin = Bitmap.createScaledBitmap(pin, (int)w, (int)h, true);

        pin2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.pin2);
        float w2 = (density/420f) * pin2.getWidth();
        float h2 = (density/420f) * pin2.getHeight();
        pin2 = Bitmap.createScaledBitmap(pin2, (int)w2, (int)h2, true);




    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Don't draw pin before image is ready so it doesn't move around during setup.
        if (!isReady()) {
            return;
        }

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        if (sPin != null && pin != null) {
            PointF vPin = sourceToViewCoord(sPin);
            PointF vPin2 = sourceToViewCoord(sPin2);
            float vX = vPin.x - (pin.getWidth()/2);
            float vY = vPin.y - pin.getHeight();
            canvas.drawBitmap(pin, vX, vY, paint);

            float vX2 = vPin2.x - (pin2.getWidth()/2);
            float vY2 = vPin2.y - pin2.getHeight();
            canvas.drawBitmap(pin2, vX2, vY2, paint);
            paint.setStrokeWidth(50);


            switch(chooseRouteInMap)
            {

                // ---------------------------------DEFAULT VALUES----------------------------------------------------
                case -1: break;
                case 0: break;

                // ----------------STAIRCASE VALUES. When From floor < To Floor. Destination =Staircases----------------

                case 101:

                    canvas.drawLine(vX-550, vY+220, vX+370, vY+220, paint);
                    canvas.drawLine(vX+345, vY+220, vX+345, vY-320, paint);

                    break;

                case 102:


                    canvas.drawLine(vX+345, vY+220, vX+345, vY-320, paint);
                    canvas.drawLine(vX+50, vY+220, vX+370, vY+220, paint);

                    break;

                case 103:

                    break;

                case 104:

                    break;

                case 105:

                    break;

                case 106:

                    break;

                case 107:

                    break;

                case 108:

                    break;

                case 201:

                    break;

                case 202:

                    break;

                case 203:

                    break;

                case 204:

                    break;

                case 205:

                    break;

                case 206:

                    break;

                case 207:

                    break;

                case 208:

                    break;

                case 209:

                    break;

                case 210:

                    break;

                case 211:

                    break;

                case 212:

                    break;

                case 301:

                    break;

                case 302:

                    break;

                case 303:

                    break;

                case 304:

                    break;

                case 305:

                    break;

                case 306:

                    break;

                case 307:

                    break;

                case 308:

                    break;

                case 309:

                    break;

                case 310:

                    break;

                case 311:

                    break;

                case 312:

                    break;

                case 313:

                    break;

                case 314:

                    break;

                case 315:

                    break;

                case 316:

                    break;

                case 317:

                    break;

                // -------------STAIRCASE VALUES. When From floor > To Floor. Starting Point =Staircases-----------------

                case -101:

                    break;

                case -102:

                    break;

                case -103:

                    break;

                case -104:

                    break;

                case -105:

                    break;

                case -106:

                    break;

                case -107:

                    break;

                case -108:

                    break;

                case -201:

                    break;

                case -202:

                    break;

                case -203:

                    break;

                case -204:

                    break;

                case -205:

                    break;

                case -206:

                    break;

                case -207:

                    break;

                case -208:

                    break;

                case -209:

                    break;

                case -210:

                    break;

                case -211:

                    break;

                case -212:

                    break;

                case -301:

                    break;

                case -302:

                    break;

                case -303:

                    break;

                case -304:

                    break;

                case -305:

                    break;

                case -306:

                    break;

                case -307:

                    break;

                case -308:

                    break;

                case -309:

                    break;

                case -310:

                    break;

                case -311:

                    break;

                case -312:

                    break;

                case -313:

                    break;

                case -314:

                    break;

                case -315:

                    break;

                case -316:

                    break;

                case -317:

                    break;




                //----------------------------------------- Floor 1 ---------------------------------------------------

                //1. Language Lab - EC Staff Room

                case (R.id.floor1_langLab*100)+R.id.floor1_ecStaffRoom:


                    break;


                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_langLab:


                    break;



                //2. Language Lab - PTC Hall

                case (R.id.floor1_langLab*100)+R.id.floor1_ptcSeminarHall:


                    break;


                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_langLab:


                    break;





                //3. Language Lab - Training Center

                case (R.id.floor1_langLab*100)+R.id.floor1_placementTraining:


                    break;


                case (R.id.floor1_placementTraining*100)+R.id.floor1_langLab:


                    break;




                //4. Language Lab -Staff Room

                case (R.id.floor1_langLab*100)+R.id.floor1_placementStaffRoom:


                    break;


                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_langLab:


                    break;





                //5. Language Lab -Council

                case (R.id.floor1_langLab*100)+R.id.floor1_studentCouncil:


                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_langLab:


                    break;



                //6. Language Lab - GD

                case (R.id.floor1_langLab*100)+R.id.floor1_gdRoom:


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_langLab:


                    break;




                //7. EC Staff Room - PTC Hall

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_ptcSeminarHall:


                    break;


                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_ecStaffRoom:


                    break;




                //8. EC Staff Room - Training Center

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_placementTraining:


                    break;


                case (R.id.floor1_placementTraining*100)+R.id.floor1_ecStaffRoom:


                    break;



                //9. EC Staff Room -Staff Room

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_placementStaffRoom:


                    break;


                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_ecStaffRoom:


                    break;




                //10. EC Staff Room -Council

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_studentCouncil:


                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_ecStaffRoom:


                    break;



                //11. EC Staff Room - GD

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_gdRoom:


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_ecStaffRoom:


                    break;





                //12. PTC Hall- Training Center

                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_placementTraining:


                    break;


                case (R.id.floor1_placementTraining*100)+R.id.floor1_ptcSeminarHall:


                    break;



                //13. PTC Hall -Staff Room

                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_placementStaffRoom:


                    break;


                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_ptcSeminarHall:


                    break;



                //14. PTC Hall -Council

                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_studentCouncil:


                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_ptcSeminarHall:


                    break;




                //15. PTC Hall - GD

                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_gdRoom:


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_ptcSeminarHall:


                    break;




                //16. Training Center-Staff Room

                case (R.id.floor1_placementTraining*100)+R.id.floor1_placementStaffRoom:


                    break;


                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_placementTraining:


                    break;




                //17. Training Center -Council
                case (R.id.floor1_placementTraining*100)+R.id.floor1_studentCouncil:


                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_placementTraining:


                    break;




                //18. Training Center - GD

                case (R.id.floor1_placementTraining*100)+R.id.floor1_gdRoom:


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_placementTraining:


                    break;





                //19. Staff Room -Council

                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_studentCouncil:


                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_placementStaffRoom:


                    break;





                //20. Staff Room- GD

                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_gdRoom:


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_placementStaffRoom:


                    break;



                //21. Council- GD

                case (R.id.floor1_studentCouncil*100)+R.id.floor1_gdRoom:


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_studentCouncil:


                    break;





                //----------------------------------------- Floor 2 ---------------------------------------------------

               // 1.       Vice Principal - S&H dept.


                case (R.id.floor2_vicePrincy*100)+R.id.floor2_scienceDept:


                    break;


                case (R.id.floor2_scienceDept*100)+R.id.floor2_vicePrincy:


                    break;


               // 2.       Vice Principal - CS Staff Room

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_csStaffRoom:


                    break;


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_vicePrincy:


                    break;




               // 3.       Vice Principal - EC staff Room 1

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_ecStaffRoom1:


                    break;


                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_vicePrincy:


                    break;



               // 4.       Vice Principal - S8 ECA





               // 5.       Vice Principal - S8 ECB





               // 6.       Vice Principal - S6 ECA





               // 7.       Vice Principal - S6 ECB





               // 8.       Vice Principal - S4 CSB





               // 9.       Vice Principal - KTU Exam Control Room





               // 10.   Vice Principal - MG Exam Control Room




               // 11.   S&H dept. -  CS Staff Room





               // 12.   S&H dept. -  EC staff Room




               // 13.   S&H dept. -  S8 ECA




               // 14.   S&H dept. -  S8 ECB





               // 15.   S&H dept. -  S6 ECA





               // 16.   S&H dept. -  S6 ECB





               // 17.   S&H dept. -  S4 CSB





                //18.   S&H dept. -  KTU Exam Control Room





               // 19.   S&H dept. -  MG Exam Control Room





               // 20.   CS Staff Room - EC staff Room





               // 21.   CS Staff Room - S8 ECA





               // 22.   CS Staff Room - S8 ECB





                //23.   CS Staff Room - S6 ECA






                //24.   CS Staff Room - S6 ECB






                //25.   CS Staff Room - S4 CSB






                //26.   CS Staff Room - KTU Exam Control Room





                //27.   CS Staff Room - MG Exam Control Room





                //28.   EC staff Room 1 - S8 ECA





                //29.   EC staff Room 1 - S8 ECB





                //30.   EC staff Room 1 - S6 ECA





                //31.   EC staff Room 1- S6 ECB





                //32.   EC staff Room 1- S4 CSB





                //33.   EC staff Room 1- KTU Exam Control Room





                //34.   EC staff Room 1- MG Exam Control Room





                //35.   S8 ECA - S8 ECB





                //36.   S8 ECA - S6 ECA





                //37.   S8 ECA - S6 ECB





                //38.   S8 ECA - S4 CSB





                //39.   S8 ECA - KTU Exam Control Room





                //40.   S8 ECA - MG Exam Control Room




                //41.   S8 ECB - S6 ECA





                //42.   S8 ECB - S6 ECB





                //43.   S8 ECB - S4 CSB





                //44.   S8 ECB - KTU Exam Control Room





                //45.   S8 ECB - MG Exam Control Room





                //46.   S6 ECA - S6 ECB





                //47.   S6 ECA - S4 CSB





                //48.   S6 ECA - KTU Exam Control Room




                //49.   S6 ECA - MG Exam Control Room




               // 50.   S6 ECB - S4 CSB




               // 51.   S6 ECB - KTU Exam Control Room




                //52.   S6 ECB - MG Exam Control Room




                //53.   S4 CSB - KTU Exam Control Room




                //54.   S4 CSB - MG Exam Control Room




                //55.   KTU Exam Control Room -  MG Exam Control Room



                //68.  EC Staff Room 2 - Vice Principal



                //69. EC Staff Room 2 - Science and Humanities Dept




                //70. EC Staff Room 2 - CS Staff Room




                //71. EC Staff Room 2 - Ec staff Room 1




                //72. EC Staff Room 2 - S8 ECA




                //73. EC Staff Room 2 - S8 ECB




                //74. EC Staff Room 2 - S6 ECA




                //75. EC Staff Room 2 - S6 ECB




                //76. EC Staff Room 2 - S4 CSB




                //77. EC Staff Room 2 - KTU




                //78. EC Staff Room 2 - MG






                //----------------------------------------- Floor 3 ---------------------------------------------------


               // 1.       CS HOD - MECH HOD






               // 2.       CS HOD - CCC


                // CCC TO HOD AND BACK
                case (R.id.floor3_ccc*100)+R.id.floor3_csHOD:

                    canvas.drawLine(vX+50, vY+220, vX+370, vY+220, paint);
                    canvas.drawLine(vX+345, vY+220, vX+345, vY-320, paint);
                    //canvas.drawLine(vX+320, vY-320, vX+530, vY-320, paint);

                    break;

                case (R.id.floor3_csHOD*100)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+50, vY2+220, vX2+370, vY2+220, paint);
                    canvas.drawLine(vX2+345, vY2+220, vX2+345, vY2-320, paint);
                    //canvas.drawLine(vX2+320, vY2-320, vX2+530, vY2-320, paint);
                    break;



               // 3.       CS HOD - CS LIB







               // 4.       CS HOD - S8 CSA











               // 5.       CS HOD - S8 CSB














               // 6.       CS HOD - S6 CSA















               // 7.       CS HOD - S6 CSB














               // 8.       CS HOD - S4 CSA












               // 9.       CS HOD - S4 ME A












               // 10.   CS HOD - S4 ME B














               // 11.   CS HOD - SEMINAR HALL 1











               // 12.   CS HOD -  SEMINAR HALL 2












               // 13.   CS HOD -  CS STAFF ROOM 1

                // HOD TO STAFFROOM_1 AND BACK
                case (R.id.floor3_csHOD*100)+R.id.floor3_csStaffRoom1:


                    canvas.drawLine(vX+20, vY+180, vX+20, vY+730, paint);
                    canvas.drawLine(vX+20, vY+705, vX-260, vY+705, paint);
                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_csHOD:

                    canvas.drawLine(vX2+20, vY2+180, vX2+20, vY2+730, paint);
                    canvas.drawLine(vX2+20, vY2+705, vX2-260, vY2+705, paint);
                    break;







               // 14.   CS HOD - CS STAFF ROOM 2



                // HOD TO STAFFROOM_2 AND BACK
                case (R.id.floor3_csHOD*100)+R.id.floor3_csStaffRoom2:

                    canvas.drawLine(vX+20, vY+180, vX+140, vY+180, paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_csHOD:

                    canvas.drawLine(vX2+20, vY2+180, vX2+140, vY2+180, paint);
                    break;


                ///15.   CS HOD - MECH STAFFROOM










                //16.   CS HOD - SERVER ROOM  













               // 17.   MECH HOD - CCC










               // 18.   MECH HOD - CS LIB













               // 19.   MECH HOD - S8 CSA














               // 20.   MECH HOD - S8 CSB














               // 21.   MECH HOD - S6 CSA















               // 22.   MECH HOD - S6 CSB














               // 23.   MECH HOD - S4 CSA














               // 24.   MECH HOD - S4 ME A












               // 25.   MECH HOD - S4 ME B













               // 26.   MECH HOD - SEMINAR HALL 1













               // 27.   MECH HOD - SEMINAR HALL 2













               // 28.   MECH HOD - CS STAFF ROOM 1













                //29.   MECH HOD - CS STAFF ROOM 2















                ///30.   MECH HOD - MECH STAFFROOM














               // 31.   MECH HOD - SERVER ROOM  













                //32.   CCC - CS LIB














                //33.   CCC - S8 CSA














                //34.   CCC - S8 CSB













                //35.   CCC - S6 CSA














                //36.   CCC - S6 CSB














                //37.   CCC - S4 CSA












                //38.   CCC - S4 ME A














                //39.   CCC - S4 ME B













                //40.   CCC - SEMINAR HALL 1















                //41.   CCC - SEMINAR HALL 2














                //42.   CCC - CS STAFF ROOM 1

                // CCC TO STAFFROOM_1 AND BACK
                case (R.id.floor3_ccc*100)+R.id.floor3_csStaffRoom1:

                    canvas.drawLine(vX+20, vY+220, vX+100, vY+220, paint);
                    canvas.drawLine(vX+100, vY+195, vX+100, vY+275, paint);
                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+20, vY2+220, vX2+100, vY2+220, paint);
                    canvas.drawLine(vX2+100, vY2+195, vX2+100, vY2+275, paint);
                    break;


                //43.   CCC - CS STAFF ROOM 2

                // CCC TO STAFFROOM_2 AND BACK
                case (R.id.floor3_ccc*100)+R.id.floor3_csStaffRoom2:

                    canvas.drawLine(vX+50, vY+220, vX+370, vY+220, paint);
                    canvas.drawLine(vX+345, vY+220, vX+345, vY-320, paint);
                    canvas.drawLine(vX+320, vY-320, vX+440, vY-320, paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+50, vY2+220, vX2+370, vY2+220, paint);
                    canvas.drawLine(vX2+345, vY2+220, vX2+345, vY2-320, paint);
                    canvas.drawLine(vX2+320, vY2-320, vX2+440, vY2-320, paint);
                    break;


                //44.   CCC - MECH STAFFROOM














                //45.   CCC - SERVER ROOM  













                ///46.   CS LIB - S8 CSA















                //47.   CS LIB - S8 CSB
















                ///48.   CS LIB - S6 CSA
















                //49.   CS LIB - S6 CSB


















               // 50.   CS LIB - S4 CSA

















                //51.   CS LIB - S4 ME A




















                //52.   CS LIB - S4 ME B


















                //53.   CS LIB - SEMINAR HALL 1

















               // 54.   CS LIB - SEMINAR HALL 2




















               // 55.   CS LIB - CS STAFF ROOM 1


















               // 56.   CS LIB - CS STAFF ROOM 2













                //57.   CS LIB - MECH STAFFROOM














                //58.   CS LIB - SERVER ROOM  




















                //59.   S8 CSA - S8 CSB














                //60.   S8 CSA - S6 CSA





















                //61.   S8 CSA - S6 CSB
















                //62.   S8 CSA - S4 CSA
















                //63.   S8 CSA - S4 ME A















                //64.   S8 CSA - S4 ME B














                //65.   S8 CSA - SEMINAR HALL 1
















                //66.   S8 CSA - SEMINAR HALL 2















                //67.   S8 CSA - CS STAFF ROOM 1













                //68.   S8 CSA - CS STAFF ROOM 2















                //69.   S8 CSA - MECH STAFFROOM












                //70.   S8 CSA - SERVER ROOM  














                ///71.   S8 CSB- S6 CSA














                //72.   S8 CSB- S6 CSB












                //73.   S8 CSB- S4 CSA










                //74.   S8 CSB- S4 ME A












                //75.   S8 CSB- S4 ME B














                //76.   S8 CSB- SEMINAR HALL 1















                //77.   S8 CSB- SEMINAR HALL 2













                //78.   S8 CSB- CS STAFF ROOM 1













                //79.   S8 CSB- CS STAFF ROOM 2















                //80.   S8 CSB- MECH STAFFROOM















                //81.   S8 CSB- SERVER ROOM  














                //82.   S6 CSA- S6 CSB















                //83.   S6 CSA- S4 CSA















                //84.   S6 CSA- S4 ME A

















                //85.   S6 CSA- S4 ME B















                //86.   S6 CSA- SEMINAR HALL 1















                //87.   S6 CSA- SEMINAR HALL 2




















                //88.   S6 CSA- CS STAFF ROOM 1













                //89.   S6 CSA- CS STAFF ROOM 2

















                //90.   S6 CSA- MECH STAFFROOM














                //91.   S6 CSA- SERVER ROOM  

















                //92.   S6 CSB- S4 CSA
















                //93.   S6 CSB- S4 ME A














                //94.   S6 CSB- S4 ME B















                //95.   S6 CSB- SEMINAR HALL 1















                //96.   S6 CSB- SEMINAR HALL 2
















                //97.   S6 CSB- CS STAFF ROOM 1
















                ///98.   S6 CSB- CS STAFF ROOM 2

















                //99.   S6 CSB- MECH STAFFROOM
















                //100.S6 CSB- SERVER ROOM  



















                //101.S4 CSA- S4 ME A












                //102.S4 CSA- S4 ME B
















                //103.S4 CSA- SEMINAR HALL 1















                //104.S4 CSA- SEMINAR HALL 2
















                //105.S4 CSA- CS STAFF ROOM 1



















                //106.S4 CSA- CS STAFF ROOM 2














                //107.S4 CSA- MECH STAFFROOM















                //108.S4 CSA- SERVER ROOM  















                //109.S4 ME A- S4 ME B














                //110.S4 ME A- SEMINAR HALL 1













                //111.S4 ME A- SEMINAR HALL 2

















                //112.S4 ME A- CS STAFF ROOM 1















                //113.S4 ME A- CS STAFF ROOM 2

















                //114.S4 ME A- MECH STAFFROOM




















                //115.S4 ME A- SERVER ROOM  
















                //116.S4 ME B- SEMINAR HALL 1


















                //117.S4 ME B- SEMINAR HALL 2






















                //118.S4 ME B- CS STAFF ROOM 1

















                //119.S4 ME B- CS STAFF ROOM 2




















                //120.S4 ME B- MECH STAFFROOM



















                //121.S4 ME B- SERVER ROOM  



















                //122.SEMINAR HALL 1- SEMINAR HALL 2
















                //123.SEMINAR HALL 1- CS STAFF ROOM 1

















                //124.SEMINAR HALL 1- CS STAFF ROOM 2

















                //125.SEMINAR HALL 1- MECH STAFFROOM

















                //126.SEMINAR HALL 1- SERVER ROOM  





















                //127.SEMINAR HALL 2- CS STAFF ROOM 1



















                //128.SEMINAR HALL 2- CS STAFF ROOM 2













                //129.SEMINAR HALL 2- MECH STAFFROOM

















                //130.SEMINAR HALL 2- SERVER ROOM  















                //131.CS STAFF ROOM 1- CS STAFF ROOM 2
                // STAFFROOM_1 To STAFFROOM_2 AND BACK
                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_csStaffRoom2:

                    canvas.drawLine(vX+20, vY-50, vX+300, vY-50, paint);
                    canvas.drawLine(vX+275, vY-50, vX+275, vY-600, paint);
                    canvas.drawLine(vX+250, vY-600, vX+400, vY-600, paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_csStaffRoom1:

                    canvas.drawLine(vX2+20, vY2-50, vX2+300, vY2-50, paint);
                    canvas.drawLine(vX2+275, vY2-50, vX2+275, vY2-600, paint);
                    canvas.drawLine(vX2+250, vY2-600, vX2+400, vY2-600, paint);
                    break;








                //132.CS STAFF ROOM 1- MECH STAFFROOM













                //133.CS STAFF ROOM 1- SERVER ROOM  















               // 134.CS STAFF ROOM 2- MECH STAFFROOM














                //135.CS STAFF ROOM 2- SERVER ROOM  














                //136.MECH STAFFROOM- SERVER ROOM 






                // --------------------------------------------------------------------------------------------

























            }


            //	drawLine(float startX, float startY, float stopX, float stopY, Paint paint)

        }

    }





}