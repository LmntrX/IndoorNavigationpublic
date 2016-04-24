package com.lmntrx.indoornavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Element versionElement = new Element();
        versionElement.setTitle("Version 1.0");

        Element Mazhar = new Element();
        Mazhar.setTitle("Mazhar Ansari");

        String desc="Indoor Navigation App for Viswajyothi College Of Engineering And Technology. Made with love by $$$$$$.More Description Here";




        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(desc)
                .setImage(R.mipmap.ic_launcher)
                .addItem(versionElement)
                .addGroup("Contributors")
                .addItem(Mazhar)
                .create();

        setContentView(aboutPage);




    }
}
