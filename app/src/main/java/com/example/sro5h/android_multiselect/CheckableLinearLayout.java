package com.example.sro5h.android_multiselect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

/**
 * This class is useful for using inside of a ListView that needs to have checkable items.
 * Adapted from [tokudu](https://gist.github.com/tokudu/410479#file-checkablelinearlayout-java)
 */
public class CheckableLinearLayout extends LinearLayout implements Checkable {
    private CheckBox checkbox;

    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();

        // find checked text view
        for (int i = 0; i < childCount; ++i) {
            View view = getChildAt(i);

            if (view instanceof CheckBox) {
                checkbox = (CheckBox) view;
            }
        }
    }

    @Override
    public boolean isChecked() {
        return checkbox != null ? checkbox.isChecked() : false;
    }

    @Override
    public void setChecked(boolean checked) {
        if (checkbox != null) {
            checkbox.setChecked(checked);
        }
    }

    @Override
    public void toggle() {
        if (checkbox != null) {
            checkbox.toggle();
        }
    }
}
