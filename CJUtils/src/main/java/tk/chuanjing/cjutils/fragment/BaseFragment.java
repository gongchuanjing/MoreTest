package tk.chuanjing.cjutils.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment的基类
 * @author ChuanJing
 */
public abstract class BaseFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), getLayoutResID(), null);
		
		initView(view);
		
		// 换字体，所有继承此Fragment的页面全部换字体了
//        TypefaceHelper.typeface(view);
        
		initListener();
		initData();

		return view;
	}

	/**
     * 获取Fragment显示的布局：
     * @return：布局id
     */
	public abstract int getLayoutResID();

	/**
     * 初始化View：findViewById
     * 参数:view,通过View查找控件
     */
	public abstract void initView(View view);
	
	/**
     * 初始化监听：点击监听、设置适配器、设置条目点击监听
     */
	public abstract void initListener();
	
	/**
     * 初始化数据
     */
	public abstract void initData();
}
