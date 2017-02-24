package com.mtelnet.baselibrary;

import com.mtelnet.baselibrary.net.ApiCallBack;
import com.mtelnet.baselibrary.net.bean.BannerList;
import com.mtelnet.baselibrary.net.bean.BaseCallBackListData;

/**
 * Created by hongzhenyue on 17/2/24.
 * 该层持有V和M的对象。
 * getValue方法会调用M的方法并返回数据，成功后调用V层的方法把数据现象出来，这样我们Presenter就完成了M、V的交互。
 */

public class MainPresenter extends MainContract.Presenter {
    public MainPresenter(MainContract.View view) {
        super(view, new MainModel());
    }

    @Override
    public void getValue(String lang) {

        mModel.getBanner(new ApiCallBack<BaseCallBackListData<BannerList>>() {
            @Override
            public void success(BaseCallBackListData<BannerList> data) {
                mView.setBannerValue(data);
            }

            @Override
            public void fail(String code, String sys_message, String message) {

            }
        },lang);


    }
}
