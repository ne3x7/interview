package com.ne3x7.interview.views;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ne3x7.interview.R;
import com.ne3x7.interview.presenters.BottomPresenter;
import com.ne3x7.interview.presenters.Presenter;

/**
 * @author nickstulov
 */
public class BottomFragment extends Fragment implements MyView {
    public Presenter presenter;

    private ImageView icon;

    public BottomFragment() {
        presenter = new BottomPresenter(this);
    }

    public static BottomFragment newInstance(boolean param) {
        BottomFragment fragment = new BottomFragment();
        Bundle args = new Bundle();
        args.putBoolean("hasIcon", param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            presenter.setShowIcon(getArguments().getBoolean("hasIcon"));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment, container, false);
        icon = (ImageView) view.findViewById(R.id.bottom_image);

        presenter.setShowIcon(true);
        presenter.toggleIcon();

        return view;
    }

    @Override
    public void showIcon() {
        icon.setVisibility(android.view.View.VISIBLE);
    }

    @Override
    public void hideIcon() {
        icon.setVisibility(android.view.View.INVISIBLE);
    }

    @Override
    public void toggleIcon(boolean value) throws NullPointerException {
        presenter.setShowIcon(value);
        presenter.toggleIcon();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
