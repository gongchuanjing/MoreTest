package tk.chuanjing.moretest.testokhttp;

import android.os.Handler;
import android.os.Message;

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
 * 如果请求失败就直接在这里提示，适用于有正规的数据返回结构，如：
 * {
        "message": "OK", // 消息提示
        "retcode": 200,  // 提示编码
        "data": [
            { }
        ]
    }
 */

public class CallbackToBean<T> extends Callback<T> {

    private Handler handler;
    private int sucCode;

    public CallbackToBean(Handler handler, int sucCode) {
        this.handler = handler;
        this.sucCode = sucCode;
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();

//        if (TextUtils.isEmpty(string) || "[]".equals(string)||"{}".equals(string)) {
//            ToastUtils.showMyToast(MyApp.getInstance(), "服务器返回数据为空");
//            return null;
//        }

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
        msg.what = sucCode;
        msg.obj = response;
        handler.handleMessage(msg);
    }
}