package com.mtelnet.baselibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mtelnet.baselibrary.base.BaseActivity;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {
    private TextView mTvValue;

    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvValue = (TextView) findViewById(R.id.tv_mvp_value);
    }

    @Override
    public void setValue(final String value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvValue.setText(value);
            }
        });
    }

    public void getValue(View view) {
        mPresenter.getValue();
    }
}
