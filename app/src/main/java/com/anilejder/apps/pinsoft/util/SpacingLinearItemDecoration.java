package com.anilejder.apps.pinsoft.util;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * User: Anıl Ejder
 * Date: 20/02/2020
 * Time: 15:14
 */
public class SpacingLinearItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;

    public SpacingLinearItemDecoration(int space) {
        mSpace = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        int position = parent.getChildAdapterPosition(view);

        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;

        if (position == 0)
            outRect.top = mSpace;
    }
}
