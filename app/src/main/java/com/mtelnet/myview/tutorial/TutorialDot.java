package com.mtelnet.myview.tutorial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.mtelnet.myview.R;

//指示点
public class TutorialDot extends LinearLayout {
    View enabled;
    View disabled;

    public TutorialDot(Context context) {
        super(context);
        init(context);
    }

    public TutorialDot(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TutorialDot(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context ctx) {
       View view= LayoutInflater.from(ctx).inflate(R.layout.tutorial_dot_layout, this, true);
        enabled=view.findViewById(R.id.enabled);
        disabled=view.findViewById(R.id.disabled);
    }

    public void enable() {
        enabled.setVisibility(View.VISIBLE);
        disabled.setVisibility(View.GONE);
    }


    public void disable() {
        enabled.setVisibility(View.GONE);
        disabled.setVisibility(View.VISIBLE);
    }
}
