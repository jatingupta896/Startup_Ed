package com.animator_abhi.gcethackathon.Post;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.animator_abhi.gcethackathon.R;

public class Detail extends AppCompatActivity {

    private static final String EXTRA_POSITION = "position";
    private TextView company_name;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        company_name=(TextView)findViewById(R.id.Company_name);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] places = resources.getStringArray(R.array.places);
        collapsingToolbar.setTitle(places[postion % places.length]);

        String[] placeDetails = resources.getStringArray(R.array.places_details_1);
        TextView placeDetail = (TextView) findViewById(R.id.place_detail);
        placeDetail.setText(placeDetails[postion % placeDetails.length]);

        String[] placeLocations = resources.getStringArray(R.array.places_locations_1);
        TextView placeLocation =  (TextView) findViewById(R.id.place_location);
        placeLocation.setText(placeLocations[postion % placeLocations.length]);

        TypedArray placePictures = resources.obtainTypedArray(R.array.places_pictures_1);
        ImageView placePicutre = (ImageView) findViewById(R.id.image);
        placePicutre.setImageDrawable(placePictures.getDrawable(postion % placePictures.length()));

        placePictures.recycle();
        company_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(this,));
            }
        });
    }

}

