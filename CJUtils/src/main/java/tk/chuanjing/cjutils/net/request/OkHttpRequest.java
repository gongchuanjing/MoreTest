package tk.chuanjing.cjutils.net.request;

import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import tk.chuanjing.cjutils.net.callback.Callback;
import tk.chuanjing.cjutils.net.utils.Exceptions;

/**
 * Created by zhy on 15/11/6.
 * 一个request的构建呢，我分三个步骤：buildRequestBody , wrapRequestBody ,buildRequest这样的次序，
 * 当以上三个方法没有问题时，我们就拿到了request，然后执行即可。但是对于不同的请求，requestBody以及
 * request的构建过程是不同的，所以大家可以看到buildRequestBody ,buildRequest为抽象的方法，也就是不同
 * 的请求类，比如OkHttpGetRequest、OkHttpPostRequest等需要自己去构建自己的request。对于wrapRequestBody
 * 方法呢，可以看到它默认基本属于空实现，主要是因为并非所有的请求类都需要复写它，只有上传的时候呢，需要回
 * 调进度，需要对requestBody进行包装，所以这个方法类似于一个钩子。其实这个过程有点类似模板方法模式
 */
public abstract class OkHttpRequest {
    protected String url;
    protected Object tag;
    protected Map<String, String> params;
    protected Map<String, String> headers;
    protected int id;

    protected Request.Builder builder = new Request.Builder();

    protected OkHttpRequest(String url, Object tag,
                            Map<String, String> params, Map<String, String> headers, int id) {
        this.url = url;
        this.tag = tag;
        this.params = params;
        this.headers = headers;
        this.id = id;

        if (url == null) {
            Exceptions.illegalArgument("url can not be null.");
        }

        initBuilder();
    }


    /**
     * 初始化一些基本参数 url , tag , headers
     */
    private void initBuilder() {
        builder.url(url).tag(tag);
        appendHeaders();
    }

    protected abstract RequestBody buildRequestBody();

    protected RequestBody wrapRequestBody(RequestBody requestBody, final Callback callback) {
        return requestBody;
    }

    protected abstract Request buildRequest(RequestBody requestBody);

    public RequestCall build() {
        return new RequestCall(this);
    }


    public Request generateRequest(Callback callback) {
        RequestBody requestBody = buildRequestBody();
        RequestBody wrappedRequestBody = wrapRequestBody(requestBody, callback);
        Request request = buildRequest(wrappedRequestBody);
        return request;
    }


    protected void appendHeaders() {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) return;

        for (String key : headers.keySet()) {
            headerBuilder.add(key, headers.get(key));
        }
        builder.headers(headerBuilder.build());
    }

    public int getId() {
        return id;
    }

}
