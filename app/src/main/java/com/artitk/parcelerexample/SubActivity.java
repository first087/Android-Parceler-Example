package com.artitk.parcelerexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.artitk.parcelerexample.data.Person;

import org.parceler.Parcels;

public class SubActivity extends AppCompatActivity {

    private TextView tvResult;

    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        person = Parcels.unwrap(intent.getParcelableExtra(MainActivity.PERSON_KEY));

        if (person == null) return;

        tvResult = (TextView) findViewById(R.id.tvResult);

        tvResult.setText("Name\t= " + person.getFullname() + "\n");
        tvResult.append( "Gender\t= " + (person.getGender() == 1 ? "Male" : "Female") + "\n");
        tvResult.append( "Age\t= " + person.getAge() + "\n\n");
        tvResult.append( "Data from MainActivity");
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        int resultCode = RESULT_OK;
        Intent intent = new Intent();

        // TODO : Return data

        setResult(resultCode, intent);

        super.onBackPressed();
    }
}
