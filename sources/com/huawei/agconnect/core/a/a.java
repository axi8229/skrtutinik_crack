package com.huawei.agconnect.core.a;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class a extends AGCInitFinishManager {
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> a = new CopyOnWriteArrayList();

    public static void a() {
        Iterator<AGCInitFinishManager.AGCInitFinishCallback> it = a.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }
}
