package com.mtelnet.baselibrary.base;

/**
 * Created by hongzhenyue on 17/2/24.
 */

public abstract class BasePresenter <T extends  BaseView,M extends BaseModel>{

    public T mView;
    public M mModel;

    public BasePresenter(T view, M model) {
        if (null==view){
            throw new NullPointerException("view must not null!");
        }
        this.mView = view;
        this.mModel = model;
    }

    public void detachView(){
        mView=null;
    }
}
