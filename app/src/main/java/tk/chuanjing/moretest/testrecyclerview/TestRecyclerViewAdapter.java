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
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.ViewHolder> {

    private List<TestBean> testList;

    public TestRecyclerViewAdapter(List<TestBean> testList){
        this.testList = testList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_recyclerview_linearlayout_manager, null);
        final ViewHolder holder = new ViewHolder(view);

        // 设置整个view条目点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestBean testBean = testList.get(holder.getAdapterPosition());
                Toast.makeText(view.getContext(), "点击了" + testBean.name, Toast.LENGTH_SHORT).show();
            }
        });

        // 设置每个条目中图片的点击事件
        holder.iv_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestBean testBean = testList.get(holder.getAdapterPosition());
                Toast.makeText(view.getContext(), "点击了" + testBean.name + "的图片", Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TestBean testBean = testList.get(position);
        holder.iv_ic.setImageResource(testBean.resId);
        holder.tv_name.setText(testBean.name);
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        ImageView iv_ic;
        TextView tv_name;

        public ViewHolder(View view) {
            super(view);

            itemView = view;
            iv_ic = (ImageView)view.findViewById(R.id.iv_ic);
            tv_name = (TextView)view.findViewById(R.id.tv_name);
        }
    }
}
