package com.wilin.tinkdemo.framework.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by Lin WenLong on 2018/6/2.
 * deal with repsonse in ui.
 */
public abstract class HttpUIHandler extends Handler implements HttpResult{

    static final int SUCCESS = 0;
    static final int FAILURE = 1;
    static final int EXCEPTION = 2;

    public HttpUIHandler(){
        super(Looper.getMainLooper());
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case SUCCESS:{
                // customize
                onSuccess();
            }
            case FAILURE:{
                int code = msg.arg1;
                String message = msg.getData().getString("ErrorMessage");
                onFailure(code,message);
            }
            case EXCEPTION:{
                onException();
            }
        }
    }


}
