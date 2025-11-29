package com.yandex.metrica.impl.ob;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.c8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0844c8 {
    private JSONObject a;
    private final InterfaceC0919f8 b;
    private final InterfaceC0919f8 c;
    private final String d;
    private final InterfaceC0869d8 e;

    public C0844c8(InterfaceC0919f8 interfaceC0919f8, InterfaceC0919f8 interfaceC0919f82, String str, InterfaceC0869d8 interfaceC0869d8) {
        this.b = interfaceC0919f8;
        this.c = interfaceC0919f82;
        this.d = str;
        this.e = interfaceC0869d8;
    }

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        try {
            if (this.a == null) {
                JSONObject jSONObjectA = this.e.a(a(this.b), a(this.c));
                this.a = jSONObjectA;
                a(jSONObjectA);
            }
            jSONObject = this.a;
            if (jSONObject == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileContents");
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    private final JSONObject a(InterfaceC0919f8 interfaceC0919f8) {
        try {
            String strC = interfaceC0919f8.c();
            return strC != null ? new JSONObject(strC) : new JSONObject();
        } catch (Throwable th) {
            a(th);
            return new JSONObject();
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "contents.toString()");
        try {
            this.b.a(string);
        } catch (Throwable th) {
            a(th);
        }
        try {
            this.c.a(string);
        } catch (Throwable th2) {
            a(th2);
        }
    }

    private final void a(Throwable th) {
        ((C1127nh) C1152oh.a()).reportEvent("vital_data_provider_exception", MapsKt.mapOf(TuplesKt.to(RemoteMessageConst.Notification.TAG, this.d), TuplesKt.to("exception", Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName())));
        ((C1127nh) C1152oh.a()).reportError("Error during reading vital data for tag = " + this.d, th);
    }
}
