package tk.chuanjing.cjutils.smallutils;

import android.app.Activity;
import android.widget.Toast;

/**
 * 点两次返回 退出
 * @author ChuanJing
 *
 */
public class OnBackTwiceExit {
	
	private static long firstPressedTime = 0;
	private static long secondPressedTime = 0;
	private static boolean isPressedBackOnce = false;
	
	/**
	 * 点两次返回退出的方法，两次点击必须在2秒之内
	 * @param activaty 传入一个Activity
	 */
	public static void onBackTwiceExit(Activity activaty) {
		// 第一次先弹一个吐司
		// 如果是第二次点击 调用finish方法

		// 代表已经点了一次，这是第二次点击
		if (isPressedBackOnce) {
			secondPressedTime = System.currentTimeMillis();

			// 第一次点击就作废了，时间重新算,还是第一次点击
			if (secondPressedTime - firstPressedTime > 2000) {
				firstPressedTime = System.currentTimeMillis();
				isPressedBackOnce = true;

				Toast toast = Toast.makeText(activaty, "再点一次退出", 0);
				toast.setDuration(2000);
				toast.show();
			} else {
				activaty.finish();

				// 做一个结束操作
				isPressedBackOnce = false;
				firstPressedTime = 0;
				secondPressedTime = 0;
			}

		} else { // 第一次点击
			firstPressedTime = System.currentTimeMillis();
			isPressedBackOnce = true;

			Toast toast = Toast.makeText(activaty, "再点一次返回退出", 0);
			toast.setDuration(2000);
			toast.show();
		}
	}
}