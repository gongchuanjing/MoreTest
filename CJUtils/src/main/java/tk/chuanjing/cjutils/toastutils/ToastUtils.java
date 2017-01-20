package tk.chuanjing.cjutils.toastutils;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * @author ChuanJing
 * @date 2016年7月28日 上午9:46:13
 * 
 * Toast工具
 */
public class ToastUtils {

	//-------------------------------   基于自定义的 MyToast 的静态Toast工具   --------------------------------------
	// 使用示例：MyToastUtils.getInstance(MainActivity.this).show("消息");
    private static MyToast mToast;
    private Context mContext;
    private volatile static ToastUtils mToastUtils;

    private ToastUtils(Context mContext) {
        this.mContext = mContext;
    }

    public static ToastUtils getInstance(Context mContext) {
        if (mToastUtils == null) {
            synchronized (ToastUtils.class) {
                if (mToastUtils == null) {
                    mToastUtils = new ToastUtils(mContext);
                }
            }
        }
        return mToastUtils;
    }

    public void showMyToast(String msg) {
        if (mToast == null) {
            mToast = (MyToast) MyToast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
    
    /**
     * 简单的使用单例MyToast
     * 不用 MyToastUtils.getInstance(MainActivity.this).show("消息") 这样用了
     * @param mContext
     * @param msg
     */
    public static void showMyToast(Context mContext, String msg) {
    	if (mToast == null) {
    		mToast = (MyToast) MyToast.makeText(mContext, "", Toast.LENGTH_SHORT);
    	}
    	mToast.setText(msg);
    	mToast.show();
    }
    
    /**
	 * 在子线程中弹一个单例的MyToast
	 * @param content 要弹出来的提示信息
	 * @param mActivity Activity对象
	 */
	public static void showMyToastInChildThread(final Activity mActivity, final String msg){
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (mToast == null) {
		    		mToast = (MyToast) MyToast.makeText(mActivity, "", Toast.LENGTH_SHORT);
		    	}
		    	mToast.setText(msg);
		    	mToast.show();
			}
		});
	}
    
    
    
    
    
    
    
//----------------------------------  基于系统的 Toast 的静态Toast工具  ----------------------------------------	
    public static Toast toast;
	/** 静态Toast */
	public static void showToast(Context mContext, String msg){
		if(toast == null) {
			toast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
		}
		toast.setText(msg);
		toast.show();
	}
	
	/**
	 * 在子线程中弹一个单例的Toast
	 * @param content 要弹出来的提示信息
	 * @param mActivity Activity对象
	 */
	public static void showToastInChildThread(final Activity mActivity, final String msg){
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if(toast == null) {
					toast = Toast.makeText(mActivity, "", Toast.LENGTH_SHORT);
				}
				toast.setText(msg);
				toast.show();
			}
		});
	}
}