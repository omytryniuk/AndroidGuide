package com.example.student.lab3c;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.buttonTerminology);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                // https://www.youtube.com/watch?v=q6-4E1JGT_k    1:15 min
                Intent intent = new Intent(v.getContext(),AutoComplete.class);
                startActivityForResult(intent,0);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/



        // The code was observed at http://developer.android.com/training/basics/firstapp/starting-activity.html


        if (id == R.id.menu_help) {
            Intent intent = new Intent (this,Help.class);
            startActivityForResult(intent,0);
            return true;
        }


        if (id == R.id.menu_about) {
            Intent intent = new Intent (this,About.class);
            startActivityForResult(intent,0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
