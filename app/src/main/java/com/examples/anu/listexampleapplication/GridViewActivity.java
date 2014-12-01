package com.examples.anu.listexampleapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

// THis class is the main activity of Grid
// You need an ImageAdapter class to display the images
// For each click of the image if you want to show the enlarged view of the image
public class GridViewActivity extends Activity {

    private GridView grView;
    public final String TAG = "GridViewActivity";
    static String imageID = "POS"; // making this a static field you cannot reference a non-static
    // varaible within a static method.
    // we want to refer this varaible inside ImageDetailActivty of onCreateView
    //static final String EXTRA_RES_ID = "POS";
    private ArrayList<Integer> mThumbIdsFlowers = new ArrayList<Integer>(
            Arrays.asList(R.drawable.image1, R.drawable.image2,
                    R.drawable.image3, R.drawable.image4, R.drawable.image5,
                    R.drawable.image6, R.drawable.image7, R.drawable.image8,
                    R.drawable.image9, R.drawable.image10, R.drawable.image11,
                    R.drawable.image12));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        grView = (GridView) findViewById(R.id.gvImages);
        grView.setAdapter(new ImageAdapter(this, mThumbIdsFlowers));

        setupListener();

    }

    private void setupListener() {

        grView.setOnItemClickListener(listener);
    }

    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d(TAG,"inside on item click listener");
            Intent i = new Intent(GridViewActivity.this, ImageDetailActivity.class);
            Log.d(TAG,"the id of the photo :" + id);
            i.putExtra(imageID,(int)id);
            startActivity(i);
        }

    };


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.grid_view, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

