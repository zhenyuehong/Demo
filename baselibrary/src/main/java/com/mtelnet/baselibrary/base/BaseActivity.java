package com.mtelnet.baselibrary.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T mPresenter;

    public abstract T createPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPresenter=createPresenter();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (null!=mPresenter){
            mPresenter.detachView();
        }
        super.onDestroy();
    }
    public Activity getActivity(){
        return this;
    }


}
