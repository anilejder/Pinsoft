package com.anilejder.apps.pinsoft.screen.film;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.anilejder.apps.pinsoft.BaseFragment;
import com.anilejder.apps.pinsoft.MainActivity;
import com.anilejder.apps.pinsoft.R;
import com.anilejder.apps.pinsoft.databinding.FragmentFilmBinding;
import com.anilejder.apps.pinsoft.model.response.FilmResponseModel;
import com.anilejder.apps.pinsoft.util.SpacingLinearItemDecoration;
import com.blankj.utilcode.util.ConvertUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FilmFragment extends BaseFragment implements SearchView.OnQueryTextListener, FilmAdapter.FilmAdapterListener {

    private FragmentFilmBinding mBinding;
    private MainActivity mActivity;
    private FilmViewModel mFilmViewModel;
    private List<FilmResponseModel> mSearchResultList = new ArrayList<>();
    private FilmAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
        mFilmViewModel = new ViewModelProvider(this).get(FilmViewModel.class);
        mAdapter = new FilmAdapter(mActivity, this);
        observe();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_film, container, false);
        mBinding.svFragmentFilm.setOnQueryTextListener(this);
        mBinding.rvFragmentFilm.setLayoutManager(new LinearLayoutManager(mActivity));
        mBinding.rvFragmentFilm.addItemDecoration(new SpacingLinearItemDecoration(ConvertUtils.dp2px(16)));
        mBinding.rvFragmentFilm.setAdapter(mAdapter);
        return mBinding.getRoot();
    }

    @Override
    public boolean onQueryTextSubmit(String title) {
        mFilmViewModel.searchFilmWith(title);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String title) {
        return false;
    }

    @Override
    public void onFilmSelected(FilmResponseModel filmResponseModel) {
        String json = new Gson().toJson(filmResponseModel);
        FilmFragmentDirections.ToFilmDetailFragment toFilmDetail = FilmFragmentDirections.toFilmDetailFragment(json);
        NavHostFragment.findNavController(this).navigate(toFilmDetail);
    }

    private void observe() {
        /*
        Designed for list response
        however there is no chance to get list from remote
         */
        mFilmViewModel.getFilmObservable().observe(this, filmResponse -> {
            mSearchResultList.clear();
            mSearchResultList.add(filmResponse);
            mAdapter.addAll(mSearchResultList);
        });
        mFilmViewModel.getError().observe(this, errorMessage -> {
            showInformationDialog(errorMessage, null);
        });
        mFilmViewModel.getLoading().observe(this, isLoading -> {
            mBinding.setIsLoading(isLoading);
        });
    }
}