package com.ne3x7.interview.presenters;

import android.view.View;
import com.ne3x7.interview.views.MyView;

/**
 * @author nickstulov
 */
public class BottomPresenter implements Presenter {
    public MyView v;

    private boolean showIcon;

    public BottomPresenter(MyView v) {
        this.v = v;
    }

    @Override
    public void setShowIcon(boolean value) {
        showIcon = value;
    }

    @Override
    public boolean getShowIcon() {
        return showIcon;
    }

    @Override
    public void toggleIcon() {
        if (showIcon) {
            v.showIcon();
        } else {
            v.hideIcon();
        }
    }

    @Override
    public void onDestroy() {
        v = null;
    }
}
