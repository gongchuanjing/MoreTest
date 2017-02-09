package tk.chuanjing.moretest.testokhttp;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.Call;
import tk.chuanjing.cjutils.activity.BaseActivity;
import tk.chuanjing.cjutils.net.OkHttpUtils;
import tk.chuanjing.cjutils.net.callback.GenericsCallback;
import tk.chuanjing.cjutils.net.callback.StringCallback;
import tk.chuanjing.cjutils.smallutils.APPUtils;
import tk.chuanjing.cjutils.toastutils.ToastUtils;
import tk.chuanjing.moretest.Constant;
import tk.chuanjing.moretest.MyApp;
import tk.chuanjing.moretest.R;

public class OkhttpActivity extends BaseActivity {

    private EditText et_username;
    private TextInputLayout til_username;
    private EditText et_pwd;
    private TextInputLayout til_pwd;
    private Button btn_login;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_okhttp;
    }

    @Override
    public void initView() {
        this.til_pwd = (TextInputLayout) findViewById(R.id.til_pwd);
        this.et_pwd = (EditText) findViewById(R.id.et_pwd);
        this.til_username = (TextInputLayout) findViewById(R.id.til_username);
        this.et_username = (EditText) findViewById(R.id.et_username);
        this.btn_login = (Button) findViewById(R.id.btn_login);
    }

    @Override
    public void initListener() {
        til_pwd.setCounterEnabled(true);
        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() > 10) {
                    til_username.setErrorEnabled(true);
                    til_username.setError("用户名超过10位了");
                } else {
                    til_username.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // 按钮
        btn_login.setOnClickListener(this);
    }

    @Override
    public void initData() {}

    @Override
    public void onInnerClick(View v) {
        super.onInnerClick(v);
        switch (v.getId()) {
            case R.id.btn_login:
                submit();
			    break;
        }
    }

    private void submit() {
        String username = et_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String pwd = et_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        doLogin(username, pwd);
    }

    /** Post加头 加参数 */
    private void doLogin(String username, String pwd) {
        String android_id = APPUtils.getDeviceId(MyApp.getInstance());// 获取deviceId
        OkHttpUtils.post()
                .url(Constant.DO_LOGIN)

                .addHeader("live-license", "")
                .addHeader("live-username", username)
                .addHeader("live-version", "1.0")
                .addHeader("live-patch", "9")

                .addParams("user", username)
                .addParams("pass", pwd)
                .addParams("uid", android_id)
                .addParams("ver", "9")
                .addParams("app", "2")// 2代表 Android iTask

                .build()

                /** 直接解析为String */
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        ToastUtils.showMyToast(MyApp.getInstance(), "请求失败--" + id + e.getMessage());
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        ToastUtils.showMyToast(MyApp.getInstance(), "请求成功--" + response);
//                    }
//                });

                /** 解析为UserCallback */
//                .execute(new UserCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        ToastUtils.showMyToast(MyApp.getInstance(), "请求失败--" + id + e.getMessage());
//                    }
//
//                    @Override
//                    public void onResponse(SCInfo response, int id) {
//                        ToastUtils.showMyToast(MyApp.getInstance(), "请求成功--" + response.toString());
//                    }
//                });

                /** 使用泛型解析，不用每个都写一个Callback */
                .execute(new GenericsCallback<SCInfo>(new GenericsSerializatorToGson()) {

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.showMyToast(MyApp.getInstance(), "请求失败--" + id + e.getMessage());
                    }

                    @Override
                    public void onResponse(SCInfo response, int id) {
                        ToastUtils.showMyToast(MyApp.getInstance(), "请求成功--" + response.toString());
                    }
                });
    }
}
