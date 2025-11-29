package com.yandex.metrica.impl.ob;

import android.os.Build;
import java.util.Set;

/* loaded from: classes3.dex */
public class Jl {
    private final Set<String> a;

    public Jl(Set<String> set) {
        this.a = set;
    }

    public String a() {
        if (!A2.a(21)) {
            return a(new String[]{Build.CPU_ABI, Build.CPU_ABI2});
        }
        String strA = a(Build.SUPPORTED_64_BIT_ABIS);
        return strA != null ? strA : a(Build.SUPPORTED_32_BIT_ABIS);
    }

    private String a(String[] strArr) {
        for (String str : strArr) {
            if (this.a.contains(str)) {
                return str;
            }
        }
        return null;
    }
}
