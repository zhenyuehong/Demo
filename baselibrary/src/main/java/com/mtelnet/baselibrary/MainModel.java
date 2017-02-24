package com.mtelnet.baselibrary;

import com.mtelnet.baselibrary.net.ApiCallBack;
import com.mtelnet.baselibrary.net.RetrofitManager;
import com.mtelnet.baselibrary.net.bean.BannerList;
import com.mtelnet.baselibrary.net.bean.BaseCallBackListData;

/**
 * Created by hongzhenyue on 17/2/24.
 */

public class MainModel implements MainContract.Model {

    @Override
    public void getBanner(final ApiCallBack<BaseCallBackListData<BannerList>> iCallBack, String lang) {
        ApiCallBack<BaseCallBackListData<BannerList>> result = new ApiCallBack<BaseCallBackListData<BannerList>>() {
            @Override
            public void success(BaseCallBackListData<BannerList> data) {
                iCallBack.success(data);
            }

            @Override
            public void fail(String code, String sys_message, String message) {
                iCallBack.fail(code,sys_message,message);
            }
        };

        RetrofitManager.getInstance().getBanner(result,lang);
    }
}
