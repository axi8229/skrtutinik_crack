package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ac.CrashpadServiceHelper;

/* loaded from: classes3.dex */
public class F7 implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        CrashpadServiceHelper.deleteCompletedReports();
    }
}
