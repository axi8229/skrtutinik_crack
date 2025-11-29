package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.H1;
import com.yandex.metrica.networktasks.api.IExecutionPolicy;
import java.util.EnumSet;

/* renamed from: com.yandex.metrica.impl.ob.od, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1148od implements IExecutionPolicy {
    private static final EnumSet<H1.d> c = EnumSet.of(H1.d.OFFLINE);
    private Rl a = new Ml();
    private final Context b;

    public C1148od(Context context) {
        this.b = context;
    }

    @Override // com.yandex.metrica.networktasks.api.IExecutionPolicy
    public boolean canBeExecuted() {
        Rl rl = this.a;
        Context context = this.b;
        ((Ml) rl).getClass();
        return !c.contains(H1.a(context));
    }
}
