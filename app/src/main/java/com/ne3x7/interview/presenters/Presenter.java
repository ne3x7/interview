package com.ne3x7.interview.presenters;

import android.view.View;

import com.ne3x7.interview.views.MyView;

/**
 * @author nickstulov
 */
public interface Presenter {
    MyView v = null;

    /**
     * Setter method for showIcon field. Typically used in {@link MyView} implementations.
     *
     * @param value boolean value to set.
     */
    void setShowIcon(boolean value);

    /**
     * Getter method for showIcon field. Never actually used, just for completeness.
     *
     * @return boolean value set.
     */
    boolean getShowIcon();

    /**
     * Changes the state of icon based on showIcon field value. Typically used in {@link MyView}
     * implementations. Works in pair with {@link Presenter#setShowIcon}.
     */
    void toggleIcon();

    /**
     * Destroys retain cycle between View and Presenter. Typically used in {@link MyView}
     * implementations.
     */
    void onDestroy();
}