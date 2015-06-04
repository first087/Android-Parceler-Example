package com.artitk.parcelerexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.artitk.parcelerexample.data.Person;
import com.artitk.parcelerexample.utils.KeyboardManager;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity {

    private final String PERSON_KEY = "person";

    private EditText    etName;
    private RadioButton rdoMale;
    private RadioButton rdoFemale;
    private SeekBar     sbAge;
    private TextView    tvAge;
    private Button      btnSave;
    private TextView    tvResult;

    private Person      person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KeyboardManager.on(this);

        setupView();
        setupViewEvent();
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
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        person = Parcels.unwrap(savedInstanceState.getParcelable(PERSON_KEY));

        if (person == null) return;

        showOutput();
        tvResult.append("Data from Restore Instance State");
        tvResult.setTextColor(getResources().getColor(R.color.blue_900));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(PERSON_KEY, Parcels.wrap(person));

        super.onSaveInstanceState(outState);
    }

    private void setupView() {
        etName      = (EditText)    findViewById(R.id.etName);
        rdoMale     = (RadioButton) findViewById(R.id.rdoMale);
        rdoFemale   = (RadioButton) findViewById(R.id.rdoFemale);
        sbAge       = (SeekBar)     findViewById(R.id.sbAge);
        tvAge       = (TextView)    findViewById(R.id.tvAge);
        btnSave     = (Button)      findViewById(R.id.btnSave);
        tvResult    = (TextView)    findViewById(R.id.tvResult);
    }

    private void setupViewEvent() {
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAge.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        tvAge.setText(String.valueOf(sbAge.getProgress()));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = etName.getText().toString();
                int gender      = rdoMale.isChecked() ? 1 : 2;
                int age         = sbAge.getProgress();

                person = new Person(fullname, gender, age);

                showOutput();
                tvResult.append("Data from click Save Button");
                tvResult.setTextColor(getResources().getColor(R.color.green_900));
            }
        });
    }

    private void showOutput() {
        tvResult.setText(person.getFullname() + " is " + (person.getGender() == 1 ? "Male" : "Female") + ".\n");
        tvResult.append((person.getGender() == 1 ? "He" : "She") + " was " + person.getAge() + " " + (person.getAge() > 1 ? "years" : "year") + " old.\n\n");
    }
}
