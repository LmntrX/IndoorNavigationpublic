package com.lmntrx.indoornavigation;

/**
 * Created by ACJLionsRoar on 4/14/16.
 */

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
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
                case (R.id.ccc*10)+R.id.hod:

                    canvas.drawLine(vX+50, vY+160, vX2, vY2+110, paint);
                    break;

                case (R.id.hod*10)+R.id.ccc:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;


                // CCC TO STAFFROOM_1 AND BACK
                case (R.id.ccc*10)+R.id.staffroom1:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;

                case (R.id.staffroom1*10)+R.id.ccc:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;


                // CCC TO STAFFROOM_2 AND BACK
                case (R.id.ccc*10)+R.id.staffroom2:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;

                case (R.id.staffroom2*10)+R.id.ccc:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;


                // CCC TO RESTROOM AND BACK
                case (R.id.ccc*10)+R.id.restroom:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;

                case (R.id.restroom*10)+R.id.ccc:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;


                // HOD TO STAFFROOM_1 AND BACK
                case (R.id.hod*10)+R.id.staffroom1:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;

                case (R.id.staffroom1*10)+R.id.hod:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;


                // HOD TO STAFFROOM_2 AND BACK
                case (R.id.hod*10)+R.id.staffroom2:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;

                case (R.id.staffroom2*10)+R.id.hod:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;


                // HOD TO RESTROOM AND BACK
                case (R.id.hod*10)+R.id.restroom:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;

                case (R.id.restroom*10)+R.id.hod:
                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;


                // STAFFROOM_1 To STAFFROOM_2 AND BACK
                case (R.id.staffroom1*10)+R.id.staffroom2:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;

                case (R.id.staffroom2*10)+R.id.staffroom1:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;


                // STAFFROOM_1 TO RESTROOM AND BACK
                case (R.id.staffroom1*10)+R.id.restroom:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;

                case (R.id.restroom*10)+R.id.staffroom1:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;



                // STAFFROOM_2 TO RESTROOM AND BACK
                case (R.id.staffroom2*10)+R.id.restroom:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;

                case (R.id.restroom*10)+R.id.staffroom2:

                    canvas.drawLine(vX+50, vY+110, vX2, vY2+110, paint);
                    break;


            }


            //	drawLine(float startX, float startY, float stopX, float stopY, Paint paint)

        }

    }


}