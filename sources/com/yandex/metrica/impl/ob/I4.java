package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes3.dex */
public class I4 extends K4<X4> {
    private final E5 a;
    private final Map<EnumC0787a1, AbstractC1356x5<X4>> b;
    private C1260t5 c;

    public I4(L3 l3) {
        E5 e5 = new E5(l3);
        this.a = e5;
        this.c = new C1260t5(e5);
        this.b = a();
    }

    private HashMap<EnumC0787a1, AbstractC1356x5<X4>> a() {
        HashMap<EnumC0787a1, AbstractC1356x5<X4>> map = new HashMap<>();
        map.put(EnumC0787a1.EVENT_TYPE_ACTIVATION, new C1236s5(this.a));
        map.put(EnumC0787a1.EVENT_TYPE_START, new H5(this.a));
        map.put(EnumC0787a1.EVENT_TYPE_REGULAR, new B5(this.a));
        C1404z5 c1404z5 = new C1404z5(this.a);
        map.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_USER, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_SEND_REFERRER, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_STATBOX, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_CUSTOM_EVENT, c1404z5);
        EnumC0787a1 enumC0787a1 = EnumC0787a1.EVENT_TYPE_SET_SESSION_EXTRA;
        E5 e5 = this.a;
        map.put(enumC0787a1, new G5(e5, e5.u()));
        map.put(EnumC0787a1.EVENT_TYPE_APP_OPEN, new D5(this.a));
        map.put(EnumC0787a1.EVENT_TYPE_PURGE_BUFFER, new A5(this.a));
        EnumC0787a1 enumC0787a12 = EnumC0787a1.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH;
        E5 e52 = this.a;
        map.put(enumC0787a12, new G5(e52, e52.l()));
        EnumC0787a1 enumC0787a13 = EnumC0787a1.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        E5 e53 = this.a;
        map.put(enumC0787a13, new G5(e53, e53.l()));
        map.put(EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH, new C1332w5(this.a));
        map.put(EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new C1332w5(this.a));
        map.put(EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_CRASHPAD_CRASH_PROTOBUF, new C1308v5(this.a));
        EnumC0787a1 enumC0787a14 = EnumC0787a1.EVENT_TYPE_API_NATIVE_CRASH_PROTOBUF;
        E5 e54 = this.a;
        map.put(enumC0787a14, new G5(e54, e54.l()));
        map.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new J5(this.a));
        I5 i5 = new I5(this.a);
        map.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED, i5);
        map.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, i5);
        map.put(EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT, i5);
        map.put(EnumC0787a1.EVENT_TYPE_ANR, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_IDENTITY, new C1380y5(this.a));
        map.put(EnumC0787a1.EVENT_TYPE_SET_USER_INFO, new F5(this.a));
        EnumC0787a1 enumC0787a15 = EnumC0787a1.EVENT_TYPE_REPORT_USER_INFO;
        E5 e55 = this.a;
        map.put(enumC0787a15, new G5(e55, e55.o()));
        EnumC0787a1 enumC0787a16 = EnumC0787a1.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        E5 e56 = this.a;
        map.put(enumC0787a16, new G5(e56, e56.d()));
        EnumC0787a1 enumC0787a17 = EnumC0787a1.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        E5 e57 = this.a;
        map.put(enumC0787a17, new G5(e57, e57.c()));
        map.put(EnumC0787a1.EVENT_TYPE_SEND_USER_PROFILE, c1404z5);
        EnumC0787a1 enumC0787a18 = EnumC0787a1.EVENT_TYPE_SET_USER_PROFILE_ID;
        E5 e58 = this.a;
        map.put(enumC0787a18, new G5(e58, e58.x()));
        map.put(EnumC0787a1.EVENT_TYPE_SEND_REVENUE_EVENT, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_SEND_AD_REVENUE_EVENT, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_IDENTITY_LIGHT, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_CLEANUP, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_VIEW_TREE, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_RAW_VIEW_TREE, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_SEND_ECOMMERCE_EVENT, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_STATBOX_EXP, c1404z5);
        map.put(EnumC0787a1.EVENT_TYPE_WEBVIEW_SYNC, c1404z5);
        return map;
    }

    public E5 b() {
        return this.a;
    }

    public void a(EnumC0787a1 enumC0787a1, AbstractC1356x5<X4> abstractC1356x5) {
        this.b.put(enumC0787a1, abstractC1356x5);
    }

    @Override // com.yandex.metrica.impl.ob.K4
    public H4 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0787a1 enumC0787a1A = EnumC0787a1.a(i);
        C1260t5 c1260t5 = this.c;
        if (c1260t5 != null) {
            c1260t5.a(enumC0787a1A, linkedList);
        }
        AbstractC1356x5<X4> abstractC1356x5 = this.b.get(enumC0787a1A);
        if (abstractC1356x5 != null) {
            abstractC1356x5.a(linkedList);
        }
        return new H4(linkedList);
    }
}
