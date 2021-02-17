package com.anilejder.apps.pinsoft;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 20:38
 */
public class BaseFragment extends Fragment {

    private MainActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    public void showInformationDialog(String message, DialogInterface.OnClickListener clickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setMessage(message).setNeutralButton(android.R.string.ok, clickListener);
        builder.create().show();
    }

    public void showInformationDialog(int messageResId, DialogInterface.OnClickListener clickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setMessage(getString(messageResId)).setNeutralButton(android.R.string.ok, clickListener);
        builder.create().show();
    }

    public void showLoading() {

    }

    public void hideLoading() {

    }
}