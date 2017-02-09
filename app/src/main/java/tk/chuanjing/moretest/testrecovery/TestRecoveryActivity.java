package tk.chuanjing.moretest.testrecovery;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import tk.chuanjing.moretest.BaseActivityMoreTest;
import tk.chuanjing.moretest.R;

public class TestRecoveryActivity extends BaseActivityMoreTest {

    private Button btn_make_crash;
    private Button btn_to_testRecoveryActivity2;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_test_recovery;
    }

    @Override
    public void initView() {
        btn_make_crash = (Button) findViewById(R.id.btn_make_crash);
        btn_to_testRecoveryActivity2 = (Button) findViewById(R.id.btn_to_testRecoveryActivity2);
    }

    @Override
    public void initListener() {
        btn_make_crash.setOnClickListener(this);
        btn_to_testRecoveryActivity2.setOnClickListener(this);
    }

    @Override
    public void initData() {}

    @Override
    public void onInnerClick(View v) {
        super.onInnerClick(v);
        switch (v.getId()) {
            case R.id.btn_make_crash :
                Activity activity = null;
                activity.finish();
                break;

            case R.id.btn_to_testRecoveryActivity2 :
//                Intent intent = new Intent(MainActivity.this, TestActivity.class);
//                startActivity(intent);
                break;
        }
    }
}
