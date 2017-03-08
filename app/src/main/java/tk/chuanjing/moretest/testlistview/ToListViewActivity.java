package tk.chuanjing.moretest.testlistview;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import tk.chuanjing.cjutils.activity.BaseActivity;
import tk.chuanjing.cjutils.adapter.DefaultAdapter;
import tk.chuanjing.cjutils.holder.BaseHolder;
import tk.chuanjing.moretest.R;

/**
 * @author ChuanJing
 * @date 2016年8月4日 上午11:18:39
 */
public class ToListViewActivity extends BaseActivity {

	private ListView mListView;
	private ArrayList<String> strs = null;
	private View headView;
	private View headView2;
	private TextView tv_1;
	private TextView tv_2;
	private TextView tv_3;
	
	@Override
	public int getLayoutResID() {
		return R.layout.activity_to_listview;
	}

	@Override
	public void initView() {
		mListView = (ListView) findViewById(R.id.mListView);
		headView = View.inflate(getApplicationContext(), R.layout.to_listview_layout_listview_head, null);
		tv_1 = (TextView) headView.findViewById(R.id.tv_1);
		tv_2 = (TextView) headView.findViewById(R.id.tv_2);
		tv_3 = (TextView) headView.findViewById(R.id.tv_3);
		headView2 = View.inflate(getApplicationContext(), R.layout.to_listview_layout_listview_head2, null);
		mListView.addHeaderView(headView);
		mListView.addHeaderView(headView2);
	}

	@Override
	public void initListener() {
		tv_1.setOnClickListener(this);
		tv_2.setOnClickListener(this);
		tv_3.setOnClickListener(this);
	}

	@SuppressLint("NewApi")
	@Override
	public void onInnerClick(View v) {
		super.onInnerClick(v);
		switch (v.getId()) {
		case R.id.tv_1:
//			mListView.setSelection(1);//没有平滑的动画，但可以把想要显示的条目移动到屏幕顶端
			
//			mListView.smoothScrollToPosition(1);//有平滑的动画，但只能把想要显示的条目移动
												// 出来，条目的位置在屏幕的下边，如果要显示
												// 的条目已经在屏幕上了，那么不会有效果
			
			mListView.smoothScrollToPositionFromTop(1, 0, 400);//这个方法既有动画，又能把
															// 条目显示到屏幕顶端，但 API 11 才有的方法
															// 参数一：要显示的条目
															// 参数二：距离屏幕顶部的偏移量
															// 参数一：平滑滑动的时间
			break;
			
		case R.id.tv_2:
//			mListView.setSelection(3);
//			mListView.smoothScrollToPosition(3);
			mListView.smoothScrollToPositionFromTop(3, 0, 400);
			break;
			
		case R.id.tv_3:
//			mListView.setSelection(50);
//			mListView.smoothScrollToPosition(50);
			mListView.smoothScrollToPositionFromTop(50, 0, 400);
			break;
		}
	}
	
	@Override
	public void initData() {
		strs = new ArrayList<String>();
		for (int i = 0; i < 200; i++) {
			strs.add("测试文字"+i);
		}
		
		mListView.setAdapter(new MyAdapter(strs));
	}

	class MyAdapter extends DefaultAdapter<String>{
		public MyAdapter(List<String> datas) {
			super(datas);
		}

		@Override
		protected BaseHolder<String> getHolder() {
			return new MyHolder();
		}
	}
	
	class MyHolder extends BaseHolder<String>{

		private TextView tv;
		
		@Override
		protected View initView() {
			View view = View.inflate(getBaseContext(), android.R.layout.simple_list_item_1, null);
			tv = (TextView) view.findViewById(android.R.id.text1);
			return view;
		}

		@Override
		protected void refreshView(String data, int position, View convertView) {
			this.tv.setText(data);
		}
		
	}
}
