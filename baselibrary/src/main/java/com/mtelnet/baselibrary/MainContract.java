package com.mtelnet.baselibrary;

import com.mtelnet.baselibrary.base.BaseModel;
import com.mtelnet.baselibrary.base.BasePresenter;
import com.mtelnet.baselibrary.base.BaseView;
import com.mtelnet.baselibrary.net.ApiCallBack;
import com.mtelnet.baselibrary.net.bean.BannerList;
import com.mtelnet.baselibrary.net.bean.BaseCallBackListData;

/**
 * Created by hongzhenyue on 17/2/24.
 * 契约类
 */

public interface MainContract {
        interface Model extends BaseModel{
//            void getBanner(ICallBack iCallBack, Context context);
            void getBanner(ApiCallBack<BaseCallBackListData<BannerList>> iCallBack, String lang);
        }

        interface View extends BaseView{
            void setBannerValue(BaseCallBackListData<BannerList> value);

        }

    abstract class Presenter extends BasePresenter<View,Model>{

        public Presenter(View view, Model model) {
            super(view, model);
        }

        public abstract void getValue(String lang);
    }

}
