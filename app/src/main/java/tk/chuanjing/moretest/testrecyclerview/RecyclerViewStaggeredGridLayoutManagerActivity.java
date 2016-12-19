package tk.chuanjing.moretest.testrecyclerview;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tk.chuanjing.moretest.R;

import static android.R.attr.name;

public class RecyclerViewStaggeredGridLayoutManagerActivity extends AppCompatActivity {

    private List<TestBean> testList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_staggered_grid_layout_manager);

        initDate();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new TestRecyclerViewAdapter(testList));
    }

    private void initDate() {
        testList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            testList.add(new TestBean(getRandomLengthName("安全"), R.mipmap.icon_anquan));
            testList.add(new TestBean(getRandomLengthName("车"), R.mipmap.icon_ce));
            testList.add(new TestBean(getRandomLengthName("钱"), R.mipmap.icon_qian));
            testList.add(new TestBean(getRandomLengthName("人"), R.mipmap.icon_ren));
            testList.add(new TestBean(getRandomLengthName("心"), R.mipmap.icon_xin));
            testList.add(new TestBean(getRandomLengthName("延"), R.mipmap.icon_yan));
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(30) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(name);
        }
        return sb.toString();
    }
}
