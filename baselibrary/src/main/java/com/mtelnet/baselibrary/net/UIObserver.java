package com.mtelnet.baselibrary.net;


import android.util.Log;

import com.mtelnet.baselibrary.net.bean.BaseCallBackData;
import com.mtelnet.baselibrary.net.bean.BaseCallBackListData;
import com.mtelnet.baselibrary.net.bean.BaseResult;

import rx.Observer;

/**
 * Created by lvbo on 16/7/21.
 */
public class UIObserver<T> implements Observer<T> {
    ApiCallBack<T> result;
    public UIObserver(ApiCallBack<T> result) {
        this.result=result;
    }

    @Override
    public void onCompleted() {
        Log.e(" http onCompleted","onCompleted");
    }

    @Override
    public void onError(Throwable e) {
//        Log.e("Http Observer error",e.getMessage());
        result.fail("Http Observer error", e.getMessage(), "Http Observer error");

    }

    @Override
    public void onNext(T t) {

        if (t instanceof BaseCallBackData) {
            BaseResult status=((BaseCallBackData) t).result;
            if (null != status && status.code.equals("1000")) {

                result.success(t);
            } else {
                result.fail(status.code,status.sys_message, status.message);
            }
        }else if (t instanceof BaseCallBackListData){
            BaseResult status=((BaseCallBackListData) t).result;
            if (null != status && status.code.equals("1000")) {

                result.success(t);
            } else {
                result.fail(status.code,status.sys_message, status.message);
            }
        }else {
            result.fail("error", "error", "error");
        }

    }
}
