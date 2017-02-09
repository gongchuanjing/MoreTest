package tk.chuanjing.moretest.testokhttp;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

import okhttp3.Call;
import okhttp3.Response;
import tk.chuanjing.cjutils.net.callback.Callback;

/**
 * Created by ChuanJing on 2017/2/9.
 * 希望在请求的execute中传入这个类，成功直接就能返回解析后的对象，如果请求失败就直接在这里提示
 */

public class GenericsCallbackToBean<T> extends Callback<T> {

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }

        T bean = new Gson().fromJson(string, entityClass);
        return bean;
    }

    @Override
    public void onError(Call call, Exception e, int id) {

    }

    @Override
    public void onResponse(T response, int id) {

    }
}