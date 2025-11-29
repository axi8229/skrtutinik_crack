package com.yandex.metrica.impl.ob;

import android.app.Activity;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class r {
    private final WeakHashMap<Activity, a> a = new WeakHashMap<>();

    public enum a {
        UNDEFINED,
        RESUMED,
        PAUSED
    }

    public boolean a(Activity activity, a aVar) {
        if (activity != null && this.a.get(activity) == aVar) {
            return false;
        }
        if (activity == null) {
            return true;
        }
        this.a.put(activity, aVar);
        return true;
    }
}
