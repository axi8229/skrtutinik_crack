package com.yandex.varioqub.config.impl;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;

/* loaded from: classes3.dex */
public abstract class l {
    public static final AtomicLong[] a;
    public static final LinkedHashMap b;
    public static final Object c;

    static {
        int length = k.a(3).length;
        AtomicLong[] atomicLongArr = new AtomicLong[length];
        for (int i = 0; i < length; i++) {
            atomicLongArr[i] = new AtomicLong();
        }
        a = atomicLongArr;
        b = new LinkedHashMap();
        c = new Object();
    }

    public static void a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AtomicLong[] atomicLongArr = a;
        if (i == 0) {
            throw null;
        }
        long andSet = atomicLongArr[i - 1].getAndSet(0L);
        if (andSet > 0) {
            long j = jCurrentTimeMillis - andSet;
            String str = "Finish tracking metric " + j.a(i) + " with elapsed time - " + j;
            if (C.a) {
                Log.d("Varioqub/PerformanceMeter", str);
            }
            synchronized (c) {
                b.put(j.a(i), Long.valueOf(j));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static void b(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AtomicLong[] atomicLongArr = a;
        if (i == 0) {
            throw null;
        }
        atomicLongArr[i - 1].set(jCurrentTimeMillis);
        String strConcat = "Start tracking metric - ".concat(j.a(i));
        if (C.a) {
            Log.d("Varioqub/PerformanceMeter", strConcat);
        }
    }
}
