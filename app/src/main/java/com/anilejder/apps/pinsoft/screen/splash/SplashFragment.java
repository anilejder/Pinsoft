package com.anilejder.apps.pinsoft.screen.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.anilejder.apps.pinsoft.BaseFragment;
import com.anilejder.apps.pinsoft.MainActivity;
import com.anilejder.apps.pinsoft.R;
import com.blankj.utilcode.util.NetworkUtils;

public class SplashFragment extends BaseFragment {

    private MainActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mActivity.getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        mActivity.getSupportActionBar().show();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!NetworkUtils.isConnected()) {
            showInformationDialog(R.string.no_internet, (dialogInterface, i) -> mActivity.finish());
        } else {
            new Handler().postDelayed(() -> {
                NavDirections toFilm = SplashFragmentDirections.toFilmFragment();
                Navigation.findNavController(view).navigate(toFilm);
            }, 1000);
        }
    }
}