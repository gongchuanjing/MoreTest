package tk.chuanjing.moretest.testrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        ViewHolder holder = new ViewHolder(view);
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

        ImageView iv_ic;
        TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);

            iv_ic = (ImageView)itemView.findViewById(R.id.iv_ic);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
        }
    }
}
