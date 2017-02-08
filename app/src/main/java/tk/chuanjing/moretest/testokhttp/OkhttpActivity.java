package tk.chuanjing.moretest.testokhttp;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import tk.chuanjing.moretest.R;

public class OkhttpActivity extends AppCompatActivity {

    private EditText et_username;
    private TextInputLayout til_username;
    private EditText et_pwd;
    private TextInputLayout til_pwd;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        this.til_pwd = (TextInputLayout) findViewById(R.id.til_pwd);
        this.et_pwd = (EditText) findViewById(R.id.et_pwd);
        this.til_username = (TextInputLayout) findViewById(R.id.til_username);
        this.et_username = (EditText) findViewById(R.id.et_username);
        this.btn_login = (Button) findViewById(R.id.btn_login);

        til_pwd.setCounterEnabled(true);
        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

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
            public void afterTextChanged(Editable editable) {

            }
        });

        // 按钮
//        btn_login.setOnClickListener();
    }
}
