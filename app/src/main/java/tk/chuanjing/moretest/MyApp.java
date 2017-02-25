package tk.chuanjing.moretest;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;

import tk.chuanjing.cjutils.MyApplication;
import tk.chuanjing.cjutils.smallutils.APPUtils;
import tk.chuanjing.moretest.testokhttp.RequestServiceMethodList;

/**
 * Created by ChuanJing on 2017/2/6.
 */

public class MyApp extends MyApplication {

    /** 所有请求网络的方法都在这个类里面 */
    public static RequestServiceMethodList requestService;

    /** 阿里AndFix的PatchManager */
    public static PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();

        if (requestService == null) {
            requestService = new RequestServiceMethodList();
        }

        // initRecovery();
        
        initPatchManager();
    }

    /** 初始化阿里AndFix的PatchManager */
    private void initPatchManager() {
        // 初始化patch管理类
        mPatchManager = new PatchManager(this);

        // 初始化patch版本
        //String appVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        //mPatchManager.init(appVersion);
        mPatchManager.init(APPUtils.getVersionName(getInstance()));
        //mPatchManager.init("1.0");

        // 加载已经添加到PatchManager中的patch
        mPatchManager.loadPatch();

        // 初始化放置补丁的文件夹，只是测试时使用
        File dir = new File(Constant.APATCH_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * 初始化Recovery
     */
//    private void initRecovery() {
//        Recovery.getInstance()
//                .debug(true)
//                .recoverInBackground(false)
//                .recoverStack(true)
//                .mainPage(MainActivity.class)
//                .recoverEnabled(true)
//                .callback(new MyCrashCallback())
//                .silent(false, Recovery.SilentMode.RECOVER_ACTIVITY_STACK)
//                .skip(RecyclerviewActivity.class)
//                .init(this);
//
//        MyCrashHandler.register();
//    }

//    static final class MyCrashCallback implements RecoveryCallback {
//        @Override
//        public void stackTrace(String exceptionMessage) {
//            Log.e("zxyRecovery", "exceptionMessage:" + exceptionMessage);
//        }
//
//        @Override
//        public void cause(String cause) {
//            Log.e("zxyRecovery", "cause:" + cause);
//        }
//
//        @Override
//        public void exception(String exceptionType, String throwClassName, String throwMethodName, int throwLineNumber) {
//            Log.e("zxyRecovery", "exceptionClassName:" + exceptionType);
//            Log.e("zxyRecovery", "throwClassName:" + throwClassName);
//            Log.e("zxyRecovery", "throwMethodName:" + throwMethodName);
//            Log.e("zxyRecovery", "throwLineNumber:" + throwLineNumber);
//        }
//
//        @Override
//        public void throwable(Throwable throwable) {
//
//        }
//    }
}
