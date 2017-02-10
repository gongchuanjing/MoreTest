package tk.chuanjing.moretest;

import tk.chuanjing.cjutils.MyApplication;
import tk.chuanjing.moretest.testokhttp.RequestServiceMethodList;

/**
 * Created by ChuanJing on 2017/2/6.
 */

public class MyApp extends MyApplication {

    /** 所有请求网络的方法都在这个类里面 */
    public static RequestServiceMethodList requestService;

    @Override
    public void onCreate() {
        super.onCreate();

        if (requestService == null) {
            requestService = new RequestServiceMethodList();
        }

        // initRecovery();
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
