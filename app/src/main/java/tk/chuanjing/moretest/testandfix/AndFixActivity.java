package tk.chuanjing.moretest.testandfix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import tk.chuanjing.cjutils.toastutils.ToastUtils;
import tk.chuanjing.moretest.Constant;
import tk.chuanjing.moretest.MyApp;
import tk.chuanjing.moretest.R;

public class AndFixActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_bug;
    private Button btn_download;
    private Button btn_hotfix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andfix);

        initView();
        initListener();
    }

    public void initView() {
        this.tv_bug = (TextView) findViewById(R.id.tv_bug);
        this.btn_download = (Button) findViewById(R.id.btn_download);
        this.btn_hotfix = (Button) findViewById(R.id.btn_hotfix);
        tv_bug.setText("修复好了");
    }

    public void initListener() {
        // 按钮
        btn_download.setOnClickListener(this);
        btn_hotfix.setOnClickListener(this);
        tv_bug.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_download:
                downloadApatch();
                break;

            case R.id.btn_hotfix:
                update();
                break;

            case R.id.tv_bug:
                ToastUtils.showMyToast(MyApp.getInstance(), "修复……搞定了");
                break;
        }
    }

    /** 从服务器下载补丁 */
    private void downloadApatch() {
        // 模拟下载
        ToastUtils.showMyToast(MyApp.getInstance(), "下载完成！");
    }

    /** 修复 */
    private void update() {
        String patchFileStr = Constant.APATCH_PATH + "/fix5.apatch";
        try {
            MyApp.mPatchManager.addPatch(patchFileStr);
            ToastUtils.showMyToast(MyApp.getInstance(), "修复完成！");
        } catch (IOException e) {
            e.printStackTrace();
            ToastUtils.showMyToast(MyApp.getInstance(), "修复失败…………！");
        }
    }
}
