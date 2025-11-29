package com.yandex.metrica.impl.ob;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C0877dg;
import java.util.concurrent.Callable;

/* renamed from: com.yandex.metrica.impl.ob.fg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class CallableC0927fg implements Callable<C0877dg> {
    final /* synthetic */ C0952gg a;

    CallableC0927fg(C0952gg c0952gg) {
        this.a = c0952gg;
    }

    @Override // java.util.concurrent.Callable
    public C0877dg call() throws Exception {
        Uri uri = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.a.a.getContentResolver();
        C0952gg c0952gg = this.a;
        c0952gg.b = contentResolver.query(uri, null, null, new String[]{c0952gg.a.getPackageName()}, null);
        if (this.a.b != null && this.a.b.moveToFirst()) {
            String string = this.a.b.getString(0);
            if (!TextUtils.isEmpty(string)) {
                return new C0877dg(string, this.a.b.getLong(1), this.a.b.getLong(2), C0877dg.a.HMS);
            }
        }
        return null;
    }
}
