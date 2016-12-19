package tk.chuanjing.moretest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewActivity extends AppCompatActivity {

    private List<TestBean> testList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initDate();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new TestRecyclerViewAdapter(testList));
    }

    private void initDate() {
        testList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            testList.add(new TestBean("安全", R.mipmap.icon_anquan));
            testList.add(new TestBean("车", R.mipmap.icon_ce));
            testList.add(new TestBean("钱", R.mipmap.icon_qian));
            testList.add(new TestBean("人", R.mipmap.icon_ren));
            testList.add(new TestBean("心", R.mipmap.icon_xin));
            testList.add(new TestBean("延", R.mipmap.icon_yan));
        }
    }
}
