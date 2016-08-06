package com.ne3x7.interview;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.ne3x7.interview.views.BottomFragment;
import com.ne3x7.interview.views.MyView;
import com.ne3x7.interview.views.TopFragment;

import java.util.Random;

public class Main extends Activity implements View.OnLayoutChangeListener {
    private FragmentManager fragmentManager;
    private MyView top;
    private MyView bottom;

    private int TOLERANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TOLERANCE = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE)).getLauncherLargeIconSize();
        //Log.d("DEBUG", "TOLERANCE = " + TOLERANCE);

        fragmentManager = getFragmentManager();

        top = (MyView) fragmentManager.findFragmentById(R.id.top_fragment);
        bottom = (MyView) fragmentManager.findFragmentById(R.id.bottom_fragment);

        findViewById(R.id.top_fragment_container).addOnLayoutChangeListener(this);
        findViewById(R.id.bottom_fragment_container).addOnLayoutChangeListener(this);

        Random random = new Random();
        boolean val = random.nextBoolean();

        top.toggleIcon(val);
        bottom.toggleIcon(!val);
    }

    // left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom
    @Override
    public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
        switch (view.getId()) {
            case R.id.top_fragment_container:
                //Log.d("DEBUG", "Top container size changed: i3-i1=" + (i3 - i1));
                if (Math.abs(i3 - i1) <= TOLERANCE) {
                    top.toggleIcon(false);
                    bottom.toggleIcon(true);
                }
                break;
            case R.id.bottom_fragment_container:
                //Log.d("DEBUG", "Bottom container size changed: i1-i3=" + (i1 - i3));
                if (Math.abs(i1 - i3) <= TOLERANCE) {
                    bottom.toggleIcon(false);
                    top.toggleIcon(true);
                }
                break;
        }
    }
}
