package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Um implements Vm {
    public final int a;

    public Um(int i) {
        this.a = i;
    }

    @Override // com.yandex.metrica.impl.ob.Vm
    public int a() {
        return this.a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.a + '}';
    }

    public static Vm a(Vm... vmArr) {
        int iA = 0;
        for (Vm vm : vmArr) {
            if (vm != null) {
                iA += vm.a();
            }
        }
        return new Um(iA);
    }
}
