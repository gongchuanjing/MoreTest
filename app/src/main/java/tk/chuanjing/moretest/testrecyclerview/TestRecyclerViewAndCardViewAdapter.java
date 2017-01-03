package tk.chuanjing.moretest.testrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import tk.chuanjing.moretest.R;

/**
 * Created by ChuanJing on 2016/12/15.
 */
public class TestRecyclerViewAndCardViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAndCardViewAdapter.ViewHolder> {

    private List<TestBean> testList;

    public TestRecyclerViewAndCardViewAdapter(List<TestBean> testList){
        this.testList = testList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_recyclerview_cardview, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView iv_ic;
        TextView tv_name;

        public ViewHolder(View view) {
            super(view);
            itemView = view;
            iv_ic = (ImageView)view.findViewById(R.id.iv_ic);
            tv_name = (TextView)view.findViewById(R.id.tv_name);
        }

        public void setData(final int position) {
            final TestBean testBean = testList.get(position);
            iv_ic.setImageResource(testBean.resId);
            tv_name.setText(testBean.name);

            // 设置整个view条目点击事件
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(view.getContext(), "点击了" + testBean.name, Toast.LENGTH_SHORT).show();
//                }
//            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 回调自己写的条目点击事件
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(view, position);
                    }
                }
            });

            // 设置每个条目中图片的点击事件
            iv_ic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "点击了" + testBean.name + "的图片", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // 自定义RecyclerView条目点击事件
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener = listener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int postion);
    }
}
