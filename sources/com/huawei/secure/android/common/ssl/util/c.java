package com.huawei.secure.android.common.ssl.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class c extends AsyncTask<Context, Integer, Boolean> {
    private static final String a = "c";
    private static volatile boolean d = false;

    @SuppressLint({"NewApi"})
    public static void a() {
        if (b()) {
            e.c(a, "checkUpgradeBks, execute check task");
            new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ContextUtil.getInstance());
        }
    }

    private static boolean b() {
        if (d) {
            return false;
        }
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            e.e(a, "checkUpgradeBks, context is null");
            return false;
        }
        d = true;
        long jA = g.a("lastCheckTime", 0L, contextUtil);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jA > 432000000) {
            g.b("lastCheckTime", jCurrentTimeMillis, contextUtil);
            return true;
        }
        e.c(a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        e.a(a, "onPreExecute");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) throws IOException {
        InputStream bksFromTss;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            bksFromTss = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            e.b(a, "doInBackground: exception : " + e.getMessage());
            bksFromTss = null;
        }
        e.a(a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        if (bksFromTss != null) {
            d.a(bksFromTss);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            e.c(a, "onPostExecute: upate done");
        } else {
            e.b(a, "onPostExecute: upate failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        e.c(a, "onProgressUpdate");
    }
}
