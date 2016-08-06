package com.ne3x7.interview.views;

import com.ne3x7.interview.presenters.Presenter;

/**
 * @author nickstulov
 */
public interface MyView {
    Presenter presenter = null;

    /**
     * Sets the visibility state of icon to VISIBLE. Typically used in {@link Presenter}
     * implementations.
     */
    void showIcon();

    /**
     * Sets the visibility state of icon to INVISIBLE. Typically used in {@link Presenter}
     * implementations.
     */
    void hideIcon();

    /**
     * Calls the presenter class to manage icon placement. Typically used in
     * {@link com.ne3x7.interview.Main} class.
     *
     * @param value value to set.
     */
    void toggleIcon(boolean value);
}
