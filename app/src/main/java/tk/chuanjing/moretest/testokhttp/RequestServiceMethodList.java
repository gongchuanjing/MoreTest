package tk.chuanjing.moretest.testokhttp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;

import java.io.File;

import okhttp3.Call;
import okhttp3.Request;
import tk.chuanjing.cjutils.net.OkHttpUtils;
import tk.chuanjing.cjutils.net.callback.FileCallBack;
import tk.chuanjing.cjutils.net.callback.GenericsCallback;
import tk.chuanjing.cjutils.net.callback.StringCallback;
import tk.chuanjing.cjutils.toastutils.ToastUtils;
import tk.chuanjing.moretest.Constant;
import tk.chuanjing.moretest.MyApp;

/**
 * Created by ChuanJing on 2017/2/10.
 */

public class RequestServiceMethodList {

    /** 直接解析为String */
    public void doLoginToString(String username, String pwd, String uid) {
        OkHttpUtils.post()
                .url(Constant.DO_LOGIN)
                .addHeader("live-license", "")//经销商代码
                .addHeader("live-username", username)
                .addHeader("live-version", "1.0")//（大版本号，e.g. 0.9/1.0）
                .addHeader("live-patch", "9")//(小补丁号，e.g. 1/2/3…)
                .addParams("user", username)
                .addParams("pass", pwd)
                .addParams("uid", uid)
                .addParams("ver", "9")
                .addParams("app", "2")// 2代表 Android iTask
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.showMyToast(MyApp.getInstance(), "请求失败--" + id + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtils.showMyToast(MyApp.getInstance(), "请求成功--" + response);
                    }
                });
    }

    /** 解析为UserCallback */
    public void doLoginToUser(String username, String pwd, String uid, final Handler handler, final int sucCode) {
        OkHttpUtils.post()
                .url(Constant.DO_LOGIN)
                .addHeader("live-license", "")//经销商代码
                .addHeader("live-username", username)
                .addHeader("live-version", "1.0")//（大版本号，e.g. 0.9/1.0）
                .addHeader("live-patch", "9")//(小补丁号，e.g. 1/2/3…)
                .addParams("user", username)
                .addParams("pass", pwd)
                .addParams("uid", uid)
                .addParams("ver", "9")
                .addParams("app", "2")// 2代表 Android iTask
                .build()
                .execute(new UserCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.showMyToast(MyApp.getInstance(), "请求失败--" + id + e.getMessage());
                    }

                    @Override
                    public void onResponse(SCInfo response, int id) {
                        // ToastUtils.showMyToast(MyApp.getInstance(), "请求成功--" + response.toString());
                        Message msg = handler.obtainMessage();
                        msg.what = sucCode;
                        msg.obj = response;
                        handler.handleMessage(msg);
                    }
                });
    }

    /** 使用泛型解析，不用每个都写一个Callback */
    public void doLoginToUserForGenericsCallback(String username, String pwd, String uid, final Handler handler, final int sucCode) {
        OkHttpUtils.post()
                .url(Constant.DO_LOGIN)
                .addHeader("live-license", "")//经销商代码
                .addHeader("live-username", username)
                .addHeader("live-version", "1.0")//（大版本号，e.g. 0.9/1.0）
                .addHeader("live-patch", "9")//(小补丁号，e.g. 1/2/3…)
                .addParams("user", username)
                .addParams("pass", pwd)
                .addParams("uid", uid)
                .addParams("ver", "9")
                .addParams("app", "2")// 2代表 Android iTask
                .build()
                .execute(new GenericsCallback<SCInfo>(new GenericsSerializatorToGson()) {

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.showMyToast(MyApp.getInstance(), "请求失败--" + id + e.getMessage());
                        e.printStackTrace();
                    }

                    //UI线程
                    @Override
                    public void onResponse(SCInfo response, int id) {
                        // ToastUtils.showMyToast(MyApp.getInstance(), "请求成功--" + response.toString());
                        Message msg = handler.obtainMessage();
                        msg.what = sucCode;
                        msg.obj = response;
                        handler.handleMessage(msg);
                    }
                });
    }

    /** 使用自己封装的泛型解析，不用每个都写一个Callback */
    public void doLoginToUserForMyGenericsCallback(String username, String pwd, String uid, final Handler handler, final int sucCode) {
        OkHttpUtils.post()
                .url(Constant.DO_LOGIN)
                .addHeader("live-license", "")//经销商代码
                .addHeader("live-username", username)
                .addHeader("live-version", "1.0")//（大版本号，e.g. 0.9/1.0）
                .addHeader("live-patch", "9")//(小补丁号，e.g. 1/2/3…)
                .addParams("user", username)
                .addParams("pass", pwd)
                .addParams("uid", uid)
                .addParams("ver", "9")
                .addParams("app", "2")// 2代表 Android iTask
                .build()
                .execute(new GenericsCallbackToBean<SCInfo>(handler, sucCode){});
    }

    public void downloadAPK(String destFileDir, String destFileName, final Activity mActivity) {
        final ProgressDialog progressDown = new ProgressDialog(mActivity);//APP级别的Context不行
        progressDown.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDown.setTitle("正在下载……");
        OkHttpUtils.get()
                .url(Constant.NET_APK)
                .build()
                .execute(new FileCallBack(destFileDir, destFileName) {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                        progressDown.show();
                    }

                    @Override
                    public void onAfter(int id) {
                        super.onAfter(id);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        progressDown.dismiss();
                        ToastUtils.showMyToast(MyApp.getInstance(), "onError-->" + id + "\r\n" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File response, int id) {
                        progressDown.dismiss();

                        // 安装下载的apk
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        Uri fileUri = Uri.fromFile(response);
                        intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
                        mActivity.startActivity(intent);
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        progressDown.setProgress((int) (100 * progress));
                    }
                });
    }
}
