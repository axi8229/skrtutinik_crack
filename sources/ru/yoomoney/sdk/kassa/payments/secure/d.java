package ru.yoomoney.sdk.kassa.payments.secure;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public abstract class d implements Function1 {
    public final int a;
    public final Function0 b;
    public final Function0 c;
    public Lazy d;

    public d(int i, Function0 function0, Function0 function02) {
        this.a = i;
        this.b = function0;
        this.c = function02;
        a();
    }

    public final void a() {
        this.d = LazyKt.lazy(new c(this));
    }

    public /* synthetic */ d(int i, Function0 function0, Function0 function02, int i2) {
        this(i, function0, function02);
    }
}
