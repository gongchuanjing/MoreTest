package tk.chuanjing.cjutils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import tk.chuanjing.cjutils.R;
import tk.chuanjing.cjutils.smallutils.TabsUtil;
import tk.chuanjing.cjutils.toastutils.ToastUtils;

public class MainActivity extends Activity {

	private LinearLayout ll_tabs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ll_tabs = (LinearLayout) findViewById(R.id.ll_tabs);
		
		// 封装好的处理下面菜单的工具
        final TabsUtil tabs = new TabsUtil();
        tabs.createTabs(ll_tabs, new String[]{"消息", "好友"},
                new int[]{R.mipmap.icon_meassage_sel, R.mipmap.icon_selfinfo_sel},
                new int[]{R.mipmap.icon_meassage_nor, R.mipmap.icon_selfinfo_nor});

        tabs.changeTab(1);// 默认选中好友
        
        // 设置菜单的点击事件
        tabs.setOnTabClickListener(new TabsUtil.OnTabClickListener() {
            @Override
            public void onItemClick(int position) {
            	switch (position) {
				case 0:
//					Toast.makeText(getApplicationContext(), "消息", 0).show();
//					MyToast.makeText(getApplicationContext(), "消息", 0).show();
//					ToastUtils.getInstance(MainActivity.this).showMyToast( "消息");
					ToastUtils.showMyToast(getApplicationContext(), "消息");
					break;
				case 1:
//					Toast.makeText(getApplicationContext(), "好友", 0).show();
//					MyToast.makeText(getApplicationContext(), "好友", 0).show();
//					ToastUtils.getInstance(MainActivity.this).showMyToast( "好友好友好友好友好友好友");
					ToastUtils.showMyToast(getApplicationContext(), "好友好友好友好友好友好友");
					break;
				}
            }
        });
        
        tabs.showDot(0, "7");
//        tabs.showDots(new int[]{0,3}, new String[]{"2","6"});

        // 页面滑动时，改变下面的菜单
//        viewpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                if (position == 0) {
//                    tv_title.setText("会话");
//                } else {
//                    tv_title.setText("好友");
//                }
//                tabs.changeTab(position);
//            }
//        });
	}

}
