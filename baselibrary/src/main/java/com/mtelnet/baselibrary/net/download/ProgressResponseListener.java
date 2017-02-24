package com.mtelnet.baselibrary.net.download;

/**
 * 请求体进度回调接口，用于文件上传进度回调
 */
public interface ProgressResponseListener {
    void onResponseProgress(long bytesRead, long contentLength, boolean done);

}
