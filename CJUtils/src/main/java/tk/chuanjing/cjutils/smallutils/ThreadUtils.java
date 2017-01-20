package tk.chuanjing.cjutils.smallutils;

import android.os.Handler;

/**
 * 线程工具类
 * @author ChuanJing
 */
public class ThreadUtils {

    /**
     * 子线程执行
     * @param runnable
     */
    public static void runOnBackThread(Runnable runnable){
        new Thread(runnable).start();
    }

    private static Handler handler = new Handler();

    /**
     * 主线程执行
     * @param runnable
     */
    public static void runOnUiThread(Runnable runnable){
        handler.post(runnable);
    }
}
