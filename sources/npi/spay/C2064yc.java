package npi.spay;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.yc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2064yc {
    public final Object a;
    public boolean b;

    public C2064yc(Object obj) {
        this.a = obj;
    }

    public final void a(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.b) {
            return;
        }
        this.b = true;
        block.invoke(this.a);
    }
}
