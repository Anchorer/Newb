package org.anchorer.newb.component.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import org.anchorer.newb.component.pub.Utils;

/**
 * Behavior for FAB: Scroll with the AppBarLayout.
 * Created by Anchorer on 16/4/28.
 */
public class ScrollingFabBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    private int toolbarHeight;

    public ScrollingFabBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        toolbarHeight = Utils.getToolbarHeight(context);
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return (dependency instanceof AppBarLayout);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        if (dependency instanceof AppBarLayout) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = fab.getHeight() + fabBottomMargin;
            float ratio = dependency.getY() / (float) toolbarHeight;
            fab.setTranslationY(-ratio * distanceToScroll);
        }
        return true;
    }
}
