package com.yandex.metrica;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.yandex.metrica.impl.ob.C0963h2;
import com.yandex.metrica.impl.ob.C1258t3;
import com.yandex.metrica.impl.ob.C1282u3;
import com.yandex.metrica.impl.ob.E0;
import com.yandex.metrica.impl.ob.Xd;
import com.yandex.metrica.impl.ob.Y;
import com.yandex.metrica.impl.ob.Yd;
import com.yandex.metrica.impl.ob.Z;

/* loaded from: classes3.dex */
public class PreloadInfoContentProvider extends ContentProvider {
    private boolean a = false;
    private final UriMatcher b = new UriMatcher(-1);

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C0963h2.b("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            try {
                if (this.a) {
                    return null;
                }
                if (contentValues != null) {
                    int iMatch = this.b.match(uri);
                    if (iMatch == 1) {
                        Z z = new Z(new Xd(), new Yd(), new E0(), "preload info");
                        Context context = getContext();
                        Context applicationContext = context == null ? null : context.getApplicationContext();
                        if (applicationContext != null) {
                            z.a(applicationContext, contentValues);
                        }
                    } else if (iMatch != 2) {
                        C0963h2.b("Bad content provider uri: %s", uri);
                    } else {
                        Z z2 = new Z(new C1258t3(), new C1282u3(), new E0(), "clids");
                        Context context2 = getContext();
                        Context applicationContext2 = context2 == null ? null : context2.getApplicationContext();
                        if (applicationContext2 != null) {
                            z2.a(applicationContext2, contentValues);
                        }
                    }
                }
                Y.a();
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        String str = (applicationContext != null ? applicationContext.getPackageName() : "") + ".appmetrica.preloadinfo.retail";
        this.b.addURI(str, "preloadinfo", 1);
        this.b.addURI(str, "clids", 2);
        Y.a(this);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C0963h2.b("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C0963h2.b("Updating is not supported", new Object[0]);
        return -1;
    }
}
