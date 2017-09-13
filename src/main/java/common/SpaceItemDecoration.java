package common;

/**
 * Created by hd on 2017/9/13.
 */

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/9/12 0012.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;
    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view)%2 ==0) {
            outRect.right = mSpace;
//        }else {
//            outRect.left = mSpace;
        }
        outRect.bottom = mSpace;
//        if (parent.getChildAdapterPosition(view) == 0) {
//            outRect.top = mSpace;
//        }
    }
}