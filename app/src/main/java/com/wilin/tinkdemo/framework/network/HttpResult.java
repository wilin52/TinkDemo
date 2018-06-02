package com.wilin.tinkdemo.framework.network;

import java.util.Objects;

/**
 * Created by Lin WenLong on 2018/6/2.
 *
 * http callback.
 */
interface HttpResult {

    void onFailure(int errCode, String msg);
    void onSuccess(Objects... object);
    void onException();
}
