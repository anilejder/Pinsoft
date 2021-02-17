package com.anilejder.apps.pinsoft.screen.film;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.anilejder.apps.pinsoft.R;
import com.anilejder.apps.pinsoft.databinding.FilmListItemBinding;
import com.anilejder.apps.pinsoft.model.response.FilmResponseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 22:41
 */
class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private Activity mActivity;
    private static List<FilmResponseModel> mSearchResult;
    private static FilmAdapterListener mFilmAdapterListener;

    interface FilmAdapterListener {
        void onFilmSelected(FilmResponseModel filmResponseModel);
    }

    FilmAdapter(Activity activity, FilmAdapterListener filmAdapterListener) {
        mActivity = activity;
        mFilmAdapterListener = filmAdapterListener;
        mSearchResult = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FilmListItemBinding binding = DataBindingUtil.inflate(mActivity.getLayoutInflater(), R.layout.film_list_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mSearchResult.get(position));
    }

    @Override
    public int getItemCount() {
        return mSearchResult.size();
    }

    public void addAll(List<FilmResponseModel> searchResult) {
        mSearchResult.clear();
        mSearchResult.addAll(searchResult);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final FilmListItemBinding mBinding;

        public ViewHolder(FilmListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            binding.getRoot().setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            if (view == mBinding.getRoot()) {
                FilmResponseModel selectedFilm = mBinding.getFilm();
                mFilmAdapterListener.onFilmSelected(selectedFilm);
            }
        }

        public void bind(FilmResponseModel filmResponseModel) {
            mBinding.setFilm(filmResponseModel);
        }
    }
}