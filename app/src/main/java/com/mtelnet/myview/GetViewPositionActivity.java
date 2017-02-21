package com.mtelnet.myview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

public class GetViewPositionActivity extends AppCompatActivity {
    private Button btn_target;

    private static int screen_height;
    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_view_position);
        btn_target = (Button) findViewById(R.id.btn_target);
        scrollView = (ScrollView) findViewById(R.id.scroll_to);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        screen_height = wm.getDefaultDisplay().getHeight();

        btn_target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(GetViewPositionActivity.this);
                dialog.setMessage("宽：" + btn_target.getWidth() + "\n" + "高：" + btn_target.getHeight());
                dialog.show();
            }
        });


        findViewById(R.id.btn_scroll_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollToWeight(scrollView,btn_target);
            }
        });
    }


    public static void scrollToWeight(final ScrollView scroll, final View inner) {
        //scroll是指定的滚动ScrollView，inner是要滚动的控件
        Handler mHandler = new Handler();
        mHandler.post(new Runnable() {
            public void run() {
                if (scroll == null || inner == null) {
                    return;
                }

                View Parent = (View) inner.getParent();
                int offset = inner.getTop() + Parent.getTop() - screen_height / 2;

                if (offset < 0) {
                    offset = 0;
                }

                scroll.scrollTo(0, offset);
            }
        });
    }
}
