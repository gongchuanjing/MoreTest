package tk.chuanjing.moretest.testokhttp;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tk.chuanjing.cjutils.activity.BaseActivity;
import tk.chuanjing.cjutils.smallutils.APPUtils;
import tk.chuanjing.moretest.Constant;
import tk.chuanjing.moretest.MyApp;
import tk.chuanjing.moretest.R;

public class OkhttpActivity extends BaseActivity {

    private EditText et_username;
    private TextInputLayout til_username;
    private EditText et_pwd;
    private TextInputLayout til_pwd;
    private Button btn_login;
    private TextView tv_content;
    private Button btn_download;

    private final int SUC_CODE = 1001;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUC_CODE:
                    SCInfo sCInfo = (SCInfo) msg.obj;
                    tv_content.setText("请求成功--" + sCInfo.toString());
                    break;
            }
        }
    };

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
        this.tv_content = (TextView) findViewById(R.id.tv_content);
        this.btn_download = (Button) findViewById(R.id.btn_download);
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
        btn_download.setOnClickListener(this);
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

            case R.id.btn_download:
                downloadAPK();
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
//        MyApp.requestService.doLoginToString(username, pwd, android_id);
//        MyApp.requestService.doLoginToUser(username, pwd, android_id, handler, SUC_CODE);
//        MyApp.requestService.doLoginToUserForGenericsCallback(username, pwd, android_id, handler, SUC_CODE);
        MyApp.requestService.doLoginToUserForMyGenericsCallback(username, pwd, android_id, handler, SUC_CODE);
    }

    private void downloadAPK() {
        MyApp.requestService.downloadAPK(Constant.DOWNLOAD_FILE_PATH, "newAPK.apk", this);
    }
}
