package npi.spay;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Qj implements InterfaceC1943tg {
    public final SharedPreferences a;

    public Qj(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context.getSharedPreferences("SPAY_SDK_DATA", 0);
    }

    @Override // npi.spay.InterfaceC1943tg
    public final SharedPreferences a() {
        return this.a;
    }

    @Override // npi.spay.InterfaceC1943tg
    public final Object a(String key, String str) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesA = a();
        if (sharedPreferencesA == null || (string = sharedPreferencesA.getString(key, str)) == null) {
            throw Q9.a;
        }
        return string;
    }

    @Override // npi.spay.InterfaceC1943tg
    /* renamed from: a */
    public final void mo2849a(String str, String str2) {
        AbstractC1918sg.a(this, str, str2);
    }

    @Override // npi.spay.InterfaceC1943tg
    public final void a(String[] strArr) {
        AbstractC1918sg.a(this, strArr);
    }
}
