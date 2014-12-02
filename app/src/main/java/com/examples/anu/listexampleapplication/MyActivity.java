package com.examples.anu.listexampleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.OnItemClickListener;

// static list layout.
//
public class MyActivity extends Activity {

    private ListView lstItems;
    private Button btnAdd;
    private ArrayList itemsArray;
    private ArrayAdapter itemsAdapter;
    public String TAG = "MY ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        setup();
        setupAdapter();
        setupListViewListener();
    }

    protected void setupListViewListener() {

        lstItems.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Toast.makeText(this,"item selected ",Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(), itemsArray.get(position).toString(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "mes" + itemsArray.get(position).toString());
                //itemsAdapter.notifyDataSetInvalidated();

            }
        });
    }


    // create IDs using findViewById
    private void setup() {
        itemsArray = new ArrayList();
        itemsArray.add("first item");
        itemsArray.add("second item");

        lstItems = (ListView) findViewById(R.id.lstItems);
      //  btnAdd = (Button) findViewById(R.id.btnAdd);

    }



    private void setupAdapter() {
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,itemsArray);
        lstItems.setAdapter(itemsAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my, menu);
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
