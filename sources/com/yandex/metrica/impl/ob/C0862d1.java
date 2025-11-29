package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.yandex.metrica.impl.ob.d1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0862d1 implements ConfigProvider {
    private final Lazy a = LazyKt.lazy(new a());
    private final L3 b;

    /* renamed from: com.yandex.metrica.impl.ob.d1$a */
    static final class a extends Lambda implements Function0<Lg> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Lg invoke() {
            return C0862d1.this.b.m();
        }
    }

    public C0862d1(L3 l3) {
        this.b = l3;
    }

    public Lg a() {
        Lg cachedConfig = (Lg) this.a.getValue();
        Intrinsics.checkNotNullExpressionValue(cachedConfig, "cachedConfig");
        return cachedConfig;
    }

    @Override // com.yandex.metrica.networktasks.api.ConfigProvider
    public Object getConfig() {
        Lg cachedConfig = (Lg) this.a.getValue();
        Intrinsics.checkNotNullExpressionValue(cachedConfig, "cachedConfig");
        return cachedConfig;
    }
}
