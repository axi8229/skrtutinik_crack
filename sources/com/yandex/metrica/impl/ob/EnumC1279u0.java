package com.yandex.metrica.impl.ob;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* renamed from: com.yandex.metrica.impl.ob.u0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC1279u0 {
    UNDEFINED("UNDEFINED"),
    APP(GrsBaseInfo.CountryCodeSource.APP),
    SATELLITE("SATELLITE"),
    RETAIL("RETAIL");

    public static final a g = new a(null);
    private final String a;

    /* renamed from: com.yandex.metrica.impl.ob.u0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    EnumC1279u0(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }
}
