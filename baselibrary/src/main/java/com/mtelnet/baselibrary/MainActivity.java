package com.mtelnet.baselibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mtelnet.baselibrary.base.BaseActivity;
import com.mtelnet.baselibrary.net.bean.BannerList;
import com.mtelnet.baselibrary.net.bean.BaseCallBackListData;

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

    public void getValue(View view) {
        mPresenter.getValue("en");
    }

    @Override
    public void setBannerValue(BaseCallBackListData<BannerList> value) {
        mTvValue.setText("Banner link: "+value.data.get(0).image);
    }
}
