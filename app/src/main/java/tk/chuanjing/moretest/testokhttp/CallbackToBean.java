package tk.chuanjing.moretest.testokhttp;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import java.lang.reflect.ParameterizedType;

import okhttp3.Call;
import okhttp3.Response;
import tk.chuanjing.cjutils.net.callback.Callback;
import tk.chuanjing.cjutils.net.callback.IGenericsSerializator;
import tk.chuanjing.cjutils.toastutils.ToastUtils;
import tk.chuanjing.moretest.MyApp;

/**
 * Created by ChuanJing on 2017/2/9.
 * 希望在请求的execute中传入这个类，成功直接就能返回解析后的对象，
 * 如果请求失败，能在这里处理掉就直接在这里处理
 */

public class CallbackToBean<T> extends Callback<T> {

    private Handler handler;
    private int successCode;
    private int noDataCode;

    public CallbackToBean(Handler handler, int successCode) {
        this.handler = handler;
        this.successCode = successCode;
    }

    public CallbackToBean(Handler handler, int successCode, int noDataCode) {
        this.handler = handler;
        this.successCode = successCode;
        this.noDataCode = noDataCode;
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();

        // 如果请求回来没有数据，直接在这里提示，也可在外面处理，接收handler的noDataCode即可处理
        if (TextUtils.isEmpty(string) || "[]".equals(string)||"{}".equals(string)) {
            ToastUtils.showMyToast(MyApp.getInstance(), "服务器返回数据为空");
            if (noDataCode != 0) {
                Message msg = handler.obtainMessage();
                msg.what = noDataCode;
                handler.handleMessage(msg);
            }
            return null;
        }

        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }

        IGenericsSerializator mGenericsSerializator = new GenericsSerializatorToGson();
        T bean = mGenericsSerializator.transform(string, entityClass);
        return bean;
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        ToastUtils.showMyToast(MyApp.getInstance(), "onError-->" + id + "\r\n" + e.getMessage());
    }

    @Override
    public void onResponse(T response, int id) {
        Message msg = handler.obtainMessage();
        msg.what = successCode;
        msg.obj = response;
        handler.handleMessage(msg);
    }
}