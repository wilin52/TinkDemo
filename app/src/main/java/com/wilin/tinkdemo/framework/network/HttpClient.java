package com.wilin.tinkdemo.framework.network;

import android.os.Bundle;
import android.os.Message;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Lin WenLong on 2018/6/2.
 * <p>
 * http.
 */
public class HttpClient {

    private OkHttpClient client;
    private Request request;

    private void setClient(OkHttpClient client) {
        this.client = client;
    }

    private void setRequest(Request request) {
        this.request = request;
    }

    /**
     * @param httpUIHandler the callback
     */
    void execute(HttpUIHandler httpUIHandler) {
        try {
            Response response = client.newCall(request).execute();
            int code = response.code();
            Message message = Message.obtain();
            if (code == 200) {
                message.what = HttpUIHandler.SUCCESS;
                ResponseBody body = response.body();
                if (body != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("result", body.string());
                    message.setData(bundle);
                }

                httpUIHandler.sendMessage(message);
            } else {
                message.what = HttpUIHandler.FAILURE;
                Bundle bundle = new Bundle();
                // customized
                message.setData(bundle);
                httpUIHandler.sendMessage(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param httpHandler the callback.
     */
    void execute(HttpHandler httpHandler) {
        try {
            Response response = client.newCall(request).execute();
            int code = response.code();
            if (code == 200) {
                if (null != httpHandler) {
                    // customize the success according the request;
                    httpHandler.onSuccess();
                }
            } else {
                if (null != httpHandler) {
                    if (response.isRedirect()) {
                        // 重定向...

                    } else {
                        httpHandler.onFailure(code, response.message());
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 建造类
     */
    public static class Builder {
        /**
         * 请求类型
         */
        public static final String GET = "get";
        public static final String POST = "post";
        public static final String PUT = "put";
        /**
         * 请求数据格式
         */
        public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

        /**
         * 路径
         */
        private String url;

        private String method = GET;
        private MediaType mediaType = MEDIA_TYPE_JSON;
        private String params = "";

        public Builder() {

        }

        public Builder requestUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder setMediaType(MediaType type) {
            this.mediaType = type;
            return this;
        }

        public Builder setParams(String params) {
            this.params = params;
            return this;
        }

        public HttpClient build() throws HttpTypeIllegalException {
            HttpClient httpClient = new HttpClient();
            OkHttpClient client = new OkHttpClient();

            Request request = null;
            Request.Builder build = new Request.Builder()
                    .url(url);

            switch (method) {
                case GET: {
                    request = build.build();
                }
                break;
                case POST: {
                    RequestBody body = RequestBody.create(mediaType, params);
                    request = build.post(body).build();
                }
                break;
                case PUT: {

                }
                break;
                default:
                    throw new HttpTypeIllegalException("the method ".concat(method).concat(" not supported."));
            }
            httpClient.setRequest(request);
            httpClient.setClient(client);
            return httpClient;
        }
    }
}
