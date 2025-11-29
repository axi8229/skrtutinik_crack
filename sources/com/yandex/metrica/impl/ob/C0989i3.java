package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.i3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0989i3 implements InterfaceC1132nm<Thread, E6> {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
    public E6 a(Thread thread) {
        String name = thread.getName();
        int priority = thread.getPriority();
        long id = thread.getId();
        ThreadGroup threadGroup = thread.getThreadGroup();
        return new E6(name, priority, id, threadGroup != null ? threadGroup.getName() : "", null, null);
    }
}
