package com.example.john.myfirstapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The next line sets the layout of the activity to activity_main.xml.
        setContentView(R.layout.activity_main);
    }

    /**
     * Show a toast
     *
     * To make a view interactive you need to:
     *
     * - Implement the method that defines the desired click behavior in the activity. This method
     * must be public, return void, and take a single argument of View.
     * - Set the method name as the value of the onClick property of the view.
     *
     * @param view -- the view that is clicked
     */
    public void toastMe(View view) {
        Toast myToast = Toast.makeText(this, "Hello Toast!",
                Toast.LENGTH_SHORT);
        myToast.show();
    }


    public void countMe(View view) {

        /*
         Get the text view

         Get a View by using findViewById(). Typically you need to cast the result to the
         relevant subclass of View.
         */
        TextView showCountTextView =
                (TextView) findViewById(R.id.textView);


        /*
        Get the value of the text view

        You can get and set values on the view using methods
        such as getText() and setText(). There are other methods for other properties.
        */
        String countString = showCountTextView.getText().toString();

        // Convert value to a number and increment it.
        Integer count = Integer.parseInt(countString);
        count ++;

        // Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }

    private static final String TOTAL_COUNT = "total_count";

    public void randomMe(View view) {

        // Create an Intent to start the second activity.
        Intent randomIntent = new Intent(this, SecondActivity.class);

        // Get the text view that shows the count.
        TextView showCountTextView = (TextView) findViewById(R.id.textView);

        // Get the value of the text view.
        String countString = showCountTextView.getText().toString();

        // Convert the count to an int.
        int count = Integer.parseInt(countString);

        /*
        Add the count to the extras for the Intent

        Use putExtra() on the Intent to add the count to the Intent.
         */
        randomIntent.putExtra(TOTAL_COUNT, count);

        // Start the new activity.
        startActivity(randomIntent);
    }
}
