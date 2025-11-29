package com.yandex.metrica.impl.ob;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class Fd implements InterfaceC1340wd {
    private Set<String> a;

    public Fd(List<Bd> list) {
        if (list == null) {
            this.a = new HashSet();
            return;
        }
        this.a = new HashSet(list.size());
        for (Bd bd : list) {
            if (bd.b) {
                this.a.add(bd.a);
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1340wd
    public boolean a(String str) {
        return this.a.contains(str);
    }

    public String toString() {
        return "StartupBasedPermissionStrategy{mEnabledPermissions=" + this.a + '}';
    }
}
