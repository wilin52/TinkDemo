package com.wilin.tinkdemo.framework.network;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lin WenLong on 2018/6/2.
 * Manager http request.
 */
public class HttpManager {

    private ExecutorService httpService;

    private static class Holder{
        private static final HttpManager instance = new HttpManager();
    }

    public static HttpManager getInstance() {
        return Holder.instance;
    }

    private HttpManager(){
        /**
         * use ThreadPool , set the maximum num of thread and alive time ,
         * and change
         */
        httpService = new ThreadPoolExecutor(0, 50,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
    }

    /**
     * 回调不在Ui线程
     */
    public void execute(final HttpClient client,final HttpHandler httpHandler){
        httpService.execute(new Runnable() {
            @Override
            public void run() {
                client.execute(httpHandler);
            }
        });
    }

    /**
     * 回调在Ui线程
     */
    public void execute(final HttpClient client,final HttpUIHandler httpHandler){
        httpService.execute(new Runnable() {
            @Override
            public void run() {
                client.execute(httpHandler);
            }
        });
    }
}
