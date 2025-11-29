package com.yandex.metrica.impl.ob;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.z0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1399z0 {
    private static final Set<Integer> a;
    private static final EnumSet<EnumC0787a1> b;
    private static final EnumSet<EnumC0787a1> c;
    private static final EnumSet<EnumC0787a1> d;
    private static final EnumSet<EnumC0787a1> e;
    private static final EnumSet<EnumC0787a1> f;
    private static final EnumSet<EnumC0787a1> g;
    private static final EnumSet<EnumC0787a1> h;
    public static final List<Integer> i;
    public static final List<Integer> j;

    static {
        Integer[] numArr = {Integer.valueOf(EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_PROTOBUF.b()), Integer.valueOf(EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF.b()), Integer.valueOf(EnumC0787a1.EVENT_TYPE_EXCEPTION_USER.b()), Integer.valueOf(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF.b()), Integer.valueOf(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE.b()), Integer.valueOf(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT.b()), Integer.valueOf(EnumC0787a1.EVENT_TYPE_ANR.b())};
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < 7; i2++) {
            hashSet.add(numArr[i2]);
        }
        a = Collections.unmodifiableSet(hashSet);
        EnumC0787a1 enumC0787a1 = EnumC0787a1.EVENT_TYPE_UNDEFINED;
        EnumC0787a1 enumC0787a12 = EnumC0787a1.EVENT_TYPE_PURGE_BUFFER;
        EnumC0787a1 enumC0787a13 = EnumC0787a1.EVENT_TYPE_SEND_REFERRER;
        EnumC0787a1 enumC0787a14 = EnumC0787a1.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC0787a1 enumC0787a15 = EnumC0787a1.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC0787a1 enumC0787a16 = EnumC0787a1.EVENT_TYPE_ACTIVATION;
        EnumC0787a1 enumC0787a17 = EnumC0787a1.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH;
        EnumC0787a1 enumC0787a18 = EnumC0787a1.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0787a1 enumC0787a19 = EnumC0787a1.EVENT_TYPE_API_NATIVE_CRASH_PROTOBUF;
        b = EnumSet.of(enumC0787a1, enumC0787a12, enumC0787a13, enumC0787a14, enumC0787a15, enumC0787a16, enumC0787a17, enumC0787a18, enumC0787a19, EnumC0787a1.EVENT_TYPE_SET_SESSION_EXTRA);
        EnumC0787a1 enumC0787a110 = EnumC0787a1.EVENT_TYPE_SET_USER_INFO;
        EnumC0787a1 enumC0787a111 = EnumC0787a1.EVENT_TYPE_REPORT_USER_INFO;
        EnumC0787a1 enumC0787a112 = EnumC0787a1.EVENT_TYPE_IDENTITY;
        EnumC0787a1 enumC0787a113 = EnumC0787a1.EVENT_TYPE_INIT;
        EnumC0787a1 enumC0787a114 = EnumC0787a1.EVENT_TYPE_APP_UPDATE;
        c = EnumSet.of(enumC0787a110, enumC0787a111, enumC0787a112, enumC0787a1, enumC0787a113, enumC0787a114, enumC0787a13, EnumC0787a1.EVENT_TYPE_ALIVE, EnumC0787a1.EVENT_TYPE_STARTUP, enumC0787a14, enumC0787a15, enumC0787a16, enumC0787a17, enumC0787a18, enumC0787a19, EnumC0787a1.EVENT_TYPE_WEBVIEW_SYNC);
        EnumC0787a1 enumC0787a115 = EnumC0787a1.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        EnumC0787a1 enumC0787a116 = EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        d = EnumSet.of(enumC0787a115, enumC0787a110, enumC0787a111, enumC0787a116);
        EnumC0787a1 enumC0787a117 = EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED;
        EnumC0787a1 enumC0787a118 = EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT;
        EnumC0787a1 enumC0787a119 = EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC0787a1 enumC0787a120 = EnumC0787a1.EVENT_TYPE_EXCEPTION_USER;
        EnumC0787a1 enumC0787a121 = EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC0787a1 enumC0787a122 = EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC0787a1 enumC0787a123 = EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH;
        EnumC0787a1 enumC0787a124 = EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0787a1 enumC0787a125 = EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_CRASHPAD_CRASH_PROTOBUF;
        EnumC0787a1 enumC0787a126 = EnumC0787a1.EVENT_TYPE_REGULAR;
        e = EnumSet.of(enumC0787a117, enumC0787a116, enumC0787a118, enumC0787a119, enumC0787a120, enumC0787a121, enumC0787a122, enumC0787a17, enumC0787a18, enumC0787a123, enumC0787a124, enumC0787a125, enumC0787a19, enumC0787a126);
        f = EnumSet.of(EnumC0787a1.EVENT_TYPE_DIAGNOSTIC, EnumC0787a1.EVENT_TYPE_DIAGNOSTIC_STATBOX, EnumC0787a1.EVENT_TYPE_DIAGNOSTIC_DISABLE_STAT_SENDING, EnumC0787a1.EVENT_TYPE_APPMETRICA_DIAGNOSTICS);
        g = EnumSet.of(enumC0787a126);
        h = EnumSet.of(enumC0787a17, enumC0787a18, enumC0787a19);
        i = Arrays.asList(Integer.valueOf(enumC0787a113.b()), Integer.valueOf(EnumC0787a1.EVENT_TYPE_FIRST_ACTIVATION.b()), Integer.valueOf(enumC0787a13.b()), Integer.valueOf(enumC0787a114.b()));
        j = Arrays.asList(Integer.valueOf(EnumC0787a1.EVENT_TYPE_CLEANUP.b()));
    }

    public static boolean a(EnumC0787a1 enumC0787a1) {
        return !b.contains(enumC0787a1);
    }

    public static boolean b(EnumC0787a1 enumC0787a1) {
        return !c.contains(enumC0787a1);
    }

    public static boolean c(int i2) {
        return e.contains(EnumC0787a1.a(i2));
    }

    public static boolean d(int i2) {
        return !h.contains(EnumC0787a1.a(i2));
    }

    public static boolean e(int i2) {
        return g.contains(EnumC0787a1.a(i2));
    }

    public static boolean f(int i2) {
        return a.contains(Integer.valueOf(i2));
    }

    public static boolean a(int i2) {
        return f.contains(EnumC0787a1.a(i2));
    }

    public static boolean b(int i2) {
        return d.contains(EnumC0787a1.a(i2));
    }

    static C0836c0 c(String str, C0858cm c0858cm) {
        return a(str, EnumC0787a1.EVENT_TYPE_API_NATIVE_CRASH_PROTOBUF, c0858cm);
    }

    public static C0836c0 a(String str, C0858cm c0858cm) {
        return a(str, EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, c0858cm);
    }

    public static C0836c0 b(String str, C0858cm c0858cm) {
        return a(str, EnumC0787a1.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, c0858cm);
    }

    private static C0836c0 a(String str, EnumC0787a1 enumC0787a1, C0858cm c0858cm) {
        J j2 = new J("", "", enumC0787a1.b(), 0, c0858cm);
        if (str != null) {
            j2.i(str);
        }
        return j2;
    }

    public static C0836c0 a() {
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.e = EnumC0787a1.EVENT_TYPE_DIAGNOSTIC_DISABLE_STAT_SENDING.b();
        try {
            c0836c0.b = new JSONObject().put("stat_sending", new JSONObject().put("disabled", true)).toString();
        } catch (Throwable unused) {
        }
        return c0836c0;
    }

    static C0836c0 a(String str, byte[] bArr, C0858cm c0858cm) {
        return new J(bArr, str, EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF.b(), c0858cm);
    }

    static C0836c0 a(String str, String str2, boolean z, C0858cm c0858cm) {
        HashMap map = new HashMap();
        map.put("type", str);
        map.put("link", str2);
        map.put("auto", Boolean.valueOf(z));
        return new J(Tl.g(map), "", EnumC0787a1.EVENT_TYPE_APP_OPEN.b(), 0, c0858cm);
    }
}
