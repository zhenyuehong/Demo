package com.mtelnet.baselibrary.net;

/**
 * Created by hongzhenyue on 16/9/26.
 */

public interface ApiCallBack<T> {
    void success(T t);
    void fail(String code, String sys_message, String message);
}
