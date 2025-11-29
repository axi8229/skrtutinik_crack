package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class c {
    private static String a;

    public interface a {
        void a(Boolean bool);
    }

    private static class b extends AsyncTask<Void, Void, Boolean> {
        a a;

        public b(a aVar) {
            this.a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            Cursor cursorQuery = null;
            boolean z = false;
            try {
                try {
                    cursorQuery = com.huawei.updatesdk.a.b.a.a.c().a().getContentResolver().query(Uri.parse(c.a), null, null, null, null);
                    if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                        com.huawei.updatesdk.a.a.a.a("AutoUpdateUtil", "cursor == null");
                    } else {
                        boolean zBooleanValue = Boolean.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex("isagree"))).booleanValue();
                        boolean zBooleanValue2 = Boolean.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex("isopenautoupdate"))).booleanValue();
                        boolean zBooleanValue3 = Boolean.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex("isneverreminder"))).booleanValue();
                        if (zBooleanValue && !zBooleanValue2 && !zBooleanValue3) {
                            z = true;
                        }
                    }
                } catch (Exception e) {
                    com.huawei.updatesdk.a.a.a.a("AutoUpdateUtil", "close cursor error: " + e.toString());
                    if (0 != 0) {
                    }
                }
                return Boolean.valueOf(z);
            } finally {
                if (0 != 0) {
                    try {
                        cursorQuery.close();
                    } catch (Exception unused) {
                        com.huawei.updatesdk.a.a.c.a.a.a.b("AutoUpdateUtil", "cursor Execption");
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(bool);
            }
        }
    }

    public void a(Context context, String str, a aVar, boolean z) throws ExecutionException, InterruptedException, TimeoutException {
        if (!com.huawei.updatesdk.b.h.b.b(context, str, z) || !f.e().d()) {
            aVar.a(Boolean.FALSE);
            return;
        }
        b bVar = new b(aVar);
        bVar.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
        try {
            a = String.format(Locale.ROOT, "content://%s.commondata/item/4", str);
            bVar.get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            bVar.cancel(true);
            com.huawei.updatesdk.a.a.a.a("AutoUpdateUtil", "init AutoUpdateInfo error: " + e.toString());
            aVar.a(Boolean.FALSE);
        }
    }
}
