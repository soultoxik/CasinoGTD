package com.toxik.soul.casinogtd.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

import com.toxik.soul.casinogtd.R;
import com.toxik.soul.casinogtd.domain.MainModule;
import com.toxik.soul.casinogtd.presenters.BalancePresenter;


public class MainActivity extends Activity {
    @Inject
    BalancePresenter balancePresenter;

    private ObjectGraph objectGraph;
    private boolean immersive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setImmersive();
        initModules();
    }

    private void setImmersive() {
        if(!immersive)
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE
            );
        immersive ^= true;
    }

    @Override
    public void onUserInteraction() {
        setImmersive();
    }


    private void initModules() {
        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this));
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

    private int getChangeValue() {
        EditText changeField = (EditText) findViewById(R.id.changeField);
        return Integer.parseInt(changeField.getText().toString());
    }

    public void onDecreasePressed(View view) {
        balancePresenter.changeBalance(-getChangeValue());
    }

    public void onIncreasePressed(View view) {
        balancePresenter.changeBalance(getChangeValue());
    }
}
