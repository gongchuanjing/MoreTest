package tk.chuanjing.cjutils.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

public class AppActivityManager {
    private static Stack<Activity> activityStack;
    private static AppActivityManager appManager;

    private AppActivityManager(){
        activityStack=new Stack<Activity>();
    }

    public static AppActivityManager getInstance() {
        if (appManager == null) {
            synchronized (AppActivityManager.class) {
                if (appManager == null) {
                    appManager = new AppActivityManager();
                }
            }
        }
        return appManager;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    public void removeActivity(Activity activity) {
        activityStack.remove(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        finishActivity(currentActivity());
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
        return;
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                return;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }


    /**
     * 退出应用程序
     */
    @SuppressWarnings("deprecation")
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
        }
    }
}