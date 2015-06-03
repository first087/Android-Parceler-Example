package com.artitk.parcelerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText    etName;
    private RadioButton rdoMale;
    private RadioButton rdoFemale;
    private SeekBar     sbAge;
    private TextView    tvAge;
    private Button      btnSave;
    private TextView    tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                tvResult.setText("Save!!");
            }
        });
    }
}
