package tk.chuanjing.moretest.testokhttp;

import com.google.gson.Gson;

import tk.chuanjing.cjutils.net.callback.IGenericsSerializator;

/**
 * Created by ChuanJing on 2017/2/9.
 * 自己实现一个用Gson解析的方法
 */

public class GenericsSerializatorToGson implements IGenericsSerializator {
    @Override
    public <T> T transform(String response, Class<T> classOfT) {
        T bean = new Gson().fromJson(response, classOfT);
        return bean;
    }
}
