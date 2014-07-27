
package com.acccalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText edtArea, edtAggregate, edtBrick, edtCement, edtSand, edtSteel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();

    }

    private void initializeView() {
        edtArea = (EditText)findViewById(R.id.edtArea);
        edtAggregate = (EditText)findViewById(R.id.edtAggregate);
        edtBrick = (EditText)findViewById(R.id.edtBrick);
        edtCement = (EditText)findViewById(R.id.edtCement);
        edtSand = (EditText)findViewById(R.id.edtSand);
        edtSteel = (EditText)findViewById(R.id.edtSteel);

        edtArea.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("onTextChanged: "+s);
                double areaSize = 0.0;

                if(s != null && !s.toString().isEmpty())
                    areaSize   = Double.parseDouble(s.toString());
                double cement     = 0.45* areaSize;
                double sand       = 1.2* areaSize;
                double aggregate  = 0.65* areaSize;
                double  steel     = 2.6 * areaSize;
                double bricks     = 16 * areaSize;

                if(areaSize == 0.0){
                    clearText();
                }else{
                    edtAggregate.setText(String.format("%.2f",aggregate));
                    edtCement.setText(String.format("%.2f",cement));
                    edtSand.setText(String.format("%.2f",sand));
                    edtBrick.setText(String.format("%.2f",bricks));
                    edtSteel.setText(String.format("%.2f",steel));
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.main, menu);
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

    public void onClearBtnClick(View v){
        System.out.println("onClearBtnClick");
        edtArea.setText("");
        clearText();
    }

    private void clearText(){
        edtAggregate.setText("");
        edtCement.setText("");
        edtSand.setText("");
        edtBrick.setText("");
        edtSteel.setText("");
    }
}
