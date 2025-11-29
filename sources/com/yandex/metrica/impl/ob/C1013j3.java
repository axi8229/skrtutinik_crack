package com.yandex.metrica.impl.ob;

import java.util.Arrays;

/* renamed from: com.yandex.metrica.impl.ob.j3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1013j3 implements InterfaceC1082lm<Thread, StackTraceElement[], E6> {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1082lm
    public E6 a(Thread thread, StackTraceElement[] stackTraceElementArr) {
        Thread thread2 = thread;
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        String name = thread2.getName();
        int priority = thread2.getPriority();
        long id = thread2.getId();
        ThreadGroup threadGroup = thread2.getThreadGroup();
        return new E6(name, priority, id, threadGroup != null ? threadGroup.getName() : "", Integer.valueOf(thread2.getState().ordinal()), stackTraceElementArr2 == null ? null : Arrays.asList(stackTraceElementArr2));
    }
}
