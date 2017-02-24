package com.mtelnet.baselibrary;

import android.content.Context;

import com.mtelnet.baselibrary.base.BaseModel;
import com.mtelnet.baselibrary.base.BasePresenter;
import com.mtelnet.baselibrary.base.BaseView;

/**
 * Created by hongzhenyue on 17/2/24.
 * 契约类
 */

public interface MainContract {
        interface Model extends BaseModel{
            void getValue(ICallBack iCallBack, Context context);
        }

        interface View extends BaseView{
            void setValue(String value);
        }

    abstract class Presenter extends BasePresenter<View,Model>{

        public Presenter(View view, Model model) {
            super(view, model);
        }

        public abstract void getValue();
    }

}
