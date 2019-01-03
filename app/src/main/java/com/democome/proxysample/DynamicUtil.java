package com.democome.proxysample;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import okhttp3.Call;
import okhttp3.Callback;


public class DynamicUtil {

    public static final String TAG = DynamicUtil.class.getSimpleName();

    public static class ResponseHandler implements InvocationHandler {

        private Object obj;

        public ResponseHandler(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {

            Log.d(TAG, "要请求了 搞事搞事搞事" + method.toString());

            Object result = method.invoke(obj, args);

            return result;
        }
    }

    /**
     * @param call
     * @param callback
     */
    public static void proxyRequest(Call call, Callback callback) {

        ResponseHandler handler = new ResponseHandler(callback);
        Callback proxy = (Callback) Proxy.newProxyInstance(callback.getClass().getClassLoader(), callback.getClass().getInterfaces(), handler);
        call.enqueue(proxy);
    }

}
