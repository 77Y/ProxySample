package com.democome.proxysample;

import okhttp3.Call;
import okhttp3.Callback;


public class StaticUtil {

    /**
     * @param callback
     */
    public static void proxyRequest(Call call, Callback callback) {
        CallbackProxy callbackProxy = new CallbackProxy(callback);
        call.enqueue(callbackProxy);
    }

}
