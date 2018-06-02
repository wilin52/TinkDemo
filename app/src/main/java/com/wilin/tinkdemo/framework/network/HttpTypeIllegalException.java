package com.wilin.tinkdemo.framework.network;

/**
 * Created by Lin WenLong on 2018/6/2.
 */

public class HttpTypeIllegalException extends java.io.InterruptedIOException {

    /**
     * Constructs a new HttpTypeIllegalException with a detail
     * message.
     * @param msg the detail message
     */
    public HttpTypeIllegalException(String msg) {
        super(msg);
    }

    /**
     * Construct a new HttpTypeIllegalException with no detailed message.
     */
    public HttpTypeIllegalException() {}

}
