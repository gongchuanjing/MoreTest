package tk.chuanjing.cjutils.smallutils;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import tk.chuanjing.cjutils.R;

/**
 * 选项卡工具，一般用于底部菜单
 * @author ChuanJing
 */
public class TabsUtil {
	private int curr = 0;
	private List<View> tabs = new ArrayList<View>();
	private List<TextView> tv_dots = new ArrayList<TextView>();
	private List<TextView> tv_menus = new ArrayList<TextView>();
	
	private int[] iconSelect;
	private int[] iconNoSelect;
	private LinearLayout layout;

	public static interface OnTabClickListener {
		public void onItemClick(int position);//position是菜单下标，如 0 1 2 ……
	}

	private OnTabClickListener listener;

	public void setOnTabClickListener(OnTabClickListener listener) {
		this.listener = listener;
	}

	/**
	 * @param layout 选项卡所在的布局
	 * @param lables 选项卡的名字数组
	 * @param iconSelect 选项卡选中的图片数组
	 * @param iconNoSelect 选项卡没选中的图片数组
	 */
	public void createTabs(final LinearLayout layout, final String[] lables, final int[] iconSelect, final int[] iconNoSelect) {
		this.layout = layout;
		this.iconSelect = iconSelect;
		this.iconNoSelect = iconNoSelect;
		WindowManager wm = (WindowManager) layout.getContext().getSystemService(Context.WINDOW_SERVICE);
		Display dp = wm.getDefaultDisplay();
		final int width = dp.getWidth() / lables.length;
		for (int i = 0; i < lables.length; i++) {
			View view = View.inflate(layout.getContext(), R.layout.view_tab_util, null);//得到每个菜单整体的布局
			TextView tv_menu = (TextView) view.findViewById(R.id.tv_menu);	//菜单
			tv_menus.add(tv_menu);
			TextView tv_dot = (TextView) view.findViewById(R.id.tv_dot);	//红点
			tv_dots.add(tv_dot);
			
			tv_menu.setText(lables[i]);// 文字
			Drawable top = layout.getContext().getResources().getDrawable(iconNoSelect[i]);
			// CompoundDrawablesWithIntrinsicBounds text四个方位
			tv_menu.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
			
			LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.MATCH_PARENT);
			view.setId(i);
			view.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					int id = v.getId();
					
					//----------------------
					// 选中-- 》默认
					tabs.get(curr).setEnabled(true);
					tabs.get(id).setEnabled(false);
					// 默认 选中-- 》
					curr = id;
					//----------------------
					
					for (int i = 0; i < lables.length; i++) {
						if (id == i) {
							Drawable top = layout.getContext().getResources().getDrawable(iconSelect[i]);
							tv_menus.get(i).setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
							if (listener != null) {
								listener.onItemClick(i);
							}
						} else {
							Drawable top = layout.getContext().getResources().getDrawable(iconNoSelect[i]);
							tv_menus.get(i).setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
						}
					}
					
				}
			});
			tabs.add(view);
			layout.addView(view, p);
		}
		tabs.get(curr).setEnabled(false);
	}

	public void changeTab(int position) {
		//----------------------
		// 选中-- 》默认
		tabs.get(curr).setEnabled(true);
		tabs.get(position).setEnabled(false);
		// 默认 选中-- 》
		curr = position;
		//----------------------
		
				
		for (int i = 0; i < iconSelect.length; i++) {
			if (position == i) {
				Drawable top = layout.getContext().getResources().getDrawable(iconSelect[i]);
				tv_menus.get(i).setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
			} else {
				Drawable top = layout.getContext().getResources().getDrawable(iconNoSelect[i]);
				tv_menus.get(i).setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
			}
		}
	}
	
	/**
	 * 给一个菜单设置点
	 * @param position 要设置菜单的下标
	 * @param number 点上面的数字
	 */
	public void showDot(int position, String number){
		TextView textView = tv_dots.get(position);
		textView.setVisibility(View.VISIBLE);
		textView.setText(number);
	}
	
	/**
	 * 设置显示很多点
	 * @param position 要设置点的菜单的下标集合
	 * @param number 要设置点上面的数字的集合
	 */
	public void showDots(int[] position, String[] number){
		for (int i = 0; i < position.length; i++) {
			TextView textView = tv_dots.get(position[i]);
			textView.setVisibility(View.VISIBLE);
			textView.setText(number[i]);
		}
	}
}
