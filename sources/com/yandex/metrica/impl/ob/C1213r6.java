package com.yandex.metrica.impl.ob;

import android.util.SparseArray;
import com.huawei.hms.support.api.entity.core.CommonCode;

/* renamed from: com.yandex.metrica.impl.ob.r6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1213r6 {
    private static SparseArray<C1213r6> c;
    public final String a;
    public final String b;

    static {
        SparseArray<C1213r6> sparseArray = new SparseArray<>();
        c = sparseArray;
        sparseArray.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED.b(), new C1213r6("jvm", "binder"));
        c.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF.b(), new C1213r6("jvm", "binder"));
        c.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT.b(), new C1213r6("jvm", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK));
        c.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE.b(), new C1213r6("jvm", "file"));
        c.put(EnumC0787a1.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH.b(), new C1213r6("jni_native", "file"));
        c.put(EnumC0787a1.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF.b(), new C1213r6("jni_native", "file"));
        c.put(EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH.b(), new C1213r6("jni_native", "file"));
        c.put(EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF.b(), new C1213r6("jni_native", "file"));
        c.put(EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_CRASHPAD_CRASH_PROTOBUF.b(), new C1213r6("jni_native", "file"));
        c.put(EnumC0787a1.EVENT_TYPE_API_NATIVE_CRASH_PROTOBUF.b(), new C1213r6("jni_native", "binder"));
    }

    private C1213r6(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static C1213r6 a(int i) {
        return c.get(i);
    }
}
