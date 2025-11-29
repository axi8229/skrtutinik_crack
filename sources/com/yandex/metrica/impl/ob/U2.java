package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import com.yandex.metrica.core.api.executors.ICommonExecutor;

/* loaded from: classes3.dex */
class U2 {
    U2() {
    }

    ResultReceiverC0911f0 a(Handler handler, T2 t2) {
        return new ResultReceiverC0911f0(handler, t2);
    }

    A3 a(Context context, ResultReceiverC0911f0 resultReceiverC0911f0) {
        return new A3(context, resultReceiverC0911f0);
    }

    T1 a(A3 a3, Context context, ICommonExecutor iCommonExecutor) {
        return new T1(a3, context, new C1136o1(context, iCommonExecutor), new P6(), new C1309v6());
    }

    C0979hi a(Context context, T1 t1, C0820b9 c0820b9, Handler handler) {
        return new C0979hi(context, t1, c0820b9, handler);
    }

    C0827bg a(T1 t1, C0820b9 c0820b9, Handler handler) {
        return new C0827bg(t1, c0820b9, handler);
    }

    R1 a(Context context, A3 a3, T1 t1, Handler handler, C0979hi c0979hi) {
        return new R1(context, a3, t1, handler, c0979hi);
    }
}
