package com.mtelnet.myview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mtelnet.flipviewlibrary.flip.FlipViewController;

public class FlipperActivity extends AppCompatActivity {
    protected FlipViewController flipView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_flipper);


        flipView = new FlipViewController(this,FlipViewController.HORIZONTAL);//设置左右翻页
        flipView = new FlipViewController(this);//默认上下翻页

        flipView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view;
                if (convertView == null) {
                    final Context context = parent.getContext();
                    view = new TextView(context);
                    view.setTextSize(26);
                } else {
                    view = (TextView) convertView;
//                    view.setText(position);
                }

                return view;
            }
        });

        setContentView(flipView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        flipView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        flipView.onPause();
    }
}
