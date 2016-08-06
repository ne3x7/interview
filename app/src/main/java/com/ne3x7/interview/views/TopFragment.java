package com.ne3x7.interview.views;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ne3x7.interview.R;
import com.ne3x7.interview.presenters.Presenter;
import com.ne3x7.interview.presenters.TopPresenter;

/**
 * @author nickstulov
 */
public class TopFragment extends Fragment implements MyView {
    public Presenter presenter;

    private ImageView icon;

    public TopFragment() {
        presenter = new TopPresenter(this);
    }

    public static TopFragment newInstance(boolean param) {
        TopFragment fragment = new TopFragment();
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
        View view = inflater.inflate(R.layout.top_fragment, container, false);
        icon = (ImageView) view.findViewById(R.id.top_image);

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
