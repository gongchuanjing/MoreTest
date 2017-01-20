package tk.chuanjing.cjutils.adapter;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import tk.chuanjing.cjutils.holder.BaseHolder;

/**
 * Adapter的基类
 * @author ChuanJing
 */
public abstract class DefaultAdapter<T> extends BaseAdapter {

	private List<T> datas;

	public DefaultAdapter(List<T> datas){
		this.datas = datas;
	}
	
	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BaseHolder<T> vh = null;
		if (convertView == null) {
			vh = getHolder();
		} else {
			vh = (BaseHolder<T>) convertView.getTag();
		}
		
		T t = datas.get(position);
		
		vh.setData(t, position, convertView);
		
		return vh.getConvertView();
	}

	protected abstract BaseHolder<T> getHolder();
}
