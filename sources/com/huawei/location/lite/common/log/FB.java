package com.huawei.location.lite.common.log;

import android.util.Log;
import java.text.Normalizer;

/* loaded from: classes3.dex */
final class FB {
    public FB(boolean z) {
    }

    private dC yn(int i, String str, String str2, Throwable th) {
        dC dCVar = new dC(i, "LITE_SDK-" + str, true);
        dCVar.yn((dC) str2);
        dCVar.yn(th);
        return dCVar;
    }

    private String yn(String str) {
        return str != null ? Normalizer.normalize(str, Normalizer.Form.NFKC).replace("\\n", "").replace("\\r", "") : "";
    }

    public void Vw(int i, String str, String str2, Throwable th) {
        dC dCVarYn = yn(i, str, str2, th);
        Log.println(i, str, yn(dCVarYn.Vw() + dCVarYn.yn()));
    }

    public void yn(int i, String str, String str2) {
        dC dCVarYn = yn(i, str, str2, null);
        Log.println(i, str, yn(dCVarYn.Vw() + dCVarYn.yn()));
    }
}
