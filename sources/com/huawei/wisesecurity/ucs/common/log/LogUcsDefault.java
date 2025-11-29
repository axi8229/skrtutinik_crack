package com.huawei.wisesecurity.ucs.common.log;

import android.util.Log;

/* loaded from: classes3.dex */
public class LogUcsDefault implements ILogUcs {
    @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
    public void w(String str, String str2) {
        Log.w(str, str2);
    }
}
