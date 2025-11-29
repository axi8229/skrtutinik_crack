package com.huawei.updatesdk.b.g;

import android.os.AsyncTask;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes3.dex */
public class b {
    private static List<AsyncTask> a = new CopyOnWriteArrayList();

    public static com.huawei.updatesdk.a.b.c.b a(com.huawei.updatesdk.b.b.c cVar, com.huawei.updatesdk.a.b.c.c.a aVar) {
        com.huawei.updatesdk.a.b.c.b bVar = new com.huawei.updatesdk.a.b.c.b(cVar, aVar);
        a(bVar, cVar);
        return bVar;
    }

    public static List<AsyncTask> a() {
        return a;
    }

    public static void a(AsyncTask asyncTask) {
        if (asyncTask == null) {
            return;
        }
        for (AsyncTask asyncTask2 : a) {
            if (asyncTask2 != null && (asyncTask2.getStatus() == AsyncTask.Status.FINISHED || asyncTask2.isCancelled())) {
                a.remove(asyncTask);
            }
        }
        a.add(asyncTask);
    }

    private static void a(com.huawei.updatesdk.a.b.c.b bVar, com.huawei.updatesdk.b.b.c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("executeTask, ActiveCount:");
        ThreadPoolExecutor threadPoolExecutor = c.a;
        sb.append(threadPoolExecutor.getActiveCount());
        sb.append(", TaskCount:");
        sb.append(threadPoolExecutor.getTaskCount());
        com.huawei.updatesdk.a.a.c.a.a.a.a("StoreAgent", sb.toString());
        bVar.a(threadPoolExecutor);
    }
}
