package com.group_ib.sdk;

import android.os.Debug;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class G0 extends B0 {
    public Method e;
    public boolean f;

    public G0(MobileSdkService mobileSdkService) {
        super(mobileSdkService, Integer.MAX_VALUE, 0L);
        this.e = null;
        this.f = false;
    }

    @Override // com.group_ib.sdk.B0
    public final void a(b1 b1Var) {
        try {
            if (this.e == null) {
                this.e = Debug.class.getDeclaredMethod(X.b(0), null);
            }
            Method method = this.e;
            b1Var.put("DebuggerConnected", method != null ? ((Boolean) method.invoke(null, null)).booleanValue() : false ? new a1("true") : "false");
        } catch (Exception e) {
            if (this.f) {
                return;
            }
            c1.b("ParamsDebugger", "detection of debugger is failed", e);
            this.f = true;
        }
    }
}
