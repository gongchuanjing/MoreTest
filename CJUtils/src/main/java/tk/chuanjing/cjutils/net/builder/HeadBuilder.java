package tk.chuanjing.cjutils.net.builder;

import tk.chuanjing.cjutils.net.OkHttpUtils;
import tk.chuanjing.cjutils.net.request.OtherRequest;
import tk.chuanjing.cjutils.net.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers, id).build();
    }
}
