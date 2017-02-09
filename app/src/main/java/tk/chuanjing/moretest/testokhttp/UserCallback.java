package tk.chuanjing.moretest.testokhttp;

import com.google.gson.Gson;

import okhttp3.Response;
import tk.chuanjing.cjutils.net.callback.Callback;

/**
 * Created by ChuanJing on 2017/2/9.
 */

public abstract class UserCallback extends Callback<SCInfo> {
    @Override
    public SCInfo parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();
        SCInfo sCInfo = new Gson().fromJson(string, SCInfo.class);
        return sCInfo;
    }
}
