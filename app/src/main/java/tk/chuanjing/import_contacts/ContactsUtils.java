package tk.chuanjing.import_contacts;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

import tk.chuanjing.moretest.MyApp;

/**
 * Created by ChuanJing on 2019/10/12.
 */
public class ContactsUtils {

    /**
     * 添加一条联系人到通讯录
     */
    public static void addOneContact(String name, String number, Context mContext) {
        ContentValues values = new ContentValues();
        // 首先向RawContacts.CONTENT_URI执行一个空值插入，目的是获取系统返回的rawContactId
        //Uri rawContactUri = mContext.getContentResolver().insert(
        Uri rawContactUri = MyApp.getInstance().getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values);
        long rawContactId = ContentUris.parseId(rawContactUri);

        // 往data表插入姓名数据
        values.clear();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);// 内容类型
        values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, name);
        mContext.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);

        // 往data表插入电话数据
        values.clear();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, number);
        values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
        mContext.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
    }

    /**
     * 批量添加联系人到通讯录
     */
    public static void batchAddContact(List<ContactBean> list, Context mContext) {
        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
        int rawContactInsertIndex = 0;
        for (ContactBean contact : list) {
            rawContactInsertIndex = ops.size(); // 有了它才能给真正的实现批量添加

            ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                    .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                    .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                    .withYieldAllowed(true)
                    .build());

            // 添加姓名
            ops.add(ContentProviderOperation.newInsert(android.provider.ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID,rawContactInsertIndex)
                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, contact.getName())
                    .withYieldAllowed(true)
                    .build());

            // 添加号码
            ops.add(ContentProviderOperation
                    .newInsert(android.provider.ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, rawContactInsertIndex)
                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, contact.getNumber())
                    .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                    .withValue(ContactsContract.CommonDataKinds.Phone.LABEL, "")
                    .withYieldAllowed(true)
                    .build());
        }

        try {
            // 真正添加
            mContext.getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
            ops.clear();
        } catch (TransactionTooLargeException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        }
    }

    public static void delAllContact(Context mContext) {
        /*
        Cursor cursor = mContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI,
                new String[] { ContactsContract.Data.RAW_CONTACT_ID },
                ContactsContract.Contacts.DISPLAY_NAME + "=?",
                new String[] { name }, null);
        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
        if (cursor.moveToFirst()) {
            do {
                long Id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data.RAW_CONTACT_ID));
                ops.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, Id)).build());
                try {
                    mContext.getContentResolver().applyBatch(ContactsContract.AUTHORITY,ops);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
            cursor.close();
        }
        */

        ContentResolver cr = mContext.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (cur.moveToNext()) {
            try{
                String lookupKey = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
                Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, lookupKey);
                //System.out.println("The uri is " + uri.toString());
                cr.delete(uri, null, null);//删除所有的联系人
            } catch(Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
