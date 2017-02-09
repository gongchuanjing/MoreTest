package tk.chuanjing.moretest;

import android.os.Bundle;

import tk.chuanjing.cjutils.activity.BaseActivity;

/**
 * Created by ChuanJing on 2017/2/9.
 */

public abstract class BaseActivityMoreTest extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        getWindow().getDecorView().post(new Runnable() {
//            @Override
//            public void run() {
//                int count = ActivityStackCompat.getActivityCount(Recovery.getInstance().getContext());
//                Log.e("zxyRecovery", "realCount: " + count);
//                String baseActivityMoreTest = ActivityStackCompat.getBaseActivityName(Recovery.getInstance().getContext());
//                Log.e("zxyRecovery", "realBaseActivityName: " + baseActivityMoreTest);
//            }
//        });

//    }
}
