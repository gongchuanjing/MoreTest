package tk.chuanjing.cjutils.smallutils;

import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import tk.chuanjing.cjutils.MyApplication;
import tk.chuanjing.cjutils.R;

/**
 * Dialog 工具
 * @author ChuanJing
 *
 *用前要在Style中添加以下对应的Style：
 *	直接全屏
 *	<style name="Dialog_FS_Style"> 
		<item name="android:windowFullscreen">true</item> 
		<item name="android:windowNoTitle">true</item> 
	</style> 
	
	宽度和屏幕宽度一样
	<style name="BottomDialogStyle">
        <item name="android:windowBackground">@android:color/transparent</item>
        <item name="android:windowFrame">@null</item>
        <item name="android:windowNoTitle">true</item>
        <item name="android:windowIsFloating">true</item>
        <item name="android:windowIsTranslucent">true</item>
        <item name="android:windowContentOverlay">@null</item>
        <item name="android:windowAnimationStyle">@android:style/Animation.Dialog</item>
        <item name="android:backgroundDimEnabled">true</item>
    </style>
    
    BottomDialog进入退出时的动画
    <style name="BottomDialogAnimationStyle" parent="android:Animation">  
        <item name="@android:windowEnterAnimation">@anim/dialog_enter</item>  
        <item name="@android:windowExitAnimation">@anim/dialog_exit</item> 
    </style>
 */
public class DialogUtils {

	/**
	 * 在屏幕下边弹出一个和屏幕一样宽的Dialog，内部没有show
	 * @param dialog
	 * @param activity
	 * @param view
	 */
	public static void bottomDialog(Dialog dialog, Activity activity, View view) {
//		AlertDialog.Builder builder = new Builder(this);
//		builder.setView(view);
//		AlertDialog fenpeiDialog = builder.create();
		
		dialog.setContentView(view); 									//设置dialog的布局view
		Window dialogWindow = dialog.getWindow();
		dialogWindow.setGravity(Gravity.LEFT | Gravity.BOTTOM);  		//设置dialog显示的位置
//		dialogWindow.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
		
		WindowManager wm = activity.getWindowManager();
		Display d = wm.getDefaultDisplay(); 							// 获取屏幕宽、高
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();	// 获取对话框当前的参数值
		lp.height = (int) (d.getHeight() * 0.3); 						// 高度设置为屏幕的0.3倍
		lp.width = d.getWidth(); 										// 宽度设置为屏幕的1倍
//		lp.alpha = 0.7f; 												// 透明度
		dialogWindow.setAttributes(lp);
		dialogWindow.setWindowAnimations(R.style.BottomDialogAnimationStyle);//添加动画，在style里面用了系统的动画，这里没用了
	}
	
	/**
	 * 在屏幕下边弹出一个和屏幕一样宽的Dialog，里面使用的布局是ListView，内部已经show过了
	 * @param dialog
	 * @param activity
	 * @param dialogTitle 	dialog标题
	 * @param strs			ListView要填充的字符串
	 * @return 				ListView
	 */
	public static ListView bottomDialogLayoutIsListView(final Dialog dialog, Activity activity, String dialogTitle, List<String> strs) {
		View view = View.inflate(activity, R.layout.dialog_bottom, null);
		
		
		// 换字体，和逻辑无关
//		TypefaceHelper.typeface(view);
		
		
		dialog.setContentView(view); 									//设置dialog的布局view
		Window dialogWindow = dialog.getWindow();
		dialogWindow.setGravity(Gravity.LEFT | Gravity.BOTTOM);  		//设置dialog显示的位置
		WindowManager wm = activity.getWindowManager();
		Display d = wm.getDefaultDisplay(); 							// 获取屏幕宽、高
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();	// 获取对话框当前的参数值
		lp.height = (int) (d.getHeight() * 0.3); 						// 高度设置为屏幕的0.3倍
		lp.width = d.getWidth(); 										// 宽度设置为屏幕的1倍
		dialogWindow.setAttributes(lp);
		dialogWindow.setWindowAnimations(R.style.BottomDialogAnimationStyle);//添加动画，在style里面用了系统的动画，这里没用了
		
		//标题
		TextView tv_dialog_title = (TextView) view.findViewById(R.id.tv_dialog_title);
		tv_dialog_title.setText(dialogTitle);
		
		// 左上角的  X 点击关闭对话框
		ImageView iv_dismiss = (ImageView) view.findViewById(R.id.iv_dismiss);
		iv_dismiss.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		
		// 为ListView填充数据
		ListView mListView = (ListView) view.findViewById(R.id.lv);
		mListView.setAdapter(new ArrayAdapter<String>(MyApplication.getInstance(), 
											android.R.layout.simple_list_item_1,
											android.R.id.text1,
											strs){
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				TextView tv = (TextView) view;
				tv.setTextColor(Color.BLACK);
				
				// 换字体，和逻辑无关
//				TypefaceHelper.typeface(tv);
				
				return tv;
			}
		});
		
		// 条目的点击事件，关闭对话框，在 refreshView() 中处理listview的条目点击事件
//		lv.setOnItemClickListener(new OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				dialog.dismiss();
//				refreshView();		//把选择的设置上去
//			}
//		});
		
		dialog.show();
		return mListView; //直接把ListView返回，可以在外面设置ListView的条目点击事件
	}
	
//	protected abstract void refreshView();

	
//----------------------------IOS风格的对话框------------------------------------------------------------
	private Dialog dialog;
	private BtnOnClick btnOnClick;
	private View view;

	public interface BtnOnClick {
		void openClick();
		void cancelClick();
	}

	public void setBtnOnClick(BtnOnClick btnOnClick) {
		this.btnOnClick = btnOnClick;
	}

	public DialogUtils(Activity activity, String title, String content) {
		view = LayoutInflater.from(activity).inflate(R.layout.dialog_ios_style, null);

		// 换字体，和逻辑无关
//		TypefaceHelper.typeface(view);
		
		dialog = new Dialog(activity);
		dialogDownDectorCenter(dialog, activity);
		dialog.setContentView(view);

		Button btn_open = (Button) view.findViewById(R.id.btn_open);
		Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
		TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
		TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
		tv_title.setText(title);
		tv_content.setText(content);
		// 打开，确定
		btn_open.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				btnOnClick.openClick();
			}
		});
		// 取消
		btn_cancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				btnOnClick.cancelClick();
			}
		});
	}

	public void show() {
		dialog.show();
	}

	public void dismiss() {
		dialog.dismiss();
	}

	public Dialog getDialog() {
		return dialog;
	}
	
	public View getContentView(){
		return view;
	}
	
	/**
	 * 让dialog显示在屏幕的中间
	 * @param dialog
	 * @param activity
	 */
	public static void dialogDownDectorCenter(Dialog dialog, Activity activity) {
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		Window dialogWindow = dialog.getWindow();
		dialogWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		// dialogWindow.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
	}
}
