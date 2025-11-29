package com.group_ib.sdk;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* renamed from: com.group_ib.sdk.u0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0624u0 implements OnCompleteListener {
    public final HandlerC0626v0 a;

    public C0624u0(HandlerC0626v0 handlerC0626v0) {
        this.a = handlerC0626v0;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.a.a(task);
    }
}
