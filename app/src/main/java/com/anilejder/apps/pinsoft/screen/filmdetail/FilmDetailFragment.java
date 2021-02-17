package com.anilejder.apps.pinsoft.screen.filmdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.anilejder.apps.pinsoft.BaseFragment;
import com.anilejder.apps.pinsoft.R;
import com.anilejder.apps.pinsoft.databinding.FragmentFilmDetailBinding;
import com.anilejder.apps.pinsoft.model.response.FilmResponseModel;
import com.google.gson.Gson;

public class FilmDetailFragment extends BaseFragment {

    private FragmentFilmDetailBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_film_detail, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String detailJson = FilmDetailFragmentArgs.fromBundle(getArguments()).getFilmDetail();
        FilmResponseModel filmDetailModel = new Gson().fromJson(detailJson, FilmResponseModel.class);
        mBinding.setFilmDetail(filmDetailModel);
    }
}