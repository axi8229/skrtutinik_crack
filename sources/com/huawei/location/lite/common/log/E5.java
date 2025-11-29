package com.huawei.location.lite.common.log;

import com.huawei.location.lite.common.log.logwrite.LogWriteApi;

/* loaded from: classes3.dex */
final class E5 implements yn<d2> {
    private final FB yn = new FB(true);

    E5() {
    }

    public void FB(String str, String str2) {
        this.yn.yn(5, str, str2);
        LogWriteApi.w(str, str2, null);
    }

    public void Vw(String str, String str2) {
        this.yn.yn(4, str, str2);
        LogWriteApi.i(str, str2, null);
    }

    public void Vw(String str, String str2, boolean z) {
        this.yn.yn(4, str, str2);
        if (z) {
            LW.yn(str, LW.yn(str, str2));
        }
        LogWriteApi.i(str, str2, null);
    }

    public void yn(String str, Object obj, boolean z) {
        d2 d2Var = (d2) obj;
        this.yn.yn(6, str, LW.yn(d2Var.yn()));
        if (z) {
            LW.yn(str, LW.yn(str, d2Var.yn()));
        }
    }

    public void yn(String str, String str2) {
        this.yn.yn(6, str, str2);
        LogWriteApi.e(str, str2, null);
    }

    public void yn(String str, String str2, Throwable th) {
        this.yn.Vw(6, str, str2, th);
        LogWriteApi.e(str, str2, null);
    }

    public void yn(String str, String str2, boolean z) {
        this.yn.yn(6, str, str2);
        if (z) {
            LW.yn(str, LW.yn(str, str2));
        }
        LogWriteApi.e(str, str2, null);
    }
}
