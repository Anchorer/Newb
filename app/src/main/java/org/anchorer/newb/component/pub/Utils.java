package org.anchorer.newb.component.pub;

import android.content.Context;
import android.util.TypedValue;

/**
 * Utils.
 * Created by Anchorer on 16/4/28.
 */
public class Utils {

    /**
     * Get Toolbar Height
     * @param context
     * @return
     */
    public static int getToolbarHeight(Context context) {
        int toolbarHeight = 0;
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.support.design.R.attr.actionBarSize, tv, true)) {
            toolbarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        return toolbarHeight;
    }
}
