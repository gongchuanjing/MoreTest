package tk.chuanjing.import_contacts;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tk.chuanjing.moretest.BaseActivityMoreTest;
import tk.chuanjing.moretest.Constant;
import tk.chuanjing.moretest.MyApp;
import tk.chuanjing.moretest.R;

public class ImportContactsActivity extends BaseActivityMoreTest {

    private Button btn_import;
    private Button btn_del_all_contact;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_import_contacts;
    }

    @Override
    public void initView() {
        this.btn_import = (Button) findViewById(R.id.btn_import);
        this.btn_del_all_contact = (Button) findViewById(R.id.btn_del_all_contact);
    }

    @Override
    public void initListener() {
        btn_import.setOnClickListener(this);
        btn_del_all_contact.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onInnerClick(View v) {
        super.onInnerClick(v);
        switch (v.getId()) {
            case R.id.btn_import:
                importContacts();
                break;

            case R.id.btn_del_all_contact:
                delAllContact();
                break;
        }
    }

    private void importContacts() {
        Toast.makeText(this, "开始导入，请稍等……", Toast.LENGTH_SHORT).show();

        File excelFile = new File(Constant.OTHER_PATH + "/importContacts.xlsx");
        try {
            List<String[]> list = POIUtils.readExcel(excelFile);//使用POI解析表格数据
            List<ContactBean> contacts = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                String name = list.get(i)[0];
                String number = list.get(i)[1];
                ContactBean contact = new ContactBean(name, number);
                contacts.add(contact);

                //System.out.println("=====解析表格创建第" + (i+1) + "个联系人=====" + contact);
            }

            //调用工具类批量导入联系人
            ContactsUtils.batchAddContact(contacts, MyApp.getInstance());

            Toast.makeText(this, "导入完成！！！", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "！！！导入出错！！！", Toast.LENGTH_SHORT).show();
        }
    }

    private void delAllContact() {
        ContactsUtils.delAllContact(MyApp.getInstance());
        Toast.makeText(this, "删除成功！！！", Toast.LENGTH_SHORT).show();
    }
}
