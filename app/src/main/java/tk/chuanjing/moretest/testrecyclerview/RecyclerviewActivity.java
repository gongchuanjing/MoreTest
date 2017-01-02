package tk.chuanjing.moretest.testrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import tk.chuanjing.moretest.R;

public class RecyclerviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        // 点击进入横向界面
        Button btn_linearlayout = (Button) findViewById(R.id.btn_recyclerview_linearlayout_manager);
        btn_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecyclerViewLinearLayoutManagerActivity.class));
            }
        });

        // 点击进入瀑布流界面
        Button btn_staggeredgridlayout = (Button) findViewById(R.id.btn_recyclerview_staggeredgridlayout_manager);
        btn_staggeredgridlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecyclerViewStaggeredGridLayoutManagerActivity.class));
            }
        });

        // 点击进入CardView结合recyclerview
        Button btn_recyclerview_cardView = (Button) findViewById(R.id.btn_recyclerview_cardView);
        btn_recyclerview_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecyclerViewCardViewActivity.class));
            }
        });
    }
}
