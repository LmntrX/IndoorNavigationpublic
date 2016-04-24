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

                case -1: break;
                case 0: break;

                // CCC TO HOD AND BACK
                case (R.id.floor3_ccc*10)+R.id.floor3_hod:

                    canvas.drawLine(vX+50, vY+220, vX+370, vY+220, paint);
                    canvas.drawLine(vX+345, vY+220, vX+345, vY-320, paint);
                    //canvas.drawLine(vX+320, vY-320, vX+530, vY-320, paint);

                    break;

                case (R.id.floor3_hod*10)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+50, vY2+220, vX2+370, vY2+220, paint);
                    canvas.drawLine(vX2+345, vY2+220, vX2+345, vY2-320, paint);
                    //canvas.drawLine(vX2+320, vY2-320, vX2+530, vY2-320, paint);
                    break;


                // CCC TO STAFFROOM_1 AND BACK
                case (R.id.floor3_ccc*10)+R.id.floor3_staffroom1:

                    canvas.drawLine(vX+20, vY+220, vX+100, vY+220, paint);
                    canvas.drawLine(vX+100, vY+195, vX+100, vY+275, paint);
                    break;

                case (R.id.floor3_staffroom1*10)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+20, vY2+220, vX2+100, vY2+220, paint);
                    canvas.drawLine(vX2+100, vY2+195, vX2+100, vY2+275, paint);
                    break;


                // CCC TO STAFFROOM_2 AND BACK
                case (R.id.floor3_ccc*10)+R.id.floor3_staffroom2:

                    canvas.drawLine(vX+50, vY+220, vX+370, vY+220, paint);
                    canvas.drawLine(vX+345, vY+220, vX+345, vY-320, paint);
                    canvas.drawLine(vX+320, vY-320, vX+440, vY-320, paint);
                    break;

                case (R.id.floor3_staffroom2*10)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+50, vY2+220, vX2+370, vY2+220, paint);
                    canvas.drawLine(vX2+345, vY2+220, vX2+345, vY2-320, paint);
                    canvas.drawLine(vX2+320, vY2-320, vX2+440, vY2-320, paint);
                    break;


                // CCC TO RESTROOM AND BACK
                case (R.id.floor3_ccc*10)+R.id.floor3_restroom:

                    canvas.drawLine(vX+50, vY+220, vX+370, vY+220, paint);
                    canvas.drawLine(vX+345, vY+220, vX+345, vY+100, paint);
                    canvas.drawLine(vX+320, vY+90, vX+415, vY+90, paint);
                    break;

                case (R.id.floor3_restroom*10)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+50, vY2+220, vX2+370, vY2+220, paint);
                    canvas.drawLine(vX2+345, vY2+220, vX2+345, vY2+100, paint);
                    canvas.drawLine(vX2+320, vY2+90, vX2+415, vY2+90, paint);
                    break;


                // HOD TO STAFFROOM_1 AND BACK
                case (R.id.floor3_hod*10)+R.id.floor3_staffroom1:


                    canvas.drawLine(vX+20, vY+180, vX+20, vY+730, paint);
                    canvas.drawLine(vX+20, vY+705, vX-260, vY+705, paint);
                    break;

                case (R.id.floor3_staffroom1*10)+R.id.floor3_hod:

                    canvas.drawLine(vX2+20, vY2+180, vX2+20, vY2+730, paint);
                    canvas.drawLine(vX2+20, vY2+705, vX2-260, vY2+705, paint);
                    break;


                // HOD TO STAFFROOM_2 AND BACK
                case (R.id.floor3_hod*10)+R.id.floor3_staffroom2:

                    canvas.drawLine(vX+20, vY+180, vX+140, vY+180, paint);
                    break;

                case (R.id.floor3_staffroom2*10)+R.id.floor3_hod:

                    canvas.drawLine(vX2+20, vY2+180, vX2+140, vY2+180, paint);
                    break;


                // HOD TO RESTROOM AND BACK
                case (R.id.floor3_hod*10)+R.id.floor3_restroom:

                    canvas.drawLine(vX+20, vY+140, vX+20, vY+630, paint);
                    canvas.drawLine(vX, vY+605, vX+110, vY+605, paint);
                    break;

                case (R.id.floor3_restroom*10)+R.id.floor3_hod:
                    canvas.drawLine(vX2+20, vY2+140, vX2+20, vY2+630, paint);
                    canvas.drawLine(vX2, vY2+605, vX2+110, vY2+605, paint);
                    break;


                // STAFFROOM_1 To STAFFROOM_2 AND BACK
                case (R.id.floor3_staffroom1*10)+R.id.floor3_staffroom2:

                    canvas.drawLine(vX+20, vY-50, vX+300, vY-50, paint);
                    canvas.drawLine(vX+275, vY-50, vX+275, vY-600, paint);
                    canvas.drawLine(vX+250, vY-600, vX+400, vY-600, paint);
                    break;

                case (R.id.floor3_staffroom2*10)+R.id.floor3_staffroom1:

                    canvas.drawLine(vX2+20, vY2-50, vX2+300, vY2-50, paint);
                    canvas.drawLine(vX2+275, vY2-50, vX2+275, vY2-600, paint);
                    canvas.drawLine(vX2+250, vY2-600, vX2+400, vY2-600, paint);
                    break;


                // STAFFROOM_1 TO RESTROOM AND BACK
                case (R.id.floor3_staffroom1*10)+R.id.floor3_restroom:

                    canvas.drawLine(vX+20, vY-50, vX+300, vY-50, paint);
                    canvas.drawLine(vX+275, vY-50, vX+275, vY-180, paint);
                    canvas.drawLine(vX+250, vY-170, vX+370, vY-170, paint);
                    break;

                case (R.id.floor3_restroom*10)+R.id.floor3_staffroom1:

                    canvas.drawLine(vX2+20, vY2-50, vX2+300, vY2-50, paint);
                    canvas.drawLine(vX2+275, vY2-50, vX2+275, vY2-180, paint);
                    canvas.drawLine(vX2+250, vY2-170, vX2+370, vY2-170, paint);
                    break;



                // STAFFROOM_2 TO RESTROOM AND BACK
                case (R.id.floor3_staffroom2*10)+R.id.floor3_restroom:

                    canvas.drawLine(vX+20, vY-50, vX-85, vY-50, paint);
                    canvas.drawLine(vX-60, vY-50, vX-60, vY+385, paint);
                    canvas.drawLine(vX-60, vY+360, vX+20, vY+360, paint);

                    break;

                case (R.id.floor3_restroom*10)+R.id.floor3_staffroom2:

                    canvas.drawLine(vX2+20, vY2-50, vX2-85, vY2-50, paint);
                    canvas.drawLine(vX2-60, vY2-50, vX2-60, vY2+385, paint);
                    canvas.drawLine(vX2-60, vY2+360, vX2+20, vY2+360, paint);
                    break;


            }


            //	drawLine(float startX, float startY, float stopX, float stopY, Paint paint)

        }

    }


}