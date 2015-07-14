// The code is used from http://androidexample.com/Show_AutoComplete_Suggestions_-_Android_Example/index.php?view=article_discription&aid=105&aaid=127


package com.example.student.lab3c;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;




public class AutoComplete extends Activity implements  OnItemClickListener, OnItemSelectedListener  {


    // Initialize variables

    AutoCompleteTextView textView=null;
    private ArrayAdapter<String> adapter;

    //These values show in autocomplete
    String item[]={
            "git-init", "git-commit", "git-push", "git-add",
            "git-pull", "git-clone", "android list avd", "adb install", "adb shell", "gradle_build",
            "pm list packages","emulator -avd", "screenshot2 -e", "display", "pm unistall"
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_auto_complete);


        // Initialize AutoCompleteTextView values

        // Get AutoCompleteTextView reference from xml
        textView = (AutoCompleteTextView) findViewById(R.id.Terms);

        //Create adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);

        textView.setThreshold(2);

        //Set adapter to AutoCompleteTextView
        textView.setAdapter(adapter);
        textView.setOnItemSelectedListener(this);
        // back
        // textView.setOnItemClickListener(this);

        textView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                String selection = (String)parent.getItemAtPosition(position);

                TextView tx = (TextView)findViewById(R.id.chan);


                if (selection == "git-init")
                    tx.setText(getString(R.string.ginit));
                if (selection == "git-commit")
                    tx.setText(getString(R.string.gcommit));
                if (selection == "git-push")
                    tx.setText(getString(R.string.gpush));
                if (selection == "git-add")
                    tx.setText(getString(R.string.gadd));
                if (selection == "git-pull")
                    tx.setText(getString(R.string.gpull));
                if (selection == "git-clone")
                    tx.setText(getString(R.string.gclone));
                if (selection ==  "android list avd")
                    tx.setText(getString(R.string.androidlistavd));
                if (selection ==  "adb install")
                    tx.setText(getString(R.string.adbinstall));
                if (selection ==  "adb shell")
                    tx.setText(getString(R.string.adbshell));
                if (selection ==  "gradle_build")
                    tx.setText(getString(R.string.gradlebuild));
                if (selection ==  "pm list packages")
                    tx.setText(getString(R.string.pmlistpackages));
                if (selection ==  "emulator -avd")
                    tx.setText(getString(R.string.emulatoravd));
                if (selection ==  "screenshot2 -e")
                    tx.setText(getString(R.string.screenshot2));
                if (selection ==  "display")
                    tx.setText(getString(R.string.display));
                if (selection ==  "pm unistall")
                    tx.setText(getString(R.string.pmunistall));




                 //TODO Do something with the selected text
            }
        });






    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
                               long arg3) {
        // TODO Auto-generated method stub
        //Log.d("AutocompleteContacts", "onItemSelected() position " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub

        // Show Alert       
        Toast.makeText(getBaseContext(), "Position:"+arg2+" Month:"+arg0.getItemAtPosition(arg2),
                Toast.LENGTH_LONG).show();

        Log.d("AutocompleteContacts", "Position:" + arg2 + " Month:" + arg0.getItemAtPosition(arg2));

    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

}