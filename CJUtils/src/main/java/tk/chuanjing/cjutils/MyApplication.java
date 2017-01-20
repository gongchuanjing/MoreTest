package tk.chuanjing.cjutils;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import tk.chuanjing.cjutils.net.OkHttpUtils;
import tk.chuanjing.cjutils.net.log.LoggerInterceptor;

/**
 * @author ChuanJing
 * @date 2016年7月27日 上午10:13:36
 */
public class MyApplication extends Application {

    private static Application instance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        // 将字体文件保存在assets/fonts/目录下
//		TypefaceCollection typeface = new TypefaceCollection.Builder()
//	            .set(Typeface.NORMAL, Typeface.createFromAsset(getAssets(), "fonts/zhiti.ttf"))
//	            .create();
//	    TypefaceHelper.init(typeface);

        initOkHttp();
    }

    /**
     * 获取上下文对象
     * @return
     */
    public static Context getInstance() {
        return instance;
    }

    private void initOkHttp() {
        // 对于Cookie(包含Session)：
        // dependencies中添加：compile 'com.github.franmontiel:PersistentCookieJar:v0.9.3'
        // ClearableCookieJar cookieJar1 = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));
        // CookieJarImpl cookieJar1 = new CookieJarImpl(new MemoryCookieStore());

        // 对于Https：
        // HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        // HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(证书的inputstream, null, null); // 设置具体的证书

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("TAG"))    // 对于Log
                // .cookieJar(cookieJar1)	// 对于Cookie(包含Session)
                // .hostnameVerifier(new HostnameVerifier() {
                //     @Override
                //    public boolean verify(String hostname, SSLSession session) {
                //         return true;
                //     }
                // })
                // .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)	// 对于Https
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}