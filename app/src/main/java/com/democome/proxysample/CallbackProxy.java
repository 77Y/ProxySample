package com.democome.proxysample;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CallbackProxy implements Callback {

    public static final String TAG = CallbackProxy.class.getSimpleName();

    private Callback realCallback;

    public CallbackProxy(Callback realCallback) {
        this.realCallback = realCallback;
    }

    @Override
    public void onFailure(Call call, IOException e) {

        Log.d(TAG, "请求失败先搞点事情" + e.toString());

        realCallback.onFailure(call, e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

        Log.d(TAG, "请求成功先搞点事情" + response.toString());

        realCallback.onResponse(call, response);
    }
}
