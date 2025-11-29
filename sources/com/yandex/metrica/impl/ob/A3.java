package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.yandex.metrica.YandexMetrica;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public class A3 implements Parcelable {
    private final ContentValues a;
    private ResultReceiver b;
    public static final String c = UUID.randomUUID().toString();
    public static final Parcelable.Creator<A3> CREATOR = new a();

    class a implements Parcelable.Creator<A3> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public A3 createFromParcel(Parcel parcel) {
            Bundle bundle = parcel.readBundle(ResultReceiverC0911f0.class.getClassLoader());
            return new A3((ContentValues) bundle.getParcelable("CFG_KEY_PROCESS_ENVIRONMENT"), (ResultReceiver) bundle.getParcelable("CFG_KEY_PROCESS_ENVIRONMENT_RECEIVER"));
        }

        @Override // android.os.Parcelable.Creator
        public A3[] newArray(int i) {
            return new A3[i];
        }
    }

    public A3(Context context, ResultReceiver resultReceiver) {
        ContentValues contentValues = new ContentValues();
        this.a = contentValues;
        contentValues.put("PROCESS_CFG_PROCESS_ID", Integer.valueOf(Process.myPid()));
        contentValues.put("PROCESS_CFG_PROCESS_SESSION_ID", c);
        contentValues.put("PROCESS_CFG_SDK_API_LEVEL", Integer.valueOf(YandexMetrica.getLibraryApiLevel()));
        contentValues.put("PROCESS_CFG_PACKAGE_NAME", context.getPackageName());
        this.b = resultReceiver;
    }

    public static A3 a(Bundle bundle) {
        if (bundle != null) {
            try {
                return (A3) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void b(com.yandex.metrica.i iVar) {
        synchronized (this) {
            try {
                if (A2.a((Object) iVar.d)) {
                    List<String> list = iVar.d;
                    synchronized (this) {
                        this.a.put("PROCESS_CFG_CUSTOM_HOSTS", Tl.c(list));
                    }
                }
                if (A2.a((Object) iVar.b)) {
                    Map<String, String> mapI = Tl.i(iVar.b);
                    synchronized (this) {
                        this.a.put("PROCESS_CFG_CLIDS", Tl.g(mapI));
                    }
                }
                a(iVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResultReceiver c() {
        return this.b;
    }

    public String d() {
        return this.a.getAsString("PROCESS_CFG_DISTRIBUTION_REFERRER");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.a.getAsString("PROCESS_CFG_INSTALL_REFERRER_SOURCE");
    }

    public String f() {
        return this.a.getAsString("PROCESS_CFG_PACKAGE_NAME");
    }

    public Integer g() {
        return this.a.getAsInteger("PROCESS_CFG_PROCESS_ID");
    }

    public String h() {
        return this.a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
    }

    public int i() {
        return this.a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue();
    }

    public boolean j() {
        return this.a.containsKey("PROCESS_CFG_CUSTOM_HOSTS");
    }

    public String toString() {
        return "ProcessConfiguration{mParamsMapping=" + this.a + ", mDataResultReceiver=" + this.b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("CFG_KEY_PROCESS_ENVIRONMENT", this.a);
        bundle.putParcelable("CFG_KEY_PROCESS_ENVIRONMENT_RECEIVER", this.b);
        parcel.writeBundle(bundle);
    }

    private void a(com.yandex.metrica.i iVar) {
        if (A2.a((Object) iVar.c)) {
            String str = iVar.c;
            synchronized (this) {
                this.a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
            }
            synchronized (this) {
                this.a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", "api");
            }
        }
    }

    public synchronized void a(List<String> list) {
        this.a.put("PROCESS_CFG_CUSTOM_HOSTS", Tl.c(list));
    }

    public Map<String, String> a() {
        return Tl.d(this.a.getAsString("PROCESS_CFG_CLIDS"));
    }

    public synchronized void a(Map<String, String> map) {
        this.a.put("PROCESS_CFG_CLIDS", Tl.g(map));
    }

    public A3(A3 a3) {
        synchronized (a3) {
            this.a = new ContentValues(a3.a);
            this.b = a3.b;
        }
    }

    public synchronized void a(String str) {
        this.a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
    }

    public List<String> b() {
        String asString = this.a.getAsString("PROCESS_CFG_CUSTOM_HOSTS");
        if (TextUtils.isEmpty(asString)) {
            return null;
        }
        return Tl.c(asString);
    }

    public synchronized void b(String str) {
        this.a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
    }

    public A3(ContentValues contentValues, ResultReceiver resultReceiver) {
        this.a = contentValues == null ? new ContentValues() : contentValues;
        this.b = resultReceiver;
    }
}
