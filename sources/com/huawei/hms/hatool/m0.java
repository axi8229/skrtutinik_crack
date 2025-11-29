package com.huawei.hms.hatool;

import android.util.Log;

/* loaded from: classes3.dex */
public class m0 {
    private boolean a = false;
    private int b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.314" + p.a();
    }

    public void a(int i) {
        Log.i("FormalHASDK", System.lineSeparator() + "======================================= " + System.lineSeparator() + a() + "" + System.lineSeparator() + "=======================================");
        this.b = i;
        this.a = true;
    }

    public void a(int i, String str, String str2) {
        if (i == 3) {
            Log.d(str, str2);
            return;
        }
        if (i == 5) {
            Log.w(str, str2);
        } else if (i != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public void b(int i, String str, String str2) {
        a(i, "FormalHASDK", str + "=> " + str2);
    }

    public boolean b(int i) {
        return this.a && i >= this.b;
    }
}
