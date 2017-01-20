package tk.chuanjing.cjutils.smallutils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import tk.chuanjing.cjutils.MyApplication;

/**
 * 获取一些资源
 * @author ChuanJing
 *
 */
public class UIUtils {

	/**
	 * dip转换px
	 */
	public static int dip2px(int dip) {
		final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f);
	}

	/**
	 * px转换dip
	 */
	public static int px2dip(int px) {
		final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}
	
	/**
	 * 根据Layout id 获取  view 对象
	 * @param resource
	 * @return
	 */
	public static View inflate(int resource) {
		return View.inflate(MyApplication.getInstance(), resource, null);
	}

	/**
	 * 通过id 获取string
	 * @param id
	 * @return
	 */
	public static String getString(int id) {
		return MyApplication.getInstance().getString(id);
	}

	public static Resources getResource() {
		return MyApplication.getInstance().getResources();
	}
	
	public static Drawable getDrawable(int id) {
		return getResource().getDrawable(id);
	}

	public static int getColor(int id) {
		return getResource().getColor(id);
	}
	
	public static int getDimension(int id) {
		return (int) getResource().getDimension(id);
	}
}
