package tk.chuanjing.moretest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import tk.chuanjing.import_contacts.ImportContactsActivity;
import tk.chuanjing.moretest.testandfix.AndFixActivity;
import tk.chuanjing.moretest.testlistview.ToListViewActivity;
import tk.chuanjing.moretest.testokhttp.OkhttpActivity;
import tk.chuanjing.moretest.testrecovery.TestRecoveryActivity;
import tk.chuanjing.moretest.testrecyclerview.RecyclerviewActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "小舟从此逝，江海寄余生", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "哈哈", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setCheckedItem(R.id.nav_camera);默认选中菜单中的照相机
        navigationView.setNavigationItemSelectedListener(this);//设置菜单选中监听

//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.mipmap.icon_qian);
//        }

        initMyView();
    }

    private void initMyView() {
        // 点击进入recyclerview界面
        ((Button) findViewById(R.id.btn_rv)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecyclerviewActivity.class));
            }
        });

        // 点击进入okhttp界面
        ((Button) findViewById(R.id.btn_okhttp)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), OkhttpActivity.class));
            }
        });

        // 点击进入TestRecovery界面
        ((Button) findViewById(R.id.btn_test_recovery)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TestRecoveryActivity.class));
            }
        });

        // 点击进入AndFix界面
        ((Button) findViewById(R.id.btn_andfix)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AndFixActivity.class));
            }
        });

        // 点击进入to_listview界面
        ((Button) findViewById(R.id.btn_to_listview)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ToListViewActivity.class));
            }
        });

        // 点击进入【导入联系人】的界面
        ((Button) findViewById(R.id.btn_import_contacts)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ImportContactsActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_send:
                Toast.makeText(getApplicationContext(), "send", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT).show();
                break;
//            case android.R.id.home:菜单按钮
//                drawer.openDrawer(GravityCompat.START);
//                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(MainActivity.this, "锦瑟无端五十弦，一弦一柱思华年", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(MainActivity.this, "庄生晓梦迷蝴蝶，望帝春心托杜鹃", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(MainActivity.this, "沧海月明珠有泪，蓝田日暖玉生烟", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(MainActivity.this, "此情可待成追忆？只是当时已惘然", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(MainActivity.this, "世间万物，希望至美", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(MainActivity.this, "晓看天色暮看云,行也思君,坐也思君", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
