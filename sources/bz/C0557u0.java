package bz;

import android.app.Application;
import android.content.Context;

/* renamed from: bz.u0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0557u0 {
    public final Context a;

    public C0557u0(Context context) {
        this.a = context instanceof Application ? context : context.getApplicationContext();
    }
}
