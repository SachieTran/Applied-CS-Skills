package com.example.demouser.motrade;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        TextView textName = (TextView) findViewById(R.id.itemNameView);
        textName.setText(name);

        String desc = intent.getStringExtra("desc");
        TextView textDesc = (TextView) findViewById(R.id.itemDescriptionView);
        textDesc.setText(desc);

        String price = intent.getStringExtra("price");
        TextView textPrice = (TextView) findViewById(R.id.itemPriceView);
        textPrice.setText(price);

        String pictureFile = intent.getStringExtra("picture");
        ImageView image = (ImageView) findViewById(R.id.itemIcon);
        setPic(this, pictureFile, image);

        //String desc = intent.getStringExtra("desc");

    }

    public static void setPic(Context context, String address, ImageView view) {
        // Get the dimensions of the View
        int targetW = view.getWidth();
        int targetH = view.getHeight();

        if(targetH == 0 || targetW == 0) {
            targetH = R.dimen.browsing_image_view;
            targetW = R.dimen.browsing_image_view;
        }

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(address, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap;
        if (!address.contains("hardcode:")) {
            bitmap = BitmapFactory.decodeFile(address, bmOptions);
        } else {
            if(address.contains("almonds")) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.almonds);
            }
            else if(address.contains("briar")) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.briar);
            }
            else if(address.contains("can")) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.coke);
            }
            else if(address.contains("jocelyn")) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.jocelyn);
            }
            else if(address.contains("cocoa")) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.nada);
            }
            else {
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.puppy);
            }


        }

        view.setImageBitmap(bitmap);
    }
}
