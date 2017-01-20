package tk.chuanjing.cjutils.holder;

import android.view.View;

/**
 * BaseHolder的基类
 * @author ChuanJing
 *
 * @param <Data>
 */
public abstract class BaseHolder <Data> {
	
	private View convertView;
	private Data data;

	public BaseHolder(){
		convertView = initView();
		convertView.setTag(this);
	}

	public View getConvertView() {
		
		// 换字体，换掉listview中每行中每个控件的字体
//		TypefaceHelper.typeface(convertView);
				
		return convertView;
	}
	
	public void setData(Data data, int position, View convertView) {
		this.data = data;
		refreshView(data, position, convertView);
	}

	public Data getData() {
		return data;
	}
	
	/**
	 * 1.xml ---> view
	 * 2.findviewById
	 * @return
	 */
	protected abstract View initView();
	
	/**
	 * 填充数据：将数据适配到界面中
	 * @param data
	 */
	protected abstract void refreshView(Data data, int position, View convertView);
}
